package net.dinomite.dropwizard.resource

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/example")
@Produces(MediaType.APPLICATION_JSON)
class ExampleResource(val todaysNumber: Int) {
    @GET
    @Path("number")
    @Timed
    fun numberOfTheDay(): NumberOfTheDay {
        return NumberOfTheDay(todaysNumber)
    }

}

data class NumberOfTheDay(val number: Int)
