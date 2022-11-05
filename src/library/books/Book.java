package library.books;

public class Book {
    String bookName;
    String bookAuthor;
    String bookPublishDate;
    String bookGenre;
    String bookID;
    String bookStatus;

    public Book(String bookName, String bookAuthor, String bookPublishDate, String bookGenre, String bookID, String bookStatus) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublishDate = bookPublishDate;
        this.bookGenre = bookGenre;
        this.bookID = bookID;
        this.bookStatus = bookStatus;
    }
}
