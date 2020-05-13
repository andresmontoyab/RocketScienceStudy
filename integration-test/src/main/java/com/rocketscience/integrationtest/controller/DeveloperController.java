package com.rocketscience.integrationtest.controller;

import com.rocketscience.integrationtest.domain.Developer;
import com.rocketscience.integrationtest.repository.DeveloperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class DeveloperController {

    private final DeveloperRepository developerRepository;

    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @GetMapping
    public List<Developer> getDevelopers() {
        return developerRepository.findDevelopersWithLifeExperiences();
    }

    @GetMapping(path = "/developer/{team}")
    public List<Developer> getDeveloperByTeam(@PathVariable("team") String team) {
        return developerRepository.findDevelopersWithLifeExperiences().stream()
                .filter(dev -> dev.getProjectName().equalsIgnoreCase(team)).collect(Collectors.toList());

    }
}
