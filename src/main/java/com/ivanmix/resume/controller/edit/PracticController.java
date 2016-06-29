package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.PracticForm;
import com.ivanmix.resume.service.EditMemberPracticService;
import com.ivanmix.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class PracticController {

    @Autowired
    private EditMemberPracticService practicService;

    @RequestMapping(value="/edit/practics", method=RequestMethod.GET)
    public String getEditPractics(Model model){
        model.addAttribute("practicForm", new PracticForm(practicService.listPractics(SecurityUtil.getCurrentIdMember())));
        return "edit/practics";
    }

    @RequestMapping(value="/edit/practics", method=RequestMethod.POST)
    public String savePractics(@Valid @ModelAttribute("practicForm") PracticForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/practics";
        }
        practicService.updatePractics(SecurityUtil.getCurrentIdMember(),form.getItems());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/practics/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deletePractic(@PathVariable("id") Long id, HttpServletResponse response) {
        practicService.deletePractics(id,SecurityUtil.getCurrentIdMember());
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
