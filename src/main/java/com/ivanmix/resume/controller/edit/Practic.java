package com.ivanmix.resume.controller.edit;


import com.ivanmix.resume.form.PracticForm;
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
public class Practic {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;

    @RequestMapping(value="/edit/practics", method=RequestMethod.GET)
    public String getEditPractics(Model model){
        LOGGER.debug("practics");
        model.addAttribute("practicForm", new PracticForm(editMemberService.listPractics(SecurityUtil.getCurrentIdMember())));
        return "edit/practics";
    }


    @RequestMapping(value="/edit/practics", method=RequestMethod.POST)
    public String savePractics(@Valid @ModelAttribute("practicForm") PracticForm form, BindingResult bindingResult, Model model) {
        LOGGER.debug("save practics");
        if (bindingResult.hasErrors()) {
            return "edit/practics";
        }
        editMemberService.updatePractics(SecurityUtil.getCurrentIdMember(),form.getPractics());
        return "redirect:/";
    }



    @RequestMapping(value = "/edit/practics/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deletePractic(@PathVariable("id") Long id, HttpServletResponse response) {
        LOGGER.debug("deletePractic" + id);
        editMemberService.deletePractics(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }


    @RequestMapping(value = "/fragment/edit/practics/{id}", method = RequestMethod.GET)
    public String getAddUniversity(@PathVariable("id") Long id,Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/practics";
    }


}
