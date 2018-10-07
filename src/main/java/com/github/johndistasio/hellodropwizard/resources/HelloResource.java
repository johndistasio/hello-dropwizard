package com.github.johndistasio.hellodropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.github.johndistasio.hellodropwizard.api.Greeting;
import com.github.johndistasio.hellodropwizard.core.Greeter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final Greeter greeter;

    @Inject
    public HelloResource(Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    @Timed
    public Greeting getHello(@QueryParam("name") Optional<String> name) {
        return greeter.sayHello(name);
    }
}
