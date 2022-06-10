package com.tma.pxbao.service.subject;

import com.tma.pxbao.entity.Score;
import com.tma.pxbao.entity.Subject;
import com.tma.pxbao.repository.score.ScoreRepository;
import com.tma.pxbao.repository.subject.SubjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SubjectServiceImpl implements SubjectService {
    @Inject
    SubjectRepository subjectRepository;

    @Inject
    ScoreRepository scoreRepository;

    @Override
    public void create(Subject subject) {
        subjectRepository.persist(subject);
    }

    @Override
    public boolean remove(Long subjectId) {
        List<Score> scores = scoreRepository.findBySubjectId(subjectId);
        for (Score scoreDeleted : scores) {
            scoreRepository.delete(scoreDeleted);
        }
        return subjectRepository.deleteById(subjectId);

    }

    @Override
    public Subject update(Subject subject) {
        Subject existedSubject = subjectRepository.findById(subject.getSubjectId());
        existedSubject.setSubjectName(subject.getSubjectName() != null ? subject.getSubjectName() : existedSubject.getSubjectName());
        subjectRepository.persist(existedSubject);
        return existedSubject;
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.listAll();
    }
}
