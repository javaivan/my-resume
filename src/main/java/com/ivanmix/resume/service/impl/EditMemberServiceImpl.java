package com.ivanmix.resume.service.impl;

import java.util.List;

import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.service.EditMemberService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ivanmix.resume.model.CurrentMember;
import com.ivanmix.resume.exception.CantCompleteClientRequestException;
import com.ivanmix.resume.form.SignUpForm;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.SkillCategoryRepository;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.DataUtil;

@Service
@SuppressWarnings("unchecked")
public class EditMemberServiceImpl implements EditMemberService{
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

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpForm.getPassword());

        member.setPassword(encodedPassword);
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
    public String addInfo(long idMember) {
        return memberRepository.findById(idMember).getMemberAddInfo().getDescription();
    }

    @Override
    public void updateAddInfo(long idMember, String addInfo) {
        Member member = memberRepository.findOne(idMember);
        member.getMemberAddInfo().setDescription(addInfo);
        memberRepository.save(member);
    }

    @Override
    public MemberContact memberContact(long idMember) {
        return memberRepository.findById(idMember).getMemberContact();
    }

    @Override
    public void updateMemberContactSocial(long idMember, MemberContactSocial memberContactSocial) {
        Member member = memberRepository.findById(idMember);
        member.getMemberContact().setMemberContactSocial(memberContactSocial);
        memberRepository.save(member);
    }

    @Override
    public List<Certificate> listCertificates(long idMember) {
        return memberRepository.findOne(idMember).getCertificates();
    }

    @Override
    @Transactional
    public void updateCertificates(long idMember, List<Certificate> certificates) {
        Member member = memberRepository.findOne(idMember);
        if (CollectionUtils.isEqualCollection(certificates, member.getSkills())) {
            LOGGER.debug("Member certificates: nothing to update");
            return;
        } else {
            member.setCertificates(certificates);
            memberRepository.save(member);
        }
    }


}