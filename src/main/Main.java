package main;

import library.Options;
import library.Search;
import library.SearchOptions;
import library.books.Book;
import library.books.BookManager;
import library.books.Bookshelf;

import java.util.Map;
import java.util.Scanner;

import static library.books.BookManager.bookshelf;


public class Main {
    public static void main(String[] args) {
        while(true) {

            // Afiseaza optiunile disponibile
            System.out.println("Bine ai venit!");
            System.out.println("1. Adauga carte");
            System.out.println("2. Arata toate cartile");
            System.out.println("3. Arata cartile disponibile");
            System.out.println("4. Imprumuta carte");
            System.out.println("5. Returneaza carte");
            System.out.println("6. Cauta carte");
            System.out.println("7. Iesire");

            // Declaram scannerul
            Scanner sc = new Scanner(System.in);
            int optiuneSelectata = sc.nextInt();

            switch (optiuneSelectata) {
                case Options.ADD_BOOK:
                    System.out.println("Numele cartii: ");
                    sc.nextLine(); // To empty the buffer
                    String bookName = sc.nextLine();
                    System.out.println("Autorul cartii: ");
                    String bookAuthor = sc.nextLine();
                    System.out.println("Data publicarii: ");
                    String bookPublishDate = sc.nextLine();
                    System.out.println("Genul cartii: ");
                    String bookGenre = sc.nextLine();
                    BookManager.addBook(bookName, bookAuthor, bookPublishDate, bookGenre);
                    break;
                case Options.SHOW_ALL_BOOKS:
                    BookManager.showAllBooks();
                    break;
                case Options.SHOW_AVAILABLE_BOOKS:
                    BookManager.showAvailableBooks();
                    break;
                case Options.BORROW_BOOK:
                    System.out.println("Introduceti ID-ul cartii: ");
                    sc.nextLine(); // Empty the buffer
                    String bookID = sc.nextLine();
                    BookManager.confirmBorrow(bookID);


                    break;
                case Options.RETURN_BOOK:
                    System.out.println("Introduceti ID-ul cartii: ");
                    sc.nextLine();// Empty the buffer, i have no idea why this happens
                    String bookIDreturn = sc.nextLine();
                    BookManager.returnBook(bookIDreturn);
                    System.out.println("Cartea cu id-ul " + bookIDreturn + " a fost returnata");

                    break;
                case Options.SEARCH_BOOK:
                    sc.nextLine();
                    System.out.println("1. Cauta dupa numele cartii");
                    System.out.println("2. Cauta dupa anul de publicatie");
                    System.out.println("3. Cauta dupa numele autorului");
                    System.out.println("4. Cauta dupa data imprumutarii");
                    System.out.println("5. Cauta dupa popularitate");
                    System.out.println("6. Inapoi la meniul principal");
                    Search.searchBooks();

                case Options.EXIT:
//                    System.exit(0);
                    break;

            }
        }
    }
}
