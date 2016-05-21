package com.ivanmix.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ivan on 20.05.2016.
 */
@Entity
@Table(name = "education")
public class Education  extends AbstractEntity<Long> implements Serializable, MemberEntity{


    @Id
    /*@SequenceGenerator(name = "EDUCATION_ID_GENERATOR", sequenceName = "EDUCATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_ID_GENERATOR")*/
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    @JsonIgnore
    private Member Member;

    @Column(nullable=false, length=255)
    private String name;
/*
    @Column(nullable=false, length=255)
    private String university;

    @Column(nullable=false, length=255)
    private String faculty;

    @Column(name="begin_year", nullable=false)
    private Integer beginYear;

    @Column(name="finish_year")
    private Integer finishYear;
*/
    public Education(){}


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return Member;
    }

    @Override
    public void setMember(Member member) {
        Member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(Integer beginYear) {
        this.beginYear = beginYear;
    }

    public Integer getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(Integer finishYear) {
        this.finishYear = finishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Education education = (Education) o;

        if (id != null ? !id.equals(education.id) : education.id != null) return false;
        if (Member != null ? !Member.equals(education.Member) : education.Member != null) return false;
        if (name != null ? !name.equals(education.name) : education.name != null) return false;
        if (university != null ? !university.equals(education.university) : education.university != null) return false;
        if (faculty != null ? !faculty.equals(education.faculty) : education.faculty != null) return false;
        if (beginYear != null ? !beginYear.equals(education.beginYear) : education.beginYear != null) return false;
        return finishYear != null ? finishYear.equals(education.finishYear) : education.finishYear == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (Member != null ? Member.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (beginYear != null ? beginYear.hashCode() : 0);
        result = 31 * result + (finishYear != null ? finishYear.hashCode() : 0);
        return result;
    }*/
}
