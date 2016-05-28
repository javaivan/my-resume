package com.ivanmix.resume.repository.storage;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ivanmix.resume.entity.Member;
import org.springframework.data.repository.RepositoryDefinition;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    List<Member> findAll(Sort sort);

    Member findById(Long id);

    Member findByEmail(String email);
/*
    void delete(Long id);

    boolean exists(Long id);
    /*
    Member findByEmail(String email);
/*
    Member findByPhone(String phone);

    int countByUid(String uid);

    Page<Member> findAllByCompletedTrue(Pageable pageable);

    List<Member> findByCompletedFalseAndCreatedBefore(Timestamp oldDate);*/
}