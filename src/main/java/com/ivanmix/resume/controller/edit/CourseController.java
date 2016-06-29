package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.CourseForm;
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
public class CourseController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;

    @RequestMapping(value="/edit/courses", method= RequestMethod.GET)
    public String getEditCourses(Model model){
        LOGGER.debug("courses");
        model.addAttribute("courseForm", new CourseForm(editMemberService.listCourses(SecurityUtil.getCurrentIdMember())));
        return "edit/course";
    }
    @RequestMapping(value="/edit/courses", method=RequestMethod.POST)
    public String saveEditCourses(@Valid @ModelAttribute("courseForm") CourseForm form, BindingResult bindingResult, Model model) {
        LOGGER.debug("save courses");
        if (bindingResult.hasErrors()) {
            return "edit/course";
        }
        editMemberService.updateCourses(SecurityUtil.getCurrentIdMember(),form.getItems());
        return "redirect:/";
    }

    @RequestMapping(value = "/fragment/edit/courses/{id}", method = RequestMethod.GET)
    public String getAddCourses(@PathVariable("id") Long id, Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/course";
    }

    @RequestMapping(value = "/edit/courses/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCourse(@PathVariable("id") Long id,HttpServletResponse response) {
        LOGGER.debug("deleteSkills" + id);
        editMemberService.deleteCourse(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }



}
