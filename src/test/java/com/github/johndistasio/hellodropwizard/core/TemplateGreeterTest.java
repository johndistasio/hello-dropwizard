package com.github.johndistasio.hellodropwizard.core;

import static org.assertj.core.api.Assertions.*;

import com.github.johndistasio.hellodropwizard.api.Greeting;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class TemplateGreeterTest {
    private final String defaultName = "Dropwizard";
    private TemplateGreeter greeter;

    @Before
    public void setup() {
        this.greeter = new TemplateGreeter(this.defaultName, "Hello, %s!");
    }

    @Test
    public void usesDefaultName() {
        Greeting greeting = greeter.sayHello(Optional.empty());
        assertThat(greeting.getGreeting()).contains(this.defaultName);
    }

    @Test
    public void usesProvidedName() {
        Greeting greeting = greeter.sayHello(Optional.of("Potato"));
        assertThat(greeting.getGreeting()).isEqualTo("Hello, Potato!");
    }
}
