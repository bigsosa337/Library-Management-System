package library.visitor;


import library.books.Book;

public interface LibraryVisitor {
    void visit(Book book);
    // You can add more visit methods if you have more elements to visit
}