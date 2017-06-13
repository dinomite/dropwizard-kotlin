package net.dinomite.dropwizard.health

import com.codahale.metrics.health.HealthCheck

class NumberHealthCheck(val number: Int) : HealthCheck() {
    @Throws(Exception::class)
    override fun check(): Result {
        if (number == 0) {
            return Result.unhealthy("The number is 0")
        }
        return Result.healthy("The number is a good one")
    }
}
