package com.ivanmix.resume.repository.storage;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.entity.Skill;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {

    @Modifying
    @Query("DELETE FROM Skill WHERE id = :id AND member_id = :member")
    void deleteByIdAndMemberId(@Param("id") Long id, @Param("member") Long member);
}