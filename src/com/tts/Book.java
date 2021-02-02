package com.tts;

public class Book {

    boolean borrowed;
    String title;

    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        this.title= bookTitle;
        this.borrowed = false;
    }

    // Marks the book as rented
    public void borrowed(boolean borrowed) {
        // borrowed true
        this.borrowed = true;

    }

    // Marks the book as not borrowed
    public void returned(boolean returned) {
        // Implement this method
        this.borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
       return this.borrowed;

    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        this.borrowed = false;
        return this.title;
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed(true);
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned(true);
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }


}
