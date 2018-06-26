package com.criva.onboardingproject.service.room;

import com.criva.onboardingproject.model.dto.RoomCreationDTO;
import com.criva.onboardingproject.model.vo.room.RoomVO;

public interface RoomService {

    RoomVO saveRoom(RoomVO room);

    RoomVO findRoomByParticipantId(String participantId);

    RoomVO createRoom(RoomCreationDTO roomCreationDTO);
}
