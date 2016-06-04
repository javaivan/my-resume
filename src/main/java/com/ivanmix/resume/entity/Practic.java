package com.ivanmix.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;
/**
 * Created by ivan on 01.06.2016.
 */
@Entity
@Table(name = "practic")
public class Practic extends AbstractFinishDateEntity<Long> implements Serializable, MemberEntity {

    @Id
    @SequenceGenerator(name = "PRACTIC_ID_GENERATOR", sequenceName = "PRACTIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRACTIC_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnore
    private Member member;


    @Column(nullable = false, length = 255)
    @Size(min=1)
    private String position;

    @Column(nullable = false, length = 255)
    @Size(min=1)
    private String company;

    @Column(name = "begin_date", nullable = false)
    private Date beginDate;

    @Column(nullable = false)
    @Size(min=1)
    private String responsibilities;

    @Column(length = 255)
    private String demo;

    @Column(length = 255)
    private String src;



    @Transient
    private Integer beginDateMonth;

    @Transient
    private Integer beginDateYear;



    public Practic(){}

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Transient
    public Integer getBeginDateMonth() {
        if (beginDate != null) {
            return new DateTime(beginDate).getMonthOfYear();
        } else {
            return null;
        }
    }

    @Transient
    public Integer getBeginDateYear() {
        if (beginDate != null) {
            return new DateTime(beginDate).getYear();
        } else {
            return null;
        }
    }

    public void setBeginDateMonth(Integer beginDateMonth) {
        this.beginDateMonth = beginDateMonth;
        setupBeginDate();
    }

    public void setBeginDateYear(Integer beginDateYear) {
        this.beginDateYear = beginDateYear;
        setupBeginDate();
    }

    private void setupBeginDate() {
        if (beginDateYear != null && beginDateMonth != null) {
            setBeginDate(new Date(new DateTime(beginDateYear, beginDateMonth, 1, 0, 0).getMillis()));
        } else {
            setBeginDate(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Practic practic = (Practic) o;

        if (id != null ? !id.equals(practic.id) : practic.id != null) return false;
        if (member != null ? !member.equals(practic.member) : practic.member != null) return false;
        if (position != null ? !position.equals(practic.position) : practic.position != null) return false;
        if (company != null ? !company.equals(practic.company) : practic.company != null) return false;
        if (beginDate != null ? !beginDate.equals(practic.beginDate) : practic.beginDate != null) return false;
        if (responsibilities != null ? !responsibilities.equals(practic.responsibilities) : practic.responsibilities != null)
            return false;
        if (demo != null ? !demo.equals(practic.demo) : practic.demo != null) return false;
        if (src != null ? !src.equals(practic.src) : practic.src != null) return false;
        if (beginDateMonth != null ? !beginDateMonth.equals(practic.beginDateMonth) : practic.beginDateMonth != null)
            return false;
        return beginDateYear != null ? beginDateYear.equals(practic.beginDateYear) : practic.beginDateYear == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (responsibilities != null ? responsibilities.hashCode() : 0);
        result = 31 * result + (demo != null ? demo.hashCode() : 0);
        result = 31 * result + (src != null ? src.hashCode() : 0);
        result = 31 * result + (beginDateMonth != null ? beginDateMonth.hashCode() : 0);
        result = 31 * result + (beginDateYear != null ? beginDateYear.hashCode() : 0);
        return result;
    }
}
