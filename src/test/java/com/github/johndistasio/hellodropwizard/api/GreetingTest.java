package com.github.johndistasio.hellodropwizard.api;

import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.FixtureHelpers;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

public class GreetingTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Greeting greeting = new Greeting(1, "Hello, Dropwizard!");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(FixtureHelpers.fixture("fixtures/greeting.json"), Greeting.class));

        assertThat(MAPPER.writeValueAsString(greeting)).isEqualTo(expected);
    }

}
