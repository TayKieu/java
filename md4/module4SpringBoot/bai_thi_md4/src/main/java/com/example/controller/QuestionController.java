package com.example.controller;

import com.example.dto.QuestionDto;
import com.example.model.Question;
import com.example.model.Type;
import com.example.repo.IQuestionRepo;
import com.example.repo.ITypeRepo;
import com.example.service.IQuestionService;
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
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ITypeRepo typeRepo;

    @GetMapping
    public ModelAndView mainForm(@RequestParam(defaultValue = "0",required = false)int page,
                                 @RequestParam(defaultValue = "2",required = false)int size,
                                 @RequestParam(defaultValue = "",required = false) String searchName,
                                 @RequestParam(defaultValue = "0",required = false) int typeId,
                                 Model model){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        if(typeId != 0 ) {
            Page<Question> questionPage = questionService.findAllFields(pageable, searchName, typeId);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("questionPage", questionPage);
            modelAndView.addObject("title", searchName);
            modelAndView.addObject("typeId", typeId);
            modelAndView.addObject("types", typeRepo.findAll());
            return modelAndView;
        }
        else if(searchName == null){
            Page<Question> questionPage = questionService.findByType(pageable, typeId);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("questionPage", questionPage);
//            modelAndView.addObject("title", searchName);
            modelAndView.addObject("typeId", typeId);
            modelAndView.addObject("types", typeRepo.findAll());
            return modelAndView;
        }
        Page<Question> questionPage = questionService.findByTitle(pageable, searchName);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("questionPage", questionPage);
        modelAndView.addObject("title", searchName);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("types", typeRepo.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("question",new QuestionDto());
        List<Type> typeList = typeRepo.findAll();
        model.addAttribute("types", typeList);
        return "/create";
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("question") QuestionDto questionDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model) {

        if (bindingResult.hasErrors()) {
            List<Type> typeList = typeRepo.findAll();
            model.addAttribute("types", typeList);
            return "/create";
        }
        Question question = new Question();
        for (Question question1 : questionService.findAllNoPaging()) {
            if (question1.getTitle().equals(questionDto.getTitle())) {
                redirectAttributes.addFlashAttribute("messages", "Can be the same");
                List<Type> types = typeRepo.findAll();
                model.addAttribute("types", types);
                return "redirect:/question/create";
            }
        }
        BeanUtils.copyProperties(questionDto, question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("messages", "add success!!!");
        return "redirect:/question";
    }
    @GetMapping("/{questionId}/delete")
    public String delete(@PathVariable("questionId")int id){
        questionService.delete(id);
        return "redirect:/question";
    }
    @GetMapping("/{questionId}/{typeId}/edit")
    public String editClubForm(@PathVariable("questionId") int id,
                               @PathVariable("typeId")int typeId,
                               Model model){
        QuestionDto questionDto = questionService.findQuestionById(id);
        model.addAttribute("question", questionDto);
        model.addAttribute("types", typeRepo.findAll());
        model.addAttribute("typePresent", typeRepo.findById(typeId));
        return "/edit";
    }
    @PostMapping("/{questionId}/{typeId}/edit")
    public String updateClub(@PathVariable("questionId")int id,
                             @PathVariable("typeId")int typeId,
                             @Valid @ModelAttribute("question")QuestionDto questionDto,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        questionDto.setId(id);
        questionService.updateQuestion(questionDto);
        return "redirect:/question";
    }

    @GetMapping("/detail/{questionId}")
    public String clubDetail(@PathVariable("questionId")int questionId, Model model){
        QuestionDto questionDto = questionService.findQuestionById(questionId);
        model.addAttribute("question",questionDto);
        return "/detail";
    }
}
