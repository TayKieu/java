package com.example.service;

import com.example.dto.QuestionDto;
import com.example.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
Page<Question> findByTitle(Pageable pageable, String title);
List<Question> findAllNoPaging();

    Page<Question> findAllFields(Pageable pageable, String title, int typeId);

    void save(Question question);

    void delete(int id);

    QuestionDto findQuestionById(int id);

    void updateQuestion(QuestionDto questionDto);

    Page<Question> findByType(Pageable pageable, int typeId);
}
