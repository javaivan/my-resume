package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.stereotype.Service;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.FindMemberService;

@Service
public class FindMemberServiceImpl implements FindMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}