<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="certificate" required="false" type="com.ivanmix.resume.entity.Certificate"%>

<div id="ui-item-${certificate.id}" class="row ui-item certificates-item">
    <div class="col-xs-12 col-sm-12 col-md-12 value-container">
        <input type="hidden" name="items[${index}].id" value="${certificate.id }" />
        <input type="text" name="items[${index}].name" value="${certificate.name }" />
        <form:errors path="items[${index}].name" cssClass="alert alert-danger" element="div" />
        <input type="text" name="items[${index}].images" value="${certificate.images }" />
        <form:errors path="items[${index}].images" cssClass="alert alert-danger" element="div" />
        <button type="button" class="close" onclick="detiteEntity(${certificate.id});">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <br>
</div>
