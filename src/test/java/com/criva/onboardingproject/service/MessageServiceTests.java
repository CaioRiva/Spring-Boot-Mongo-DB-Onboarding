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
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Arrays;

public class MessageServiceTests {

    private RoomService roomService;
    private MessageDAO messageDAO;
    private ContextService contextService;

    private MessageService messageService;

    @Before
    public void setUp() {

        roomService = Mockito.mock(RoomService.class);
        messageDAO = Mockito.mock(MessageDAO.class);
        contextService = Mockito.mock(ContextService.class);
        messageService = new MessageServiceImpl(roomService, messageDAO, contextService);
    }

    @Test(expected = RoomNotFoundException.class)
    public void testSendMessageRoomNotFound() {

        MessageCreationDTO messageCreation = new MessageCreationDTO("", "");

        Mockito.when(roomService.findRoomByParticipantId(Mockito.anyString())).thenReturn(null);

        messageService.sendMessage(messageCreation);
    }

    @Test
    public void testSendMessage() {

        MessageCreationDTO messageCreation = new MessageCreationDTO("", "");

        Mockito.when(roomService.findRoomByParticipantId(Mockito.anyString())).thenReturn(
                new RoomVO("" ,"", Arrays.asList("", "")));
        Mockito.when(contextService.saveContext(Mockito.any(ContextVO.class))).thenReturn(
                new ContextVO("", Boolean.TRUE, Boolean.FALSE));
        Mockito.when(messageDAO.save(Mockito.any(MessageVO.class))).thenReturn(
                new MessageVO("", "", Instant.now(), Boolean.TRUE, "",
                        Arrays.asList("", "")));

        messageService.sendMessage(messageCreation);
    }

}
