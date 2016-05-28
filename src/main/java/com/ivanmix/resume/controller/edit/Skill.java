package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.SkillForm;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class Skill {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getSkills(Model model) {
        LOGGER.debug("getSkills");
        model.addAttribute("skillForm", new SkillForm(editMemberService.listSkills(SecurityUtil.getCurrentIdMember())));
        return gotoSkillsJSP(model);
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
        LOGGER.debug("saveSkills");
        if (bindingResult.hasErrors()) {
            return gotoSkillsJSP(model);
        }
        editMemberService.updateSkills(SecurityUtil.getCurrentIdMember(), form.getItems());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/skills_delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteSkills(@PathVariable("id") Long id,HttpServletResponse response) {
        LOGGER.debug("deleteSkills" + id);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        editMemberService.deleteSkill(SecurityUtil.getCurrentIdMember(), id);
        return "successfully";
        /*{
            return "successfully";
        } else {
            return "fails";
        }*/
    }


    private String gotoSkillsJSP(Model model){
        model.addAttribute("skillCategories", editMemberService.listSkillCategories());
        return "edit/skills";
    }


}
