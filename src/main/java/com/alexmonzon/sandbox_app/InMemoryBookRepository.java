package com.alexmonzon.sandbox_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository{

    private final static List<Book> booksDB = new ArrayList<>();

    public InMemoryBookRepository(){
        booksDB.add(new Book("A001","Java","Sergi"));
        booksDB.add(new Book("A002","JavaScript","Manuel"));
    }


    @Override
    public List<Book> findAll() {
        return booksDB;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : booksDB){
            if(book.getIsbn().equals(isbn)) return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        booksDB.add(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {

    }
}
