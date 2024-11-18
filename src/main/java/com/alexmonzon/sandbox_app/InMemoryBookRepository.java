package com.alexmonzon.sandbox_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {

    private final static List<Book> booksDB = new ArrayList<>();

    public InMemoryBookRepository() {
        booksDB.add(new Book("A001", "Java", "Sergi"));
        booksDB.add(new Book("A002", "JavaScript", "Manuel"));
    }


    @Override
    public List<Book> findAll() {
        return booksDB;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : booksDB) {
            if (book.getIsbn().equals(isbn)) return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        booksDB.add(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getIsbn().equals(isbn));
    }



    @Override
    public Optional<Book> updateBook(String isbn, Book book) {
        if (isbn == null || book == null) {
            throw new IllegalArgumentException("ISBN o libro no pueden ser nulos");
        }

        for (int i = 0; i < booksDB.size(); i++) {
            Book existBook = booksDB.get(i);
            if (existBook.getIsbn().equals(isbn)) {
                if (book.getTitle() != null) {
                    existBook.setTitle(book.getTitle());
                }
                if (book.getAuthor() != null) {
                    existBook.setAuthor(book.getAuthor());
                }
                return Optional.of(existBook);
            }
        }
        return Optional.empty();
    }

}
