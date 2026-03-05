package com.lpu.LibraryManagementSystem.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer publishedYear;
    private String category;
    private String description;
}