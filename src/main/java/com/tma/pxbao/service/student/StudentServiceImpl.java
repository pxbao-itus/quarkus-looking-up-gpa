package com.tma.pxbao.service.student;

import com.tma.pxbao.entity.Student;
import com.tma.pxbao.repository.student.StudentRepository;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {
    @Inject
    StudentRepository studentRepository;


    @Override
    public void createStudent(Student student) {
        studentRepository.persist(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll().list();
    }
}
