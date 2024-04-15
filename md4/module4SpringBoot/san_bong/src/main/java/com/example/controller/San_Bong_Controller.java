package com.example.controller;

import com.example.dto.San_bongDto;
import com.example.model.*;
import com.example.repo.*;
import com.example.service.IServiceSan_Bong;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stadiums")
public class San_Bong_Controller {
    final
    IServiceSan_Bong iServiceSan_bong;
    @Autowired
    IRepoKhach_Hang iRepoKhachHang;
    @Autowired
    IRepoSan_Bong iRepoSan_bong;
    @Autowired
    IRepoKhung_Gio iRepoKhung_gio;
    @Autowired
    IRepoKhu_Vuc iRepoKhuVuc;
    @Autowired
    IRepoLoai_San iRepoLoaiSan;

    public San_Bong_Controller(IServiceSan_Bong iServiceSan_bong) {
        this.iServiceSan_bong = iServiceSan_bong;
    }

    @GetMapping
    public String show_List(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            @RequestParam("name") Optional<String> OName,
                            Model model
    ) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<San_bong> san_bongPage = iServiceSan_bong.findAllByNameContaining(pageable, nameValue);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("type", loaiSans);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "stadium/list";
    }

    @GetMapping("/searchAll")
    public String searchAll(@RequestParam(value = "loaisann", defaultValue = "") Loai_san loai_san,
                            @RequestParam(value = "khuvucc", defaultValue = "") Khu_vuc khu_vuc,
                            @RequestParam("namee") Optional<String> OName,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            Model model) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Pageable pageable = PageRequest.of(page, size);
        if (loai_san == null && khu_vuc == null) {
            Page<San_bong> san_bongPage = iServiceSan_bong.findAllByNameContaining(pageable, nameValue);
            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
            model.addAttribute("stadiums", san_bongPage);
            model.addAttribute("type", loaiSans);
            model.addAttribute("areas", khu_vucs);
            model.addAttribute("hours", khung_gios);
            model.addAttribute("customer", khach_hangs);
            return "/stadium/list";
        }
        if (loai_san == null && nameValue == "") {
            Page<San_bong> san_bongPage = iServiceSan_bong.findKhuVuc(pageable, khu_vuc);
            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
            model.addAttribute("type", loaiSans);
            model.addAttribute("stadiums", san_bongPage);
            model.addAttribute("areas", khu_vucs);
            model.addAttribute("hours", khung_gios);
            model.addAttribute("customer", khach_hangs);
            return "/stadium/list";
        }
        if (khu_vuc == null && nameValue == "") {
            Page<San_bong> san_bongPage = iServiceSan_bong.findLoaiSan(pageable, loai_san);
            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
            model.addAttribute("type", loaiSans);
            model.addAttribute("stadiums", san_bongPage);
            model.addAttribute("areas", khu_vucs);
            model.addAttribute("hours", khung_gios);
            model.addAttribute("customer", khach_hangs);
            return "/stadium/list";
        }
        Page<San_bong> san_bongPage = iServiceSan_bong.findThreeField(pageable, nameValue, khu_vuc, loai_san);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        iServiceSan_bong.delete(id);
        return "redirect:/stadiums";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("stadium", new San_bongDto());
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/create";
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("stadium") San_bongDto san_bongDto,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
            model.addAttribute("type", loaiSans);
            model.addAttribute("areas", khu_vucs);
            model.addAttribute("hours", khung_gios);
            return "/stadium/create";
        }
        San_bong san_bong = new San_bong();
        for (San_bong san_bong1 : iServiceSan_bong.findALl()) {
            if (san_bong1.getName().equals(san_bongDto.getName())) {
                redirectAttributes.addFlashAttribute("mess", "tên không được trùng nhau");
                List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
                List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
                List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
                model.addAttribute("type", loaiSans);
                model.addAttribute("areas", khu_vucs);
                model.addAttribute("hours", khung_gios);
                return "redirect:/stadiums/create";
            }
        }
        BeanUtils.copyProperties(san_bongDto, san_bong);
        iServiceSan_bong.save(san_bong);
        redirectAttributes.addFlashAttribute("mess", "add success!!!");
        return "redirect:/stadiums";
    }

}
