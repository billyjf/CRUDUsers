package com.billyjf;

import com.billyjf.health.Dependency1HealthCheck;
import com.billyjf.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CRUDUsersApplication extends Application<CRUDUsersConfiguration> {
    public final String APP_NAME = "CRUDUsers";

    public static void main(String[] args) throws Exception {
        new CRUDUsersApplication().run(args);
    }

    @Override
    public String getName() {
        return APP_NAME;
    }

    @Override
    public void run(CRUDUsersConfiguration configuration, Environment environment) {
        final UserResource resource = new UserResource(configuration.getUsers());
        final Dependency1HealthCheck healthCheck = new Dependency1HealthCheck();
        environment.healthChecks().register("dependency1", healthCheck);
        environment.jersey().register(resource);
    }
}
