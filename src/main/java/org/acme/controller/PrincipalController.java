package org.acme.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.PersonEntity;
import org.acme.repository.PrincipalRepository;
import org.acme.service.PrincipalService;
import org.acme.util.PersonMapper;

import java.util.List;
import java.util.Optional;

@Path("/v1/api")
public class PrincipalController {
    private PrincipalService service;

    public PrincipalController(PrincipalService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {
        return Response.ok(service.fetchAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchById(@PathParam("id") Long id) {
        return Response.ok(service.fetchById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@BeanParam PersonDTO dto) {
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.create(entity);
        return Response.noContent().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@BeanParam PersonDTO dto) {
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.update(entity);
        return Response.noContent().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@BeanParam PersonDTO dto) {
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.delete(entity);
        return Response.noContent().build();
    }
}
