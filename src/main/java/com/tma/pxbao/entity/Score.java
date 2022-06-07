package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Score")
@Table(name = "\"Score\"", schema = "default_schema")
@NoArgsConstructor
@EqualsAndHashCode
public class Score extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "\"SubjectId\"")
    @JoinColumn(name = "\"SubjectId\"")
    private Long subjectId;

    @Id
    @Column(name = "\"StudentId\"")
    @JoinColumn(name = "\"StudentId\"")
    private Long studentId;

    @Column(name = "\"Score\"")
    private Double score;

    public Score(Long subjectId, Long studentId, Double score) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.score = score;
    }


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}
