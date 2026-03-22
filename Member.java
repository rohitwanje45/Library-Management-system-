public class Member {
    private int memberId;
    private String name;
    private String email;
    private int booksIssued;
    private static final int MAX_BOOKS = 3;

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.booksIssued = 0;
    }

    // Getters
    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getBooksIssued() { return booksIssued; }

    public boolean canBorrow() {
        return booksIssued < MAX_BOOKS;
    }

    public void incrementBooks() { booksIssued++; }
    public void decrementBooks() { if (booksIssued > 0) booksIssued--; }

    @Override
    public String toString() {
        return "Member ID: " + memberId + " | Name: " + name +
               " | Email: " + email + " | Books Issued: " + booksIssued;
    }
}
