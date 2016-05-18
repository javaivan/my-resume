package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AddInfoForm implements Serializable {


	@Valid
	private String description;

    public AddInfoForm() {
		super();
	}

    public AddInfoForm(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}