package com.ivanmix.resume.service;

import java.util.List;

import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.form.SignUpForm;

public interface EditMemberService {

    Member createNewMember(SignUpForm signUpForm);

    List<Skill> listSkills(long idMember);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idMember, List<Skill> skills);

    String addInfo(long idMember);

    void updateAddInfo(long idMember, String  addInfo);

    MemberContact memberContact(long idMember);

    void updateMemberContactSocial(long idMember, MemberContactSocial memberContactSocial);

    List<Certificate> listCertificates(long idMember);

    void updateCertificates(long idMember, List<Certificate> certificates);

}