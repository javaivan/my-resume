package com.ivanmix.resume.service;

import com.ivanmix.resume.model.UploadCertificateResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ivan on 14.06.2016.
 */
public interface ImageProcessorService {

    String processNewCertificateImage(MultipartFile uploadCertificateImage);

}
