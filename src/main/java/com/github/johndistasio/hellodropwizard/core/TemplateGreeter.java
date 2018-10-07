package com.github.johndistasio.hellodropwizard.core;

import com.github.johndistasio.hellodropwizard.api.Greeting;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TemplateGreeter implements Greeter {
    private final AtomicLong counter;
    private final String defaultName;
    private final String template;

    public TemplateGreeter(String defaultName, String template) {
        this.counter = new AtomicLong();
        this.defaultName = defaultName;
        this.template = template;
    }

    public Greeting sayHello(Optional<String> name) {
        return new Greeting(
            counter.getAndIncrement(),
            String.format(this.template, name.orElse(this.defaultName))
        );
    }
}
