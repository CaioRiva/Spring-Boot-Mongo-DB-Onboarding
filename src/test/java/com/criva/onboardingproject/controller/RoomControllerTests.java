package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Room;
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

        RoomCreation roomCreation = new RoomCreation("", "", Arrays.asList("", ""));

        when(roomService.createRoom(any(RoomCreation.class))).thenReturn(
                new Room("", "", Arrays.asList("", "", "")));

        Room room = roomController.createRoom(roomCreation);

        Assert.assertEquals(3, room.getParticipantsId().size());
        verify(roomService, times(1)).createRoom(any(RoomCreation.class));
    }
}
