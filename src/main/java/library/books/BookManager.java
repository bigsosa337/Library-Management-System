package library.books;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookManager {

    public static Bookshelf bookshelf = new Bookshelf();

    public static void addBook(String bookName, String bookAuthor, String bookPublishDate, String bookGenre) {
        String status = "available";
        int timesBorrowed = 0;
        final String bookID = UUID.randomUUID().toString().replace("-", "").substring(0,5);
        String bookAddedDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        System.out.println("Numele cartii este " + bookName);
        System.out.println("Autorul cartii este " + bookAuthor);
        System.out.println("Data publicarii este " + bookPublishDate);
        System.out.println("Genul cartii este " + bookGenre);
        System.out.println("Cartea are statusul de " + status);
        System.out.println("ID-ul cartii este " + bookID);
        System.out.println("Cartea a fost adaugata in data de " + bookAddedDate);
        System.out.println("--------------------------------------------------");

        Book book = new Book(bookName, bookAuthor, bookPublishDate, bookGenre, bookID, status, timesBorrowed);
        bookshelf.addBook(book, bookID);
    }

    public static void showAllBooks() {
        Map<String, Book> books = bookshelf.getBooks();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void showAvailableBooks() {
        Map<String, Book> books = bookshelf.getBooks();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookStatus().equals("available")) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void confirmBorrow(String bookID) {

        Map<String, Book> books = bookshelf.getBooks();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookID().equals(bookID)) {
                if (entry.getValue().getBookStatus().equals("available")) {
                    entry.getValue().setBookStatus("unavailable");
                    entry.getValue().setTimesBorrowed(entry.getValue().getTimesBorrowed() + 1);
                    bookshelf.saveBooks();
                    System.out.println("Cartea cu id-ul " + bookID + " a fost imprumutata");
                } else {
                    System.out.println("Aceasta carte a fost deja imprumutata");
                }
            }

        }
    }


    public static void returnBook (String bookID) {
        Map<String, Book> books = bookshelf.getBooks();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookID().equals(bookID)) {
                entry.getValue().setBookStatus("available");
                bookshelf.saveBooks();
            }
        }

}
    public static void searchByPop() {
        Map<String, Integer> maxime = new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            String maxID = "";
            int max = -1;
            for (Map.Entry<String, Book> entry : bookshelf.getBooks().entrySet()) {
                if (entry.getValue().getTimesBorrowed() > max) {
                    if (!maxime.containsValue(entry.getValue().getTimesBorrowed())) {
                        max = entry.getValue().getTimesBorrowed();
                        maxID = entry.getValue().getBookID();
                    }

                }
            }
            maxime.put(maxID, max);
        }

        for (Map.Entry<String, Integer> entry : maxime.entrySet()) {
            System.out.println("-----------");
            Book book = bookshelf.getBooks().get(entry.getKey());
            System.out.println(book);
        }

    }

    public static void exit () {
        bookshelf.saveBooks();
    }



}



