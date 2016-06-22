package com.ivanmix.resume.model;

import java.io.Serializable;

public class UploadCertificate implements Serializable {

    private String certificateName;
    private String bigImage;
    private String smallImage;

    public UploadCertificate(String certificateName, String bigImage, String smallImage){
        this.certificateName = certificateName;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }
}
