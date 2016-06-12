package com.ivanmix.resume.service.member;

import com.ivanmix.resume.entity.Hobby;
import com.ivanmix.resume.entity.HobbyItem;

import java.util.List;

public interface MemberHobbyService {

    List<HobbyItem> listHobbyItem();
    List<Hobby> listHobby(long memberId);
    List<HobbyItem> listHobbiesWithProfileSelected(long memberId);
    void updateHobbies(long memberId, List<Hobby> hobbies);
}
