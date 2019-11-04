package com.company;

public class Staff extends Person {

    public String position;

    public Staff(String name, String position){
        super.name = name;
        this.position = position;
    }

    // overriding the method borrow of the parent person.
    public void borrow(Book bookObject, int period){
        //A staff asks to borrow a book.
        System.out.println(position + " " + this.name + " asks to borrow " + bookObject.bookName);
    }
}
