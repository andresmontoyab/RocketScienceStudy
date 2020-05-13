package com.rocketscience.integrationtest.repository;

import com.rocketscience.integrationtest.domain.Developer;
import com.rocketscience.integrationtest.domain.LifeExperience;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DeveloperRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RestTemplate restTemplate;

    public DeveloperRepository(JdbcTemplate jdbcTemplate, RestTemplate restTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = restTemplate;
    }

    public List<Developer> findDevelopersFromProjectA() {
        return jdbcTemplate.query(
                "Select dev.*, proj.name as projectName from developer dev, project proj where dev.project_id = proj.id and proj.name = 'A'",
                new DeveloperRowMapper()
        );
    }

    public List<Developer> findDevelopersWithLifeExperiences() {
        List<Developer> allDevelopers = jdbcTemplate.query(
                "Select dev.*,  proj.name as projectName from developer dev, project proj where dev.project_id = proj.id",
                new DeveloperRowMapper());

        ResponseEntity<List<LifeExperience>> lifeExperiencesResponse = getLifeExperiences();
        List<LifeExperience> lifeExperiences = lifeExperiencesResponse.getBody();
        Map<Long, List<LifeExperience>> lifeExperiencesPerDeveloper = lifeExperiences.stream()
                .collect(Collectors.groupingBy(x -> x.getDeveloperId()));

        allDevelopers.forEach(developer -> developer.getLifeExperiences().addAll(lifeExperiencesPerDeveloper.get(developer.getId())));
        return allDevelopers;

    }

    private ResponseEntity<List<LifeExperience>> getLifeExperiences() {
        return restTemplate.exchange("https://xxxxx.xx/xx/xx",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<LifeExperience>>() {});
    }

    static class DeveloperRowMapper implements RowMapper<Developer> {
        @Override
        public Developer mapRow(ResultSet resultSet, int i) throws SQLException {
            return Developer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .role(resultSet.getString("role"))
                    .alias(resultSet.getString("alias"))
                    .projectName(resultSet.getString("projectName"))
                    .lifeExperiences(new ArrayList<>())
                    .build();
        }
    }
}
