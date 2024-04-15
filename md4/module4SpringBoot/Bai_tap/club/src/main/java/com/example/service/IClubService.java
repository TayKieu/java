package com.example.service;

import com.example.dto.ClubDto;
import com.example.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClubService {
    List<Club> findAll();
    List<ClubDto> findAllClubs();
    Page<Club> findAllClubsWithP(Pageable pageable, String title);
    Club save(ClubDto club);
    ClubDto findClubById(int id);

    void updateClub(ClubDto clubDto);

    void delete(int id);
}
