package javaAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BookStore {
    private int bookId;
    private String bookName;

    public BookStore(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Book Name: " + bookName);
    }
}

class SortByName implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return b1.getBookName().compareToIgnoreCase(b2.getBookName());
    }
}

class SortById implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return Integer.compare(b1.getBookId(), b2.getBookId());
    }
}

public class que41 {
    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();

        books.add(new BookStore(101, "The Great Gatsby"));
        books.add(new BookStore(102, "To Kill a Mockingbird"));
        books.add(new BookStore(103, "1984"));
        books.add(new BookStore(99, "Pride and Prejudice"));
        books.add(new BookStore(105, "The Catcher in the Rye"));

        System.out.println("Original list:");
        for (BookStore book : books) {
            book.display();
        }

        // Sort by book name
        Collections.sort(books, new SortByName());
        System.out.println("\nSorted by Book Name:");
        for (BookStore book : books) {
            book.display();
        }

        // Sort by book id
        Collections.sort(books, new SortById());
        System.out.println("\nSorted by Book ID:");
        for (BookStore book : books) {
            book.display();
        }
    }
}

