package com.criva.onboardingproject.service.participant;

import com.criva.onboardingproject.model.dao.ParticipantDAO;
import com.criva.onboardingproject.model.vo.room.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService{

    private ParticipantDAO participantDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantDAO participantDAO) {

        this.participantDAO = participantDAO;
    }

    @Override
    public List<Participant> saveParticipants(List<Participant> participants) {

        return participantDAO.saveAll(participants);
    }

    @Override
    public List<Participant> findAllByIds(List<String> ids) {

        return participantDAO.findAllByIdIn(ids);
    }
}
