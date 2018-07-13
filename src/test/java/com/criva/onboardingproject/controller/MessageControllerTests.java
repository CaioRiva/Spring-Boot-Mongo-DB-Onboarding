package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.service.message.MessageService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MessageControllerTests {

    private MessageService messageService;

    private MessageController messageController;

    @Before
    public void setUp() {

        messageService = mock(MessageService.class);
        messageController = new MessageController(messageService);
    }

    @Test
    public void testsSendMessage() {

        MessageCreation messageCreation = new MessageCreation("", "");

        doNothing().when(messageService).sendMessage(any(MessageCreation.class));

        messageController.sendMessage(messageCreation);
        verify(messageService, times(1)).sendMessage(
                any(MessageCreation.class));
    }
}
