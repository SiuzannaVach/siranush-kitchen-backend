package com.siuzanna.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    // Папка на вашем Mac, куда будут сохраняться сочные фото рецептов
    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    public FileStorageService() {
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory.", e);
        }
    }

    public String storeFile(MultipartFile file) {
        // Генерируем уникальное имя файла, чтобы картинки не перезаписывали друг друга
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
}
