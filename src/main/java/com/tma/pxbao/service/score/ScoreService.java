package com.tma.pxbao.service.score;


import com.tma.pxbao.entity.Score;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Map;

public interface ScoreService{
    void input(List<Score> scores);

    Uni<Map<String, Object>> getInfo(Long studentId);
}
