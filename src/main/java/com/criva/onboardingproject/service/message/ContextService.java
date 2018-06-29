package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.vo.message.ContextVO;

import java.util.List;

public interface ContextService {

    ContextVO saveContext(ContextVO context);

    List<ContextVO> saveContexts(List<ContextVO> contexts);

    List<ContextVO> findAllByIds(List<String> ids);
}
