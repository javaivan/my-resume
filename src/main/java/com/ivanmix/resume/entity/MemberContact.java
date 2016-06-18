package com.ivanmix.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="member_contact")
public class MemberContact implements Serializable, MemberEntity {


    @Id
    @SequenceGenerator(name="MEMBER_CONTACT_ID_GENERATOR", sequenceName="MEMBER_CONTACT_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_CONTACT_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    @JsonIgnore
    private Member member;

    @Column
    private String photo;

    @Column(length = 255)
    private String country;

    @Column(length = 255)
    private String city;

    @Column(length = 255)
    private String phone;

    @Column(length = 255)
    private String objective;

    @Column
    private String qualification;


    @Embedded
    private MemberContactSocial memberContactSocial;

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


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public MemberContactSocial getMemberContactSocial() {
        if(memberContactSocial == null){
            memberContactSocial = new MemberContactSocial();
        }
        return memberContactSocial;
    }

    public void setMemberContactSocial(MemberContactSocial memberContactSocial) {
        this.memberContactSocial = memberContactSocial;
    }
}
