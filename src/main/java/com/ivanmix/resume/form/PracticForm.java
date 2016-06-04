package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Practic;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PracticForm implements Serializable {

	@Valid
	private List<Practic> practics = new ArrayList<>();

    public PracticForm() {
		super();
	}

    public PracticForm(List<Practic> practics) {
		super();
		this.practics = practics;
	}

	public List<Practic> getPractics() {
		return practics;
	}

	public void setPractics(List<Practic> practics) {
		this.practics = practics;
	}
}