package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.vo.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends MongoRepository<User, String> {

    User findByName(String name);
}
