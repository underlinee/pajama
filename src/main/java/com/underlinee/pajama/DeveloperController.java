package com.underlinee.pajama;

import com.underlinee.pajama.domain.Developer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/developers")
@AllArgsConstructor
public class DeveloperController {

    private DeveloperRepository developerRepository;

    @GetMapping("")
    public List<Developer> getDevelopers() {
        return developerRepository.findAll();
    }

    @PatchMapping("")
    public String addExperience() {
        Integer experience = developerRepository.findAll().stream()
                .map(developer -> developer.addExperience())
                .map(developer -> developer.getExperience())
                .findFirst()
                .orElse(0);
        return experience + " year";
    }

    @PostMapping
    public Developer hire() {
        Developer newbie = new Developer(0);
        developerRepository.save(newbie);
        return newbie;
    }

}
