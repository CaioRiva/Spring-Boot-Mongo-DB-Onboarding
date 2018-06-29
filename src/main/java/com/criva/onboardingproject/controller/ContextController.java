package com.criva.onboardingproject.controller;

import com.criva.onboardingproject.model.vo.message.ContextVO;
import com.criva.onboardingproject.service.message.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contexts")
public class ContextController {

    ContextService contextService;

    @Autowired
    public ContextController(ContextService contextService) {

        this.contextService = contextService;
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ContextVO> findAllByIds(@RequestParam("ids") List<String> ids) {

        return contextService.findAllByIds(ids);
    }
}