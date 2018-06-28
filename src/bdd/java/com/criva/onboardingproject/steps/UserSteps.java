package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestLocalThread;
import com.criva.onboardingproject.model.vo.user.UserVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.steps.Steps;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class UserSteps extends Steps {

    private static final String USER_RESOURCE_URL = "http://localhost:8080/users";

    private RestTemplate restTemplate;

    public UserSteps() {

        this.restTemplate = new RestTemplate();
    }

    @Given("the new user(s) $users")
    public void theNewUsers(@Named("users") List<String> users) {

        UserVO body;
        HttpEntity<UserVO> request;
        ResponseEntity<UserVO> response;

        for(String user : users) {

             body = new UserVO(UUID.randomUUID().toString(), RandomStringUtils.randomAlphanumeric(8));
             request = new HttpEntity<>(body);
             response = restTemplate.postForEntity(USER_RESOURCE_URL, request, UserVO.class);

             assertThat(response.getStatusCode(), is(HttpStatus.OK));
             assertThat(response.getBody(), notNullValue());

             IntegrationTestLocalThread.getContext().getContextMapping().put(user, response.getBody());
        }
    }
}
