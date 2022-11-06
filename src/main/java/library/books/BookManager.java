package library.books;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class BookManager {

    public static Bookshelf bookshelf = new Bookshelf();

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

        Book book = new Book(bookName, bookAuthor, bookPublishDate, bookGenre,bookID, status);
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
            if(entry.getValue().getBookStatus().equals("available")) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void borrowBook() {

    }

    public static void returnBook() {

    }

    public static void exit() {

    }
}

