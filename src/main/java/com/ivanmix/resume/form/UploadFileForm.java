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
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.util.Properties;

public class UploadFileForm  implements Serializable {


	Certificate certificate = new Certificate();

	/*
	* http://www.codegur.site/29535187/how-to-use-spring-validation-for-ajax-request
	* */
	@Valid
	@Column(nullable=false, length=250)
	@Size(min=1)
	private String name;


	@Valid
	@Column(nullable=false, length=250)
	@Size(min=1)
	private String images;


    public UploadFileForm() {
		super();
	}

    public UploadFileForm(String name, String images) {
		super();
		this.name = name;
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		certificate.setName(name);
		this.name = name;
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
					fileName = "D:/my-resume/src/main/webapp/media/" + date.getTime() + "_" + name.replaceAll(" ", "_") + ".jpg";
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(fileName)));
					FileCopyUtils.copy(images.getInputStream(), stream);
					stream.close();
					System.out.println("yes");
					certificate.setImages(fileName);
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

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	/*
	public void setImages(MultipartFile images) {
		String fileName;
		if (!images.isEmpty()) {
			/*if((!images.getContentType().equals("image/png"))&&
					(!images.getContentType().equals("image/x-png"))&&
					(!images.getContentType().equals("image/jpeg"))&&
					(!images.getContentType().equals("image/pjpeg"))&&
					(!images.getContentType().equals("image/jpg"))&&
					(!images.getContentType().equals("image/gif"))) {
				fileName = "";
			} else {
				try {
					fileName = "/" + time() + name.replaceAll(" ", "_") + ".jpg";

					//fileName = "D:/my-resume/src/main/webapp/media/" + time() + name.replaceAll(" ", "_") + ".jpg";
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(fileName)));
					FileCopyUtils.copy(images.getInputStream(), stream);
					stream.close();
					System.out.println("yes");
				} catch (Exception e) {
					fileName = "";
				}
			//}
		} else {
			fileName = "";
		}
		this.images = name;
	}*/
}