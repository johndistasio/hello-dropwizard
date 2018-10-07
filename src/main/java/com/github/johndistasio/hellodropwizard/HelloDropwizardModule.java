package com.github.johndistasio.hellodropwizard;

import com.github.johndistasio.hellodropwizard.core.Greeter;
import com.github.johndistasio.hellodropwizard.core.TemplateGreeter;
import com.github.johndistasio.hellodropwizard.health.TemplateHealthCheck;
import com.github.johndistasio.hellodropwizard.resources.HelloResource;
import com.google.inject.Binder;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;

public class HelloDropwizardModule extends DropwizardAwareModule<HelloDropwizardConfiguration> {
    @Override
    public void configure(Binder binder) {
        binder.bind(HelloResource.class);

        binder.bind(TemplateHealthCheck.class).toInstance(
            new TemplateHealthCheck(getConfiguration().getTemplate())
        );

        binder.bind(Greeter.class).toInstance(
            new TemplateGreeter(
                getConfiguration().getName(),
                getConfiguration().getTemplate()
        ));
    }
}
