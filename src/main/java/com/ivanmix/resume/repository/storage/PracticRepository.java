package com.ivanmix.resume.repository.storage;

import com.ivanmix.resume.entity.Practic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//@RepositoryDefinition(domainClass=Member.class, idClass=Long.class)
//public interface MemberRepository {
public interface PracticRepository extends PagingAndSortingRepository<Practic, Long> {

    @Modifying
    @Query("DELETE FROM Practic WHERE id = :id AND member_id = :member")
    void deleteByIdAndMemberId(@Param("id") Long id, @Param("member") Long member);
}