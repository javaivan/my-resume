<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>




<div class="thumbnail ui-item certificates-item">
    <input type="hidden" id="certificates-id" name="items[${index}].id" 	value="" />
    <input type="hidden" id="certificates-smallUrl" name="items[${index}].smallUrl" 	value="" />
    <input type="hidden" id="certificates-largeUrl" name="items[${index}].largeUrl" 	value="" />
    <input type="hidden" id="certificates-name" name="items[${index}].name" 		value="" />

    <a class="certificate-link" href="#" data-title="" data-url="">
        <img class="img-responsive" src="" alt="">
        <span></span>
    </a>
</div>