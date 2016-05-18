package com.ivanmix.resume.entity;


import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="certificate")
public class Certificate extends AbstractEntity<Long> implements Serializable, MemberEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="CERTIFICATE_ID_GENERATOR", sequenceName="CERTIFICATE_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CERTIFICATE_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false, length=250)
    @Size(min=1)
    private String name;

    @Column(nullable=false, length=250)
    @Size(min=10)
    private String images;

    //bi-directional many-to-one association to Profile
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
    private Member member;

    public Certificate() {
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


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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
        result = prime * result + ((images == null) ? 0 : images.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Certificate))
            return false;
        Certificate other = (Certificate) obj;
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
        if (images == null) {
            if (other.images != null)
                return false;
        } else if (!images.equals(other.images))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Certificate: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images='" + images + '\'' +
                ", member=" + member +
                '}';
    }
}