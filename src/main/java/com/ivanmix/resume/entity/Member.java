package com.ivanmix.resume.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.data.elasticsearch.annotations.Document;


@Entity
@Table(name = "member")
@Document(indexName="profile")
public class Member extends AbstractEntity<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MEMBER_ID_GENERATOR", sequenceName = "MEMBER_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(insertable=false)
    private Timestamp created;



    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Skill> skills;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Certificate> certificates;

    @OneToOne(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private MemberAddInfo memberAddInfo;

    @OneToOne(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private MemberContact memberContact;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<University> universities;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Language> languages;

    @OneToMany(mappedBy = "member", cascade={CascadeType.MERGE, CascadeType.PERSIST})
  /*  @OrderBy("finishDate DESC")*/
    private List<Practic> practics;


    public Member() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        updateListSetMember(this.skills);
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
        updateListSetMember(this.hobbies);
    }

    public List<Certificate> getCertificates() {    return certificates;}

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
        updateListSetMember(this.certificates);
    }




    public MemberAddInfo getMemberAddInfo() {
        return memberAddInfo;
    }

    public void setMemberAddInfo(MemberAddInfo memberAddInfo) {
        this.memberAddInfo = memberAddInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }


    public MemberContact getMemberContact() {
        return memberContact;
    }

    public void setMemberContact(MemberContact memberContact) {
        this.memberContact = memberContact;
    }

    public List<Course> getCourses() {
        return courses;

    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        updateListSetMember(this.courses);
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
        updateListSetMember(this.languages);
    }


    public List<Practic> getPractics() {
        return this.practics;
    }

    public void setPractics(List<Practic> practics) {
        this.practics = practics;
        updateListSetMember(this.practics);
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
        updateListSetMember(this.universities);
    }

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    private void updateListSetMember(List<? extends MemberEntity> list) {
        if(list != null) {
            for(MemberEntity entity : list) {
                entity.setMember(this);
            }
        }
    }



}