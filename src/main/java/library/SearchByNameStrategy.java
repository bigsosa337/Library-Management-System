package library;

import library.books.Book;
import library.books.BookManager;

import java.util.Map;
import java.util.stream.Collectors;

public class SearchByNameStrategy implements SearchStrategy {
    @Override
    public Map<String, Book> search(String bookName) {
        return BookManager.bookshelf.getBooks().entrySet().stream()
                .filter(entry -> entry.getValue().getBookName().equalsIgnoreCase(bookName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

