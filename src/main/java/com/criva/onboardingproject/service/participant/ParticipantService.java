package com.criva.onboardingproject.service.participant;

import com.criva.onboardingproject.model.vo.room.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> saveParticipants(List<Participant> participants);

    List<Participant> findAllByIds(List<String> ids);
}
