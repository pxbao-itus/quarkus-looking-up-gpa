package com.tma.pxbao.controller;

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
@Transactional
public class SubjectController {
    @Inject
    SubjectService subjectService;

    @POST
    public Response createSubject(Subject subject) {
        System.out.println(subject.toString());
        subjectService.createSubject(subject);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Uni<Response> removeSubject(@PathParam("id") Long subjectId) {
//        QuarkusTransaction.begin();
        if (subjectService.removeSubject(subjectId)) {
//            QuarkusTransaction.commit();
            return Uni.createFrom().item(Response.status(200).build());
        } else {
//            QuarkusTransaction.rollback();
            return Uni.createFrom().item(Response.status(400).build());
        }
    }
}
