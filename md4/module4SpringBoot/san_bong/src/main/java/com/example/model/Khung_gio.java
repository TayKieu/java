package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Khung_gio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    @OneToMany(mappedBy = "khungGio")
    List<San_bong> san_bongs;

    public Khung_gio() {
    }
}
