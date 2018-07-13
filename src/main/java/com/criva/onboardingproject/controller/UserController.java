package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.vo.user.User;
import com.criva.onboardingproject.validator.group.AfterSaving;
import com.criva.onboardingproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User saveUser(@Valid @RequestBody User user) {

        return userService.saveUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Validated({AfterSaving.class}) @RequestBody User user) {

        return userService.updateUser(user);
    }


    /* Update that returns no body

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User room) {

        userService.updateUser(room);
    }

    */

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@Validated({AfterSaving.class}) @RequestBody User user) {

        userService.deleteUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") String id) {

        return  userService.findUserById(id);
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByName(@NotEmpty @RequestParam("name") String name) {

        return userService.findUserByName(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {

        return userService.findAllUsers();
    }
}
