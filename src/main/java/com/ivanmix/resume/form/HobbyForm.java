package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Hobby;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HobbyForm implements Serializable {

	@Valid
	private List<Hobby> items = new ArrayList<>();

    public HobbyForm() {
		super();
	}

    public HobbyForm(List<Hobby> items) {
		super();
		this.items = items;
	}

    public List<Hobby> getItems() {
		return items;
	}

	public void setItems(List<Hobby> items) {
		this.items = items;
	}
}