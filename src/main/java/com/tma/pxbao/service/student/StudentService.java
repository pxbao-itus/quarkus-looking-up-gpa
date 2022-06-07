package com.tma.pxbao.service.student;

import com.tma.pxbao.entity.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);

    List<Student> getAll();

    Student update(Student student);


}
