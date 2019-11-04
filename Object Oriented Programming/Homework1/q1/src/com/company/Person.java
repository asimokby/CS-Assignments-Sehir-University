package com.company;

public class Person {

    public String name;


    //a person asks to borrow a book for a period of time.
    public void borrow(Book bookObject, int period){
        //A person asks to borrow a book.
        System.out.println(this.name + " asks to borrow " + bookObject.bookName);
    }
}
