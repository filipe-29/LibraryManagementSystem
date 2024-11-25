//Library.java
import java.util.*;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public boolean borrowBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            System.out.println("Member or book not found.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available for borrowing.");
            return false;
        }

        book.setAvailable(false);
        book.setCurrentBorrower(memberId);
        member.borrowBook(book);
        System.out.println("Book borrowed successfully.");
        return true;
    }

    public boolean returnBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            System.out.println("Member or book not found.");
            return false;
        }

        if (book.isAvailable() || !book.getCurrentBorrower().equals(memberId)) {
            System.out.println("This book was not borrowed by this member.");
            return false;
        }

        book.setAvailable(true);
        book.setCurrentBorrower(null);
        member.returnBook(book);
        System.out.println("Book returned successfully.");
        return true;
    }

    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    public void displayBorrowedBooks() {
        System.out.println("\nBorrowed Books:");
        books.values().stream()
                .filter(book -> !book.isAvailable())
                .forEach(System.out::println);
    }

    public void displayMemberInfo(String memberId) {
        Member member = members.get(memberId);
        if (member != null) {
            System.out.println("\nMember Information:");
            System.out.println(member);
        } else {
            System.out.println("Member not found.");
        }
    }
}