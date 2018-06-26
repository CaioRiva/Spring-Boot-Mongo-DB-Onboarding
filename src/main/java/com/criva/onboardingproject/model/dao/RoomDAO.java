package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.room.RoomVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDAO extends MongoRepository<RoomVO, String> {

    RoomVO findByParticipantsIdIn(List<String> ids);
}
