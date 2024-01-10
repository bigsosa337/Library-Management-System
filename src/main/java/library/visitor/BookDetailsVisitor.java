package library.visitor;

import library.books.Book;

public class BookDetailsVisitor implements LibraryVisitor {

    @Override
    public void visit(Book book) {
        System.out.println("Book Details: ");
        System.out.println("Numele Cartii: " + book.getBookName());
        System.out.println("Autor: " + book.getBookAuthor());
        System.out.println("Anul publicarii: " + book.getBookPublishDate());
        System.out.println("Genul cartii: " + book.getBookGenre());

    }
}
