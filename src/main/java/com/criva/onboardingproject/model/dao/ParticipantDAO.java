package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.room.ParticipantVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantDAO extends MongoRepository<ParticipantVO, String> {
}
