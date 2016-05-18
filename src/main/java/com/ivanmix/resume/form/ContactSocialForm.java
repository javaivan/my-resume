package com.ivanmix.resume.form;

import com.ivanmix.resume.entity.MemberContactSocial;
import com.ivanmix.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ContactSocialForm implements Serializable {

	@Valid
	private MemberContactSocial memberContactSocial;


    public ContactSocialForm() {
		super();
	}

    public ContactSocialForm(MemberContactSocial memberContactSocial) {
		super();
		this.memberContactSocial = memberContactSocial;
	}

    public MemberContactSocial getMemberContactSocial() {
		return memberContactSocial;
	}

    public void setMemberContactSocial(MemberContactSocial memberContactSocial) {
		this.memberContactSocial = memberContactSocial;
	}
}