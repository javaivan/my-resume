package com.ivanmix.resume.repository.storage;


import com.ivanmix.resume.entity.HobbyItem;
import com.ivanmix.resume.entity.SkillCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass=HobbyItem.class, idClass=Long.class)
public interface HobbyItemRepository {

    List<HobbyItem> findAll(Sort sort);
}