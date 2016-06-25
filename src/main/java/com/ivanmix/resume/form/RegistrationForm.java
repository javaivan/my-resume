package com.ivanmix.resume.form;

import com.ivanmix.resume.annotation.constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class RegistrationForm implements Serializable {


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

	@NotNull
	@Size(max=255, min = 5)
	private String password;

	@NotNull
	@Size(max=255, min = 5)
	private String confirmPassword;


	public RegistrationForm() {
		super();
	}

	public RegistrationForm(String nickname, String email, String firstName, String lastName, String password, String confirmPassword) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

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