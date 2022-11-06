package main;

import library.Options;
import library.books.BookManager;

import java.util.Scanner;


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
            System.out.println("6. Iesire");

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

                    break;
                case Options.RETURN_BOOK:

                    break;
                case Options.EXIT:

                    break;

            }
        }
    }
}
