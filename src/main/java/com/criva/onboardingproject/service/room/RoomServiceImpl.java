package com.criva.onboardingproject.service.room;

import com.criva.onboardingproject.model.dao.RoomDAO;
import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Participant;
import com.criva.onboardingproject.model.enumerator.Role;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.service.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public Room saveRoom(Room room) {

        return roomDAO.save(room);
    }

    @Override
    public Room findRoomByParticipantId(String participantId) {

        return roomDAO.findByParticipantsIdIn(Arrays.asList(participantId));
    }

    @Override
    public Room createRoom(RoomCreation roomCreation) {

        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(roomCreation.getOwnerUserId(), Role.OWNER));
        roomCreation.getGuestUsersId().forEach(
                id -> participants.add(new Participant(id, Role.GUEST))
        );

        List<String> participantsId = participantService.saveParticipants(participants).stream().map(
                participant -> participant.getId()
        ).collect(Collectors.toList());

        return saveRoom(new Room(roomCreation.getName(), participantsId));
    }
}