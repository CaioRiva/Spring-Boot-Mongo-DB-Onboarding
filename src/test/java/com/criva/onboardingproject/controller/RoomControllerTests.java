package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.RoomCreationDTO;
import com.criva.onboardingproject.model.vo.room.RoomVO;
import com.criva.onboardingproject.service.room.RoomService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RoomControllerTests {

    private RoomService roomService;

    private  RoomController roomController;

    @Before
    public void setUp() {

        roomService = mock(RoomService.class);
        roomController = new RoomController(roomService);
    }

    @Test
    public void testCreateRoomWithCorrectParticipantsNumber() {

        RoomCreationDTO roomCreation = new RoomCreationDTO("", "", Arrays.asList("", ""));

        when(roomService.createRoom(any(RoomCreationDTO.class))).thenReturn(
                new RoomVO("", "", Arrays.asList("", "", "")));

        RoomVO room = roomController.createRoom(roomCreation);

        Assert.assertEquals(3, room.getParticipantsId().size());
        verify(roomService, times(1)).createRoom(any(RoomCreationDTO.class));
    }
}
