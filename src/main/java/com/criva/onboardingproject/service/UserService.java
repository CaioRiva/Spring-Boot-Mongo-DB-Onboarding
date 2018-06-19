package com.criva.onboardingproject.service;

import com.criva.onboardingproject.model.dto.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    User findUserById(Long id);

    List<User> findAllUsers();

}
