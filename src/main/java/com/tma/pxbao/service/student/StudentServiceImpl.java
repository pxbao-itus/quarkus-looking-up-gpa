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
    public void create(Student student) {
        studentRepository.persist(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.listAll();
    }

    @Override
    public Student update(Student student) {
        Student existedStudent = studentRepository.findById(student.getStudentId());
        existedStudent.setFirstName(student.getFirstName() != null ? student.getFirstName() : existedStudent.getFirstName());
        existedStudent.setLastName(student.getLastName() != null ? student.getLastName() : existedStudent.getLastName());
        studentRepository.persist(existedStudent);
        return existedStudent;
    }
}
