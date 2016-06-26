package com.ivanmix.resume.repository.storage;

import com.ivanmix.resume.entity.Certificate;
import com.ivanmix.resume.entity.MemberContact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface ContactRepository extends PagingAndSortingRepository<MemberContact, Long> {

}