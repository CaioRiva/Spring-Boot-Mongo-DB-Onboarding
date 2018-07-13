package com.criva.onboardingproject.service.user;

import com.criva.onboardingproject.handler.exception.user.UserNameAlreadyTakenException;
import com.criva.onboardingproject.handler.exception.user.UserNotFoundException;
import com.criva.onboardingproject.model.dao.UserDAO;
import com.criva.onboardingproject.model.vo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    public User saveUser(User user) {

        if(userDAO.findByName(user.getName()) != null) {

            throw  new UserNameAlreadyTakenException();
        }

        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {

        User savedUser = findUserByName(user.getName());

        if(savedUser != null && !savedUser.getId().equals(user.getId())) {

            throw new UserNameAlreadyTakenException();
        }

        return userDAO.save(user);
    }

    @Override
    public void deleteUser(User user) {

        userDAO.delete(user);
    }

    @Override
    public User findUserById(String id) {

        Optional<User> user = userDAO.findById(id);

        if(!user.isPresent()) {

            throw  new UserNotFoundException();
        }

        return user.get();
    }

    @Override
    public List<User> findAllUsers() {

        return userDAO.findAll();
    }

    @Override
    public User findUserByName(String name) {

        User user = userDAO.findByName(name);

        if(user == null) {

            throw new UserNotFoundException();
        }

        return user;
    }
}
