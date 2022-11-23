package Libary.BookList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class Library {

    List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> searchBookByTitle(String title) {
        return books.stream()
                .filter(withTitle(title))
                .findFirst();
    }

    private static Function<Book, String> toTitle() {
        return Book::getTitle;
    }

    private static Predicate<Book> withTitle(String title) {
        return book -> book.getTitle().equals(title);
    }

    public List<Book> searchBookByAuthor(String author) {
        return books.stream()
                .filter(withAuthor(author))
                .toList();
    }

    private static Function<Book, String> toAuthor() {
        return Book::getAuthor;
    }

    private static Predicate<Book> withAuthor(String author) {
        return book -> book.getAuthor().equals(author);
    }

    public List<Book> searchBookByISBN(String iSBN) {
        return books.stream()
                .filter(withISBN(iSBN))
                .toList();
    }

    private static Function<Book, String> toISBN() {
        return Book::getInternationalStandardBookNumber;
    }

    private static Predicate<Book> withISBN(String iSBN) {
        return book -> book.getInternationalStandardBookNumber().equals(iSBN);
    }

    public void borrowBook(int quantity, String bookTitle, String bookAuthor) {

        this.searchBookByTitle(bookTitle);
        this.searchBookByAuthor(bookAuthor);
        if (isBookAvailable(quantity) && quantity > 0) {
            return;
        } else if (quantity <= 0) {
            throw new IllegalArgumentException("You cannot borrow zero or negative number of book");
        }
        Book.currentState -= quantity;

    }

    public void returnBook(int quantity, String bookTitle, String bookAuthor) {
        this.searchBookByTitle(bookTitle);
        this.searchBookByAuthor(bookAuthor);
        if (isBookAvailable(quantity)) {
            return;
        }
        Book.currentState += quantity;
    }

    private boolean isBookAvailable(int quantity) {
        return Book.currentState <= quantity;
    }


    public String showMeTitles() {
        return books.stream()
                .map(toTitle())
                .collect(joining(", "));
    }

    public String showMeAuthors() {
        return books.stream()
                .map(toAuthor())
                .collect(joining(", "));
    }


}
