package com.tma.pxbao.service.student;

import com.tma.pxbao.entity.Student;


import java.util.List;

public interface StudentService {
    void createStudent(Student student);

    List<Student> getStudents();

}
