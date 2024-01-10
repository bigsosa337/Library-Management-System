package library.search;

import library.books.Book;

import java.util.Map;

public interface SearchStrategy {
    Map<String, Book> search(String searchTerm);
}
