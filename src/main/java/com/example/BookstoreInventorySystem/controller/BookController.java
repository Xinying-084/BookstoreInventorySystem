package com.example.BookstoreInventorySystem.controller;

import com.example.BookstoreInventorySystem.entity.Book;
import com.example.BookstoreInventorySystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void removeBook(@PathVariable Long bookId) {
        bookService.removeBook(bookId);
    }

    @PutMapping("/{bookId}")
    public void updateStock(@PathVariable Long bookId, @RequestParam int newQuantity) {
        bookService.updateStock(bookId, newQuantity);
    }

    @GetMapping("/{bookId}")
    public int getStock(@PathVariable Long bookId) {
        return bookService.getStock(bookId);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, 
                              @RequestParam(required = false) String author,
                              @RequestParam(required = false) String isbn,
                              @RequestParam(required = false) Double minPrice,
                              @RequestParam(required = false) Double maxPrice,
                              @RequestParam(required = false) Integer minStock) {
    }
}