package com.juanpalacios.crud.controllers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.juanpalacios.crud.models.Book;
import com.juanpalacios.crud.services.BookServiceImpl;


@RestController()
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    try {
        Book savedbook = bookServiceImpl.saveBook(book);
        return new ResponseEntity<>(savedbook, HttpStatus.CREATED);
    }
    catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PatchMapping("/")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
    try {
        Book updatedbook = bookServiceImpl.updateBook(book);
        return new ResponseEntity<>(updatedbook, HttpStatus.OK);
    }
    catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> books = bookServiceImpl.getBooks();
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        try {
            Optional<Book> book = bookServiceImpl.getBookById(id);
            if (!book.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            Optional<Book> book = bookServiceImpl.getBookById(id);
            if (book.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                bookServiceImpl.deleteBook(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

