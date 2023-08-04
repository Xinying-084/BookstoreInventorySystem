package com.example.BookstoreInventorySystem.service; 

import com.example.BookstoreInventorySystem.entity.Book; 
import com.example.BookstoreInventorySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public void addBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            logger.error("Error adding book: {}", e.getMessage());
            throw e;
        }
    }

    public void removeBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public void updateStock(Long bookId, int newQuantity) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setQuantityInStock(newQuantity);
            bookRepository.save(book);
        }
    }

    public int getStock(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        return bookOptional.map(Book::getQuantityInStock).orElse(0);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}