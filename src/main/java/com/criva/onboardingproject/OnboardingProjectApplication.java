package com.criva.onboardingproject;

import com.criva.onboardingproject.service.room.RoomService;
import com.criva.onboardingproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnboardingProjectApplication /* implements  CommandLineRunner */{

    /*
    private UserService userService;
    private RoomService roomService;

    @Autowired
    public OnboardingProjectApplication(UserService userService, RoomService roomService) {

        this.userService = userService;
        this.roomService = roomService;
    }
    */

    public static void main(String[] args) {

        SpringApplication.run(OnboardingProjectApplication.class, args);
    }

    /*
    @Override
    public void run(String... args) {

        String idUser1 = userService.saveUser(new UserVO("Caio", "12345678")).getId();
        String idUser2 = userService.saveUser(new UserVO("Cesar", "12345678")).getId();
        String idUser3 = userService.saveUser(new UserVO("Gorete", "12345678")).getId();

        List<String> list = Arrays.asList(idUser2, idUser3);

        roomService.createRoom("Sala1", idUser1, list);
    }
    */

}