package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Course;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CourseForm implements Serializable {

	@Valid
	private List<Course> items = new ArrayList<>();

    public CourseForm() {
		super();
	}

    public CourseForm(List<Course> items) {
		super();
		this.items = items;
	}

    public List<Course> getItems() {
		return items;
	}

    public void setItems(List<Course> items) {
		this.items = items;
	}
}