package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/login")
    public String showFormLogIn(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/views/home";
    }
    @PostMapping("/checkValidate")
    public String checkValidate(@Valid @ModelAttribute UserDto userDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/views/home";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("mess","thong tin hop le");
        return "redirect:/result";
    }
}
