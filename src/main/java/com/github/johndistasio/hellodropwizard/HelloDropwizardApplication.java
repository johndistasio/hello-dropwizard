package com.github.johndistasio.hellodropwizard;

import com.hubspot.dropwizard.guicier.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Greeter world!
 */
public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloDropwizardApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloDropwizardConfiguration> bootstrap) {
        GuiceBundle<HelloDropwizardConfiguration> guiceBundle = GuiceBundle.defaultBuilder(HelloDropwizardConfiguration.class)
                .modules(new HelloDropwizardModule())
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(HelloDropwizardConfiguration config, Environment env) throws Exception {
    }
}
