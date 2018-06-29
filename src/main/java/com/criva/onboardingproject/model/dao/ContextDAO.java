package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.message.ContextVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextDAO extends MongoRepository<ContextVO, String> {

    List<ContextVO> findAllByIdIn(List<String> ids);
}
