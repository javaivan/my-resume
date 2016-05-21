package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Course;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CourseForm implements Serializable {

	@Valid
	private List<Course> courses = new ArrayList<>();

    public CourseForm() {
		super();
	}

    public CourseForm(List<Course> courses) {
		super();
		this.courses = courses;
	}

    public List<Course> getCourses() {
		return courses;
	}

    public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}