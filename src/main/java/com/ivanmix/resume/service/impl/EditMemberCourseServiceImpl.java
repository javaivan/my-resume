package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Course;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.CourseRepository;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.EditMemberCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberCourseServiceImpl implements EditMemberCourseService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> listCourses(long idMember) {
        return memberRepository.findOne(idMember).getCourses();
    }

    @Override
    public void updateCourses(long idMember, List<Course> courses) {
        Member member = memberRepository.findOne(idMember);
        courses.removeAll(Collections.singleton(new Course()));
        if(CollectionUtils.isEqualCollection(courses, member.getCourses())){
            return;
        } else {
            member.setCourses(courses);
            memberRepository.save(member);
        }
    }

    @Override
    @Transactional
    public void deleteCourse(long id, long idMember){
        courseRepository.deleteByIdAndMemberId(id,idMember);
    }
}
