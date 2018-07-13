package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.vo.message.Context;
import com.criva.onboardingproject.service.message.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/contexts",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ContextController {

    ContextService contextService;

    @Autowired
    public ContextController(ContextService contextService) {

        this.contextService = contextService;
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public List<Context> findAllByIds(@NotEmpty @RequestParam("ids") List<String> ids) {

        return contextService.findAllByIds(ids);
    }
}