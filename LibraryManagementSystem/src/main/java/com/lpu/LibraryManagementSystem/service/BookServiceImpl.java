package com.lpu.LibraryManagementSystem.service;


import com.lpu.LibraryManagementSystem.dto.BookRequestDto;
import com.lpu.LibraryManagementSystem.dto.BookResponseDto;
import com.lpu.LibraryManagementSystem.dto.PageResponseDto;
import com.lpu.LibraryManagementSystem.entity.Book;
import com.lpu.LibraryManagementSystem.repository.BookRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {

        Book book = modelMapper.map(bookRequestDto, Book.class);

        Book savedBook = bookRepository.save(book);

        return modelMapper.map(savedBook, BookResponseDto.class);
    }

    @Override
    public BookResponseDto getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        return modelMapper.map(book, BookResponseDto.class);
    }

    @Override
    public PageResponseDto<BookResponseDto> getAllBooks(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Book> bookPage = bookRepository.findAll(pageable);

        List<BookResponseDto> content = bookPage.getContent()
                .stream()
                .map(book -> modelMapper.map(book, BookResponseDto.class))
                .collect(Collectors.toList());

        PageResponseDto<BookResponseDto> response = new PageResponseDto<>();

        response.setContent(content);
        response.setPageNumber(bookPage.getNumber());
        response.setPageSize(bookPage.getSize());
        response.setTotalElements(bookPage.getTotalElements());
        response.setTotalPages(bookPage.getTotalPages());
        response.setLast(bookPage.isLast());

        return response;
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        modelMapper.map(bookRequestDto, existingBook);

        Book updatedBook = bookRepository.save(existingBook);

        return modelMapper.map(updatedBook, BookResponseDto.class);
    }

    @Override
    public void deleteBook(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        bookRepository.delete(book);
    }
}