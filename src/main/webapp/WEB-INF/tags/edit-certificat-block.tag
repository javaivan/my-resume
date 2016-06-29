<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="certificate" required="false" type="com.ivanmix.resume.entity.Certificate"%>


<div id="ui-item-${certificate.id}" class="thumbnail ui-item certificates-item">
    <input type="hidden" name="items[${index }].id" 	value="${certificate.id}" />
    <input type="hidden" name="items[${index }].bigImage" 	value="${certificate.bigImage}" />
    <input type="hidden" name="items[${index }].smallImage" 	value="${certificate.smallImage}" />
    <input type="hidden" name="items[${index }].name" 		value="${name}" />


    <a class="certificate-link" href="#" data-title="${certificate.name}" data-url="${certificate.bigImage}">
        <img class="img-responsive" src="${certificate.smallImage}" alt="${certificate.name}">
        <span>${certificate.name}</span>
    </a>

    <button type="button" class="close" onclick="detiteEntity(${certificate.id});">
        <span aria-hidden="true">&times;</span>
    </button>
</div>