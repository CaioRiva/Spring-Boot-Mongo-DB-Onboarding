package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestLocalThread;
import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.model.vo.message.Context;
import com.criva.onboardingproject.model.vo.message.Message;
import com.criva.onboardingproject.model.vo.room.Participant;
import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MessageSteps extends Steps {

    private static final String MESSAGES_RESOURCE_URL = "http://localhost:8080/messages";
    private static final String CONTEXTS_RESOURCE_URL = "http://localhost:8080/contexts";

    private RestTemplate restTemplate;

    public MessageSteps() {

        this.restTemplate = new RestTemplate();
    }

    @When("the participant $participant sends a message $message")
    public void theParticipantSendsMessage(@Named("participant") String particpant,
                                           @Named("message") String message) {

        Participant savedParticipant = (Participant) IntegrationTestLocalThread.getContext().getContextMapping().get(particpant);

        MessageCreation body = new MessageCreation(RandomStringUtils.randomAlphabetic(10), savedParticipant.getId());
        HttpEntity<MessageCreation> request = new HttpEntity<>(body);
        ResponseEntity<Message> response = restTemplate.postForEntity(MESSAGES_RESOURCE_URL, request, Message.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        IntegrationTestLocalThread.getContext().getContextMapping().put(message, response.getBody());
    }

    @Then("the participants $participants must receive the message $message")
    public void allParticipantsOfParticipantRoomMustReceiveMessage(@Named("participants") List<String> participants,
                                                                   @Named("message") String message) {

        Message savedMessage = (Message) IntegrationTestLocalThread.getContext().getContextMapping().get(message);
        List<String> savedParticipantsId = participants.stream().map(
                participant -> ((Participant) IntegrationTestLocalThread.getContext().getContextMapping().get(participant)).getId()
        ).collect(Collectors.toList());

        UriComponentsBuilder urlBuilder = UriComponentsBuilder
                .fromHttpUrl(CONTEXTS_RESOURCE_URL)
                .queryParam("ids", String.join(",", savedMessage.getContextsId()));

        ResponseEntity<Context[]> response = restTemplate.getForEntity(urlBuilder.toUriString(), Context[].class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        List<Optional<Context>> savedContexts = savedParticipantsId.stream().map(
                id -> stream(response.getBody()).filter(
                        context -> id.equals(context.getRecipientParticipantId()) && Boolean.TRUE.equals(context.getReceived())
                ).findAny()
        ).collect(Collectors.toList());

        assertEquals(savedParticipantsId.size(), savedContexts.stream().filter(Optional::isPresent).collect(Collectors.toList()).size());
    }
}
