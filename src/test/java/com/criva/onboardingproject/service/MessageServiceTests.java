package com.criva.onboardingproject.service;

import com.criva.onboardingproject.handler.exception.room.RoomNotFoundException;
import com.criva.onboardingproject.model.dao.MessageDAO;
import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.model.vo.message.Context;
import com.criva.onboardingproject.model.vo.message.Message;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.service.message.ContextService;
import com.criva.onboardingproject.service.message.MessageService;
import com.criva.onboardingproject.service.message.MessageServiceImpl;
import com.criva.onboardingproject.service.room.RoomService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.util.Arrays;

public class MessageServiceTests {

    private RoomService roomService;
    private MessageDAO messageDAO;
    private ContextService contextService;

    private MessageService messageService;

    @Before
    public void setUp() {

        roomService = mock(RoomService.class);
        messageDAO = mock(MessageDAO.class);
        contextService = mock(ContextService.class);
        messageService = new MessageServiceImpl(roomService, messageDAO, contextService);
    }

    @Test(expected = RoomNotFoundException.class)
    public void testSendMessageRoomNotFound() {

        MessageCreation messageCreation = new MessageCreation("", "");

        when(roomService.findRoomByParticipantId(anyString())).thenReturn(null);

        messageService.sendMessage(messageCreation);

        verify(roomService, times(1)).findRoomByParticipantId(anyString());
    }

    @Test
    public void testSendMessage() {

        MessageCreation messageCreation = new MessageCreation("", "");

        when(roomService.findRoomByParticipantId(anyString())).thenReturn(
                new Room("" ,"", Arrays.asList("", "")));
        when(contextService.saveContext(any(Context.class))).thenReturn(
                new Context("", Boolean.TRUE, Boolean.FALSE));
        when(messageDAO.save(any(Message.class))).thenReturn(
                new Message("", "", Instant.now(), Boolean.TRUE, "",
                        Arrays.asList("", "")));

        messageService.sendMessage(messageCreation);

        verify(roomService, times(1)).findRoomByParticipantId(anyString());
        verify(contextService, times(2)).saveContext(any(Context.class));
        verify(messageDAO, times(1)).save(any(Message.class));
    }

}
