package com.ivanmix.resume.service;

import com.ivanmix.resume.model.UploadCertificate;
import com.ivanmix.resume.model.UploadCertificateResult;
import org.springframework.web.multipart.MultipartFile;


public interface ImageProcessorService {

    UploadCertificate newCertificateImage(MultipartFile file);

    String processNewCertificateImage(MultipartFile uploadCertificateImage);

    String newPhotoImage(MultipartFile file);

}
