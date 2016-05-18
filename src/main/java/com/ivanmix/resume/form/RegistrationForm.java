package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;


public class RegistrationForm implements Serializable {

	@Valid
	private Member member = new Member();

    public RegistrationForm() {
		super();
	}

    public RegistrationForm(Member member) {
		super();
		this.member = member;
	}


	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}