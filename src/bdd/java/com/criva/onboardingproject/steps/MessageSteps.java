package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestLocalThread;
import com.criva.onboardingproject.model.dto.MessageCreationDTO;
import com.criva.onboardingproject.model.vo.message.ContextVO;
import com.criva.onboardingproject.model.vo.message.MessageVO;
import com.criva.onboardingproject.model.vo.room.ParticipantVO;
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

        ParticipantVO savedParticipant = (ParticipantVO) IntegrationTestLocalThread.getContext().getContextMapping().get(particpant);

        MessageCreationDTO body = new MessageCreationDTO(RandomStringUtils.randomAlphabetic(10), savedParticipant.getId());
        HttpEntity<MessageCreationDTO> request = new HttpEntity<>(body);
        ResponseEntity<MessageVO> response = restTemplate.postForEntity(MESSAGES_RESOURCE_URL, request, MessageVO.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        IntegrationTestLocalThread.getContext().getContextMapping().put(message, response.getBody());
    }

    @Then("the participants $participants must receive the message $message")
    public void allParticipantsOfParticipantRoomMustReceiveMessage(@Named("participants") List<String> participants,
                                                                   @Named("message") String message) {

        MessageVO savedMessage = (MessageVO) IntegrationTestLocalThread.getContext().getContextMapping().get(message);
        List<String> savedParticipantsId = participants.stream().map(
                participant -> ((ParticipantVO) IntegrationTestLocalThread.getContext().getContextMapping().get(participant)).getId()
        ).collect(Collectors.toList());

        UriComponentsBuilder urlBuilder = UriComponentsBuilder
                .fromHttpUrl(CONTEXTS_RESOURCE_URL)
                .queryParam("ids", String.join(",", savedMessage.getContextsId()));

        ResponseEntity<ContextVO[]> response = restTemplate.getForEntity(urlBuilder.toUriString(), ContextVO[].class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        List<Optional<ContextVO>> savedContexts = savedParticipantsId.stream().map(
                id -> stream(response.getBody()).filter(
                        context -> id.equals(context.getRecipientParticipantId()) && Boolean.TRUE.equals(context.getReceived())
                ).findAny()
        ).collect(Collectors.toList());

        assertEquals(savedParticipantsId.size(), savedContexts.stream().filter(Optional::isPresent).collect(Collectors.toList()).size());
    }
}
