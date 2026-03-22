import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // ==================== Book Class ====================
    static class Book {
        int id;
        String title;
        String author;
        boolean available;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = true;
        }

        void display() {
            System.out.println("ID: " + id + " | " + title + " by " + author +
                               " | " + (available ? "Available" : "Issued"));
        }
    }

    // ==================== Member Class ====================
    static class Member {
        int id;
        String name;
        int booksIssued;

        Member(int id, String name) {
            this.id = id;
            this.name = name;
            this.booksIssued = 0;
        }

        void display() {
            System.out.println("ID: " + id + " | " + name + " | Books Issued: " + booksIssued);
        }
    }

    // ==================== Data Storage ====================
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static int bookIdCounter = 1;
    static int memberIdCounter = 1;

    // ==================== Helper Methods ====================
    static Book findBook(int id) {
        for (Book b : books)
            if (b.id == id) return b;
        return null;
    }

    static Member findMember(int id) {
        for (Member m : members)
            if (m.id == id) return m;
        return null;
    }

    // ==================== Menu Actions ====================
    static void addBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        books.add(new Book(bookIdCounter++, title, author));
        System.out.println("✔ Book added successfully!");
    }

    static void addMember(Scanner sc) {
        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();
        members.add(new Member(memberIdCounter++, name));
        System.out.println("✔ Member registered successfully!");
    }

    static void showAllBooks() {
        if (books.isEmpty()) { System.out.println("No books found."); return; }
        System.out.println("\n====== All Books ======");
        for (Book b : books) b.display();
    }

    static void showAllMembers() {
        if (members.isEmpty()) { System.out.println("No members found."); return; }
        System.out.println("\n====== All Members ======");
        for (Member m : members) m.display();
    }

    static void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int bId = sc.nextInt();
        System.out.print("Enter Member ID: ");
        int mId = sc.nextInt();
        sc.nextLine();

        Book book = findBook(bId);
        Member member = findMember(mId);

        if (book == null)         { System.out.println("✘ Book not found.");   return; }
        if (member == null)       { System.out.println("✘ Member not found."); return; }
        if (!book.available)      { System.out.println("✘ Book already issued."); return; }
        if (member.booksIssued >= 3) { System.out.println("✘ Member limit reached (max 3)."); return; }

        book.available = false;
        member.booksIssued++;
        System.out.println("✔ \"" + book.title + "\" issued to " + member.name);
    }

    static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int bId = sc.nextInt();
        System.out.print("Enter Member ID: ");
        int mId = sc.nextInt();
        sc.nextLine();

        Book book = findBook(bId);
        Member member = findMember(mId);

        if (book == null)    { System.out.println("✘ Book not found.");   return; }
        if (member == null)  { System.out.println("✘ Member not found."); return; }
        if (book.available)  { System.out.println("✘ Book was not issued."); return; }

        book.available = true;
        member.booksIssued--;
        System.out.println("✔ \"" + book.title + "\" returned by " + member.name);
    }

    static void searchBook(Scanner sc) {
        System.out.print("Enter title or author to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        System.out.println("\n====== Search Results ======");
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword) ||
                b.author.toLowerCase().contains(keyword)) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    // ==================== Main Method ====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=============================");
        System.out.println("  Library Management System  ");
        System.out.println("=============================");

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Show All Members");
            System.out.println("7. Search Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addBook(sc);     break;
                case 2: addMember(sc);   break;
                case 3: issueBook(sc);   break;
                case 4: returnBook(sc);  break;
                case 5: showAllBooks();  break;
                case 6: showAllMembers(); break;
                case 7: searchBook(sc);  break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
