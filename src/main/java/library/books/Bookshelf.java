package library.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Bookshelf {
    Map<String, Book> books;

    public static void main(String[] args) {
        Bookshelf bKs = new Bookshelf();
        System.out.println(bKs);
    }
    public Bookshelf() {
        try {
            loadBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadBooks() throws IOException {
        // Reads all elements as a list
        List<String> readLines = Files.readAllLines(Paths.get("C:\\Users\\ACDnu\\Documents\\GitHub\\priectppoo\\resources\\books.json"), StandardCharsets.UTF_8);

        String newJson = String.join(" ", readLines);

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Book>>() {
        }.getType();

        Map<String, Book> readBooks = gson.fromJson(newJson, type);
        this.books = readBooks;
    }

    public void saveBooks() {

    }
}