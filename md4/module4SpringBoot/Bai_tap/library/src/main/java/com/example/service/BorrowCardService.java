package com.example.service;

import com.example.model.BorrowedCard;
import com.example.repo.IBorrowedCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowCardService implements IBorrowedCardService{
    @Autowired
    private IBorrowedCardRepo borrowedCardRepo;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @Override
    public List<BorrowedCard> findAll() {
        return borrowedCardRepo.findAll();
    }

    @Override
    public BorrowedCard findById(Integer id) {
        return borrowedCardRepo.findById(id).orElse(null);
    }

    @Override
    public boolean save(BorrowedCard borrowCard) {
        BorrowedCard newBorrowedCard = borrowedCardRepo.save(borrowCard);
        if(newBorrowedCard != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean borrowBook(Integer borrowedCardId, Integer bookId, Integer userId) {
        BorrowedCard borrowCard=new BorrowedCard(borrowedCardId,bookService.findById(bookId),userService.findById(userId));
        bookService.findById(bookId).setQuantity(bookService.findById(bookId).getQuantity()-1);
        this.save(borrowCard);
        return true;
    }
}
