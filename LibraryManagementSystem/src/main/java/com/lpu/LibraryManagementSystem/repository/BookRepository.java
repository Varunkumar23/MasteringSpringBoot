package com.lpu.LibraryManagementSystem.repository;


import com.lpu.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategory(String category);

    @Query(value = "SELECT * FROM books WHERE price BETWEEN :min AND :max", nativeQuery = true)
    List<Book> findBooksByPriceRange(@Param("min") Double min,@Param("max") Double max);
}