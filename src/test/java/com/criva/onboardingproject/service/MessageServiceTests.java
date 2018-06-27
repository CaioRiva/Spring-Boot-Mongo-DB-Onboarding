package com.criva.onboardingproject.service;

import com.criva.onboardingproject.handler.exception.room.RoomNotFoundException;
import com.criva.onboardingproject.model.dao.MessageDAO;
import com.criva.onboardingproject.model.dto.MessageCreationDTO;
import com.criva.onboardingproject.model.vo.message.ContextVO;
import com.criva.onboardingproject.model.vo.message.MessageVO;
import com.criva.onboardingproject.model.vo.room.RoomVO;
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

        MessageCreationDTO messageCreation = new MessageCreationDTO("", "");

        when(roomService.findRoomByParticipantId(anyString())).thenReturn(null);

        messageService.sendMessage(messageCreation);

        verify(roomService, times(1)).findRoomByParticipantId(anyString());
    }

    @Test
    public void testSendMessage() {

        MessageCreationDTO messageCreation = new MessageCreationDTO("", "");

        when(roomService.findRoomByParticipantId(anyString())).thenReturn(
                new RoomVO("" ,"", Arrays.asList("", "")));
        when(contextService.saveContext(any(ContextVO.class))).thenReturn(
                new ContextVO("", Boolean.TRUE, Boolean.FALSE));
        when(messageDAO.save(any(MessageVO.class))).thenReturn(
                new MessageVO("", "", Instant.now(), Boolean.TRUE, "",
                        Arrays.asList("", "")));

        messageService.sendMessage(messageCreation);

        verify(roomService, times(1)).findRoomByParticipantId(anyString());
        verify(contextService, times(2)).saveContext(any(ContextVO.class));
        verify(messageDAO, times(1)).save(any(MessageVO.class));
    }

}
