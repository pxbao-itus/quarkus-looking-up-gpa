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
    public void createSubject(Subject subject) {
        subjectRepository.persist(subject);
    }

    @Override
    public boolean removeSubject(Long subjectId) {
        List<Score> scores = Score.findBySubject(subjectId);
        for (Score scoreDeleted : scores) {
            scoreRepository.delete(scoreDeleted);
        }
        return subjectRepository.deleteById(subjectId);

    }
}
