package com.ivanmix.resume.controller.edit;


import com.ivanmix.resume.form.UniversityForm;
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
public class UniversityController {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;


    @RequestMapping(value="/edit/university", method= RequestMethod.GET)
    public String getUniversity(Model model){
        LOGGER.debug("university");
        model.addAttribute("universityForm", new UniversityForm(editMemberService.listUniversities(SecurityUtil.getCurrentIdMember())));
        return "edit/university";
    }

    @RequestMapping(value="/edit/university", method=RequestMethod.POST)
    public String saveUniversity(@Valid @ModelAttribute("universityForm") UniversityForm form, BindingResult bindingResult, Model model) {
        LOGGER.debug("save University");
        if (bindingResult.hasErrors()) {
            return "edit/university";
        }
        editMemberService.updateUniversities(SecurityUtil.getCurrentIdMember(),form.getUniversities());
        return "redirect:/";
    }


    @RequestMapping(value = "/edit/university/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUniversity(@PathVariable("id") Long id, HttpServletResponse response) {
        LOGGER.debug("deleteUniversity" + id);
        editMemberService.deleteUniversity(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }

    @RequestMapping(value = "/fragment/edit/university/{id}", method = RequestMethod.GET)
    public String getAddUniversity(@PathVariable("id") Long id,Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/university";
    }



}
