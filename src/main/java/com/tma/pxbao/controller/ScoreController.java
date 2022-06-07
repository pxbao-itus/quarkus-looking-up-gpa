package com.tma.pxbao.controller;


import com.tma.pxbao.entity.Score;
import com.tma.pxbao.service.score.ScoreService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ScoreController {

    @Inject
    ScoreService scoreService;

    @POST
    @Transactional
    public Uni<Response> importListScore(List<Score> scoreList) {
        try {
            scoreService.input(scoreList);
            return Uni.createFrom().item(Response.status(200).build());
        } catch (Exception e) {
            return Uni.createFrom().item(Response.status(400).build());
        }
    }

    @GET
    @Path("student")
    @Transactional
    public Uni<Response> getInfo(@QueryParam(value = "id") Long studentId) {
        return scoreService.getInfo(studentId)
                .onItem()
                .transform(Response::ok)
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }
}
