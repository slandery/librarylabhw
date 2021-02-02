package com.tts;
import java.util.ArrayList;

public class Library {

    String address;
    ArrayList<Book> books;

    //creates addresses and books
    public Library(String libraryAddresses) {
        address = libraryAddresses;
        books = new ArrayList<Book>();
    }
    //call to addBook to pull in books
    public void addBook(Book book) {
        books.add(book);
    }


    //hours
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9AM to 5PM");
    }
    //addresses
    public void printAddress() {
        System.out.println(address);
    }

    public void printAvailableBooks() {
        boolean bookIn = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
                bookIn = true;
            }
        }
        if (!bookIn) {
            System.out.println("No book in catalog");
        }
    }

    public void borrowBook(String title) {
        boolean availborrow = true;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (!book.isBorrowed()) {
                    book.borrowed(true);
                    availborrow = false;

                }
            }
        }
        if (availborrow) {
            System.out.println("Sorry, this book is already borrowed.");
        } if (availborrow) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else if (!availborrow) {
            System.out.println("You successfully borrowed " + title);
        }
    }

    public void returnBook(String title) {
        boolean bookIn = false;
        for (Book rb : books) {
            if (rb.getTitle().equals(title) && rb.isBorrowed()) {
                rb.returned(true);
                bookIn = true;
            }
        }
        if (bookIn) {
            System.out.println("You successfully returned " + title);
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
