package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.PersonEntity;
import org.acme.service.PrincipalService;
import org.acme.util.PersonMapper;

import java.util.Optional;

@Path("/v1/api")
public class PrincipalController {
    private PrincipalService service;

    public PrincipalController(PrincipalService service) {
        this.service = service;
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {
        return Response.ok(service.fetchAll()).build();
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchById(@PathParam("id") Long id) {
        return Response.ok(service.fetchById(id)).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid @BeanParam PersonDTO dto) {
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.create(entity);
        return Response.noContent().build();
    }

    @PUT
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@NotBlank(message = "Campo id não pode ser vazio")
                               @PathParam("id")
                               Long id, @Valid @BeanParam PersonDTO dto) {
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.update(id, entity);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@NotBlank(message = "Campo id não pode ser vazio")
                               @PathParam("id")
                               Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
