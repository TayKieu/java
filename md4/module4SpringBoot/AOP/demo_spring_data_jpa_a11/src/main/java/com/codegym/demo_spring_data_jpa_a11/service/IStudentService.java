package com.codegym.demo_spring_data_jpa_a11.service;


import com.codegym.demo_spring_data_jpa_a11.exception.AdminException;
import com.codegym.demo_spring_data_jpa_a11.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable,String searchName);
    List<Student> search(String searchName);
    Student findById(int id);
    boolean save(Student student) throws AdminException;
}
