package com.company;

public class Main {

    public static void main(String[] args) {
        Library.buildLibrary(); //constructing the library, books are populated.

//      simulating a library borrowing system.
        int day = 1;
        while (day < 6){
            System.out.println("Day: " + day);
            for (int i = 0; i < Library.numberOfBooks; i++){
                //decrementing days from to simulate the passing of days.
                if (Library.arrayOfBooks[i].daysToBeReturned > 0){
                    Library.arrayOfBooks[i].daysToBeReturned --;
                }
            }
            if (day == 1) {
                //Asem will borrow bookB for day 1, 2, 3; the book will be available on day 4 for other students.
                Student std1 = new Student(21729, "Asem");
                Book book1 = Library.arrayOfBooks[1];
                std1.borrow(book1, 3);
                if (Library.checkAvailability(book1)) {
                    Library.loan(std1, book1, 3);
                }
            }else if(day == 2) {
                //Ali tried to borrow bookB on day 2, but he could not because bookB is not available.
                Student std1 = new Student(21830, "Ali");
                Book book1 = Library.arrayOfBooks[1];
                std1.borrow(book1, 2);
                if (Library.checkAvailability(book1)) {
                    Library.loan(std1, book1, 2);
                }
            }else if (day == 3) {
                //Omar will borrow bookA and bookC for day 3 and day 4.
                Student std3 = new Student(21923, "Omar");
                Book book3 = Library.arrayOfBooks[0];
                Book book3_1 = Library.arrayOfBooks[2];
                std3.borrow(book3, 2);
                if (Library.checkAvailability(book3)) {
                    Library.loan(std3, book3, 2);
                }
                std3.borrow(book3_1, 2);
                if (Library.checkAvailability(book3_1)) {
                    Library.loan(std3, book3_1, 2);
                }
            }else if (day == 4) {
                //Mohamed was able to borrow bookB when it was returned by Asem. he will borrow it for 5 days.
                Student std4 = new Student(21684, "Mohamed");
                Book book4 = Library.arrayOfBooks[1];
                std4.borrow(book4, 3); //The student tries to borrow a book, availability is checked is available.
                if (Library.checkAvailability(book4)) {
                    Library.loan(std4, book4, 2);
                }

            }else if (day == 5){
                Staff staffMember = new Staff("Ali Cakmac", "Professer");
                Book book5 = Library.arrayOfBooks[3];
                staffMember.borrow(book5, 2);
                if (Library.checkAvailability(book5)){
                    Library.loan(staffMember, book5, 2);
                }
            }
            day++;
        }
    }
}
