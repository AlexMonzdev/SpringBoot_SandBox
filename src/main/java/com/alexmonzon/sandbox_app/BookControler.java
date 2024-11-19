package com.alexmonzon.sandbox_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookControler {

    private final BookRepository bookRepository;

    public BookControler() {
        this.bookRepository = new InMemoryBookRepository();

    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookIsbn(@PathVariable String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if(optionalBook.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBookByIsbn(@PathVariable String isbn) {
        //TODO comprobar si no existe devolver 404
        //TODO si se ha borrado devolver ok
        bookRepository.deleteByIsbn(isbn);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBookByIsbn(@PathVariable String isbn, @RequestBody Book book) {
        Optional<Book> optionalBook = bookRepository.updateBook(isbn, book);
        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);// Retorna el libro actualizado con un código 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna un 404 si el libro no fue encontrado
        }
    }



}
