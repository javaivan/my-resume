package com.ivanmix.resume.entity;

import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill_category")
public class SkillCategory extends AbstractEntity<Long>{
    private static final long serialVersionUID = -8959739023562086833L;

    @Id
    @Column
    private Long id;

    @Column(nullable=false, length=250)
    @EnglishLanguage
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}