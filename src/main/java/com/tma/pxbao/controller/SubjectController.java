package com.tma.pxbao.controller;

import com.tma.pxbao.entity.Student;
import com.tma.pxbao.entity.Subject;
import com.tma.pxbao.service.subject.SubjectService;
import io.quarkus.narayana.jta.QuarkusTransaction;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SubjectController {
    @Inject
    SubjectService subjectService;

    @POST
    @Transactional
    public Response createSubject(Subject subject) {
        System.out.println(subject.toString());
        subjectService.create(subject);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Uni<Response> removeSubject(@PathParam("id") Long subjectId) {
        if (subjectService.remove(subjectId)) {
            return Uni.createFrom().item(Response.status(200).build());
        } else {
            return Uni.createFrom().item(Response.status(404).build());
        }
    }

    @PATCH
    @Transactional
    public Uni<Response> updateStudent(Subject subject) {
        return Uni.createFrom().item(subjectService.update(subject))
                .onItem()
                .transform(item -> item != null ? Response.ok(item) : Response.status(404))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

    @GET
    @Transactional
    public Uni<Response> getSubjects() {
        return Uni.createFrom().item(subjectService.getAll())
                .onItem()
                .transform(item -> item != null ? Response.ok(item) : Response.status(404))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }
}
