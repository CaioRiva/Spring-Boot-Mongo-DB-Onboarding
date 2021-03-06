package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.room.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDAO extends MongoRepository<Room, String> {

    Room findByParticipantsIdIn(List<String> ids);
}
