package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.handler.GeneralExceptionHandler;
import com.criva.onboardingproject.model.dto.User;
import com.criva.onboardingproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody User user) {

        userService.deleteUser(user);
    }

    /*  Using path paramusers;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@RequestParam("id") Long id) {

        return userService.findUserById(id);
    }

    */

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {

        User user = userService.findUserById(id);

        return user;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {

        return userService.findAllUsers();
    }
}
