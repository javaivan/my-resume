package com.ivanmix.resume.entity;

import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
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

    @Transient
    private boolean selected;

    public HobbyItem() {
    }

    public HobbyItem(String name) {
        super();
        this.name = name;
    }
    public HobbyItem(String name, boolean selected){
        super();
        this.name = name;
        this.selected = selected;
    }

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

    public boolean isSelected() {
        return selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getCssClassName(){
        return name.replace(" ", "-").toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HobbyItem hobbyItem = (HobbyItem) o;

        return name != null ? name.equals(hobbyItem.name) : hobbyItem.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public int compareTo(Hobby o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("Hobby [name=%s]", name);
    }
}