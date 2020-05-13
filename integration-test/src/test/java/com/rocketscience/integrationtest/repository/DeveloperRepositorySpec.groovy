package com.rocketscience.integrationtest.repository

import com.rocketscience.integrationtest.IntegrationTestApplication
import com.rocketscience.integrationtest.domain.Developer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.test.web.client.ExpectedCount.once
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@SpringBootTest(classes = [IntegrationTestApplication])
@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/populateDeveloper.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/cleanDeveloper.sql")
])
class DeveloperRepositorySpec extends Specification {

    private static MockRestServiceServer server

    @Autowired
    private RestTemplate restTemplate

    @Autowired
    private DeveloperRepository developerRepository

    def "FindDevelopersFromProjectA"() {
        given: " Developer and project information in our db"

        when: " the application call the method find"
        List<Developer> developers = developerRepository.findDevelopersFromProjectA()

        then: " the application only return developer from the project A"
        developers.stream().allMatch{ x -> x.getProjectName().equalsIgnoreCase("A")}
        developers.stream().allMatch{ x -> x.getLifeExperiences().size() == 0}
    }

    def "find developers with life experiences"() {
        given: " Developer information in our db and life experience in external service"
        String lifeExperienceResponse = FileLoadUtils.lifeExperiencesResponseTwo()
        server = MockRestServiceServer.createServer(restTemplate)
        server.expect(once(), requestTo("https://xxxxx.xx/xx/xx"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(lifeExperienceResponse, MediaType.APPLICATION_JSON))

        when: " the application call the method find developer with life experience"
        List<Developer> developers = developerRepository.findDevelopersWithLifeExperiences()

        then: " the application returns developers  with life experience "
        developers.stream().allMatch{ x -> x.getLifeExperiences().size() > 1}
    }

    def "life experiences endpoint return 500 code"() {
        given: " Developer information in our db and life experience service fails with internal error"
        server = MockRestServiceServer.createServer(restTemplate)
        server.expect(once(), requestTo("https://xxxxx.xx/xx/xx"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withServerError())

        when: " the application call the method find developer with life experience"
        developerRepository.findDevelopersWithLifeExperiences()

        then: " the rest call should thrown an HtppServerErrorException"
        thrown HttpServerErrorException
    }

    def "life experiences unauthorized endpoint"() {
        given: " Developer information in our db and we dont have life experience service credentials "
        server = MockRestServiceServer.createServer(restTemplate)
        server.expect(once(), requestTo("https://xxxxx.xx/xx/xx"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.UNAUTHORIZED))

        when: " the application call the method find developer with life experience "
        developerRepository.findDevelopersWithLifeExperiences()

        then: " the rest call should thrown an HttpClientErrorException"
        thrown HttpClientErrorException
    }
}
