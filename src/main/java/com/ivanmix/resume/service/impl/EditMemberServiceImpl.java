package com.ivanmix.resume.service.impl;

import java.util.List;

import com.ivanmix.resume.service.EditMemberService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ivanmix.resume.model.CurrentMember;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Skill;
import com.ivanmix.resume.entity.SkillCategory;
import com.ivanmix.resume.exception.CantCompleteClientRequestException;
import com.ivanmix.resume.form.SignUpForm;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.SkillCategoryRepository;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.DataUtil;

@Service
public class EditMemberServiceImpl implements EditMemberService, UserDetailsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EditMemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;
/*
    @Value("${generate.uid.suffix.length}")
    private int generateUidSuffixLength;

    @Value("${generate.uid.alphabet}")
    private String generateUidAlphabet;

    @Value("${generate.uid.max.try.count}")
    private int maxTryCountToGenerateUid;
*/
    @Override
    @Transactional
    public Member createNewMember(SignUpForm signUpForm) {
        Member member = new Member();
        member.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
        member.setLastName(DataUtil.capitalizeName(signUpForm.getLastName()));
        member.setEmail(DataUtil.capitalizeName(signUpForm.getEmail()));
        member.setPassword(signUpForm.getPassword());
        memberRepository.save(member);
        return member;
    }

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
        if (CollectionUtils.isEqualCollection(updatedData, member.getSkills())) {
            LOGGER.debug("Member skills: nothing to update");
            return;
        } else {
            member.setSkills(updatedData);
            memberRepository.save(member);
        }
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = findProfile(username);
        if (member != null) {
            return new CurrentMember(member);
        } else {
            LOGGER.error("Profile not found by " + username);
            throw new UsernameNotFoundException("Profile not found by " + username);
        }
    }

    private Member findProfile(String anyUnigueId) {
        Member member = memberRepository.findByEmail(anyUnigueId);

        if (member == null) {
            member = memberRepository.findById(Long.parseLong(anyUnigueId));
        }

        return member;
    }

}