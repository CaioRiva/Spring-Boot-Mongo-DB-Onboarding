package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.vo.user.UserVO;
import com.criva.onboardingproject.validation.group.AfterSavingValidation;
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
@RequestMapping("/users")
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserVO saveUser(@Valid @RequestBody UserVO user) {

        return userService.saveUser(user);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserVO updateUser(@Validated({AfterSavingValidation.class}) @RequestBody UserVO user) {

        return userService.updateUser(user);
    }


    /* Update that returns no body

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody UserVO room) {

        userService.updateUser(room);
    }

    */

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@Validated({AfterSavingValidation.class}) @RequestBody UserVO user) {

        userService.deleteUser(user);
    }

    @GetMapping("/{id}")
    public UserVO findUserById(@PathVariable("id") String id) {

        return  userService.findUserById(id);
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    public UserVO findUserByName(@NotEmpty @RequestParam("name") String name) {

        return userService.findUserByName(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> findAllUsers() {

        return userService.findAllUsers();
    }
}
