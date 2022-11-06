package library.books;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BookManager {
    public static void addBook(String bookName, String bookAuthor, String bookPublishDate, String bookGenre) {
        String status = "available";
        final String bookID = UUID.randomUUID().toString().replace("-", "");
        String bookAddedDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        System.out.println("Numele cartii este " + bookName);
        System.out.println("Autorul cartii este " + bookAuthor);
        System.out.println("Data publicarii este " + bookPublishDate);
        System.out.println("Genul cartii este " + bookGenre);
        System.out.println("Cartea are statusul de " + status);
        System.out.println("ID-ul cartii este " + bookID);
        System.out.println("Cartea a fost adaugata in data de " + bookAddedDate);
    }

    public static void showAllBooks() {

    }

    public static void showAvailableBooks() {

    }

    public static void borrowBook() {

    }

    public static void returnBook() {

    }

    public static void exit() {

    }
}

