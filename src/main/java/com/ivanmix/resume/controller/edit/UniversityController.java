package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.UniversityForm;
import com.ivanmix.resume.service.EditMemberUniversityService;
import com.ivanmix.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UniversityController {

    @Autowired
    private EditMemberUniversityService updateUniversities;

    @RequestMapping(value="/edit/university", method= RequestMethod.GET)
    public String getUniversity(Model model){
        model.addAttribute("universityForm", new UniversityForm(updateUniversities.listUniversities(SecurityUtil.getCurrentIdMember())));
        return "edit/university";
    }

    @RequestMapping(value="/edit/university", method=RequestMethod.POST)
    public String saveUniversity(@Valid @ModelAttribute("universityForm") UniversityForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/university";
        }
        updateUniversities.updateUniversities(SecurityUtil.getCurrentIdMember(),form.getUniversities());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/university/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUniversity(@PathVariable("id") Long id, HttpServletResponse response) {
        updateUniversities.deleteUniversity(id,SecurityUtil.getCurrentIdMember());
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
