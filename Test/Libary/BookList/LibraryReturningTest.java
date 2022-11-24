package Libary.BookList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryReturningTest {
    @Test
    public void ReturningABook() {
        //given
        Library tomLibrary = new Library();
        tomLibrary.addBook(new Book("Dzieci z Bullerbyn", "Astrid Lindgren", 2, "9788310104748"));

        //when
        tomLibrary.returnBook(1, "Dzieci z Bullerbyn", "Astrid Lindgren");

        //then
        assertEquals(3, Book.currentState);
    }

}