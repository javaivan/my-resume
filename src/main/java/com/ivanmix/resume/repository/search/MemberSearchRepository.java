package com.ivanmix.resume.repository.search;

import com.ivanmix.resume.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by ivan on 16.06.2016.
 */
public interface MemberSearchRepository extends ElasticsearchRepository<Member, Long> {
/*
    Page<Member> findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
            String objective, String summary, String practicCompany, String practicPosition, Pageable pageable);*/

    Page<Member> findById(long id, Pageable pageable);
}
