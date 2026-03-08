package com.lpu.UserManagementSystem.service;

import com.lpu.UserManagementSystem.entity.Image;
import com.lpu.UserManagementSystem.repository.ImageRepository;
import com.lpu.UserManagementSystem.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        Image image = imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType()).imageData(ImageUtil.compressImage(file.getBytes())).build());
        if (image != null) {
            return "Image is uploaded successfully!  " + image.getName();
        }
        return "Image upload failed";
    }

    public byte[] downloadImage(String fileName) {
        Optional<Image> image = imageRepository.findByName(fileName);
        byte[] imageData = ImageUtil.decompressImage(image.get().getImageData());
        return imageData;

    }
}
