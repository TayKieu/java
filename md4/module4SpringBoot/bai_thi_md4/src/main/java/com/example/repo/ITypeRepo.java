package com.example.repo;

import com.example.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepo extends JpaRepository<Type,Integer> {
}
