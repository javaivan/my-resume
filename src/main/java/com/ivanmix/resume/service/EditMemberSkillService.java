package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Skill;
import com.ivanmix.resume.entity.SkillCategory;

import java.util.List;

public interface EditMemberSkillService {

    List<Skill> listSkills(long idMember);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idMember, List<Skill> skills);

    void deleteSkill(long idSkill, long idMember);

}
