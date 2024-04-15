package com.example.service;

import com.example.model.Khu_vuc;
import com.example.model.Loai_san;
import com.example.model.San_bong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceSan_Bong {
    List<San_bong> findALl();
    Page<San_bong> findAllByNameContaining(Pageable pageable, String name);
    Page<San_bong> findKhuVuc(Pageable pageable, Khu_vuc khu_vuc);
    Page<San_bong> findLoaiSan(Pageable pageable, Loai_san loai_san);
    Page<San_bong> findThreeField(Pageable pageable,String name,Khu_vuc khu_vuc,Loai_san loai_san);
    void delete(Long id);
    San_bong findById(Long id);
    void save(San_bong san_bong);
}
