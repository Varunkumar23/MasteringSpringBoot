package com.lpu.LibraryManagementSystem.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCoverResponseDto {

    private Long id;
    private String fileName;
    private String fileType;
    private Long fileSize;
}
