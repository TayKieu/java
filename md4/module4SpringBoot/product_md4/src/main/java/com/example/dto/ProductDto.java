package com.example.dto;

import com.example.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Validated
@Component
public class ProductDto {
    private int id;
    @NotBlank(message = "tên không được để trống !!")
    private String name;
    private double price;
    private LocalDate date;
    private Category category;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double price, LocalDate date, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.category = category;
    }
}
