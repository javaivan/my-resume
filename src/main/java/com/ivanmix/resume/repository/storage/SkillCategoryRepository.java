package com.ivanmix.resume.repository.storage;


import java.util.List;

import com.ivanmix.resume.entity.SkillCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass=SkillCategory.class, idClass=Long.class)
public interface SkillCategoryRepository {

    List<SkillCategory> findAll(Sort sort);
}