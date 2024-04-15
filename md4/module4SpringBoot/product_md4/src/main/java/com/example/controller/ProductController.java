package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repo.ICategoryRepo;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryRepo categoryRepo;

    @GetMapping()
    public ModelAndView mainForm(@RequestParam(defaultValue = "0",required = false)int page,
                                 @RequestParam(defaultValue = "2",required = false)int size,
                                 @RequestParam(defaultValue = "",required = false) String searchName,
                                 @RequestParam(defaultValue = "0",required = false) int categoryId,
                                 Model model){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        if(categoryId == 0) {
            Page<Product> productPage = productService.findByName(pageable, searchName);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("productPage", productPage);
            modelAndView.addObject("searchName", searchName);
            modelAndView.addObject("categoryId", categoryId);
            modelAndView.addObject("categories", categoryRepo.findAll());
            return modelAndView;
        }
        Page<Product> productPage = productService.findAllFields(pageable,searchName, categoryId);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productPage", productPage);
        modelAndView.addObject("searchName", searchName);
        modelAndView.addObject("categoryId", categoryId);
        modelAndView.addObject("categories",categoryRepo.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new ProductDto());
        List<Category> categoryList = categoryRepo.findAll();
        model.addAttribute("categories", categoryList);
        return "/create";
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("product") ProductDto productDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model) {

        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryRepo.findAll();
            model.addAttribute("categories", categories);
            return "/create";
        }
        Product product = new Product();
        for (Product product1 : productService.findAllNotPaging()) {
            if (product1.getName().equals(productDto.getName())) {
                redirectAttributes.addFlashAttribute("messages", "tên không được trùng nhau");
                List<Category> categories = categoryRepo.findAll();
                model.addAttribute("categories", categories);
                return "redirect:/product/create";
            }
        }
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("messages", "add success!!!");
        return "redirect:/product";
    }
    @GetMapping("/{productId}/delete")
    public String delete(@PathVariable("productId")int id){
        productService.delete(id);
        return "redirect:/product";
    }
    @GetMapping("/{productId}/{categoryId}/edit")
    public String editClubForm(@PathVariable("productId") int id,
                               @PathVariable("categoryId")int categoryId,
                               Model model){
        ProductDto productDto = productService.findProductById(id);
        model.addAttribute("product", productDto);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("categoryPresent", categoryRepo.findById(categoryId));
        return "/edit";
    }

    @PostMapping("/{productId}/{categoryId}/edit")
    public String updateClub(@PathVariable("productId")int id,
                             @PathVariable("categoryId")int categoryId,
                             @Valid @ModelAttribute("product")ProductDto productDto,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        productDto.setId(id);
        productService.updateProduct(productDto);
        return "redirect:/product";
    }

    @GetMapping("/detail/{productId}")
    public String clubDetail(@PathVariable("productId")int productId, Model model){
        ProductDto productDto = productService.findProductById(productId);
        model.addAttribute("product",productDto);
        return "/detail";
    }
//    @GetMapping("/searchAll")
//    public String searchAll(@RequestParam(value = "loaisann", defaultValue = "") Loai_san loai_san,
//                            @RequestParam(value = "khuvucc", defaultValue = "") Khu_vuc khu_vuc,
//                            @RequestParam("namee") Optional<String> OName,
//                            @RequestParam(defaultValue = "0") int page,
//                            @RequestParam(defaultValue = "3") int size,
//                            Model model) {
//        String nameValue = "";
//        if (OName.isPresent()) {
//            nameValue = OName.get();
//        }
//        Pageable pageable = PageRequest.of(page, size);
//        if (loai_san == null && khu_vuc == null) {
//            Page<San_bong> san_bongPage = iServiceSan_bong.findAllByNameContaining(pageable, nameValue);
//            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
//            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
//            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
//            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
//            model.addAttribute("stadiums", san_bongPage);
//            model.addAttribute("type", loaiSans);
//            model.addAttribute("areas", khu_vucs);
//            model.addAttribute("hours", khung_gios);
//            model.addAttribute("customer", khach_hangs);
//            return "/stadium/list";
//        }
//        if (loai_san == null && nameValue == "") {
//            Page<San_bong> san_bongPage = iServiceSan_bong.findKhuVuc(pageable, khu_vuc);
//            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
//            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
//            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
//            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
//            model.addAttribute("type", loaiSans);
//            model.addAttribute("stadiums", san_bongPage);
//            model.addAttribute("areas", khu_vucs);
//            model.addAttribute("hours", khung_gios);
//            model.addAttribute("customer", khach_hangs);
//            return "/stadium/list";
//        }
//        if (khu_vuc == null && nameValue == "") {
//            Page<San_bong> san_bongPage = iServiceSan_bong.findLoaiSan(pageable, loai_san);
//            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
//            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
//            List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
//            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
//            model.addAttribute("type", loaiSans);
//            model.addAttribute("stadiums", san_bongPage);
//            model.addAttribute("areas", khu_vucs);
//            model.addAttribute("hours", khung_gios);
//            model.addAttribute("customer", khach_hangs);
//            return "/stadium/list";
//        }
//        Page<San_bong> san_bongPage = iServiceSan_bong.findThreeField(pageable, nameValue, khu_vuc, loai_san);
//        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
//        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
//        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
//        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
//        model.addAttribute("type", loaiSans);
//        model.addAttribute("stadiums", san_bongPage);
//        model.addAttribute("areas", khu_vucs);
//        model.addAttribute("hours", khung_gios);
//        model.addAttribute("customer", khach_hangs);
//        return "/stadium/list";
//    }
}
