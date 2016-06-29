package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Hobby;
import com.ivanmix.resume.entity.HobbyItem;

import java.util.List;

public interface EditMemberHobbyService {

    List<HobbyItem> listHobbyItem();

    List<Hobby> listHobby(long memberId);

    List<HobbyItem> listHobbiesWithProfileSelected(long memberId);

    void updateHobbies(long memberId, List<Hobby> hobbies);
}
