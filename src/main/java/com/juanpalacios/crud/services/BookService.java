package com.juanpalacios.crud.services;
import com.juanpalacios.crud.models.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
    List<Book> getBooks();
    Optional<Book> getBookById(Long id);
    
}
