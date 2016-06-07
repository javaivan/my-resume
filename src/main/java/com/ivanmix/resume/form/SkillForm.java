package com.ivanmix.resume.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;


public class SkillForm implements Serializable {

	@Valid
	private List<Skill> items = new ArrayList<>();

    public SkillForm() {
		super();
	}

    public SkillForm(List<Skill> items) {
		super();
		this.items = items;
	}

    public List<Skill> getItems() {
		return items;
	}

	public void setItems(List<Skill> items) {
		this.items = items;
	}
}