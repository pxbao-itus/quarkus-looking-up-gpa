package com.tma.pxbao.service.subject;

import com.tma.pxbao.entity.Subject;

public interface SubjectService {
    void createSubject(Subject subject);

    boolean removeSubject(Long subjectId);
}
