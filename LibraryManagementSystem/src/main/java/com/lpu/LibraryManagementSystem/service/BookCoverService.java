package com.lpu.LibraryManagementSystem.service;


import com.lpu.LibraryManagementSystem.dto.BookCoverResponseDto;
import com.lpu.LibraryManagementSystem.entity.BookCover;
import org.springframework.web.multipart.MultipartFile;

public interface BookCoverService {

    BookCoverResponseDto uploadBookCover(Long bookId, MultipartFile file);

    BookCoverResponseDto getBookCoverByBookId(Long bookId);
    BookCover getBookCoverEntityByBookId(Long bookId);
}
