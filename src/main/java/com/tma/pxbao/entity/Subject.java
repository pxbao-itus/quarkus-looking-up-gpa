package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Subject extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "SubjectId")
    public Long subjectId;

    @Column(name = "SubjectName")
    private String subjectName;

}
