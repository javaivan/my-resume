package com.ivanmix.resume.entity;

import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="hobby_item")
public class HobbyItem  implements Serializable {

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