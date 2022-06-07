package com.tma.pxbao.repository.score;

import com.tma.pxbao.entity.Score;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ScoreRepository implements PanacheRepository<Score> {
    public List<Score> findBySubjectId(Long subjectId) {
        return find("subjectId", subjectId).list();
    }

    public List<Score> findByStudentId(Long studentId) {
        return find("studentId", studentId).list();
    }

    public int update(Score score) {
        return update("score = ?1 where subjectId = ?2 and studentId = ?3", score.getScore(), score.getSubjectId(), score.getStudentId());

    }

}
