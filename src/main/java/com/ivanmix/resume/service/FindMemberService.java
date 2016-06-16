package com.ivanmix.resume.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ivanmix.resume.entity.Member;


public interface FindMemberService {

    Member findById(Long id);

    Page<Member> findAll(Pageable pageable);
}