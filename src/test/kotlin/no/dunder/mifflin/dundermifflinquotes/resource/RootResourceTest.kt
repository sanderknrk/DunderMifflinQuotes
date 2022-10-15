package no.dunder.mifflin.dundermifflinquotes.resource

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


@SpringBootTest
@AutoConfigureMockMvc
class RootResourceTest(@Autowired val mvc: MockMvc) {

    @Test
    fun root_returnsOK() {
        // Arrange

        // Act
        val response = mvc.perform(get("/")).andReturn().response

        // Assert
        assert(response.status == HttpStatus.OK.value())
        assert(response.contentAsString == "OK")
    }

}
