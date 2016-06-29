package com.ivanmix.resume.controller;

import com.fasterxml.jackson.databind.Module;
import com.ivanmix.resume.entity.Member;
import com.ivanmix.resume.form.*;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.service.ImageProcessorService;
import com.ivanmix.resume.service.ImageUploadService;
import com.ivanmix.resume.util.SecurityUtil;
import com.ivanmix.resume.model.CurrentMember;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EditMemberController {


	@Autowired
	private EditMemberService editMemberService;

	@Autowired
	private ImageProcessorService imageService;

	@Autowired
	private ImageUploadService imageUploadService;

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
/*
    @RequestMapping(value = "/edit/certificates/upload", method = RequestMethod.POST)
    @ResponseBody
    public UploadCertificate uploadCertificate(@RequestParam("certificateFile") MultipartFile certificateFile,@RequestParam("certificateName") String certificateName) {
        System.out.println(certificateName);
        UploadCertificate uploadCertificate =  imageService.newCertificateImage(certificateFile);
        editMemberService.addCertificate(SecurityUtil.getCurrentIdMember(),certificateName, uploadCertificate);
        return imageService.newCertificateImage(certificateFile);
    }


*
*
* */

	@RequestMapping(value="/edit/photo", method=RequestMethod.POST)
	@ResponseBody
	public String savePhoto(@RequestParam("photoFile") MultipartFile file){

		UploadImage image = imageUploadService.uploadNewImage(file);

		editMemberService.addMemberPhoto(SecurityUtil.getCurrentIdMember(), image);
		return "success";
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
		model.addAttribute("PasswordForm", new PasswordForm());
		return "edit/password";
	}
	@RequestMapping(value="/edit/password", method=RequestMethod.POST)
	public String saveEditPassword(@Valid @ModelAttribute("passwordForm") PasswordForm form, BindingResult bindingResult, Model model) {
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
		System.out.println(editMemberService.memberContact(SecurityUtil.getCurrentIdMember()).getMemberContactSocial());
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
