package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.model.UploadCertificate;
import com.ivanmix.resume.model.UploadCertificateResult;
import com.ivanmix.resume.service.ImageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.UUID;

@Service
public class ImageProcessorServiceImpl implements ImageProcessorService {



    public UploadCertificate newCertificateImage(MultipartFile images){
        String fileName;
        if (!images.isEmpty()) {
            if((!images.getContentType().equals("image/png"))&&
                    (!images.getContentType().equals("image/x-png"))&&
                    (!images.getContentType().equals("image/jpeg"))&&
                    (!images.getContentType().equals("image/pjpeg"))&&
                    (!images.getContentType().equals("image/jpg"))&&
                    (!images.getContentType().equals("image/gif"))) {
                fileName = "";
                System.out.println("not format");
            } else {
                try {

                    Date date = new Date();
                    fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + "_" + images.getName().replaceAll(" ", "_") + ".jpg";
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(fileName)));
                    FileCopyUtils.copy(images.getInputStream(), stream);
                    stream.close();
                    System.out.println("yes");
                }
                catch (Exception e) {
                    fileName = "";
                    System.out.println("e" + e);
                }
            }
        } else {
            fileName = "";
            System.out.println("not");
        }

        return new UploadCertificate(fileName, fileName, fileName);
    }



    public String newPhotoImage(MultipartFile images){
        String fileName;
        if (!images.isEmpty()) {
            if((!images.getContentType().equals("image/png"))&&
                    (!images.getContentType().equals("image/x-png"))&&
                    (!images.getContentType().equals("image/jpeg"))&&
                    (!images.getContentType().equals("image/pjpeg"))&&
                    (!images.getContentType().equals("image/jpg"))&&
                    (!images.getContentType().equals("image/gif"))) {
                fileName = "";
                System.out.println("not format");
            } else {
                try {

                    Date date = new Date();
                    fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + "_" + images.getName().replaceAll(" ", "_") + ".jpg";
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(fileName)));
                    FileCopyUtils.copy(images.getInputStream(), stream);
                    stream.close();
                    System.out.println("newPhotoImage yes");
                }
                catch (Exception e) {
                    fileName = "";
                    System.out.println("e" + e);
                }
            }
        } else {
            fileName = "";
            System.out.println("not");
        }

        return fileName;
    }





    @Override
    public String processNewCertificateImage(MultipartFile images) {
        String fileName;
        if (!images.isEmpty()) {
            if((!images.getContentType().equals("image/png"))&&
                    (!images.getContentType().equals("image/x-png"))&&
                    (!images.getContentType().equals("image/jpeg"))&&
                    (!images.getContentType().equals("image/pjpeg"))&&
                    (!images.getContentType().equals("image/jpg"))&&
                    (!images.getContentType().equals("image/gif"))) {
                fileName = "";
                System.out.println("not format");
            } else {
                try {

                    Date date = new Date();
                    fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + "_" + images.getName().replaceAll(" ", "_") + ".jpg";
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(fileName)));
                    FileCopyUtils.copy(images.getInputStream(), stream);
                    stream.close();
                    System.out.println("processNewCertificateImage yes");
                }
                catch (Exception e) {
                    fileName = "";
                    System.out.println("e" + e);
                }
            }
        } else {
            fileName = "";
            System.out.println("not");
        }
        return fileName;
    }

}
