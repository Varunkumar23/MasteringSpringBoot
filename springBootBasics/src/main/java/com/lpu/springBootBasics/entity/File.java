package com.lpu.springBootBasics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "file_uploads")
@Getter
@Setter
public class File{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private Long fileSize;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    private LocalDateTime uploadedAt;

    public File() {
        this.uploadedAt = LocalDateTime.now();
    }

    public File(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.fileSize = (long) data.length;
        this.uploadedAt = LocalDateTime.now();
    }
}
