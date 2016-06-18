package com.ivanmix.resume.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="hobby")
public class Hobby extends AbstractEntity<Long> implements Serializable, MemberEntity {

    @Id
    @SequenceGenerator(name="HOBBY_ID_GENERATOR", sequenceName="HOBBY_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOBBY_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    @JsonIgnore
    private Member member;

    @Column(nullable=false, length=255)
    @EnglishLanguage
    @Size(min=1)
    private String name;

    public Hobby() {
    }

    public Hobby(String name) {
        super();
        this.name = name;
    }

    public Hobby(String name, Member member) {
        this.name = name;
        this.member = member;
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

/*    public String getCssClassName(){
        return name.replace(" ", "-").toLowerCase();
    }*/


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Hobby))
            return false;
        Hobby other = (Hobby) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

/*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hobby hobby = (Hobby) o;

        return name != null ? name.equals(hobby.name) : hobby.name == null;

    }
*/
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /*
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }*/
}