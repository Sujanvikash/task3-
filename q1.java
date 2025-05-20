import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library() {
        books = new Book[100];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void replaceBook(int bookID, String newTitle, String newAuthor) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public void displayBooks() {
        if (count == 0) {
            System.out.println("Library is empty.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(books[i]);
            }
        }
    }

    public Book searchBook(int bookID) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        return null;
    }
}

public class q1 {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Replace Book Info");
            System.out.println("3. Display All Books");
            System.out.println("4. Search Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author, true));
                    break;

                case 2:
                    System.out.print("Enter Book ID to replace: ");
                    int repId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    library.replaceBook(repId, newTitle, newAuthor);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    Book found = library.searchBook(searchId);
                    if (found != null) {
                        System.out.println("Book found: " + found);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
