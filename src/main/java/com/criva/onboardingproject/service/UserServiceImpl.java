package com.criva.onboardingproject.service;

import com.criva.onboardingproject.model.dao.UserDAO;
import com.criva.onboardingproject.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User saveUser(User user) {

        return userDAO.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {

        return userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {

        userDAO.delete(user);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public User findUserById(Long id) {

        return userDAO.findById(id);
    }
}
