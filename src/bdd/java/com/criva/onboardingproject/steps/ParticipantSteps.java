package com.criva.onboardingproject.steps;

import com.criva.onboardingproject.context.IntegrationTestLocalThread;
import com.criva.onboardingproject.model.vo.room.Participant;
import com.criva.onboardingproject.model.vo.room.Room;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.steps.Steps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ParticipantSteps extends Steps {

    private static final String PARTICIPANTS_RESOURCE_URL = "http://localhost:8080/participants";

    private RestTemplate restTemplate;

    public ParticipantSteps() {

        this.restTemplate = new RestTemplate();
    }

    @Given("the participants $participants of the room $room")
    public void theParticipantsOfTheRoom(@Named("participants") List<String> participants,
                                         @Named("room") String room) {

        Room savedRoom = (Room) IntegrationTestLocalThread.getContext()
                .getContextMapping().get(room);

        UriComponentsBuilder urlBuilder = UriComponentsBuilder
                .fromHttpUrl(PARTICIPANTS_RESOURCE_URL)
                .queryParam("ids", String.join(",", savedRoom.getParticipantsId()));

        ResponseEntity<Participant[]> response = restTemplate.getForEntity(urlBuilder.toUriString(), Participant[].class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertEquals(participants.size(), response.getBody().length);

        for(int i = 0; i < participants.size(); i++) {

            IntegrationTestLocalThread.getContext().getContextMapping().put(participants.get(i), response.getBody()[i]);
        }
    }
}
