package com.tma.pxbao.controller;

import com.tma.pxbao.entity.Student;
import com.tma.pxbao.service.student.StudentService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class StudentController {
    @Inject
    StudentService studentService;

    @POST
    @Transactional
    public Response createStudent(Student student) {
        studentService.create(student);
        return Response.status(200).build();
    }

    @GET
    @Transactional
    public Uni<Response> getStudents() {
        return Uni.createFrom().item(studentService.getAll())
                .onItem()
                .transform(item -> item != null ? Response.ok(item) : Response.status(404))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

    @PATCH
    @Transactional
    public Uni<Response> updateStudent(Student student) {
        return Uni.createFrom().item(studentService.update(student))
                .onItem()
                .transform(item -> item != null ? Response.ok(item) : Response.status(404))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

}
