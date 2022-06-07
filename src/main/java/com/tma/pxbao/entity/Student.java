package com.tma.pxbao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "\"Student\"", schema = "default_schema")
@Entity(name = "Student")
@NoArgsConstructor
@EqualsAndHashCode
public class Student extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "\"StudentId\"")
    private Long studentID;

    @Column(name = "\"FirstName\"")
    private String firstName;

    @Column(name = "\"LastName\"")
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
