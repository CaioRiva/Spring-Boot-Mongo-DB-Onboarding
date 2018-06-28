package com.criva.onboardingproject.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MessageSteps extends Steps {

    private static final String MESSAGES_RESOURCE_URL = "http://localhost:8080/messages";

    private RestTemplate restTemplate;

    public MessageSteps() {

        this.restTemplate = new RestTemplate();
    }

    @When("the participant $participant sends a message $message")
    public void theParticipantSendsMessage(@Named("participant") String particpant,
                                           @Named("message") String message) {

    }

    @Then("the participants $participants must receive the message $message")
    public void allParticipantsOfParticipantRoomMustReceiveMessage(@Named("participants") List<String> participants,
                                                                   @Named("message") String message) {

    }
}
