package com.lpu.LibraryManagementSystem.service;


import com.lpu.LibraryManagementSystem.dto.BookCoverResponseDto;
import com.lpu.LibraryManagementSystem.entity.Book;
import com.lpu.LibraryManagementSystem.entity.BookCover;
import com.lpu.LibraryManagementSystem.repository.BookCoverRepository;
import com.lpu.LibraryManagementSystem.repository.BookRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class BookCoverServiceImpl implements BookCoverService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCoverRepository bookCoverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookCoverResponseDto uploadBookCover(Long bookId, MultipartFile file) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        try {

            BookCover bookCover = new BookCover();

            bookCover.setFileName(file.getOriginalFilename());
            bookCover.setFileType(file.getContentType());
            bookCover.setFileSize(file.getSize());
            bookCover.setFileData(file.getBytes());
            bookCover.setUploadDate(LocalDateTime.now());
            bookCover.setBook(book);

            BookCover savedCover = bookCoverRepository.save(bookCover);

            return modelMapper.map(savedCover, BookCoverResponseDto.class);

        } catch (IOException e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    @Override
    public BookCoverResponseDto getBookCoverByBookId(Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        BookCover cover = book.getBookCover();

        if (cover == null) {
            throw new RuntimeException("Book cover not found");
        }

        return modelMapper.map(cover, BookCoverResponseDto.class);
    }

    @Override
    public BookCover getBookCoverEntityByBookId(Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getBookCover() == null) {
            throw new RuntimeException("Cover not found");
        }

        return book.getBookCover();
    }
}