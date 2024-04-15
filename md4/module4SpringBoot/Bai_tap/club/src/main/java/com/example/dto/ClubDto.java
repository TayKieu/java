package com.example.dto;

import net.bytebuddy.asm.Advice;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class ClubDto  {
    private int id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Club content should not be empty")
    private String content;
    @NotEmpty(message = "Club photo link should not be empty")
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public ClubDto() {
    }

    public ClubDto(int id, String title, String content, String photoUrl, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photoUrl = photoUrl;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public ClubDto(int id, String title, String content, String photoUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
