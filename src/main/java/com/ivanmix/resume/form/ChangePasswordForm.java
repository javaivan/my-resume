package com.ivanmix.resume.form;

import com.ivanmix.resume.annotation.constraints.EnglishLanguage;
import com.ivanmix.resume.entity.Certificate;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 09.06.2016.
 */
public class ChangePasswordForm {

    @Valid
    @Column(length = 255)
    @EnglishLanguage
    @Size(min=5)
    public String password;

    public ChangePasswordForm() {
        super();
    }

    public ChangePasswordForm(String password) {
        super();
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
