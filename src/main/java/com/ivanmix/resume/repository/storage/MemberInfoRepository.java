package com.ivanmix.resume.repository.storage;

import com.ivanmix.resume.entity.MemberAddInfo;
import com.ivanmix.resume.entity.MemberContact;
import org.springframework.data.repository.PagingAndSortingRepository;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface MemberInfoRepository extends PagingAndSortingRepository<MemberAddInfo, Long> {

}