package net.dinomite.dropwizard;

import io.dropwizard.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

public class ExampleConfiguration extends Configuration {
    private static final Logger logger = LoggerFactory.getLogger(ExampleConfiguration.class);

    @NotNull
    private int numberOfTheDay = 5;

    public int setNumberOfTheDay(int num) {
        logger.info("Setting numberOfTheDay to " + num);
        numberOfTheDay = num;
        return num;
    }

    public int getNumberOfTheDay() {
        return numberOfTheDay;
    }
}
