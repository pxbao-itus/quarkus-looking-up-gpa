package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Column(name = "StudentId")
    public Long studentID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

}
