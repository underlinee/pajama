package com.underlinee.pajama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Developer {

    @Id
    @GeneratedValue
    private Long id;

    private Integer experience;


    public Developer(Integer experience) {
        this.experience = experience;
    }

    public Developer addExperience() {
        this.experience++;
        return this;
    }
}
