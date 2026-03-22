public class Main {
    public static void main(String[] args) {

        // Create library
        Library library = new Library("City Public Library");

        // Add books
        library.addBook(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(102, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(103, "1984", "George Orwell"));
        library.addBook(new Book(104, "Animal Farm", "George Orwell"));
        library.addBook(new Book(105, "The Alchemist", "Paulo Coelho"));

        // Register members
        library.addMember(new Member(1, "Alice Johnson", "alice@email.com"));
        library.addMember(new Member(2, "Bob Smith", "bob@email.com"));

        // Display all books
        library.displayAllBooks();

        // Display all members
        library.displayAllMembers();

        // Issue books
        System.out.println("\n--- Issuing Books ---");
        library.issueBook(101, 1);  // Alice borrows Book 101
        library.issueBook(103, 1);  // Alice borrows Book 103
        library.issueBook(102, 2);  // Bob borrows Book 102
        library.issueBook(101, 2);  // Already issued - should fail

        // Display updated book list
        library.displayAllBooks();

        // Return a book
        System.out.println("\n--- Returning Books ---");
        library.returnBook(101, 1);  // Alice returns Book 101

        // Display after return
        library.displayAllBooks();

        // Search
        System.out.println("\n--- Searching ---");
        library.searchByAuthor("George Orwell");
        library.searchByTitle("Alchemist");

        // Display members with issued count
        library.displayAllMembers();
    }
}
