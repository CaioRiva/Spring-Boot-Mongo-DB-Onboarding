package com.criva.onboardingproject.model.dao;

import com.criva.onboardingproject.model.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
}
