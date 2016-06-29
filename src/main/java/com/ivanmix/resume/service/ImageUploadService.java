package com.ivanmix.resume.service;

import com.ivanmix.resume.model.UploadImage;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    UploadImage uploadNewImage(MultipartFile file);
}
