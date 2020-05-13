package com.rocketscience.integrationtest.repository;

import com.rocketscience.integrationtest.domain.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Project> findProjectFromOtherAccount() {
        return jdbcTemplate.query(
                "Select proj.* from project proj where proj.account = 'Other'",
                (resultSet, i) ->
                        Project.builder()
                                .id(resultSet.getLong("id"))
                                .name(resultSet.getString("name"))
                                .account(resultSet.getString("account"))
                                .build()
        );
    }

    public int deleteAll(){
        return jdbcTemplate.update("delete from project");
    }

}
