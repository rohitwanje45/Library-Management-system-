# 📚 Library Management System

A simple **Library Management System** built in **Core Java** using Object-Oriented Programming (OOP) concepts. Everything is in a single file — easy to run and understand.

---

## 🗂️ Project Structure

```
LibraryManagement/
├── LibrarySystem.java    # Single file containing all classes and main method
└── README.md
```

---

## 🧱 OOP Concepts Used

| Concept | Where Used |
|---|---|
| **Class & Object** | `Book`, `Member` inner classes |
| **Encapsulation** | Fields accessed via methods |
| **Static members** | Shared `books` and `members` lists |
| **Constructor** | Initialize `Book` and `Member` objects |
| **ArrayList** | Dynamic storage for books and members |

---

## ✨ Features

- ➕ Add new books to the library
- 👤 Register new members
- 📖 Issue a book to a member
- 🔁 Return a book
- 📋 View all books with availability status
- 👥 View all registered members
- 🔍 Search books by title or author
- ✅ Validation — max 3 books per member, duplicate issue check

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or above installed
- Any terminal / command prompt

### Steps

```bash
# Step 1: Compile
javac LibrarySystem.java

# Step 2: Run
java LibrarySystem
```

---

## 🖥️ Menu Options

```
------ MENU ------
1. Add Book
2. Add Member
3. Issue Book
4. Return Book
5. Show All Books
6. Show All Members
7. Search Book
0. Exit
```

---

## 📌 Sample Usage

```
Enter choice: 1
Enter Book Title: The Great Gatsby
Enter Author Name: F. Scott Fitzgerald
✔ Book added successfully!

Enter choice: 3
Enter Book ID to issue: 1
Enter Member ID: 1
✔ "The Great Gatsby" issued to Alice

Enter choice: 5
====== All Books ======
ID: 1 | The Great Gatsby by F. Scott Fitzgerald | Issued
```

---

## ⚙️ Validations

- A book **cannot be issued** if it is already issued to someone else
- A member **cannot borrow more than 3 books** at a time
- Returns are validated — a book must be in issued state to be returned

---

## 👨‍💻 Author

Built with ❤️ using Core Java — no external libraries required.
