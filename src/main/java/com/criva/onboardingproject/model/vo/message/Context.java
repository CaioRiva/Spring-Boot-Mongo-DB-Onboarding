package com.criva.onboardingproject.model.vo.message;

import com.criva.onboardingproject.validator.group.AfterSaving;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Context {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String recipientParticipantId;

    @NotNull
    private Boolean received;

    @NotNull
    private Boolean viewed;

    public Context(String recipientParticipantId, Boolean received, Boolean viewed) {

        this.recipientParticipantId = recipientParticipantId;
        this.received = received;
        this.viewed = viewed;
    }
}
