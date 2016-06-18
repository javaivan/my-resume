package com.ivanmix.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="member_add_info")
public class MemberAddInfo  implements Serializable, MemberEntity {


    @Id
    @SequenceGenerator(name="MEMBER_ADD_INFO_ID_GENERATOR", sequenceName="MEMBER_ADD_INFO_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_ADD_INFO_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    @JsonIgnore
    private Member member;

    @Size(min=1)
    private String description;


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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
