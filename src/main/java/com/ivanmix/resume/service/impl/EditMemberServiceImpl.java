package com.ivanmix.resume.service.impl;

import java.util.*;

import com.ivanmix.resume.configuration.SecurityConfig;
import com.ivanmix.resume.entity.*;
import com.ivanmix.resume.form.RegistrationForm;
import com.ivanmix.resume.model.UploadCertificate;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.repository.storage.*;
import com.ivanmix.resume.service.EditMemberService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.DataUtil;

@Service
@SuppressWarnings("unchecked")
public class EditMemberServiceImpl implements EditMemberService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EditMemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private HobbyItemRepository hobbyItemRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private PracticRepository practicRepository;

    @Autowired
    private LanguageRepository languageRepository;
/*
    @Autowired
    private CertificateRepository certificateRepository;
*/
    @Autowired
    private HobbiesRepository hobbiesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MemberInfoRepository memberInfoRepository;


    protected Member getMember(long memberId){
        return memberRepository.findById(memberId);
    }

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
    public boolean createNewMember(RegistrationForm form) {

        if(memberRepository.existsByEmailOrNickname(form.getEmail(),form.getNickname())){
            return false;
        } else {
            Member member = new Member();
            member.setFirstName(form.getFirstName());
            member.setLastName(form.getLastName());
            member.setNickname(form.getNickname());
            member.setEmail(form.getEmail());
            String encodedPassword = passwordEncoder.encode(form.getPassword());
            member.setPassword(encodedPassword);



/*
            MemberContact memberContact = memberRepository.findById(idMember).getMemberContact();
            if(memberContact==null){
                memberContact = new MemberContact();
            }*/

            memberRepository.save(member);




            MemberAddInfo info = new MemberAddInfo();
            info.setMember(member);
            memberInfoRepository.save(info);


            MemberContact contact = new MemberContact();
            contact.setMember(member);
            contactRepository.save(contact);

            /*
            System.out.println(memberRepository.save(member));
*

            member.setMemberAddInfo(info);
            member.setMemberContact(contact);

            memberRepository.save(member);
*/
            return true;
        }
    }

    @Override
    @Transactional
    public void changePassword(long idMember, String password){
        Member member = memberRepository.findOne(idMember);
        String encodedPassword = passwordEncoder.encode(password);
        if (member.getPassword().equals(encodedPassword)) {
            LOGGER.debug("Member password: nothing to update");
            return;
        } else {
            member.setPassword(encodedPassword);
            memberRepository.save(member);
        }
    }


    @Override
    @Transactional
    public void addMemberPhoto(long idMember, UploadImage image){
        Member member = memberRepository.findOne(idMember);
        //String memberPhoto = member.getMemberContact().getPhoto();
        MemberContact memberContact = member.getMemberContact();
        memberContact.setBigImage(image.getBigImage());
        memberContact.setSmallImage(image.getSmallImage());
        member.setMemberContact(memberContact);
        memberRepository.save(member);
/*
        member = memberRepository.findOne(idMember);
        System.out.println("170 " + member.getMemberContact().getPhoto());
        /*
        updatedData.removeAll(Collections.singleton(new Skill()));*/
    }

    @Override
    public String addInfo(long idMember) {
        String info = memberRepository.findById(idMember).getMemberAddInfo().getDescription();
        if(info == null){
            info = "";
        }
        return info;
    }

    @Override
    public void updateAddInfo(long idMember, String addInfo) {
        Member member = memberRepository.findOne(idMember);
        member.getMemberAddInfo().setDescription(addInfo);
        memberRepository.save(member);
    }

    @Override
    public MemberContact memberContact(long idMember) {
        MemberContact memberContact = memberRepository.findById(idMember).getMemberContact();
        if(memberContact==null){
            memberContact = new MemberContact();
        }
        return memberContact;
    }

    @Override
    @Transactional
    public void updateMemberContact(long idMember, MemberContact memberContact) {
        Member member = memberRepository.findById(idMember);

        MemberContact mc = member.getMemberContact();

        mc.setCountry(memberContact.getCountry());
        mc.setCity(memberContact.getCity());
        mc.setPhone(memberContact.getPhone());
        mc.setObjective(memberContact.getObjective());
        mc.setQualification(memberContact.getQualification());

        member.setMemberContact(mc);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void updateMemberContactSocial(long idMember, MemberContactSocial memberContactSocial) {
        Member member = memberRepository.findById(idMember);
        member.getMemberContact().setMemberContactSocial(memberContactSocial);
        memberRepository.save(member);
    }

/*
    @Override
    public List<Certificate> listCertificates(long idMember) {
        return memberRepository.findOne(idMember).getCertificates();
    }

    @Override
    @Transactional
    public void addCertificate(long idMember, Certificate certificate) {
        Member member = memberRepository.findOne(idMember);
        List<Certificate> certificates = member.getCertificates();
        certificates.add(certificate);
        member.setCertificates(certificates);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void addCertificate(long idMember, String name, UploadImage image){
        Member member = memberRepository.findOne(idMember);
        List<Certificate> certificates = member.getCertificates();
        Certificate c = new Certificate();
        c.setBigImage(image.getBigImage());
        c.setSmallImage(image.getSmallImage());
        c.setName(name);
        certificates.add(c);
        member.setCertificates(certificates);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void deleteCertificate(long id, long idMember){
        certificateRepository.deleteByIdAndMemberId(id,idMember);
    }


    @Override
    public List<Course> listCourses(long idMember) {
        return memberRepository.findOne(idMember).getCourses();
    }

    @Override
    public void updateCourses(long idMember, List<Course> courses) {
        Member member = memberRepository.findOne(idMember);
        courses.removeAll(Collections.singleton(new Course()));
        if(CollectionUtils.isEqualCollection(courses, member.getCourses())){
            LOGGER.debug("Member courses: nothing to update");
            return;
        } else {

            member.setCourses(courses);
            memberRepository.save(member);
        }
    }

    @Override
    @Transactional
    public void deleteCourse(long id, long idMember){
        courseRepository.deleteByIdAndMemberId(id,idMember);
    }

*/
    /*
    @Override
    public List<University> listUniversities(long idMember) {
        return memberRepository.findById(idMember).getUniversities();
    }

    @Override
    public void updateUniversities(long idMember, List<University> universities) {
        Member member = memberRepository.findOne(idMember);
        universities.removeAll(Collections.singleton(new University()));
        if(CollectionUtils.isEqualCollection(universities,member.getUniversities())){
            LOGGER.debug("Member Universities: nothing to update");
            return;
        } else {
            member.setUniversities(universities);
            memberRepository.save(member);
        }
    }


    @Transactional
    public void deleteUniversity(long id, long idMember){
        universityRepository.deleteByIdAndMemberId(id,idMember);
    }
*/

}