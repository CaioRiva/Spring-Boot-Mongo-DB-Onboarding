package com.criva.onboardingproject;

import com.criva.onboardingproject.model.vo.room.Participant;
import com.criva.onboardingproject.service.participant.ParticipantService;
import com.criva.onboardingproject.service.room.RoomService;
import com.criva.onboardingproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class OnboardingProjectApplication implements CommandLineRunner {


    private UserService userService;
    private RoomService roomService;
    private ParticipantService participantService;

    @Autowired
    public OnboardingProjectApplication(UserService userService, RoomService roomService, ParticipantService participantService) {

        this.userService = userService;
        this.roomService = roomService;
        this.participantService = participantService;
    }


    public static void main(String[] args) {

        SpringApplication.run(OnboardingProjectApplication.class, args);
    }


    @Override
    public void run(String... args) {

        List<Participant> p = participantService.findAllByIds(Arrays.asList("5b350965893ff20f06f7d1dc", "5b350965893ff20f06f7d1dd", "5b350965893ff20f06f7d1de"));
        List<String> a = new ArrayList<>();
    }
}