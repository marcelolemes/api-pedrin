package org.acme.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;

import java.time.LocalDate;

public class PersonDTO {
    @NotEmpty
    @NotBlank(message = "Campo nome não pode ser vazio")
    @QueryParam("name")
    String name;

    @NotNull(message = "Campo nascimento não pode ser vazio")
    @QueryParam("birth")
    LocalDate birth;
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

    public PersonDTO(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public PersonDTO() {
    }
}
