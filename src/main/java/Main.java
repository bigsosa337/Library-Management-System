
import library.*;
import library.books.Book;
import library.books.BookManager;
import library.books.Bookshelf;

import java.util.Map;
import java.util.Scanner;

import static library.books.BookManager.bookshelf;


public class Main {
    public static void main(String[] args) {
        while (true) {

            // Afiseaza optiunile disponibile
            System.out.println("Bine ai venit!");
            System.out.println("1. Adauga carte");
            System.out.println("2. Arata toate cartile");
            System.out.println("3. Arata cartile disponibile");
            System.out.println("4. Imprumuta carte");
            System.out.println("5. Returneaza carte");
            System.out.println("6. Cauta carte");
            System.out.println("7. Afla detalii despre o carte");
            System.out.println("8. Iesire");

            // Declaram scannerul
            Scanner sc = new Scanner(System.in);
            int optiuneSelectata = sc.nextInt();
            SearchContext context = new SearchContext(); // Declare and initialize SearchContext

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
                    System.out.println("Introduceti ID-ul cartii: ");
                    sc.nextLine(); // Empty the buffer
                    String bookID = sc.nextLine();
                    BookManager.confirmBorrow(bookID);
                    if (bookID != "available" && bookID != "unavailable") {
                        System.out.println("Nu detinem cartea dorita");
                    }


                    break;
                case Options.RETURN_BOOK:
                    System.out.println("Introduceti ID-ul cartii: ");
                    sc.nextLine();// Empty the buffer, i have no idea why this happens
                    String bookIDreturn = sc.nextLine();
                    BookManager.returnBook(bookIDreturn);
                    System.out.println("Cartea cu id-ul " + bookIDreturn + " a fost returnata");

                    break;
                case Options.SEARCH_BOOK:
                    sc.nextLine();
                    System.out.println("Select search criteria:");
                    System.out.println("1. By Name");
                    System.out.println("2. By Author");
                    // ... other options ...

                    int searchOption = sc.nextInt();
                    sc.nextLine(); // consume the rest of the line

                    System.out.println("Enter search term:");
                    String searchTerm = sc.nextLine();

                    switch (searchOption) {
                        case 1: // Search by name
                            context.setStrategy(new SearchByNameStrategy());
                            break;
                        case 2: // Search by author
                            context.setStrategy(new SearchByAuthorStrategy());
                            break;
                        // ... other cases ...
                    }

                    Map<String, Book> results = context.executeSearch(searchTerm);
                    // Display the search results
                    for (Map.Entry<String, Book> entry : results.entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;
                case Options.SHOW_BOOK_DETAILS:
                    System.out.println("Introduceti ID-ul cartii pentru detalii: ");
                    sc.nextLine(); // Empty the buffer
                    String bookIDDetails = sc.nextLine();
                    Book book = bookshelf.getBook(bookIDDetails); // Assuming getBook method exists
                    if (book != null) {
                        LibraryVisitor detailsVisitor = new BookDetailsVisitor();
                        book.accept(detailsVisitor);
                    } else {
                        System.out.println("Cartea nu a fost gasita.");
                    }
                    break;
                case Options.EXIT:
                    BookManager.exit();
                    System.exit(0);
                    break;

            }
        }
    }
}
