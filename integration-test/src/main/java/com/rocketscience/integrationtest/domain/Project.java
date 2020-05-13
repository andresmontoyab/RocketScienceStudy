package com.rocketscience.integrationtest.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Project {

    private Long id;
    private String name;
    private String account;

}
