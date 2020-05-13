package com.rocketscience.integrationtest.repository

import com.rocketscience.integrationtest.IntegrationTestApplication
import com.rocketscience.integrationtest.domain.Developer
import com.rocketscience.integrationtest.domain.LifeExperience
import com.rocketscience.integrationtest.domain.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@SpringBootTest(classes = [IntegrationTestApplication])
@Sql("/project.sql")
class ProjectRepositorySpec extends Specification {

    @Autowired
    private ProjectRepository projectRepository
    private Developer developer = Developer.builder().lifeExperiences(new ArrayList<LifeExperience>()).build()

    @DirtiesContext
    def "delete all data from project table"() {
        given: " an project table with information"

        when: " the application calls the method deleteAll"
        Integer amountRowDeleted = projectRepository.deleteAll()
        developer.getLifeExperiences().add(new LifeExperience())

        then: " the application must delete more than zero record"
        amountRowDeleted > 0
        developer.getLifeExperiences().size() == 1
    }

    def "Find Project from account Other"() {
        given: " project from the account Other"

        when: " the application call the method find projects"
        List<Project> projects = projectRepository.findProjectFromOtherAccount()

        then: " the application only return project from the account Other"
        projects.stream().allMatch{ x -> x.getAccount().equalsIgnoreCase("Other")}
        projects.stream().count() > 0
        developer.getLifeExperiences().size() == 0
    }
}
