package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Practic;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.PracticRepository;
import com.ivanmix.resume.service.EditMemberPracticService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberPracticServiceImpl implements EditMemberPracticService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PracticRepository practicRepository;

    @Override
    public List<Practic> listPractics(long idMember) {
        return memberRepository.findById(idMember).getPractics();
    }

    @Override
    @Transactional
    public void updatePractics(long idMember, List<Practic> practics) {
        Member member = memberRepository.findOne(idMember);
        practics.removeAll(Collections.singleton(new Practic()));
        if(CollectionUtils.isEqualCollection(practics, member.getPractics())){
            return;
        } else {
            member.setPractics(practics);
            memberRepository.save(member);
        }
    }

    @Transactional
    public void deletePractics(long id, long idMember){
        practicRepository.deleteByIdAndMemberId(id,idMember);
    }
}
