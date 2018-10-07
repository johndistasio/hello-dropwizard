package com.github.johndistasio.hellodropwizard.api;

public class Greeting {
    private long id;
    private String greeting;

    public Greeting() {}

    public Greeting(long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

    public long getId() {
        return id;
    }
    public String getGreeting() {
        return this.greeting;
    }
}
