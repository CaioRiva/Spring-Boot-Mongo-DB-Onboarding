package com.criva.onboardingproject.service.user;

import com.criva.onboardingproject.model.vo.user.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    User findUserById(String id);

    List<User> findAllUsers();

    User findUserByName(String name);
}