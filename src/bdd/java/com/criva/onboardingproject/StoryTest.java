package com.criva.onboardingproject;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import com.criva.onboardingproject.steps.MessageSteps;
import com.criva.onboardingproject.steps.ParticipantSteps;
import com.criva.onboardingproject.steps.RoomSteps;
import com.criva.onboardingproject.steps.UserSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoryTest extends JUnitStories {

    @Override
    public Configuration configuration() {

        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.HTML, Format.CONSOLE)
                        .withRelativeDirectory("jbehave-report")
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {

        return new InstanceStepsFactory(configuration(), getConfiguredStepsClasses());
    }

    @Override
    protected List<String> storyPaths() {

        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
                Collections.singletonList("**/story/*.story"), Collections.singletonList(""));
    }

    private List<Steps> getConfiguredStepsClasses() {

        List<Steps> configuredStepsClasses = new ArrayList<>();

        configuredStepsClasses.add(new MessageSteps());
        configuredStepsClasses.add(new RoomSteps());
        configuredStepsClasses.add(new UserSteps());
        configuredStepsClasses.add(new ParticipantSteps());

        return configuredStepsClasses;
    }
}
