package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.component.ImageComponent;
import com.ivanmix.resume.exception.CantCompleteClientRequestException;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.service.ImageUploadService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Autowired
    private ImageComponent imageComponent;

    @Override
    public UploadImage uploadNewImage(MultipartFile file) {
        try {
            UploadImage image = processUpload(file);
            return image;
        } catch (IOException e){
            throw new CantCompleteClientRequestException("Can't save  image upload: " + e.getMessage(), e);
        }
    }

    protected UploadImage processUpload(MultipartFile file) throws IOException{
        String bigImageUrl = imageComponent.getBigImageName();
        Path bigImagePath = imageComponent.getUploadPath(bigImageUrl);
        multipartFileUploadToJpeg(file, bigImagePath);

        String smallImageUrl = imageComponent.getSmallImageName(bigImageUrl);
        Path smallImagePath = imageComponent.getUploadPath(smallImageUrl);

        Thumbnails.of(bigImagePath.toString()).size(100, 100).toFile(smallImagePath.toString());
        return new  UploadImage(bigImagePath.toString(), smallImagePath.toString());
    }

    protected void multipartFileUploadToJpeg(MultipartFile file, Path path) throws IOException{
        String fileType = file.getContentType();
        file.transferTo(path.toFile());
        if (fileType.contains("png")){
            imageComponent.PngToJpeg(path, path);
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
