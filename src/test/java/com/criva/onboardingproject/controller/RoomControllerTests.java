package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.RoomCreationDTO;
import com.criva.onboardingproject.model.vo.room.RoomVO;
import com.criva.onboardingproject.service.room.RoomService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class RoomControllerTests {

    private RoomService roomService;

    private  RoomController roomController;

    @Before
    public void setUp() {

        roomService = Mockito.mock(RoomService.class);
        roomController = new RoomController(roomService);
    }

    @Test
    public void testCreateRoom() {

        RoomCreationDTO roomCreation = new RoomCreationDTO("", "", Arrays.asList("", ""));

        Mockito.when(roomService.createRoom(Mockito.any(RoomCreationDTO.class))).thenReturn(
                new RoomVO("", "", Arrays.asList("", "")));

        roomController.createRoom(roomCreation);
    }
}
