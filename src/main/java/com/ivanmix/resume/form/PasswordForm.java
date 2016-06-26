package com.ivanmix.resume.form;

import com.ivanmix.resume.annotation.constraints.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class PasswordForm {

    @NotNull
    @Size(max=255, min = 5)
    private String password;

    @NotNull
    @Size(max=255, min = 5)
    private String confirmPassword;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
