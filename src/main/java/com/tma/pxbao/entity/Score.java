package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Score")
public class Score extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "SubjectId")
    @JoinColumn(name = "SubjectId")
    private Long subjectId;

    @Id
    @Column(name = "StudentId")
    @JoinColumn(name = "StudentId")
    private Long studentId;

    @Column(name = "Score")
    private double score;

}
