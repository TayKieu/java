package com.example.model;

import com.example.model.San_bong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Khu_vuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_khu_vuc;
    @OneToMany(mappedBy = "khuVuc")
    List<San_bong> san_bongs;

    public Khu_vuc() {
    }
}
