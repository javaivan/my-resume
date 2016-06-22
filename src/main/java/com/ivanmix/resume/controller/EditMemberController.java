package com.ivanmix.resume.controller;

import com.fasterxml.jackson.databind.Module;
import com.ivanmix.resume.form.*;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.SecurityUtil;
import com.ivanmix.resume.model.CurrentMember;

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


	@Autowired
	private EditMemberService editMemberService;

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String getEditProfile(Model model){
		model.addAttribute("contactForm", editMemberService.memberContact(SecurityUtil.getCurrentIdMember()));
		return "edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEditProfile(@Valid @ModelAttribute("contactForm") ContactForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		editMemberService.updateMemberContact(SecurityUtil.getCurrentIdMember(), form.getItems());
		return "redirect:/";
	}


	@RequestMapping(value="/edit/photo", method=RequestMethod.POST)
	public String savePhoto(@Valid @ModelAttribute("uploadFileForm") UploadPhotoForm form, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			System.out.println("hasErrors");
			return "edit";
		}
		editMemberService.addMemberPhoto(SecurityUtil.getCurrentIdMember(),form.getImages());
		System.out.println(form.getImages());
		return "redirect:/";
	}


	@RequestMapping(value="/edit/contacts", method=RequestMethod.GET)
	public String getEditContacts(){
		return "edit/contacts";
	}
	@RequestMapping(value="/edit/contacts", method=RequestMethod.POST)
	public String saveEditContacts(){
		return "redirect:/";
	}





	@RequestMapping(value = "/my-profile")
	public String getMyProfile(@AuthenticationPrincipal CurrentMember currentMember) {
		return "redirect:/" + currentMember.getId();
	}


	@RequestMapping(value="/edit/password", method=RequestMethod.GET)
	public String getEditPassword(Model model){
		model.addAttribute("changePasswordForm", new ChangePasswordForm());
		return "edit/password";
	}
	@RequestMapping(value="/edit/password", method=RequestMethod.POST)
	public String saveEditPassword(@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			return "edit/password";
		}
		editMemberService.changePassword(SecurityUtil.getCurrentIdMember(),form.getPassword());
		return "redirect:/";
	}

	@RequestMapping(value="/edit/info", method=RequestMethod.GET)
	public String getEditAddInfo(Model model) {

		model.addAttribute("description", editMemberService.addInfo(SecurityUtil.getCurrentIdMember()));
		return "edit/add-info";
	}


	@RequestMapping(value = "/edit/info", method = RequestMethod.POST)
	public String saveEditAddInfo(@Valid @ModelAttribute("addInfoForm") AddInfoForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("description", editMemberService.addInfo(SecurityUtil.getCurrentIdMember()));
			return "edit/add-info";
		}
		editMemberService.updateAddInfo(SecurityUtil.getCurrentIdMember(), form.getDescription());
		return "redirect:/";
	}


	@RequestMapping(value="/edit/contact-social", method=RequestMethod.GET)
	public String getEditContactSocial(Model model) {
		model.addAttribute("contactSocial", editMemberService.memberContact(SecurityUtil.getCurrentIdMember()).getMemberContactSocial());
		return "edit/contact-social";
	}



	@RequestMapping(value = "/edit/contact-social", method = RequestMethod.POST)
	public String saveEditContactSocial(@Valid @ModelAttribute("contactSocialForm") ContactSocialForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("contactSocial", editMemberService.memberContact(SecurityUtil.getCurrentIdMember()).getMemberContactSocial());
			return "edit/contact-social";
		}
		editMemberService.updateMemberContactSocial(SecurityUtil.getCurrentIdMember(), form.getMemberContactSocial());
		return "redirect:/";
	}


	/*MemberContactSocial*/

}
