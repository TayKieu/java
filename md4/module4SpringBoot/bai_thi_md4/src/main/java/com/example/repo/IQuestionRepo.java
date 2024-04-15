package com.example.repo;

import com.example.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepo extends JpaRepository<Question,Integer> {
    Page<Question> findAllByTitleContaining(Pageable pageable, String title);
    Page<Question> findAllByTitleAndType_Id(Pageable pageable, String title, Integer typeId);
    Page<Question> findAllByType_IdContaining(Pageable pageable, Integer typeId);
}
