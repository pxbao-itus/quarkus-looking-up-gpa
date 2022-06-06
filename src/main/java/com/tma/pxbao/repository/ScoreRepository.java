package com.tma.pxbao.repository;

import com.tma.pxbao.entity.Score;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScoreRepository implements PanacheRepository<Score> {
}
