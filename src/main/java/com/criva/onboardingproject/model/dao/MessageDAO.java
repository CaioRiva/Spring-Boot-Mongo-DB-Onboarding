package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.message.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO extends MongoRepository<Message, String> {
}
