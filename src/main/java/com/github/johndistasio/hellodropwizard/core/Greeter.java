package com.github.johndistasio.hellodropwizard.core;

import com.github.johndistasio.hellodropwizard.api.Greeting;

import java.util.Optional;

public interface Greeter {
    Greeting sayHello(Optional<String> name);
}
