package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private LocalDate localDate;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    Type type;
    private String status;

    public Question() {
    }
}
