package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.vo.room.ParticipantVO;
import com.criva.onboardingproject.service.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/participants")
@Validated
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {

        this.participantService = participantService;
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipantVO> findAllByIds(@NotEmpty  @RequestParam("ids") List<String> ids) {

        return participantService.findAllByIds(ids);
    }
}
