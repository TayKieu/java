package com.example.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class BlogDto implements Validator {
    private long id;
    private String title;
    private String content;
    private String imgUrl;

    private long likes = 0;
    private LocalDate date;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto  blogDto = (BlogDto) target;
        if (blogDto.title.equals("")){
            errors.rejectValue("title",null, "Khong duoc de trong");
        }else if (!blogDto.title.matches("^[a-zA-Z]{3,}$")){
            errors.rejectValue("name",null, "Khong dung dinh dang");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
