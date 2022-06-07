package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Score")
@Table(name = "\"Score\"", schema = "default_schema")
public class Score extends PanacheEntityBase implements Serializable {

    private Long subjectId;
    private Long studentId;
    private double score;

    public Score() {
    }

    public Score(Long subjectId, Long studentId, double score) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.score = score;
    }

    @Id
    @Column(name = "\"SubjectId\"")
    @JoinColumn(name = "\"SubjectId\"")
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Id
    @Column(name = "\"StudentId\"")
    @JoinColumn(name = "\"StudentId\"")
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Column(name = "\"Score\"")
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return Double.compare(score1.getScore(), getScore()) == 0 && Objects.equals(getSubjectId(), score1.getSubjectId()) && Objects.equals(getStudentId(), score1.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjectId(), getStudentId(), getScore());
    }
}
