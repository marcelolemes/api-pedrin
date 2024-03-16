package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public PersonEntity(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public PersonEntity(Long id, String name, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public PersonEntity() {
    }
}
