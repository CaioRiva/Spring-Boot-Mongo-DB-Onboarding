package com.criva.onboardingproject;

import com.criva.onboardingproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnboardingProjectApplication /* implements CommandLineRunner */ {

    @Autowired
    UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(OnboardingProjectApplication.class, args);
    }

    /* Should be used when trying to run locally

    @Override
    public void run(String... args) throws Exception {

        User user = userService.findUserById(2L);
        userService.deleteUser(user);
    }

    */
}git
