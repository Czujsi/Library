package Libary.BookList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryBorrowABookTest {
    @Test
    void BorrowingABook() {
        //given
        Library tomLibrary = new Library();
        tomLibrary.addBook(new Book("Dzieci z Bullerbyn", "Astrid Lindgren", 4, "9788310104748"));

        //when
        tomLibrary.borrowBook(1, "Dzieci z Bullerbyn", "Astrid Lindgren");

        //then
        assertEquals(3, Book.currentState);
    }

    @Test
    void whenBorrowingZeroBookThenThrowIllegal() {
        //given
        Library tomLibrary = new Library();
        tomLibrary.addBook(new Book("Dzieci z Bullerbyn", "Astrid Lindgren", 4, "9788310104748"));

        //then
        assertThrows(IllegalArgumentException.class,
                () -> tomLibrary.borrowBook(0, "Dzieci z Bullerbyn", "Astrid Lindgren"));
    }

    @Test
    void whenBorrowingNegativeNumberOfBookThenDoNotBorrow() {
        //given
        Library tomLibrary = new Library();
        tomLibrary.addBook(new Book("Dzieci z Bullerbyn", "Astrid Lindgren", 4, "9788310104748"));

        //then
        assertThrows(IllegalArgumentException.class,
                () -> tomLibrary.borrowBook(-1, "Dzieci z Bullerbyn", "Astrid Lindgren"));
    }

}