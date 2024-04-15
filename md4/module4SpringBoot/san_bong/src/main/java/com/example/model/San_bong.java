package com.example.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class San_bong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "khu_vuc_id",referencedColumnName = "id")
    private  Khu_vuc khuVuc;

    @ManyToOne
    @JoinColumn(name = "loai_san_id",referencedColumnName = "id")
    private Loai_san loaiSan;

    @ManyToOne
    @JoinColumn(name = "khung_gio_id",referencedColumnName = "id")
    private Khung_gio khungGio;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id",referencedColumnName = "id")
    private Khach_hang khachHang;

    public San_bong() {
    }
}
