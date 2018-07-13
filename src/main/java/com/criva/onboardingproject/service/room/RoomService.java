package com.criva.onboardingproject.service.room;

import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Room;

public interface RoomService {

    Room saveRoom(Room room);

    Room findRoomByParticipantId(String participantId);

    Room createRoom(RoomCreation roomCreationDTO);
}
