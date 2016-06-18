package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.model.CurrentMember;
import com.ivanmix.resume.repository.search.MemberSearchRepository;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.FindMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.FindMemberService;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unchecked")
public class FindMemberServiceImpl implements FindMemberService, UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindMemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSearchRepository memberSearchRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
/*
    @Override
    public Iterable<Member> findAllForIndexing() {       return null;}

    @Override
    public Page<Member> findBySearchQuery(String query, Pageable pageable) {    return null;   }
*/

    @Override
    @Transactional
    public Iterable<Member> findAllForIndexing() {
        Iterable<Member> all = memberRepository.findAll();
        for(Member m : all) {
            m.getSkills().size();
            m.getCertificates().size();
            m.getLanguages().size();
            m.getPractics().size();
            m.getCourses().size();
        }
        return all;
    }

    @Override
    public Page<Member> findBySearchQuery(Long query, Pageable pageable) {
        return memberSearchRepository.findById(query, pageable);
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