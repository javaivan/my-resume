package com.ivanmix.resume.repository.storage;

import com.ivanmix.resume.entity.Hobby;
import com.ivanmix.resume.entity.Practic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface HobbiesRepository extends PagingAndSortingRepository<Hobby, Long> {

    @Modifying
    @Query("DELETE FROM Hobby WHERE member_id = :member")
    void deleteByMemberId(@Param("member") Long member);
}