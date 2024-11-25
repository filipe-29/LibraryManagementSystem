// Book.java
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private String currentBorrower;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.currentBorrower = null;
    }

    // Getters and setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public String getCurrentBorrower() { return currentBorrower; }

    public void setAvailable(boolean available) { isAvailable = available; }
    public void setCurrentBorrower(String borrower) { currentBorrower = borrower; }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                ", currentBorrower='" + currentBorrower + '\'' +
                '}';
    }
}








