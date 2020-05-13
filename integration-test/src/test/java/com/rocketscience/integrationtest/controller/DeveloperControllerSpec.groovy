package com.rocketscience.integrationtest.controller

import com.rocketscience.integrationtest.IntegrationTestApplication
import com.rocketscience.integrationtest.repository.FileLoadUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.NestedServletException
import spock.lang.Specification

import static org.springframework.test.web.client.ExpectedCount.once
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest(classes = [IntegrationTestApplication])
@AutoConfigureMockMvc
@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/populateDeveloper.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/cleanDeveloper.sql")
])
class DeveloperControllerSpec extends Specification {

    private static MockRestServiceServer server
    @Autowired
    private RestTemplate restTemplate
    @Autowired
    private MockMvc mvc

    def "Good Response"() {
        given: " Developer information in our db and life experience service its ok"
        String lifeExperienceResponse = FileLoadUtils.lifeExperiencesResponseTwo()
        server = MockRestServiceServer.createServer(restTemplate)
        server.expect(once(), requestTo("https://xxxxx.xx/xx/xx"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(lifeExperienceResponse, MediaType.APPLICATION_JSON))

        when: " the rest call should thrown an HtppServerErrorException"
        mvc.perform(get("/developer/A")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())

        then: ""
    }

    def "life experiences endpoint return 500 code"() {
        given: " Developer information in our db and life experience service fails with internal error"
        server = MockRestServiceServer.createServer(restTemplate)
        server.expect(once(), requestTo("https://xxxxx.xx/xx/xx"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withServerError())

        when: " the application call the method find developer with life experience"
        mvc.perform(get("/developer/A")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())

        then: " the rest call should thrown an HtppServerErrorException"
        thrown NestedServletException
    }

}
