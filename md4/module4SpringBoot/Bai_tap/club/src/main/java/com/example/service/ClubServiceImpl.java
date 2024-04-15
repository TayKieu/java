package com.example.service;

import com.example.dto.ClubDto;
import com.example.model.Club;
import com.example.repo.IClubRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements IClubService{
    private IClubRepo clubRepo;

    @Autowired
    public ClubServiceImpl(IClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public List<Club> findAll() {
        return clubRepo.findAll();
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepo.findAll();
        return mapToClubDto(clubs);
//        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


    @Override
    public Page<Club> findAllClubsWithP(Pageable pageable, String title) {
        return clubRepo.findClubByTitleContaining(pageable, title);
    }

    @Override
    public Club save(ClubDto clubDto) {
        Club newClub = mapToClub(clubDto);
        return clubRepo.save(newClub);
    }

    @Override
    public ClubDto findClubById(int id) {
        Club club = clubRepo.findById(id).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepo.save(club);
    }

    @Override
    public void delete(int id) {
        clubRepo.deleteById(id);
    }

    private Club mapToClub(ClubDto clubDto) {
        Club club = new Club();
        BeanUtils.copyProperties(clubDto,club);
        return club;
    }

    private List<ClubDto> mapToClubDto(List<Club> clubs) {
      return   clubRepo.findAll().stream().map(e -> {
            ClubDto clubDto = new ClubDto();
            clubDto.setId(e.getId());
            clubDto.setContent(e.getContent());
            clubDto.setPhotoUrl(e.getPhotoUrl());
            clubDto.setTitle(e.getTitle());
            return  clubDto;
        }).collect(Collectors.toList());

//        ClubDto clubDto = new ClubDto();
//        BeanUtils.copyProperties(clubDto,);
//        return clubDto;
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = new ClubDto();
        BeanUtils.copyProperties(club,clubDto);
        return clubDto;
    }
}
