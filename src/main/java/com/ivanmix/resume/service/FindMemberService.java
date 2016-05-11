package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Member;


public interface FindMemberService {

    Member findById(Long id);
}