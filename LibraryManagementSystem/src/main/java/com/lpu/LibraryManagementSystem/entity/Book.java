package com.lpu.LibraryManagementSystem.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Double price;

    private Integer publishedYear;

    private String category;

    private String description;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private BookCover bookCover;
}
