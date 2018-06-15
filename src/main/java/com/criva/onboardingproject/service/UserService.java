package com.criva.onboardingproject.service;

import com.criva.onboardingproject.model.vo.User;

public interface UserService {

    public User saveUser(User user);

    public User updateUser(User user);

    public void deleteUser(User user);

    public User findUserById(Long id);

}
