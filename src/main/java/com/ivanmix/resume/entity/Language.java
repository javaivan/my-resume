package com.ivanmix.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ivanmix.resume.model.LanguageLevel;
import com.ivanmix.resume.model.LanguageType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ivan on 21.05.2016.
 */
@Entity
@Table(name="language")
public class Language extends AbstractEntity<Long> implements Serializable, MemberEntity{

    @Id
    @SequenceGenerator(name="LANGUAGE_ID_GENERATOR", sequenceName="LANGUAGE_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="LANGUAGE_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    @JsonIgnore
    private Member member;

    @Column
    @Convert(converter = LanguageType.PersistJPAConverter.class)
    private LanguageType type;

    @Column(length = 255)
    private String name;

    @Column(nullable=false)
    @Convert(converter = LanguageLevel.PersistJPAConverter.class)
    private LanguageLevel level;

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

    public LanguageType getType() {
        return type;
    }

    public void setType(LanguageType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", member=" + member +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Language language = (Language) o;

        if (id != null ? !id.equals(language.id) : language.id != null) return false;
        if (member != null ? !member.equals(language.member) : language.member != null) return false;
        if (type != language.type) return false;
        if (name != null ? !name.equals(language.name) : language.name != null) return false;
        return level == language.level;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
