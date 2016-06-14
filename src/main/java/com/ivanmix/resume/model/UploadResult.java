package com.ivanmix.resume.model;

import java.io.Serializable;

/**
 * Created by ivan on 14.06.2016.
 */
public class UploadResult implements Serializable {

    private String largeUrl;
    private String smallUrl;

    public UploadResult(String largeUrl, String smallUrl) {
        super();
        this.largeUrl = largeUrl;
        this.smallUrl = smallUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }
}
