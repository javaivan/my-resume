package com.ivanmix.resume.util;

import java.util.UUID;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.model.CurrentMember;

public final class SecurityUtil {

    public static CurrentMember getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof CurrentMember) {
            return ((CurrentMember)principal);
        } else {
            return null;
        }
    }

    public static Long getCurrentIdMember() {
        CurrentMember currentMember = getCurrentMember();
        return currentMember != null ? currentMember.getId() : null;
    }

    public static void authentificate(Member member) {
        CurrentMember currentMember = new CurrentMember(member);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                currentMember, currentMember.getPassword(), currentMember.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static boolean isCurrentMemberAuthentificated() {
        return getCurrentMember() != null;
    }

    public static String generateNewActionUid(){
        return UUID.randomUUID().toString();
    }

    public static String generateNewRestoreAccessToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}