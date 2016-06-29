package com.ivanmix.resume.service.impl;

import com.ivanmix.resume.entity.Certificate;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.repository.storage.CertificateRepository;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.service.EditMemberCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EditMemberCertificateServiceImpl implements EditMemberCertificateService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> listCertificates(long idMember) {
        return memberRepository.findOne(idMember).getCertificates();
    }

    @Override
    @Transactional
    public void addCertificate(long idMember, Certificate certificate) {
        Member member = memberRepository.findOne(idMember);
        List<Certificate> certificates = member.getCertificates();
        certificates.add(certificate);
        member.setCertificates(certificates);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void addCertificate(long idMember, String name, UploadImage image){
        Member member = memberRepository.findOne(idMember);
        List<Certificate> certificates = member.getCertificates();
        Certificate c = new Certificate();
        c.setBigImage(image.getBigImage());
        c.setSmallImage(image.getSmallImage());
        c.setName(name);
        certificates.add(c);
        member.setCertificates(certificates);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void deleteCertificate(long id, long idMember){
        certificateRepository.deleteByIdAndMemberId(id,idMember);
    }
}