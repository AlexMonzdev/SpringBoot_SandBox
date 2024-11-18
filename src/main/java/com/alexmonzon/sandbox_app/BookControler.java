package com.alexmonzon.sandbox_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookControler {

    private final BookRepository bookRepository;

    public BookControler() {
        this.bookRepository = new InMemoryBookRepository();

    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookIsbn(@PathVariable String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        //TODO comprobar que no exista
        //TODO si existe devolver un bad request
        //TODO retornar un 201
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/(isbn)")
    public void deleteBookByIsbn(@PathVariable String isbn) {
        //TODO comprobar si no existe devolver 404
        //TODO si se ha borrado devolver ok
        bookRepository.deleteByIsbn(isbn);
    }

    //TODO CREAR UPDATE.

}