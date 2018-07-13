package com.criva.onboardingproject.model.vo.user;

import com.criva.onboardingproject.validator.group.AfterSaving;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String name;

    @Size(min = 8, max = 24)
    private String password;

    public User(String name, String password) {

        this.name = name;
        this.password = password;
    }
}
