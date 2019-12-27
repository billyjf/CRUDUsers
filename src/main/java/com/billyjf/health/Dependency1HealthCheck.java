package com.billyjf.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * There aren't many dependencies in this project, but, if there were, this class would represent
 * the first dependency health check.
 */
public class Dependency1HealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
