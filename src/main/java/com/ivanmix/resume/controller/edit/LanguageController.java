package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.LanguageForm;
import com.ivanmix.resume.form.SkillForm;
import com.ivanmix.resume.model.LanguageLevel;
import com.ivanmix.resume.model.LanguageType;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class LanguageController {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;

    @RequestMapping(value="/edit/languages", method=RequestMethod.GET)
    public String getEditLanguages(Model model){
        LOGGER.debug("languages");
        model.addAttribute("languageForm", new LanguageForm(editMemberService.listLanguages(SecurityUtil.getCurrentIdMember())));
        return gotoLanguageJSP(model);
    }

    @RequestMapping(value="/edit/languages", method=RequestMethod.POST)
    public String saveEditLanguages(@Valid @ModelAttribute("languageForm") LanguageForm form, BindingResult bindingResult, Model model) {
        LOGGER.debug("save languages");
        if (bindingResult.hasErrors()) {
            return gotoLanguageJSP(model);
        }
        editMemberService.updateLanguages(SecurityUtil.getCurrentIdMember(),form.getItems());
        return "redirect:/";
    }


    @RequestMapping(value = "/edit/languages/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteSkills(@PathVariable("id") Long id,HttpServletResponse response) {
        LOGGER.debug("deleteLanguage" + id);
        editMemberService.deleteLanguage(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }

    @RequestMapping(value = "/fragment/edit/languages/{id}", method = RequestMethod.GET)
    public String getAddlanguage(@PathVariable("id") Long id,Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/languages";
    }

    private String gotoLanguageJSP(Model model){
        model.addAttribute("languageType", LanguageType.values());
        model.addAttribute("languageLevel", LanguageLevel.values());
        return "edit/languages";
    }


}
