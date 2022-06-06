package com.tma.pxbao.repository;

import com.tma.pxbao.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {
}
