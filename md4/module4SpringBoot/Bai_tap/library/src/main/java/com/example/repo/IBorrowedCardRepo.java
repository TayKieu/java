package com.example.repo;

import com.example.model.BorrowedCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedCardRepo extends JpaRepository<BorrowedCard,Integer> {
}
