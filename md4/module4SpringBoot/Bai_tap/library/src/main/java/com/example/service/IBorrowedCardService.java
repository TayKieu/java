package com.example.service;

import com.example.model.BorrowedCard;

import java.util.List;

public interface IBorrowedCardService {
    List<BorrowedCard> findAll();

    BorrowedCard findById(Integer id);

    boolean save(BorrowedCard borrowCard);
    boolean borrowBook(Integer borredCardId,Integer bookId,Integer UserId);
}
