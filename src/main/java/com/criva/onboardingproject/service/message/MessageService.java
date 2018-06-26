package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.dto.MessageCreationDTO;
import com.criva.onboardingproject.model.vo.message.MessageVO;

public interface MessageService {

    MessageVO saveMessage(MessageVO message);

    void sendMessage(MessageCreationDTO messageCreation);
}
