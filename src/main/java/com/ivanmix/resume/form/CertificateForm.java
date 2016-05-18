package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Certificate;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CertificateForm implements Serializable {

	@Valid
	private List<Certificate> certificates = new ArrayList<>();

    public CertificateForm() {
		super();
	}

    public CertificateForm(List<Certificate> certificates) {
		super();
		this.certificates = certificates;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
}