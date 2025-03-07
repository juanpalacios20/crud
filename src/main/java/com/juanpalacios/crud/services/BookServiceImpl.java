package com.juanpalacios.crud.services;
import org.springframework.stereotype.Service;
import com.juanpalacios.crud.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.juanpalacios.crud.models.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
