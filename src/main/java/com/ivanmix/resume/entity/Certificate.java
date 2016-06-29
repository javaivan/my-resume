package com.ivanmix.resume.entity;


import com.ivanmix.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="certificate")
public class Certificate extends AbstractEntity<Long> implements Serializable, MemberEntity {

    @Id
    @SequenceGenerator(name="CERTIFICATE_ID_GENERATOR", sequenceName="CERTIFICATE_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CERTIFICATE_ID_GENERATOR")
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false, length=250)
    @Size(min=1)
    private String name;

    @Column(name = "big_image", length=250)
    private String bigImage;

    @Column(name = "small_image", length=250)
    private String smallImage;




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


    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public Member getMember() {
        return this.member;
    }

    @Override
    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Certificate that = (Certificate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (bigImage != null ? !bigImage.equals(that.bigImage) : that.bigImage != null) return false;
        if (smallImage != null ? !smallImage.equals(that.smallImage) : that.smallImage != null) return false;
        return member != null ? member.equals(that.member) : that.member == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bigImage != null ? bigImage.hashCode() : 0);
        result = 31 * result + (smallImage != null ? smallImage.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bigImage='" + bigImage + '\'' +
                ", smallImage='" + smallImage + '\'' +
                ", member=" + member +
                '}';
    }
}