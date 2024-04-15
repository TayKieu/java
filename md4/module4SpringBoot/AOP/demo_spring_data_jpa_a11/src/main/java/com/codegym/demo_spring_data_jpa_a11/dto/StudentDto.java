package com.codegym.demo_spring_data_jpa_a11.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto implements Validator {
    private int id;
//    @NotEmpty(message ="Khong dc de trong" )
//    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "khong dung dinh dang")
    private String name;
    private int gender;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       StudentDto  studentDto = (StudentDto) target;
       if (studentDto.name.equals("")){
           errors.rejectValue("name",null, "Khong duoc de trong");
       }else if (!studentDto.name.matches("^[a-zA-Z]{3,}$")){
           errors.rejectValue("name",null, "Khong dung dinh dang");
       }
    }
}
