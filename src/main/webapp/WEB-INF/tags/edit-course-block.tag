<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="сourse" required="false" type="com.ivanmix.resume.entity.Course"%>

<div id="ui-item-${сourse.id}" class="row ui-item сourse-item">
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="courses[${index }].id" value="${сourse.id }" />
        <input type="text" name="courses[${index}].name" value="${сourse.name }" />
    </div>
    <div class="col-xs-7 col-sm-8 col-md-10 value-container">
        <button type="button" class="close" onclick="detiteEntity(${сourse.id });">
            <span aria-hidden="true">&times;</span>
        </button>
        <input type="text" name="courses[${index }].school" value="${сourse.school }" />
    </div>
</div>

<div class="row сourse-delim" >
    <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
        <form:errors path="courses[${index}].school" cssClass="alert alert-danger" element="div" />
        <form:errors path="courses[${index}].name" cssClass="alert alert-danger" element="div" />
    </div>
</div>