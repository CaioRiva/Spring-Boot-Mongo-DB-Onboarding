package com.criva.onboardingproject.model.vo.room;

import com.criva.onboardingproject.model.enumerator.Role;
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
public class Participant {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String userId;

    @NotNull
    private Role role;

    public Participant(String userId, Role role) {

        this.userId = userId;
        this.role = role;
    }
}
