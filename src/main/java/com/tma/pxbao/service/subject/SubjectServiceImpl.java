package com.tma.pxbao.service.subject;

import com.tma.pxbao.entity.Subject;
import com.tma.pxbao.repository.SubjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Inject
    SubjectRepository subjectRepository;

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.persist(subject);

    }


}
