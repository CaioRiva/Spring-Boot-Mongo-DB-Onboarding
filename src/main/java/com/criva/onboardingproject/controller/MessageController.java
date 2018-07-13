package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.model.vo.message.Message;
import com.criva.onboardingproject.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/messages",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {

        this.messageService = messageService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Message sendMessage(@Valid @RequestBody MessageCreation messageCreation) {

        return messageService.sendMessage(messageCreation);
    }
}
