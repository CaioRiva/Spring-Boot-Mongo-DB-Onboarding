package com.criva.onboardingproject.service.user;

import com.criva.onboardingproject.model.vo.user.UserVO;

import java.util.List;

public interface UserService {

    UserVO saveUser(UserVO user);

    UserVO updateUser(UserVO user);

    void deleteUser(UserVO user);

    UserVO findUserById(String id);

    List<UserVO> findAllUsers();

    UserVO findUserByName(String name);
}