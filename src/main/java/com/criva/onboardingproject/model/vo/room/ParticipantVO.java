package com.criva.onboardingproject.model.vo.room;

import com.criva.onboardingproject.validation.group.AfterSavingValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "participant")
public class ParticipantVO {

    @Id
    @Field("_id")
    @Getter
    @NotNull(groups = {AfterSavingValidation.class})
    @NotEmpty(groups = {AfterSavingValidation.class})
    private String id;

    @Field("user_id")
    @Getter
    @Setter
    private String userId;

    @Field("role")
    @Getter
    @Setter
    private RoleEnum role;

    public ParticipantVO() {
    }

    public ParticipantVO(String id, String userId, RoleEnum role) {

        this.id = id;
        this.userId = userId;
        this.role = role;
    }

    public ParticipantVO(String userId, RoleEnum role) {

        this.userId = userId;
        this.role = role;
    }
}
