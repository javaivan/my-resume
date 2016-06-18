package com.ivanmix.resume.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import com.ivanmix.resume.entity.Member;
//import com.ivanmix.resume.repository.search.ProfileSearchRepository;
import com.ivanmix.resume.service.FindMemberService;

@Service
public class ElasticSearchIndexingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchIndexingService.class);

    @Value("${index.all.during.startup}")
    private boolean indexAllDuringStartup;
/*
    @Autowired
    private ProfileSearchRepository profileSearchRepository;
*/
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private FindMemberService findMemberService;

    @PostConstruct
    private void postConstruct(){
        if(indexAllDuringStartup) {
            LOGGER.info("Detected index all command");
            LOGGER.info("Clear old index");
            elasticsearchOperations.deleteIndex(Member.class);
            LOGGER.info("Start index of profiles");
/*            for(Member m : findMemberService.findAllForIndexing()){
              /*  profileSearchRepository.save(m);
                LOGGER.info("Successful indexing of profile: "+m.getId());
            }*/
            LOGGER.info("Finish index of profiles");
        }
        else{
            LOGGER.info("indexAllDuringStartup is disabled");
        }
    }
}
