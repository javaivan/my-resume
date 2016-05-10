package com.ivanmix.resume.entity;


import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="skill")
public class Skill extends AbstractEntity<Long> implements Serializable, MemberEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SKILL_ID_GENERATOR", sequenceName="SKILL_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKILL_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false, length=50)
    @EnglishLanguage
    @Size(min=1)
    private String name;

    @Column(nullable=false, length=2147483647)
    @EnglishLanguage
    @Size(min=10)
    private String description;

    //bi-directional many-to-one association to Profile
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    private Member member;

    public Skill() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getMember() {
        return this.member;
    }

    @Override
    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Skill))
            return false;
        Skill other = (Skill) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

}