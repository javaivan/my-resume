package com.ivanmix.resume.service;

import java.util.List;

import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.form.SignUpForm;

public interface EditMemberService {

    Member createNewMember(SignUpForm signUpForm);

    List<Skill> listSkills(long idMember);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idMember, List<Skill> skills);

    void deleteSkill(Long idSkill, long idMember);


    String addInfo(long idMember);

    void updateAddInfo(long idMember, String  addInfo);

    MemberContact memberContact(long idMember);

    void updateMemberContactSocial(long idMember, MemberContactSocial memberContactSocial);

    List<Certificate> listCertificates(long idMember);

    void updateCertificates(long idMember, List<Certificate> certificates);

    List<Course> listCourses(long idMember);

    void updateCourses(long idMember, List<Course> courses);


    List<University> listUniversities(long idMember);

    void updateUniversities(long idMember, List<University> universities);

    List<Language> listLanguages(long idMember);

    void updateLanguages(long idMember, List<Language> languages);

}