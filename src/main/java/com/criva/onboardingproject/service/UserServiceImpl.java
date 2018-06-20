package com.criva.onboardingproject.service;

import com.criva.onboardingproject.handler.exception.UserNotFoundException;
import com.criva.onboardingproject.model.dao.UserDAO;
import com.criva.onboardingproject.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    public User saveUser(User user) {


        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {

        return userDAO.update(user);
    }

    @Override
    public void deleteUser(User user) {

        userDAO.delete(user);
    }

    @Override
    public User findUserById(Long id) {

        User user = userDAO.findById(id);

        if(user == null) {

            throw  new UserNotFoundException();
        }

        return user;
    }

    @Override
    public List<User> findAllUsers() {

        return userDAO.findAll();
    }
}
