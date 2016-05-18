package com.ivanmix.resume.entity;

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
    private Member member;

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
