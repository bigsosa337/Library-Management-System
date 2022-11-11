package library.books;

public class Book {
    String bookName;
    String bookAuthor;
    String bookPublishDate;
    String bookGenre;
    String bookID;
    String bookStatus;
    int timesBorrowed;

    public Book(String bookName, String bookAuthor, String bookPublishDate, String bookGenre, String bookID, String bookStatus, int timesBorrowed) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublishDate = bookPublishDate;
        this.bookGenre = bookGenre;
        this.bookID = bookID;
        this.bookStatus = bookStatus;
        this.timesBorrowed = timesBorrowed;
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(String bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    @Override
    public String toString() {
        return  "Numele Cartii: " + bookName + '\n' +
                "Autorul Cartii: " + bookAuthor + '\n' +
                "Data Publicarii: " + bookPublishDate + '\n' +
                "Genul Cartii: " + bookGenre + '\n' +
                "ID-ul cartii: " + bookID + '\n' +
                "Statusul cartii: " + bookStatus + '\n' +
                "  " + '\n';

    }
}
