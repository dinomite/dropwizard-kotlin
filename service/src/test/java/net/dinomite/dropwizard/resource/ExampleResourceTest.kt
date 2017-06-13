package net.forumforall.kuorum.resource

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.testing.junit.ResourceTestRule
import net.dinomite.dropwizard.resource.ExampleResource
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ExampleResourceTest {
    val number = 7
    val exampleResource = ExampleResource(number)

    val objectMapper = ObjectMapper()

    @Rule @JvmField
    val resources: ResourceTestRule = ResourceTestRule.builder()
            .setTestContainerFactory(GrizzlyWebTestContainerFactory())
            .addResource(exampleResource)
            .build()

    @Test
    fun testGetNumberOfTheDay() {
        val resultJson = resources.jerseyTest
                .target("/example/number")
                .request()
                .get(String::class.java)

        val result = objectMapper.readValue(resultJson, JsonNode::class.java)
        assertEquals(number, result.get("number").intValue())
    }
}
