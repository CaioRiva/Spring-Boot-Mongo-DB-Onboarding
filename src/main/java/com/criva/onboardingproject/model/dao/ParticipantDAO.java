package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.room.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantDAO extends MongoRepository<Participant, String> {

    List<Participant> findAllByIdIn(List<String> ids);
}
