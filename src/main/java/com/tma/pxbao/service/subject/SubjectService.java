package com.tma.pxbao.service.subject;

import com.tma.pxbao.entity.Subject;

import java.util.List;

public interface SubjectService {
    void create(Subject subject);

    boolean remove(Long subjectId);

    Subject update(Subject subject);

    List<Subject> getAll();
}
