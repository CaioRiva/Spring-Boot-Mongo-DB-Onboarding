package com.criva.onboardingproject.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.steps.Steps;

public class RoomSteps extends Steps {

    @Given("the participant $participant of a room with $roomParticipantsNumber participants in total")
    public void theParticipantOfARoom(@Named("participant") String participant,
                                    @Named("roomParticipantsNumber") Integer roomParticipantsNumber) {

    }
}
