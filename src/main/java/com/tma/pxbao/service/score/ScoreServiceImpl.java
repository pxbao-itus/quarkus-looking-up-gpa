package com.tma.pxbao.service.score;

import com.tma.pxbao.entity.Score;
import com.tma.pxbao.repository.score.ScoreRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
//@Transactional
public class ScoreServiceImpl implements ScoreService {

    @Inject
    ScoreRepository scoreRepository;

    @Override
    public void input(List<Score> scoreList) {
        for (Score score : scoreList) {
            if (scoreRepository.update(score) == 0) {
                scoreRepository.persist(score);
            }
        }
    }

    @Override
    public Uni<Map<String, Object>> getInfo(Long studentId) {
        List<Score> scores = scoreRepository.findByStudentId(studentId);
        List<Double> listScore = scores.stream()
                .map(Score::getScore)
                .sorted()
                .collect(Collectors.toList());
        Double avg =  listScore.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
        Map<String, Object> studentScoreInfo = new HashMap<>();
        studentScoreInfo.put("avg",Math.round(avg * 100.0) / 100.0);
        studentScoreInfo.put("highest",listScore.get(listScore.size() - 1));
        studentScoreInfo.put("lowest", listScore.get(0));
        studentScoreInfo.put("greater5", listScore.stream().filter(item -> item > 5).collect(Collectors.toList()));
        return Uni.createFrom().item(studentScoreInfo);
    }



    public List<Score> getListScoreByStudentId(Long studentId) {
        return scoreRepository.findByStudentId(studentId);
    }
}
