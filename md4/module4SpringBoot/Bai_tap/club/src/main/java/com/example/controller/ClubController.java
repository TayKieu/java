package com.example.controller;

import com.example.dto.ClubDto;
import com.example.model.Club;
import com.example.service.ICategoryService;
import com.example.service.IClubService;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/club")
public class ClubController {
    final IClubService clubService;
    final ICategoryService categoryService;

    @Autowired
    public ClubController(IClubService clubService, ICategoryService categoryService) {
        this.clubService = clubService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView mainForm(@RequestParam(defaultValue = "0",required = false)int page,
                                 @RequestParam(defaultValue = "2",required = false)int size,
                                 @RequestParam(defaultValue = "",required = false) String searchName,
                                 Model model){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Club> clubPage = clubService.findAllClubsWithP(pageable,searchName);
        ModelAndView modelAndView = new ModelAndView("clubs-list");
        modelAndView.addObject("clubPage", clubPage);
        modelAndView.addObject("searchName",searchName);
//        modelAndView.addObject("categories",categoryService.findAll() );
//        List<ClubDto> clubs = clubService.findAllClubs();
//        model.addAttribute("clubs", clubs);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        ClubDto clubDto = new ClubDto();
        model.addAttribute("club", clubDto);
        return "clubs-create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("club") ClubDto clubDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.save(clubDto);
        redirectAttributes.addFlashAttribute("message","create successfully");
        return "redirect:/club";
    }

    @GetMapping("/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") int id, Model model){
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("club", clubDto);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable("clubId")int id,
                             @Valid @ModelAttribute("club")ClubDto clubDto,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "clubs-edit";
        }
        clubDto.setId(id);
        clubService.updateClub(clubDto);
        return "redirect:/club";
    }

    @GetMapping("/{clubId}/delete")
    public String delete(@PathVariable("clubId")int id){
        clubService.delete(id);
        return "redirect:/club";
    }

    @GetMapping("/detail/{clubId}")
    public String clubDetail(@PathVariable("clubId")int clubId, Model model){
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club",clubDto);
        return "clubs-detail";
    }
}
