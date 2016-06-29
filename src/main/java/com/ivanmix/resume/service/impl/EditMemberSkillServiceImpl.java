package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Skill;
import com.ivanmix.resume.entity.SkillCategory;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.SkillCategoryRepository;
import com.ivanmix.resume.repository.storage.SkillRepository;
import com.ivanmix.resume.service.EditMemberSkillService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberSkillServiceImpl implements EditMemberSkillService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Override
    public List<Skill> listSkills(long idMember) {
        return memberRepository.findOne(idMember).getSkills();
    }

    @Override
    public List<SkillCategory> listSkillCategories() {
        return skillCategoryRepository.findAll(new Sort("id"));
    }

    @Override
    @Transactional
    public void updateSkills(long idMember, List<Skill> updatedData) {
        Member member = memberRepository.findOne(idMember);
        updatedData.removeAll(Collections.singleton(new Skill()));

        if (CollectionUtils.isEqualCollection(updatedData, member.getSkills())) {
            return;
        } else {
            member.getSkills().clear();
            member.setSkills(updatedData);
            memberRepository.save(member);
        }
    }

    @Override
    @Transactional
    public void deleteSkill(long idSkill,long idMember){
        skillRepository.deleteByIdAndMemberId(idSkill, idMember);
    }
}
