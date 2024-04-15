package com.example.dto;

import com.example.model.Type;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Validated
@Component
public class QuestionDto {
    private int id;
    @NotBlank(message = "can not be empty !!")
    private String title;
    private String content;
    private LocalDate localDate;
    Type type;
    private String status;

    public QuestionDto() {
    }

    public QuestionDto(int id, String title, LocalDate localDate, Type type, String status) {
        this.id = id;
        this.title = title;
        this.localDate = localDate;
        this.type = type;
        this.status = status;
    }
}
