package org.acme.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;

import java.time.LocalDate;

public record PersonDTO(@NotBlank(message = "Campo nome não pode ser vazio")
                        @QueryParam("name")
                        String name,
                        @NotNull(message = "Campo nascimento não pode ser vazio")
                        @QueryParam("birth")
                        LocalDate birth) {

}