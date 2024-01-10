package library.search;

import library.books.Book;
import library.books.BookManager;

import java.util.Map;
import java.util.Scanner;

import static library.search.SearchOptions.*;
import static library.books.BookManager.bookshelf;

public class Search {

    public static void searchBookByName() {
        System.out.println("Introdu numele cartii:");
        Scanner scan = new Scanner(System.in);
        Map<String, Book> books = bookshelf.getBooks();
        String bookBorrowName = scan.nextLine();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookName().equals(bookBorrowName)) {
                System.out.println(entry.getValue());
            }
        }
    }
    public static void searchBookByYear() {
        System.out.println("Introdu anul publicatiei:");
        Scanner scan = new Scanner(System.in);
        Map<String, Book> books = bookshelf.getBooks();
        String bookBorrowName = scan.nextLine();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookPublishDate().equals(bookBorrowName)) {
                System.out.println(entry.getValue());
            }
        }
    }
    public static void searchBookByAuthor() {
        System.out.println("Introdu numele autorului:");
        Scanner scan = new Scanner(System.in);
        Map<String, Book> books = bookshelf.getBooks();
        String bookBorrowName = scan.nextLine();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookAuthor().equals(bookBorrowName)) {
                System.out.println(entry.getValue());
            }
        }
    }
    public static void searchBookByGenre() {
        System.out.println("Introdu genul cartii");
        Scanner scan = new Scanner(System.in);
        Map<String, Book> books = bookshelf.getBooks();
        String bookBorrowName = scan.nextLine();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookGenre().equals(bookBorrowName)) {
                System.out.println(entry.getValue());
            }
        }
    }


    public static void searchBooks() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (CAUTARE_NUME == a) {
            Search.searchBookByName();
        } else if (CAUTARE_AUTOR == a) {
            Search.searchBookByAuthor();
        } else if (CAUTARE_AN == a) {
            Search.searchBookByYear();
        } else if (CAUTARE_POPULARITATE == a) {
            BookManager.searchByPop();
        } else if (CAUTARE_GEN == a) {
            Search.searchBookByGenre();
        } else if (INAPOI_MENIU == a) {

        }
    }
}
