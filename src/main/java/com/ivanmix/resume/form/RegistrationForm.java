package com.ivanmix.resume.form;

import com.ivanmix.resume.annotation.constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm extends PasswordForm {


	@NotNull
	@Size(max=255, min = 5)
	private String nickname;

	@NotNull
	@Email
	@Size(max=255, min = 5)
	private String email;

	@NotNull
	@Size(max=255, min = 2)
	private String firstName;

	@NotNull
	@Size(max=255, min = 2)
	private String lastName;


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}