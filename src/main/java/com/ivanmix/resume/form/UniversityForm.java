package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Course;
import com.ivanmix.resume.entity.Education;
import com.ivanmix.resume.entity.University;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UniversityForm implements Serializable {

	@Valid
	private List<University> universities = new ArrayList<>();

    public UniversityForm() {
		super();
	}

    public UniversityForm(List<University> universities) {
		super();
		this.universities = universities;
	}

	public List<University> getUniversities() {
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}
}