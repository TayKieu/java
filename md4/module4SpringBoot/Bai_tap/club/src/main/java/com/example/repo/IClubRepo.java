package com.example.repo;

import com.example.dto.ClubDto;
import com.example.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClubRepo extends JpaRepository<Club,Integer> {
    Optional<Club> findClubByTitle(String title);
    Page<Club> findClubByTitleContaining(Pageable pageable, String title);
}
