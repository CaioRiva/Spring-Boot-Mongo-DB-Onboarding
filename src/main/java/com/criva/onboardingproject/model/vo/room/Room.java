package com.criva.onboardingproject.model.vo.room;

import com.criva.onboardingproject.validator.group.AfterSaving;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Room {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String name;

    @NotEmpty
    private List<String> participantsId;

    public Room(String name, List<String> participantsId) {

        this.name = name;
        this.participantsId = participantsId;
    }
}
