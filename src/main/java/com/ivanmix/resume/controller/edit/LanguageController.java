package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.LanguageForm;
import com.ivanmix.resume.model.LanguageLevel;
import com.ivanmix.resume.model.LanguageType;
import com.ivanmix.resume.service.EditMemberLanguageService;
import com.ivanmix.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LanguageController {

    @Autowired
    private EditMemberLanguageService languageService;

    @RequestMapping(value="/edit/languages", method=RequestMethod.GET)
    public String getEditLanguages(Model model){
        model.addAttribute("languageForm", new LanguageForm(languageService.listLanguages(SecurityUtil.getCurrentIdMember())));
        return gotoLanguageJSP(model);
    }

    @RequestMapping(value="/edit/languages", method=RequestMethod.POST)
    public String saveEditLanguages(@Valid @ModelAttribute("languageForm") LanguageForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return gotoLanguageJSP(model);
        }
        languageService.updateLanguages(SecurityUtil.getCurrentIdMember(),form.getItems());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/languages/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteSkills(@PathVariable("id") Long id,HttpServletResponse response) {
        languageService.deleteLanguage(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }

    @RequestMapping(value = "/fragment/edit/languages/{id}", method = RequestMethod.GET)
    public String getAddlanguage(@PathVariable("id") Long id,Model model) {
        model.addAttribute("index", id);
        model.addAttribute("languageType", LanguageType.values());
        model.addAttribute("languageLevel", LanguageLevel.values());
        return "fragment/edit/languages";
    }

    private String gotoLanguageJSP(Model model){
        model.addAttribute("languageType", LanguageType.values());
        model.addAttribute("languageLevel", LanguageLevel.values());
        return "edit/languages";
    }
}
