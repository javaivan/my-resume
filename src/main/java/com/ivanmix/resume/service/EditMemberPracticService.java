package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Practic;

import java.util.List;

public interface EditMemberPracticService {

    List<Practic> listPractics(long idMember);

    void updatePractics(long idMember, List<Practic> practics);

    void deletePractics(long idPractic, long idMember);

}
