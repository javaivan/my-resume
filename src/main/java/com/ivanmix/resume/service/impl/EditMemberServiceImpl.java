package com.ivanmix.resume.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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

        System.out.println("1" + updatedData);
        updatedData.removeAll(Collections.singleton(new Skill()));
        System.out.println("2" + updatedData);
        Iterator<Skill> it = updatedData.iterator();
        while (it.hasNext()) {
            Skill skill = it.next();

            if(skill.equals(null)){
                it.remove();
            }
        }

        System.out.println("3" + updatedData);


        if (CollectionUtils.isEqualCollection(updatedData, member.getSkills())) {
            LOGGER.debug("Member skills: nothing to update");
            return;
        } else {
            member.setSkills(updatedData);
           /* member.getSkills().clear();*/
            memberRepository.save(member);
        }
    }

    @Override
    @Transactional
    public void deleteSkill(long idMember, Long idSkill){


/*
        Member member = memberRepository.findOne(idMember);




        System.out.println("1 skills :" + member.getSkills());


        List<Skill> skills = member.getSkills();
        Skill skill = null;
        for (Skill s: skills){
            if(skill.getId().equals(idSkill)){
                skill = s;
                break;
            }
        }
        member.setSkills();
        memberRepository.save(member);

/*
        System.out.println("1 skills :" + skills);
        Iterator<Skill> it = skills.iterator();
        while (it.hasNext()) {
            Skill skill = it.next();

            if(skill.getId().equals(idSkill)){
                it.remove();
            }
        }
*//*
        System.out.println("2 skills :" + member.getSkills());

        member.setSkills(skills);
        memberRepository.save(member);*/




        //System.out.println("3 skills :" + memberRepository.findOne(idMember).getSkills());



/*



        memberRepository.findOne(idMember)

        void delete(Long id);

        boolean exists(Long id);
*/
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
        if (CollectionUtils.isEqualCollection(certificates, member.getCertificates())) {
            LOGGER.debug("Member certificates: nothing to update");
            return;
        } else {
            member.setCertificates(certificates);
            memberRepository.save(member);
        }
    }

    @Override
    public List<Course> listCourses(long idMember) {
        return memberRepository.findOne(idMember).getCourses();
    }

    @Override
    public void updateCourses(long idMember, List<Course> courses) {
        Member member = memberRepository.findOne(idMember);
        if(CollectionUtils.isEqualCollection(courses, member.getCourses())){
            LOGGER.debug("Member courses: nothing to update");
            return;
        } else {
            member.setCourses(courses);
            memberRepository.save(member);
        }
    }

    @Override
    public List<University> listUniversities(long idMember) {
        return memberRepository.findById(idMember).getUniversities();
    }

    @Override
    public void updateUniversities(long idMember, List<University> universities) {
        Member member = memberRepository.findOne(idMember);
        if(CollectionUtils.isEqualCollection(universities,member.getUniversities())){
            LOGGER.debug("Member Universities: nothing to update");
            return;
        } else {
            member.setUniversities(universities);
            memberRepository.save(member);
        }
    }

    @Override
    public List<Language> listLanguages(long idMember) {
        return memberRepository.findById(idMember).getLanguages();
    }

    @Override
    public void updateLanguages(long idMember, List<Language> languages) {
        Member member = memberRepository.findOne(idMember);
        if(CollectionUtils.isEqualCollection(languages,member.getUniversities())){
            LOGGER.debug("Member languages: nothing to update");
            return;
        } else {
            member.setLanguages(languages);
            memberRepository.save(member);
        }
    }



/*
    @Override
    public List<Education> listEducations(long idMember) {
        return memberRepository.findById(idMember).getEducations();
    }

    @Override
    public void updateEducations(long idMember, List<Education> educations) {
        Member member = memberRepository.findOne(idMember);
        if(CollectionUtils.isEqualCollection(educations, member.getEducations())){
            LOGGER.debug("Member ducation: nothing to update");
            return;
        } else {
            member.setEducations(educations);
            memberRepository.save(member);
        }
    }
*/

}