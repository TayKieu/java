package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {
    private int id;
    private String name;
    private int age;
    private String email;

    public UserDto() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto  userDto = (UserDto) target;
        if (userDto.name.equals("")){
            errors.rejectValue("name",null, "Khong duoc de trong");
        } else if (!(userDto.getAge() < 18)) {
            errors.rejectValue("age", null,"Khong du tuoi" );
        } else if (!userDto.name.matches("^[a-zA-Z]{5,45}$")){
            errors.rejectValue("name",null, "Khong dung dinh dang");
        }
    }
}
