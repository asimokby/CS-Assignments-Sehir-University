package com.company;


public class Library {
    //the following variables are class level variables, hence the modifier "static" is added.
    public static int numberOfBooks = 4;
    public static Book arrayOfBooks[] = new Book[numberOfBooks];

    //Building the library - filling the data structure or the library with the books
    public static void buildLibrary(){
        String bookNames[] = {"bookA", "bookB", "bookC", "bookD"};
        for (int i = 0; i < numberOfBooks; i++){
                arrayOfBooks[i] = new Book(i, bookNames[i],0);
        }
    }

    //loaning the book to a person, and setting the number of days for which a book is borrowed.
    public static void loan(Person personObject, Book bookObj, int period){
        System.out.println(personObject.name + " borrowed " + bookObj.bookName + " For " + period + " days.");
        bookObj.daysToBeReturned += period;
    }
    //checking the availability of a book.
    public static boolean checkAvailability(Book bookObject){
        System.out.println("Checking Availability...");
        for (Book b : Library.arrayOfBooks){
            if (b.bookName.equals(bookObject.bookName) && b.daysToBeReturned == 0) {
                return true;
            }
        }
        System.out.println(bookObject.bookName + " is not available");
        return false;
    }
}
