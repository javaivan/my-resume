package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.MemberContact;
import com.ivanmix.resume.entity.MemberContactSocial;

import javax.validation.Valid;
import java.io.Serializable;


public class ContactForm implements Serializable {

	@Valid
	private MemberContact items;


    public ContactForm() {
		super();
	}

    public ContactForm(MemberContact items) {
		super();
		this.items = items;
	}

	public MemberContact getItems() {
		return items;
	}

	public void setItems(MemberContact items) {
		this.items = items;
	}
}