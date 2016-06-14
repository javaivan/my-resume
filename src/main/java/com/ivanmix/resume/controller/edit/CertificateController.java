package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.CertificateForm;
import com.ivanmix.resume.form.CourseForm;
import com.ivanmix.resume.form.UploadFileForm;
import com.ivanmix.resume.model.UploadCertificateResult;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.service.ImageProcessorService;
import com.ivanmix.resume.util.SecurityUtil;
import com.sun.glass.ui.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;


@Controller
public class CertificateController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private EditMemberService editMemberService;

    @Autowired
    private ImageProcessorService imageService;

    @RequestMapping(value="/edit/certificates", method=RequestMethod.GET)
    public String getEditCertificates(Model model){
        LOGGER.debug("certificates");
        model.addAttribute("certificateForm", new CertificateForm(editMemberService.listCertificates(SecurityUtil.getCurrentIdMember())));
        model.addAttribute("uploadFileForm", new UploadFileForm());
        return "edit/certificates";
    }
    /*
    @RequestMapping(value = "/fragment/edit/certificates/{id}", method = RequestMethod.GET)
    public String getAddCertificate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/certificates";
    }*/

    @RequestMapping(value = "/edit/certificates/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCertificate(@PathVariable("id") Long id,HttpServletResponse response) {
        LOGGER.debug("deleteCertificate" + id);
        editMemberService.deleteCertificate(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }



    @RequestMapping(value="/edit/certificates", method=RequestMethod.POST)
    public String saveEditCertificates(@Valid @ModelAttribute("uploadFileForm") UploadFileForm form, BindingResult bindingResult, Model model){
        LOGGER.debug("save certificates");
        if(bindingResult.hasErrors()){
            System.out.println("hasErrors");
            return "edit/certificates";
        }
        editMemberService.addCertificate(SecurityUtil.getCurrentIdMember(),form.getCertificate());
        System.out.println(form.getImages());
        return "redirect:/";
    }

/*
    @RequestMapping(value = "/edit/certificates/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public String uploadCertificate(@RequestParam("certificateFile") MultipartFile certificateFile) {
        return imageService.processNewCertificateImage(certificateFile);
    }

*/
}
