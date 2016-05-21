package com.ivanmix.resume.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="university")
public class University extends AbstractEntity<Long> implements Serializable, MemberEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UNIVERSITY_ID_GENERATOP", sequenceName = "UNIVERSITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIVERSITY_ID_GENERATOP")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable = false, length = 255)
    private String faculty;

    @Column(name="begin_year", nullable=false)
    private Integer beginYear;

    @Column(name="finish_year")
    private Integer finishYear;

    public University(){
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        University that = (University) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (faculty != null ? !faculty.equals(that.faculty) : that.faculty != null) return false;
        if (beginYear != null ? !beginYear.equals(that.beginYear) : that.beginYear != null) return false;
        return finishYear != null ? finishYear.equals(that.finishYear) : that.finishYear == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (beginYear != null ? beginYear.hashCode() : 0);
        result = 31 * result + (finishYear != null ? finishYear.hashCode() : 0);
        return result;
    }
}
