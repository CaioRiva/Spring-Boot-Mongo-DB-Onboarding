package com.criva.onboardingproject.model.vo.user;

import com.criva.onboardingproject.validation.group.AfterSavingValidation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "room")
public class UserVO implements Serializable {

    private static final long serialVersionUID = 3163789829776614249L;

    @Id
    @Field("_id")
    @Getter
    @NotNull(groups = {AfterSavingValidation.class})
    @NotEmpty(groups = {AfterSavingValidation.class})
    private String id;

    @Field("name")
    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private String name;

    @Field("password")
    @Getter
    @Setter
    @NotNull
    @Size(min = 8, max = 24)
    private String password;

    public UserVO() { }

    @JsonCreator
    public UserVO(@JsonProperty("name") String name, @JsonProperty("password") String password) {
        this.name = name;
        this.password = password;
    }
}
