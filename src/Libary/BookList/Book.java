package Libary.BookList;

import java.util.Objects;

public class Book {

    public static int currentState;
    private final String title;
    private final String author;
    protected final String internationalStandardBookNumber;

    public String getInternationalStandardBookNumber() {
        return internationalStandardBookNumber;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(internationalStandardBookNumber, book.internationalStandardBookNumber);
    }

    @Override
    public int hashCode() {

        return 31 + (internationalStandardBookNumber != null ? internationalStandardBookNumber.hashCode() : 0);
    }

    public Book(String title, String author, int currentState, String internationalStandardBookNumber) {
        this.title = title;
        this.author = author;
        Book.currentState = currentState;
        this.internationalStandardBookNumber = internationalStandardBookNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Current quantity='" + currentState + '\'' +
                ", International Standard Book Number='" + internationalStandardBookNumber + '\'' +
                '}';
    }
}
