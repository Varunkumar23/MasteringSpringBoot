package com.lpu.springBootBasics.controller;

import com.lpu.springBootBasics.entity.File;
import com.lpu.springBootBasics.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File savedFile = fileService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully with ID: " + savedFile.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload file: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        File fileUpload = fileService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileUpload.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileUpload.getFileName() + "\"")
                .body(fileUpload.getData());
    }
}
