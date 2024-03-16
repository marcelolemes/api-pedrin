package org.acme.controller;

import jakarta.ws.rs.QueryParam;

import java.time.LocalDate;

public class PersonDTO {
    @QueryParam("id")
    Long id;
    @QueryParam("name")
    String name;
    @QueryParam("birth")
    LocalDate birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PersonDTO(Long id, String name, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public PersonDTO(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public PersonDTO() {
    }
}
