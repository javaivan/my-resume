package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Certificate;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CertificateForm implements Serializable {

	@Valid
	private List<Certificate> items = new ArrayList<>();

    public CertificateForm() {
		super();
	}

    public CertificateForm(List<Certificate> items) {
		super();
		this.items = items;
	}

	public List<Certificate> getItems() {
		return items;
	}

	public void setItems(List<Certificate> items) {
		this.items = items;
	}
}