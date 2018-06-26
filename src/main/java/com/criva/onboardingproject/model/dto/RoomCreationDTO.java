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
    private String creatorUserId;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    private List<String> invitedUsersId;

    public RoomCreationDTO() {
    }

    public RoomCreationDTO(String name, String creatorUserId, List<String> invitedUsersId) {

        this.name = name;
        this.creatorUserId = creatorUserId;
        this.invitedUsersId = invitedUsersId;
    }
}
