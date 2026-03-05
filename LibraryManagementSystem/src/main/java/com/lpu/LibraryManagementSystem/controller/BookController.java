package com.lpu.LibraryManagementSystem.controller;


import com.lpu.LibraryManagementSystem.dto.BookRequestDto;
import com.lpu.LibraryManagementSystem.dto.BookResponseDto;
import com.lpu.LibraryManagementSystem.dto.PageResponseDto;
import com.lpu.LibraryManagementSystem.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @PostMapping
    @Operation(summary = "Create a new warehouse",
            description = "Creates a warehouse with name, location, and capacity")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        BookResponseDto createdBook = bookService.createBook(bookRequestDto);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<PageResponseDto<BookResponseDto>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        PageResponseDto<BookResponseDto> books = bookService.getAllBooks(page, size, sortBy);
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDto bookRequestDto) {

        BookResponseDto updatedBook = bookService.updateBook(id, bookRequestDto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}