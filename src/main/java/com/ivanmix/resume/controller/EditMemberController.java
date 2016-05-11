package com.ivanmix.resume.controller;

import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.SecurityUtil;

import com.ivanmix.resume.form.SkillForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
/*
	@RequestMapping(value="/edit/skills", method=RequestMethod.GET)
	public String getEditSkills(Model model){
		LOGGER.debug("skills");
		model.addAttribute("skillCategories", skillCategoryRepository.findAll(new Sort("id")));
		return "edit/skills";
	}

	@RequestMapping(value="/edit/skills", method=RequestMethod.POST)
	public String saveEditSkills(){
		LOGGER.debug("save skills");
		return "redirect:/";
	}*/

	@RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
	public String getEditSkills(Model model) {
		model.addAttribute("skillForm", new SkillForm(editMemberService.listSkills(SecurityUtil.getCurrentIdProfile())));
		return gotoSkillsJSP(model);
	}

	@RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
	public String saveEditSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return gotoSkillsJSP(model);
		}
		editMemberService.updateSkills(SecurityUtil.getCurrentIdProfile(), form.getItems());
		return "redirect:/mike-ross";
	}

	private String gotoSkillsJSP(Model model){
		model.addAttribute("skillCategories", editMemberService.listSkillCategories());
		return "edit/skills";
	}


	@RequestMapping(value="/edit/practics", method=RequestMethod.GET)
	public String getEditPractics(){
		LOGGER.debug("practics");
		return "edit/practics";
	}
	@RequestMapping(value="/edit/practics", method=RequestMethod.POST)
	public String saveEditPractics(){
		LOGGER.debug("save practics");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/certificates", method=RequestMethod.GET)
	public String getEditCertificates(){
		LOGGER.debug("certificates");
		return "edit/certificates";
	}
	@RequestMapping(value="/edit/certificates", method=RequestMethod.POST)
	public String saveEditCertificates(){
		LOGGER.debug("save certificates");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/courses", method=RequestMethod.GET)
	public String getEditCourses(){
		LOGGER.debug("courses");
		return "edit/courses";
	}
	@RequestMapping(value="/edit/courses", method=RequestMethod.POST)
	public String saveEditCourses(){
		LOGGER.debug("save courses");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/education", method=RequestMethod.GET)
	public String getEditEducation(){
		LOGGER.debug("education");
		return "edit/education";
	}
	@RequestMapping(value="/edit/education", method=RequestMethod.POST)
	public String saveEditEducation(){
		LOGGER.debug("save education");
		return "redirect:/";
	}

	@RequestMapping(value="/edit/languages", method=RequestMethod.GET)
	public String getEditLanguages(){
		LOGGER.debug("languages");
		return "edit/languages";
	}
	@RequestMapping(value="/edit/languages", method=RequestMethod.POST)
	public String saveEditLanguages(){
		LOGGER.debug("save languages");
		return "redirect:/";
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



}
