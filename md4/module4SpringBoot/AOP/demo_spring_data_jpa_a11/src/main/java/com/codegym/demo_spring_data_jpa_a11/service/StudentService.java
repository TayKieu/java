package com.codegym.demo_spring_data_jpa_a11.service;


import com.codegym.demo_spring_data_jpa_a11.exception.AdminException;
import com.codegym.demo_spring_data_jpa_a11.model.Student;
import com.codegym.demo_spring_data_jpa_a11.reposiotry.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable,String searchName) {
        System.out.println(1/0);
        return studentRepository.findStudentByNameContaining(pageable,searchName);
    }

    @Override
    public List<Student> search(String searchName) {
        return studentRepository.searchByName("%"+searchName+"%");
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Student student) throws AdminException {
        if (student.getName().equals("admin")){
            throw  new AdminException("ten khong dc la admin");
        }
        Student newStudent = studentRepository.save(student);
         if (newStudent!=null){
             return  true;
         }
         return false;
    }
}
