package com.lpu.LibraryManagementSystem.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_covers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    private Long fileSize;

    @Lob
    private byte[] fileData;

    private LocalDateTime uploadDate;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
