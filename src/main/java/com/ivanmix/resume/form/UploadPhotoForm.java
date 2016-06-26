package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Certificate;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;

public class UploadPhotoForm implements Serializable {


	@Valid
	@Column(nullable=false, length=250)
	@Size(min=1)
	private String images;


    public UploadPhotoForm() {
		super();
	}

    public UploadPhotoForm(String name, String images) {
		super();
		this.images = images;
	}

	public String getImages() {
		return images;
	}


	public void setImages(MultipartFile images) {
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
					fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + ".jpg";
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(fileName)));
					FileCopyUtils.copy(images.getInputStream(), stream);
					stream.close();
					System.out.println("setImages yes");
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
		this.images = fileName;
	}
}