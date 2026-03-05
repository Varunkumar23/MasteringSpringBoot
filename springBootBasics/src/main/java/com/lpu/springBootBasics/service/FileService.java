package com.lpu.springBootBasics.service;


import com.lpu.springBootBasics.entity.File;
import com.lpu.springBootBasics.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    private final FileRepository fileUploadRepository;

    public FileService(FileRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    public File uploadFile(MultipartFile file) throws IOException {
        File fileUpload = new File(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
        );
        return fileUploadRepository.save(fileUpload);
    }

    public File getFile(Long id) {
        return fileUploadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
    }
}

