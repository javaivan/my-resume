package com.ivanmix.resume.service;

import java.util.List;

import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.form.SignUpForm;

public interface EditMemberService {

    Member createNewMember(SignUpForm signUpForm);

    List<Skill> listSkills(long idMember);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idMember, List<Skill> skills);

    void deleteSkill(long idSkill, long idMember);


    String addInfo(long idMember);

    void updateAddInfo(long idMember, String  addInfo);

    MemberContact memberContact(long idMember);

    void updateMemberContactSocial(long idMember, MemberContactSocial memberContactSocial);

    List<Certificate> listCertificates(long idMember);

    void updateCertificates(long idMember, List<Certificate> certificates);

    List<Course> listCourses(long idMember);

    void updateCourses(long idMember, List<Course> courses);

    void deleteCourse(long id, long idMember);



    List<University> listUniversities(long idMember);

    void updateUniversities(long idMember, List<University> universities);

    void deleteUniversity(long idUniversity, long idMember);


    List<Language> listLanguages(long idMember);

    void updateLanguages(long idMember, List<Language> languages);

    void deleteLanguage(long idLanguage, long idMember);


    List<Practic> listPractics(long idMember);

    void updatePractics(long idMember, List<Practic> practics);

    void deletePractics(long idPractic, long idMember);


}