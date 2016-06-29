package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.University;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.UniversityRepository;
import com.ivanmix.resume.service.EditMemberUniversityService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberUniversityServiceImpl implements EditMemberUniversityService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> listUniversities(long idMember) {
        return memberRepository.findById(idMember).getUniversities();
    }

    @Override
    public void updateUniversities(long idMember, List<University> universities) {
        Member member = memberRepository.findOne(idMember);
        universities.removeAll(Collections.singleton(new University()));
        if(CollectionUtils.isEqualCollection(universities,member.getUniversities())){
            return;
        } else {
            member.setUniversities(universities);
            memberRepository.save(member);
        }
    }

    @Transactional
    public void deleteUniversity(long id, long idMember){universityRepository.deleteByIdAndMemberId(id,idMember);}
}
