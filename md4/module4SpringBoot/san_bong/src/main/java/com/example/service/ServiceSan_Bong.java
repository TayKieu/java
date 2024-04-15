package com.example.service;

import com.example.model.Khu_vuc;
import com.example.model.Loai_san;
import com.example.model.San_bong;
import com.example.repo.IRepoSan_Bong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSan_Bong implements IServiceSan_Bong {
    final
    IRepoSan_Bong iRepoSan_bong;

    public ServiceSan_Bong(IRepoSan_Bong iRepoSan_bong) {
        this.iRepoSan_bong = iRepoSan_bong;
    }


    @Override
    public List<San_bong> findALl() {
        return iRepoSan_bong.findAll();
    }

    @Override
    public Page<San_bong> findAllByNameContaining(Pageable pageable, String name) {
        return iRepoSan_bong.findAllByNameContaining(pageable,name);
    }

    @Override
    public Page<San_bong> findKhuVuc(Pageable pageable, Khu_vuc khu_vuc) {
        return iRepoSan_bong.findAllByKhuVuc(pageable,khu_vuc);
    }

    @Override
    public Page<San_bong> findLoaiSan(Pageable pageable, Loai_san loai_san) {
        return iRepoSan_bong.findAllByLoaiSan(pageable,loai_san);
    }

    @Override
    public Page<San_bong> findThreeField(Pageable pageable, String name, Khu_vuc khu_vuc, Loai_san loai_san) {
        return iRepoSan_bong.findAllByNameContainingAndKhuVucAndLoaiSan(pageable,name,khu_vuc,loai_san);
    }

    @Override
    public void delete(Long id) {
        iRepoSan_bong.deleteById(id);
    }

    @Override
    public San_bong findById(Long id) {
        return iRepoSan_bong.findById(id).orElse(null);
    }

    @Override
    public void save(San_bong san_bong) {
        iRepoSan_bong.save(san_bong);
    }
}
