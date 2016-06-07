package com.ivanmix.resume.entity;


import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="hobby")
public class Hobby extends AbstractEntity<Long> implements Serializable, MemberEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="HOBBY_ID_GENERATOR", sequenceName="HOBBY_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOBBY_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false, length=255)
    @EnglishLanguage
    @Size(min=1)
    private String name;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    private Member member;

    public Hobby() {
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
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Hobby))
            return false;
        Hobby other = (Hobby) obj;
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
        return true;
    }

}