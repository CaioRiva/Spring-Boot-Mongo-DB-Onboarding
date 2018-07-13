package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestLocalThread;
import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.model.vo.user.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.steps.Steps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RoomSteps extends Steps {

    private static final String ROOM_RESOURCE_URL = "http://localhost:8080/rooms";

    private RestTemplate restTemplate;

    public RoomSteps() {

        this.restTemplate = new RestTemplate();
    }

    @Given("a new room $room created by the user $owner and with the following invited user(s) $guests")
    public void aNewRoom(@Named("room") String room,
                         @Named("owner") String owner,
                         @Named("guests") List<String> guests) {


        String ownerId = ((User) IntegrationTestLocalThread.getContext()
                .getContextMapping().get(owner)).getId();

        List<String> guestsId = guests.stream().map(
                guest -> ((User) IntegrationTestLocalThread.getContext().getContextMapping().get(guest)).getId()
        ).collect(Collectors.toList());

        RoomCreation body = new RoomCreation(RandomStringUtils.randomAlphabetic(10), ownerId, guestsId);
        HttpEntity<RoomCreation> request = new HttpEntity<>(body);
        ResponseEntity<Room> response = restTemplate.postForEntity(ROOM_RESOURCE_URL, request, Room.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        IntegrationTestLocalThread.getContext().getContextMapping().put(room, response.getBody());
    }
}
