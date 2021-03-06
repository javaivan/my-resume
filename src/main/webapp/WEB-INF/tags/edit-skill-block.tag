<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="skill" required="false" type="com.ivanmix.resume.entity.Skill"%>

<div id="ui-item-${skill.id}" class="row ui-item skill-item">
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="items[${index }].id" value="${skill.id }" />
        <select name="items[${index }].name" class="form-control">
            <c:forEach var="category" items="${skillCategories }">
                <option value="${category.name }" ${category.name == skill.name ? ' selected="selected"' : ''}>${category.name }</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-xs-7 col-sm-8 col-md-10 value-container">
        <button type="button" class="close" onclick="detiteEntity(${skill.id });">
            <span aria-hidden="true">&times;</span>
        </button>
        <textarea name="items[${index}].description" class="form-control pull-right" required="required" rows="2">${skill.description }</textarea>
    </div>
</div>

<div class="row skill-delim" >
    <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
        <form:errors path="items[${index}].description" cssClass="alert alert-danger" element="div" />
    </div>
</div>