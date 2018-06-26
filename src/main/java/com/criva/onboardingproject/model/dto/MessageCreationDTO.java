package com.criva.onboardingproject.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MessageCreationDTO {

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private String text;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private String senderParticipantId;

    public MessageCreationDTO() {
    }

    public MessageCreationDTO(String text, String senderParticipantId) {

        this.text = text;
        this.senderParticipantId = senderParticipantId;
    }
}
