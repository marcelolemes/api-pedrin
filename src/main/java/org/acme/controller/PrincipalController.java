package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.PersonEntity;
import org.acme.service.PrincipalService;
import org.acme.util.PersonMapper;

import java.time.LocalDate;
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
    public Response create(@QueryParam("name") String name, @QueryParam("birth") LocalDate birth) {
        final PersonDTO dto = new PersonDTO(name,birth);
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.create(entity);
        return Response.noContent().build();
    }

    @PUT
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id")
                           Long id, @QueryParam("name") String name, @QueryParam("birth") LocalDate birth) {
        final PersonDTO dto = new PersonDTO(name,birth);
        final PersonEntity entity = Optional.of(dto).map(PersonMapper::toEntity).orElse(new PersonEntity());
        service.update(id, entity);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id")
                           Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
