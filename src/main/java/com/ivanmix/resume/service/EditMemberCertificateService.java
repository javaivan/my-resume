package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.form.RegistrationForm;
import com.ivanmix.resume.model.UploadImage;

import java.util.List;

public interface EditMemberCertificateService {

    List<Certificate> listCertificates(long idMember);

    void addCertificate(long idMember, Certificate certificate);

    void addCertificate(long idMember, String name, UploadImage image);

    void deleteCertificate(long id, long idMember);
}