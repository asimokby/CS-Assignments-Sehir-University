package com.company;

public class Book {

    //these are instance variables, meaning that we can have multiple copies of them. One for each object.
    int bookId;
    String bookName;
    int daysToBeReturned;

    public Book(int bookId, String bookName, int daysToBeReturned){
        this.bookId = bookId;
        this.bookName = bookName;
        this.daysToBeReturned = daysToBeReturned; // number of days till the book is available.
    }
}
