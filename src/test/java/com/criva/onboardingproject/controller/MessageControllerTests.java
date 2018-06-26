package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.MessageCreationDTO;
import com.criva.onboardingproject.service.message.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MessageControllerTests {

    private MessageService messageService;

    private MessageController messageController;

    @Before
    public void setUp() {

        messageService = Mockito.mock(MessageService.class);
        messageController = new MessageController(messageService);
    }

    @Test
    public void testsSendMessage() {

        MessageCreationDTO messageCreation = new MessageCreationDTO("", "");

        Mockito.doNothing().when(messageService).sendMessage(Mockito.any(MessageCreationDTO.class));

        messageController.sendMessage(messageCreation);
    }
}
