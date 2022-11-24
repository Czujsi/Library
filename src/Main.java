import Libary.BookList.Book;
import Libary.BookList.Library;
//ctrl+alt+shift+t ZAPAMIĘTAĆĆĆĆĆ

import java.util.*;


public class Main {
    public static void main(String[] args) {

        HistoricLibraryRecords();

    }

    private static void HistoricLibraryRecords() {
        String option1 = "Enter 1 if You want to search a book by author";
        String option2 = "Enter 2 if You want to search a book by title";
        String option3 = "Enter 3 if You want to search a book by International Standard Book Number";
        String option4 = "Enter 4 if You want to display all titles";
        String option5 = "Enter 5 if You want to display all authors";
        String typeNumber = "Type chosen number :";
        Library historicLibrary = new Library();
        Book book3 = new Book("FFF", "GGG", 3, "1");
        historicLibrary.addBook(book3);
        historicLibrary.addBook(new Book("FFF2", "GGG", 2, "2"));
        historicLibrary.addBook(new Book("FFF3", "ttt", 4, "3"));
        historicLibrary.addBook(new Book("Dzieci z Bullerbyn", "Astrid Lindgren", 4, "9788310104748"));

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println(option1 + "\r\n" + option2 + "\r\n" + option3 + "\r\n" + option4 + "\r\n" + option5 + "\r\n" + typeNumber);

        String choseOption = scanner.nextLine();
        if (Objects.equals(choseOption, "1")) {
            System.out.println("Enter author");
            String author = scanner.nextLine();
            List<String> bookAuthor = historicLibrary.searchBookByAuthor(author).stream()
                    .map(Book::toString).toList();
            System.out.println(bookAuthor);
        } else if (Objects.equals(choseOption, "2")) {
            System.out.println("Enter title");
            String title = scanner.nextLine();  // Read user input
            String book = historicLibrary.searchBookByTitle(title)
                    .map(Book::toString)
                    .orElse("Book not found");
            System.out.println(book);
        } else if (Objects.equals(choseOption, "3")) {
            System.out.println("Enter ISBN");
            String iSBN = scanner.nextLine();  // Read user input
            List<String> bookISBN = historicLibrary.searchBookByISBN(iSBN).stream()
                    .map(Book::toString).toList();
            System.out.println(bookISBN);
        } else if (Objects.equals(choseOption, "4"))
            System.out.println(historicLibrary.showMeTitles());

        else if (Objects.equals(choseOption, "5"))
            System.out.println(historicLibrary.showMeAuthors());
        else
            System.out.println("incorrect statement");

    }
}
