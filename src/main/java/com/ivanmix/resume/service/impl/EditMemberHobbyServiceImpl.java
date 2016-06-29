package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Hobby;
import com.ivanmix.resume.entity.HobbyItem;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.HobbiesRepository;
import com.ivanmix.resume.repository.storage.HobbyItemRepository;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.EditMemberHobbyService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberHobbyServiceImpl implements EditMemberHobbyService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HobbyItemRepository hobbyItemRepository;

    @Autowired
    private HobbiesRepository hobbiesRepository;

    @Override
    public List<HobbyItem> listHobbyItem(){
        return hobbyItemRepository.findAll(new Sort("name"));
    }

    @Override
    public List<Hobby> listHobby(long memberId){
        return memberRepository.findById(memberId).getHobbies();
    }

    @Override
    public List<HobbyItem> listHobbiesWithProfileSelected(long memberId) {
        List<Hobby> memberHobbies =  listHobby(memberId);
        List<HobbyItem> hobbies = new ArrayList<>();
        List<HobbyItem> allHobbies =  listHobbyItem();
        for (HobbyItem h: allHobbies){
            boolean selected = memberHobbies.contains(new Hobby(h.getName()));
            hobbies.add(new HobbyItem(h.getName(),selected));
        }
        return hobbies;
    }

    @Override
    @Transactional
    public void updateHobbies(long idMember, List<Hobby> hobbies) {
        hobbiesRepository.deleteByMemberId(idMember);
        Member member = memberRepository.findOne(idMember);
        hobbies.removeAll(Collections.singleton(new Hobby()));
        if (CollectionUtils.isEqualCollection(hobbies, member.getHobbies())) {
            return;
        }
        member.setHobbies(hobbies);
        memberRepository.save(member);
    }
}
