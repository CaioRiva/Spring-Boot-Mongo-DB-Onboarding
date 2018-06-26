package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.message.MessageVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO extends MongoRepository<MessageVO, String> {
}
