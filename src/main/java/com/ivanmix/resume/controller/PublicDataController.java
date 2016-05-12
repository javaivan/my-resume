package com.ivanmix.resume.controller;

import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.repository.storage.MemberRepository;
import com.ivanmix.resume.repository.storage.SkillCategoryRepository;
import com.ivanmix.resume.form.SkillForm;
import com.ivanmix.resume.service.FindMemberService;
import com.ivanmix.resume.model.CurrentMember;
import com.ivanmix.resume.util.SecurityUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PublicDataController {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private SkillCategoryRepository skillCategoryRepository;

	@Autowired
	private FindMemberService findMemberService;


	@RequestMapping(value="/{uid}", method=RequestMethod.GET)
	public String getProfile(@PathVariable("uid") Long uid, Model model){

		Member member = findMemberService.findById(uid);
		if(member == null) {
			return "profile_not_found";
		}
		model.addAttribute("member", member);
		return "profile";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String getError(){
		LOGGER.debug("getError");
		return "error";
	}

	@RequestMapping(value = "/sign-in")
	public String signIn() {
		CurrentMember currentMember = SecurityUtil.getCurrentMember();
		if(currentMember != null) {
				return "redirect:/" + currentMember.getUsername();
		}else{
				return "sign-in";
		}
	}

	@RequestMapping(value = "/sign-in-failed", method = RequestMethod.GET)
	public String signInFailed(HttpSession session) {
		if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") == null) {
				return "redirect:/sign-in";
			}
		return "sign-in";
	}
}
