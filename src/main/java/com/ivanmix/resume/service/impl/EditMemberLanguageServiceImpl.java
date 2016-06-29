package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Language;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.LanguageRepository;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.EditMemberLanguageService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberLanguageServiceImpl implements EditMemberLanguageService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> listLanguages(long idMember) {
        return memberRepository.findById(idMember).getLanguages();
    }

    @Override
    @Transactional
    public void updateLanguages(long idMember, List<Language> languages) {
        Member member = memberRepository.findOne(idMember);
        if(CollectionUtils.isEqualCollection(languages,member.getUniversities())){
            return;
        } else {
            member.setLanguages(languages);
            memberRepository.save(member);
        }
    }

    @Transactional
    public void deleteLanguage(long id, long idMember){
        languageRepository.deleteByIdAndMemberId(id,idMember);
    }

}
