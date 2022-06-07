package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Subject")
@Table(name = "\"Subject\"", schema = "default_schema")
@EqualsAndHashCode
@NoArgsConstructor
public class Subject extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "\"SubjectId\"")
    private Long subjectId;

    @Column(name = "\"SubjectName\"")
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
