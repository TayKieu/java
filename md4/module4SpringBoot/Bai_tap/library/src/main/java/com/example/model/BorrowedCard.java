package com.example.model;

import javax.persistence.*;

@Entity
public class BorrowedCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowed_card_id;
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public BorrowedCard() {
    }

    public BorrowedCard(int borrowed_card_id, Book book, User user) {
        this.borrowed_card_id = borrowed_card_id;
        this.book = book;
        this.user = user;
    }

    public int getBorrowed_card_id() {
        return borrowed_card_id;
    }

    public void setBorrowed_card_id(int borrowed_card_id) {
        this.borrowed_card_id = borrowed_card_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
