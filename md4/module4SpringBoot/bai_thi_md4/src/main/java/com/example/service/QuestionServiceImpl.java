package com.example.service;

import com.example.dto.QuestionDto;
import com.example.model.Question;
import com.example.repo.IQuestionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService{
    @Autowired
    private IQuestionRepo questionRepo;
    @Override
    public Page<Question> findByTitle(Pageable pageable, String title) {
        return questionRepo.findAllByTitleContaining(pageable, title);
    }

    @Override
    public List<Question> findAllNoPaging() {
        return questionRepo.findAll();
    }

    @Override
    public Page<Question> findAllFields(Pageable pageable, String title, int typeId) {
        return questionRepo.findAllByTitleAndType_Id(pageable,title,typeId);
    }

    @Override
    public void save(Question question) {
        questionRepo.save(question);
    }

    @Override
    public void delete(int id) {
        questionRepo.deleteById(id);
    }

    @Override
    public QuestionDto findQuestionById(int id) {
        Question question = questionRepo.findById(id).get();
        return mapToQuestionDto(question);
    }

    @Override
    public void updateQuestion(QuestionDto questionDto) {
        Question question = mapToQuestion(questionDto);
        questionRepo.save(question);
    }

    @Override
    public Page<Question> findByType(Pageable pageable, int typeId) {
        return questionRepo.findAllByType_IdContaining(pageable,typeId);
    }

    private QuestionDto mapToQuestionDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question,questionDto);
        return questionDto;
    }
    private Question mapToQuestion(QuestionDto questionDto) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        return question;
    }
}
