package library.search;

import library.books.Book;

import java.util.Map;

public class SearchContext {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<String, Book> executeSearch(String searchTerm) {
        return strategy.search(searchTerm);
    }
}
