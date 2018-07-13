package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.dto.MessageCreation;
import com.criva.onboardingproject.model.vo.message.Message;

public interface MessageService {

    Message saveMessage(Message message);

    Message sendMessage(MessageCreation messageCreation);
}
