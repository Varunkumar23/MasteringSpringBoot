package com.lpu.LibraryManagementSystem.service;


import com.lpu.LibraryManagementSystem.dto.BookRequestDto;
import com.lpu.LibraryManagementSystem.dto.BookResponseDto;
import com.lpu.LibraryManagementSystem.dto.PageResponseDto;

public interface BookService {

    BookResponseDto createBook(BookRequestDto bookRequestDto);

    BookResponseDto getBookById(Long id);

    PageResponseDto<BookResponseDto> getAllBooks(int page, int size, String sortBy);

    BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto);

    void deleteBook(Long id);
}
