package com.lpu.LibraryManagementSystem.controller;


import com.lpu.LibraryManagementSystem.dto.BookCoverResponseDto;
import com.lpu.LibraryManagementSystem.entity.BookCover;
import com.lpu.LibraryManagementSystem.service.BookCoverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/books")
public class BookCoverController {

    @Autowired
    private BookCoverService bookCoverService;

    @PostMapping("/{bookId}/cover")
    public ResponseEntity<BookCoverResponseDto> uploadBookCover(
            @PathVariable Long bookId,
            @RequestParam("file") MultipartFile file) {

        BookCoverResponseDto response = bookCoverService.uploadBookCover(bookId, file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{bookId}/cover")
    public ResponseEntity<BookCoverResponseDto> getBookCover(
            @PathVariable Long bookId) {

        BookCoverResponseDto response = bookCoverService.getBookCoverByBookId(bookId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{bookId}/cover/image")
    public ResponseEntity<byte[]> getBookCoverImage(@PathVariable Long bookId) {

        BookCover cover = bookCoverService.getBookCoverEntityByBookId(bookId);

        return ResponseEntity.ok()
                .header("Content-Type", cover.getFileType())
                .body(cover.getFileData());
    }
}
