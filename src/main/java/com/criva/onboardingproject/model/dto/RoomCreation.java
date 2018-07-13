package com.criva.onboardingproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoomCreation {

    @NotBlank
    private String name;

    @NotBlank
    private String ownerUserId;

    @NotEmpty
    private List<String> guestUsersId;

    public RoomCreation(@NotNull @NotEmpty String name, @NotNull @NotEmpty String ownerUserId, @NotNull @NotEmpty List<String> guestUsersId) {

        this.name = name;
        this.ownerUserId = ownerUserId;
        this.guestUsersId = guestUsersId;
    }
}
