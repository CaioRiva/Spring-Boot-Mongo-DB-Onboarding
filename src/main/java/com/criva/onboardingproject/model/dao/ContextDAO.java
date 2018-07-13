package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.message.Context;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextDAO extends MongoRepository<Context, String> {

    List<Context> findAllByIdIn(List<String> ids);
}
