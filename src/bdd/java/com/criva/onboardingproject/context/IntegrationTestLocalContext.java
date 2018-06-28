package com.criva.onboardingproject.context;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class IntegrationTestLocalContext {

    @Getter
    @Setter
    private Map<String, Object>  contextMapping = new HashMap<>();
}
