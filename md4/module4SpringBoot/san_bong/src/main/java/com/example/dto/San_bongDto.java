package com.example.dto;

import com.example.model.Khach_hang;
import com.example.model.Khu_vuc;
import com.example.model.Khung_gio;
import com.example.model.Loai_san;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Component
@Validated
public class San_bongDto implements Validator {

    private Long id;
    @NotBlank(message = "tên không được để trống !!")
    private String name;
    @NotBlank(message = "địa chỉ không được để trống !!")
    private String address;
    //    @NotBlank(message = "khu vực không được để trống !!")
    private Khu_vuc khuVuc;
    //    @NotBlank(message = " loại sân không được để trống !!")
    private Loai_san loaiSan;
    //    @NotBlank(message = "khung giờ không được để trống !!")
    private Khung_gio khungGio;
    private Khach_hang khachHang;

    public San_bongDto() {
    }

    public San_bongDto(Long id, String name, String address, Khu_vuc khuVuc, Loai_san loaiSan, Khung_gio khungGio, Khach_hang khachHang) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.khuVuc = khuVuc;
        this.loaiSan = loaiSan;
        this.khungGio = khungGio;
        this.khachHang = khachHang;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
