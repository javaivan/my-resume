package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Language;

import java.util.List;

public interface EditMemberLanguageService {

    List<Language> listLanguages(long idMember);

    void updateLanguages(long idMember, List<Language> languages);

    void deleteLanguage(long idLanguage, long idMember);
}
