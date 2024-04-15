package com.codegym.demo_spring_data_jpa_a11.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjectSet")
    private Set<Student> studentSet;
}
