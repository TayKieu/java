package com.example.model;

import com.example.model.San_bong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Khach_hang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double phone;
    private int gender;
    @OneToMany(mappedBy = "khachHang")
    List<San_bong> san_bongs;

    public Khach_hang() {
    }
}
