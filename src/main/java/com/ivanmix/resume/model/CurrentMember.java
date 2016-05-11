package com.ivanmix.resume.model;

import com.ivanmix.resume.Constants;
import com.ivanmix.resume.entity.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by ivan on 12.05.2016.
 */
public class CurrentMember extends User {
    private static final long serialVersionUID = 3850489832510630519L;
    private final Long id;
    private final String fullName;

    public CurrentMember(Member member) {
        super(UUID.randomUUID().toString(), member.getPassword(), true, true, true, true, Collections.singleton(new SimpleGrantedAuthority(Constants.USER)));
        this.id = member.getId();
        this.fullName = member.getFullName();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return String.format("CurrentMember [id=%s, username=%s]", id, getUsername());
    }
}