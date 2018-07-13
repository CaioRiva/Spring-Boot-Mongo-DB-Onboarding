package com.criva.onboardingproject.model.vo.message;

import com.criva.onboardingproject.validator.group.AfterSaving;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Message {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String text;

    @NotNull
    private Instant sentTimestamp;

    @NotNull
    private Boolean sent;

    @NotBlank
    private String senderParticipantId;

    @NotEmpty
    private List<String> contextsId;

    public Message(String text, Instant sentTimestamp, Boolean sent, String senderParticipantId, List<String> contextsId) {

        this.text = text;
        this.sentTimestamp = sentTimestamp;
        this.sent = sent;
        this.senderParticipantId = senderParticipantId;
        this.contextsId = contextsId;
    }
}
