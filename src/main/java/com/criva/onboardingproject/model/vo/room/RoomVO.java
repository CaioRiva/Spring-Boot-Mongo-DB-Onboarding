package com.criva.onboardingproject.model.vo.room;

import com.criva.onboardingproject.validation.group.AfterSavingValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "room")
public class RoomVO {

    @Id
    @Field("_id")
    @Getter
    @NotNull(groups = {AfterSavingValidation.class})
    @NotEmpty(groups = {AfterSavingValidation.class})
    private String id;

    @Field("name")
    @Getter
    @Setter
    private String name;

    @Field("participants_id")
    @Getter
    @Setter
    private List<String> participantsId;

    public RoomVO() {
    }

    public RoomVO(String id, String name, List<String> participantsId) {

        this.id = id;
        this.name = name;
        this.participantsId = participantsId;
    }

    public RoomVO(String name, List<String> participantsId) {

        this.name = name;
        this.participantsId = participantsId;
    }
}
