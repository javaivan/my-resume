package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.component.ImageComponent;
import com.ivanmix.resume.exception.CantCompleteClientRequestException;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class ImageUploadServiceImpl implements ImageUploadService {

    @Autowired
    private ImageComponent imageFormatConverter;

    @Override
    public UploadImage uploadNewImage(MultipartFile file) {


        String fileName;
        if (!file.isEmpty()) {
            if((!file.getContentType().equals("image/png"))&&
                    (!file.getContentType().equals("image/x-png"))&&
                    (!file.getContentType().equals("image/jpeg"))&&
                    (!file.getContentType().equals("image/pjpeg"))&&
                    (!file.getContentType().equals("image/jpg"))&&
                    (!file.getContentType().equals("image/gif"))) {
                fileName = "";
                System.out.println("not format");
            } else {
                try {

                    Date date = new Date();
                    fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + "_" + file.getName().replaceAll(" ", "_") + ".jpg";
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(fileName)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
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

        return new UploadImage(fileName, fileName);
    }


    protected void multipartFileUploadToJpeg(MultipartFile file, Path path) throws IOException{
        String fileType = file.getContentType();
        file.transferTo(path.toFile());
        if (fileType.contains("png")){
           imageFormatConverter.PngToJpeg(path, path);
        } else if(!fileType.contains("jpg") && !fileType.contains("jpeg")){
            throw new CantCompleteClientRequestException("Only png and jpg image formats are supported: Current content type=" + fileType);
        }

    }

    /*
    * File photo = new File(MEDIA_DIR + "/certificates/" + uid);
			if (!photo.getParentFile().exists()) {
				photo.getParentFile().mkdirs();
			}
    * */
}
