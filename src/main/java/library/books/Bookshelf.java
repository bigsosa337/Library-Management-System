package library.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Bookshelf {
    private static Bookshelf instance; // Singleton instance
    Map<String, Book> books;

    final String DATABASE_PATH = "books.json";

    private Bookshelf() {
        try {
            loadBooks();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Bookshelf getInstance() {
        if (instance == null) {
            instance = new Bookshelf();
        }
        return instance;
    }


    public Map<String, Book> getBooks() {
        return books;
    }

    /**
     *
     * @throws IOException
     */
    public void loadBooks() throws IOException {
        // Reads all elements as a list
        List<String> readLines = Files.readAllLines(Path.of("C:\\Users\\golf3\\Desktop\\Library-Management-System\\resources\\books.json"),
                StandardCharsets.UTF_8);

        String newJson = String.join(" ", readLines);

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Book>>() {}.getType();

        Map<String, Book> readBooks = gson.fromJson(newJson, type);
        this.books = readBooks;
    }


    public void saveBooks() {
        Gson gson = new Gson();
        String content = gson.toJson(books);

        try (PrintWriter out = new PrintWriter("C:\\Users\\golf3\\Desktop\\Library-Management-System\\resources\\books.json")) {
            out.println(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBook(Book book, String ID) {
        books.put(ID, book);
        this.saveBooks();
    }

    public Book getBook(String bookID) {
        // Check if the book exists in the map and return it
        if (books.containsKey(bookID)) {
            return books.get(bookID);
        } else {
            return null; // or handle the case where the book is not found
        }
    }
}