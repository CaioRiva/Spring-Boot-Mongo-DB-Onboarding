package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.handler.exception.room.RoomNotFoundException;
import com.criva.onboardingproject.model.dao.MessageDAO;
import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.model.vo.message.Context;
import com.criva.onboardingproject.model.vo.message.Message;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService{

    private RoomService roomService;
    private MessageDAO messageDAO;
    private ContextService contextService;

    @Autowired
    public MessageServiceImpl(RoomService roomService, MessageDAO messageDAO, ContextService contextService) {

        this.roomService = roomService;
        this.messageDAO = messageDAO;
        this.contextService = contextService;
    }

    @Override
    public Message saveMessage(Message message) {

        return messageDAO.save(message);
    }

    @Override
    public Message sendMessage(MessageCreation messageCreation) {

        Room room = roomService.findRoomByParticipantId(
                messageCreation.getSenderParticipantId());

        if(room == null) {

            throw new RoomNotFoundException();
        }

        List<Context> contexts = contextService.saveContexts(
                room.getParticipantsId().stream().map(
                        id -> new Context(id, Boolean.TRUE, Boolean.FALSE)
                ).collect(Collectors.toList()));

        return saveMessage(new Message(messageCreation.getText(),
                Instant.now(),
                Boolean.TRUE, messageCreation.getSenderParticipantId(),
                contexts.stream().map(
                        context -> context.getId()
        ).collect(Collectors.toList())));
    }
}
