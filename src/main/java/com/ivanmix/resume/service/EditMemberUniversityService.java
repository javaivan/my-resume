package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.University;

import java.util.List;

public interface EditMemberUniversityService {

    List<University> listUniversities(long idMember);

    void updateUniversities(long idMember, List<University> universities);

    void deleteUniversity(long idUniversity, long idMember);
}
