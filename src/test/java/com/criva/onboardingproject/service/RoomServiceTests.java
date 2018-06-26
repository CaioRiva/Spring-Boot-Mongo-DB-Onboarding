package com.criva.onboardingproject.service;

import com.criva.onboardingproject.model.dao.RoomDAO;
import com.criva.onboardingproject.model.dto.RoomCreationDTO;
import com.criva.onboardingproject.model.vo.room.ParticipantVO;
import com.criva.onboardingproject.model.vo.room.RoleEnum;
import com.criva.onboardingproject.model.vo.room.RoomVO;
import com.criva.onboardingproject.service.participant.ParticipantService;
import com.criva.onboardingproject.service.room.RoomService;
import com.criva.onboardingproject.service.room.RoomServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class RoomServiceTests {

    private RoomDAO roomDAO;
    private ParticipantService participantService;

    private RoomService roomService;

    @Before
    public void setUp() {

        roomDAO = Mockito.mock(RoomDAO.class);
        participantService = Mockito.mock(ParticipantService.class);

        roomService = new RoomServiceImpl(roomDAO, participantService);
    }

    @Test
    public void testRoomCreatedWithCorrectParticipantsNumber() {

        RoomCreationDTO roomCreation = new RoomCreationDTO("", "", Arrays.asList("", ""));

        Mockito.when(participantService.saveParticipants(Mockito.anyList())).thenReturn(
                Arrays.asList(new ParticipantVO("", "", RoleEnum.RULER),
                        new ParticipantVO("", "", RoleEnum.GUEST),
                        new ParticipantVO("", "", RoleEnum.GUEST)));
        Mockito.when(roomDAO.save(Mockito.any(RoomVO.class))).thenReturn(
                new RoomVO("", "", Arrays.asList("", "", "")));

        RoomVO room = roomService.createRoom(roomCreation);

        Assert.assertEquals(3, room.getParticipantsId().size());
    }
}
