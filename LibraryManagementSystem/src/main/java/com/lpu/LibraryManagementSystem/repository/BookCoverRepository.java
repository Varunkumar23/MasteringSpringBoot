package com.lpu.LibraryManagementSystem.repository;


import com.lpu.LibraryManagementSystem.entity.BookCover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCoverRepository extends JpaRepository<BookCover, Long> {
}
