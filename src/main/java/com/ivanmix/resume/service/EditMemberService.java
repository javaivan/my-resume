package com.ivanmix.resume.service;

import java.util.List;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Skill;
import com.ivanmix.resume.entity.SkillCategory;
import com.ivanmix.resume.form.SignUpForm;

public interface EditMemberService {

    Member createNewMember(SignUpForm signUpForm);

    List<Skill> listSkills(long idMember);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idMember, List<Skill> skills);
}