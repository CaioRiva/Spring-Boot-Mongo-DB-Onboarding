package com.criva.onboardingproject.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RoomCreationDTO {

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private String name;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private String ownerUserId;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private List<String> guestUsersId;

    public RoomCreationDTO() {
    }

    public RoomCreationDTO(@NotNull @NotEmpty String name, @NotNull @NotEmpty String ownerUserId, @NotNull @NotEmpty List<String> guestUsersId) {
        this.name = name;
        this.ownerUserId = ownerUserId;
        this.guestUsersId = guestUsersId;
    }
}
