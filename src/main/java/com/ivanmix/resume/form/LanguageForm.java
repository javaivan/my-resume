package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Language;
import com.ivanmix.resume.entity.University;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LanguageForm implements Serializable {

	@Valid
	private List<Language> languages = new ArrayList<>();

    public LanguageForm() {
		super();
	}

    public LanguageForm(List<Language> languages) {
		super();
		this.languages = languages;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
}