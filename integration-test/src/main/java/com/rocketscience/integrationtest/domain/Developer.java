package com.rocketscience.integrationtest.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Developer {

    private Long id;
    private String name;
    private String role;
    private String alias;
    private String projectName;
    private List<LifeExperience> lifeExperiences;
}
