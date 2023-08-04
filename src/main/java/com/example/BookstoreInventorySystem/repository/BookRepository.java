package com.example.BookstoreInventorySystem.repository;

import com.example.BookstoreInventorySystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByIsbn(String isbn);
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
    List<Book> findByQuantityInStockGreaterThan(int minStock);
}