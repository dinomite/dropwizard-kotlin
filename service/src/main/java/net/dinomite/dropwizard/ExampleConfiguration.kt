package net.dinomite.dropwizard

import io.dropwizard.Configuration
import javax.validation.constraints.NotNull

class ExampleConfiguration : Configuration() {
    @NotNull
    var numberOfTheDay = 5
}
