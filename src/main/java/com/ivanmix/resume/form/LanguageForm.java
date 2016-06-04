package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Language;
import com.ivanmix.resume.entity.University;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LanguageForm implements Serializable {

	@Valid
	private List<Language> items = new ArrayList<>();

    public LanguageForm() {
		super();
	}

    public LanguageForm(List<Language> items) {
		super();
		this.items = items;
	}

	public List<Language> getItems() {
		return items;
	}

	public void setItems(List<Language> items) {
		this.items = items;
	}
}