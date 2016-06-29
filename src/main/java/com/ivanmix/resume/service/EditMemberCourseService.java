package com.ivanmix.resume.service;

import com.ivanmix.resume.entity.Course;

import java.util.List;

public interface EditMemberCourseService {

    List<Course> listCourses(long idMember);

    void updateCourses(long idMember, List<Course> courses);

    void deleteCourse(long id, long idMember);
}
