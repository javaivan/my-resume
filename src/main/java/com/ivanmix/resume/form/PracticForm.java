package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Practic;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PracticForm implements Serializable {

	@Valid
	private List<Practic> items = new ArrayList<>();

    public PracticForm() {
		super();
	}

    public PracticForm(List<Practic> items) {
		super();
		this.items = items;
	}

	public List<Practic> getItems() {
		return items;
	}

	public void setItems(List<Practic> items) {
		this.items = items;
	}
}