package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.MessageCreationDTO;
import com.criva.onboardingproject.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {

        this.messageService = messageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody MessageCreationDTO messageCreation) {

        messageService.sendMessage(messageCreation);
    }
}
