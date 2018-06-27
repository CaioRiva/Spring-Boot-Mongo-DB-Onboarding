package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestsLocalThread;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import java.util.concurrent.atomic.AtomicReference;

public class MessageSteps extends Steps {


    @When("the participant $participant sends a message $message")
    public void theParticipantSendsMessage(@Named("participant") String particpant,
                                           @Named("message") String message) {

        IntegrationTestsLocalThread.getContext().getContextMapping().put(particpant, "Esse cara");
        System.out.println("antes");
    }

    @Then("all participants from the participant $participant room must receive the message $message")
    public void allParticipantsOfParticipantRoomMustReceiveMessage(@Named("participant") String participant,
                                                                   @Named("message") String message) {

        AtomicReference<String> test = new AtomicReference<>((String) IntegrationTestsLocalThread.getContext().getContextMapping().get(participant));

        System.out.println(test.get());
    }
}
