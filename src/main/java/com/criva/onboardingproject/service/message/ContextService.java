package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.vo.message.Context;

import java.util.List;

public interface ContextService {

    Context saveContext(Context context);

    List<Context> saveContexts(List<Context> contexts);

    List<Context> findAllByIds(List<String> ids);
}
