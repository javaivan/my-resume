package com.ivanmix.resume.controller;

import com.ivanmix.resume.form.*;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.SecurityUtil;
import com.ivanmix.resume.model.CurrentMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class EditMemberController {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private EditMemberService editMemberService;

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String getEditProfile(){
		return "edit";
	}

	@RequestMapping(value="/edit/contacts", method=RequestMethod.GET)
	public String getEditContacts(){
		LOGGER.debug("contacts");
		return "edit/contacts";
	}
	@RequestMapping(value="/edit/contacts", method=RequestMethod.POST)
	public String saveEditContacts(){
		LOGGER.debug("save contacts");
		return "redirect:/";
	}





	@RequestMapping(value = "/my-profile")
	public String getMyProfile(@AuthenticationPrincipal CurrentMember currentMember) {
		return "redirect:/" + currentMember.getUsername();
	}



	@RequestMapping(value="/edit/hobbies", method=RequestMethod.GET)
	public String getEditHobbies(){
		LOGGER.debug("hobbies");
		return "edit/hobbies";
	}
	@RequestMapping(value="/edit/hobbies", method=RequestMethod.POST)
	public String saveEditHobbies(){
		LOGGER.debug("save hobbies");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/info", method=RequestMethod.GET)
	public String getEditInfo(){
		LOGGER.debug("info");
		return "edit/info";
	}
	@RequestMapping(value="/edit/info", method=RequestMethod.POST)
	public String saveEditInfo(){
		LOGGER.debug("save info");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/password", method=RequestMethod.GET)
	public String getEditPassword(){
		LOGGER.debug("password");
		return "edit/password";
	}
	@RequestMapping(value="/edit/password", method=RequestMethod.POST)
	public String saveEditPassword(){
		LOGGER.debug("save password");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/add-info", method=RequestMethod.GET)
	public String getEditAddInfo(Model model) {
		LOGGER.debug("add-info");

		model.addAttribute("description", editMemberService.addInfo(SecurityUtil.getCurrentIdMember()));
		return "edit/add-info";
	}


	@RequestMapping(value = "/edit/add-info", method = RequestMethod.POST)
	public String saveEditAddInfo(@Valid @ModelAttribute("addInfoForm") AddInfoForm form, BindingResult bindingResult, Model model) {
		LOGGER.debug("saveEditAddInfo");
		if (bindingResult.hasErrors()) {
			model.addAttribute("description", editMemberService.addInfo(SecurityUtil.getCurrentIdMember()));
			return "edit/add-info";
		}
		editMemberService.updateAddInfo(SecurityUtil.getCurrentIdMember(), form.getDescription());
		return "redirect:/";
	}


	@RequestMapping(value="/edit/contact-social", method=RequestMethod.GET)
	public String getEditContactSocial(Model model) {
		LOGGER.debug("contact-contact");

		model.addAttribute("contactSocial", editMemberService.memberContact(SecurityUtil.getCurrentIdMember()).getMemberContactSocial());
		return "edit/contact-social";
	}



	@RequestMapping(value = "/edit/contact-social", method = RequestMethod.POST)
	public String saveEditContactSocial(@Valid @ModelAttribute("contactSocialForm") ContactSocialForm form, BindingResult bindingResult, Model model) {
		LOGGER.debug("saveEditContactSocial: " + form);
		if (bindingResult.hasErrors()) {
			model.addAttribute("contactSocial", editMemberService.memberContact(SecurityUtil.getCurrentIdMember()).getMemberContactSocial());
			return "edit/contact-social";
		}
		editMemberService.updateMemberContactSocial(SecurityUtil.getCurrentIdMember(), form.getMemberContactSocial());
		return "redirect:/";
	}


	/*MemberContactSocial*/

}
