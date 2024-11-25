import java.util.Scanner;

//Main.java
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Display Member Info");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(new Member(memberId, memberName));
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    String borrowMemberId = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowMemberId, borrowIsbn);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnMemberId, returnIsbn);
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    library.displayBorrowedBooks();
                    break;

                case 7:
                    System.out.print("Enter Member ID: ");
                    String infoMemberId = scanner.nextLine();
                    library.displayMemberInfo(infoMemberId);
                    break;

                case 8:
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
