package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/rooms",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {

        this.roomService = roomService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Room createRoom(@Valid @RequestBody RoomCreation roomCreation) {

        return roomService.createRoom(roomCreation);
    }
}