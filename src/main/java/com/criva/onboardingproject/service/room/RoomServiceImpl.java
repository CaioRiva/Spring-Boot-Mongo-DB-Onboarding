package com.criva.onboardingproject.service.room;

import com.criva.onboardingproject.model.dao.RoomDAO;
import com.criva.onboardingproject.model.dto.RoomCreationDTO;
import com.criva.onboardingproject.model.vo.room.ParticipantVO;
import com.criva.onboardingproject.model.vo.room.RoleEnum;
import com.criva.onboardingproject.model.vo.room.RoomVO;
import com.criva.onboardingproject.service.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private RoomDAO roomDAO;
    private ParticipantService participantService;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO, ParticipantService participantService) {
        this.roomDAO = roomDAO;
        this.participantService = participantService;
    }

    @Override
    public RoomVO saveRoom(RoomVO room) {

        return roomDAO.save(room);
    }

    @Override
    public RoomVO findRoomByParticipantId(String participantId) {

        return roomDAO.findByParticipantsIdIn(Arrays.asList(participantId));
    }

    @Override
    public RoomVO createRoom(RoomCreationDTO roomCreation) {

        List<ParticipantVO> participants = new ArrayList<>();
        List<String> participantsId = new ArrayList<>();

        participants.add(new ParticipantVO(roomCreation.getOwnerUserId(), RoleEnum.OWNER));
        roomCreation.getGuestUsersId().forEach(id -> participants.add(new ParticipantVO(id, RoleEnum.GUEST)));

        participantService.saveParticipants(participants)
                .forEach(participant -> participantsId.add(participant.getId()));

        return saveRoom(new RoomVO(roomCreation.getName(), participantsId));
    }
}
