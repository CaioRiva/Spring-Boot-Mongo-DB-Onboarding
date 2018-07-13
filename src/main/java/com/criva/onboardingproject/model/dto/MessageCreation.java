package com.criva.onboardingproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class MessageCreation {

    @NotBlank
    private String text;

    @NotBlank
    private String senderParticipantId;

    public MessageCreation(String text, String senderParticipantId) {

        this.text = text;
        this.senderParticipantId = senderParticipantId;
    }
}
