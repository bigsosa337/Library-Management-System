package library.search;

import library.books.Book;
import library.books.BookManager;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchByAuthorStrategy implements SearchStrategy {

    @Override
    public Map<String, Book> search(String authorName) {
        return BookManager.bookshelf.getBooks().entrySet().stream()
                .filter(entry -> entry.getValue().getBookAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
