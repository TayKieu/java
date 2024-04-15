package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
     IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "2") int size,
                                 @RequestParam() Optional<String> searchName
    ){
        String searchNameValue ="";
        if (searchName.isPresent()){
            searchNameValue = searchName.get();
        }
        Pageable pageable = PageRequest.of(page,size, Sort.by("title").ascending().and(Sort.by("id").ascending()));
        Page<Blog> blogPage = blogService.findAll( pageable,searchNameValue);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogPage",blogPage);
        modelAndView.addObject("searchName",searchNameValue);
        return modelAndView ;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blogDto",new BlogDto());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute BlogDto blogDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes){
        new BlogDto().validate(blogDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","THem moi thanh cong");
        return "redirect:/blog";
    }


}
