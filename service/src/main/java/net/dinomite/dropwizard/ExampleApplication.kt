package net.dinomite.dropwizard

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import net.dinomite.dropwizard.health.NumberHealthCheck
import net.dinomite.dropwizard.resource.ExampleResource

class ExampleApplication : Application<ExampleConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ExampleApplication().run(*args)
        }
    }

    override fun getName(): String {
        return "example"
    }

    override fun initialize(bootstrap: Bootstrap<ExampleConfiguration>) {
        bootstrap.objectMapper.apply {
            registerModule(KotlinModule())
            registerModule(JavaTimeModule())
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, false)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }

        bootstrap.configurationSourceProvider = SubstitutingSourceProvider(bootstrap.configurationSourceProvider,
                EnvironmentVariableSubstitutor(false))
    }

    @JvmSuppressWildcards
    override fun run(configuration: ExampleConfiguration, environment: Environment) {
        environment.jersey().register(ExampleResource(configuration.numberOfTheDay))

        environment.healthChecks().register("number", NumberHealthCheck(configuration.numberOfTheDay))
    }
}
