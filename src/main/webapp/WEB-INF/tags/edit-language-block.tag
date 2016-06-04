<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="language" required="false" type="com.ivanmix.resume.entity.Language"%>

<div id="ui-item-${language.id}" class="row ui-item language-item">


    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="items[${index }].id" value="${language.id }" />
        <strong>Тип</strong>
        <input type="text" name="items[${index}].type" value="${language.type }" />
        <form:errors path="items[${index}].type" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <strong>Язык</strong>
        <input type="text" name="items[${index}].name" value="${language.name }" />
        <form:errors path="items[${index}].name" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <button type="button" class="close" onclick="detiteEntity(${language.id });">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>Уровень</strong>
        <input type="text" name="items[${index}].level" value="${language.level }" />
        <form:errors path="items[${index}].level" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="row skill-delim" >
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
        </div>
    </div>
</div>