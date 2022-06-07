package com.tma.pxbao.controller;

import com.tma.pxbao.entity.Student;
import com.tma.pxbao.service.student.StudentService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentAPI {
    @Inject
    StudentService studentService;

    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.status(200).build();
    }

    @GET
    public Response getStudents() {
        return Response.ok(studentService.getStudents()).build();
    }
}
