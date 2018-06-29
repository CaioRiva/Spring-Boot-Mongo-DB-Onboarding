package com.criva.onboardingproject.model.vo.message;

import com.criva.onboardingproject.validation.group.AfterSavingValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Document(collection = "message")
public class MessageVO {

    @Id
    @Field("_id")
    @Getter
    @NotNull(groups = {AfterSavingValidation.class})
    @NotEmpty(groups = {AfterSavingValidation.class})
    private String id;

    @Field("text")
    @Getter
    @Setter
    private String text;

    @Field("sent_timestamp")
    @Getter
    @Setter
    private Instant sentTimestamp;

    @Field("sent")
    @Getter
    @Setter
    private Boolean sent;

    @Field("sender_participant_id")
    @Getter
    @Setter
    private String senderParticipantId;

    @Field("contexts_id")
    @Getter
    @Setter
    private List<String> contextsId;

    public MessageVO() {
    }

    public MessageVO(String id, String text, Instant sentTimestamp, Boolean sent, String senderParticipantId, List<String> contextsId) {

        this.id = id;
        this.text = text;
        this.sentTimestamp = sentTimestamp;
        this.sent = sent;
        this.senderParticipantId = senderParticipantId;
        this.contextsId = contextsId;
    }

    public MessageVO(String text, Instant sentTimestamp, Boolean sent, String senderParticipantId, List<String> contextsId) {

        this.text = text;
        this.sentTimestamp = sentTimestamp;
        this.sent = sent;
        this.senderParticipantId = senderParticipantId;
        this.contextsId = contextsId;
    }
}
