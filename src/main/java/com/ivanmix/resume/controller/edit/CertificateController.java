package com.ivanmix.resume.controller.edit;

import com.ivanmix.resume.form.CertificateForm;
import com.ivanmix.resume.form.UploadFileForm;
import com.ivanmix.resume.model.UploadImage;
import com.ivanmix.resume.service.EditMemberCertificateService;
import com.ivanmix.resume.service.EditMemberService;
import com.ivanmix.resume.service.ImageUploadService;
import com.ivanmix.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class CertificateController {

    @Autowired
    private EditMemberCertificateService certificateService;

    @Autowired
    private ImageUploadService imageUploadService;

    @RequestMapping(value="/edit/certificates", method=RequestMethod.GET)
    public String getEditCertificates(Model model){
        model.addAttribute("certificateForm", new CertificateForm(certificateService.listCertificates(SecurityUtil.getCurrentIdMember())));
        model.addAttribute("uploadFileForm", new UploadFileForm());
        return "edit/certificates";
    }

    @RequestMapping(value = "/edit/certificates/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCertificate(@PathVariable("id") Long id,HttpServletResponse response) {
        certificateService.deleteCertificate(id,SecurityUtil.getCurrentIdMember());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        return "successfully";
    }

    @RequestMapping(value="/edit/certificates", method=RequestMethod.POST)
    public String saveEditCertificates(@Valid @ModelAttribute("uploadFileForm") UploadFileForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "edit/certificates";
        }
        certificateService.addCertificate(SecurityUtil.getCurrentIdMember(),form.getCertificate());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/certificates/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadCertificate(@RequestParam("certificateFile") MultipartFile file,@RequestParam("certificateName") String certificateName) {
        UploadImage image = imageUploadService.uploadNewImage(file);
        certificateService.addCertificate(SecurityUtil.getCurrentIdMember(),certificateName, image);
        return "success";
    }

    @RequestMapping(value = "/fragment/edit/certificates/{id}", method = RequestMethod.GET)
    public String getAddCourses(@PathVariable("id") Long id, Model model) {
        model.addAttribute("index", id);
        return "fragment/edit/certificates";
    }
}
