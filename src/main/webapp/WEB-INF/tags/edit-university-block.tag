<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="university" required="false" type="com.ivanmix.resume.entity.University"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />

<div id="ui-item-${university.id}" class="row ui-item university-item">
    <input type="hidden" name="universities[${index}].id" value="${university.id}" />
    <div class="col-xs-12 col-sm-12 col-md-12 value-container">
        <button type="button" class="close" onclick="detiteEntity(${university.id });">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>Развернутая специалицация</strong>
        <textarea name="universities[${index}].description" class="form-control pull-right" required="required" rows="2">${university.description}</textarea>
        <form:errors path="universities[${index}].description" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="row" ><div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;"></div></div>
    <div class="col-xs-6 col-sm-6 col-md-6 form-group">
        <strong>Год поступления</strong>
        <select name="universities[${index }].beginYear" class="form-control">
            <c:forEach begin="1960" end="${year}" var="i">
                <option value="${i}" ${i == university.beginYear ? ' selected="selected"' : ''}>${i}</option>
            </c:forEach>
        </select>
        <form:errors path="universities[${index}].beginYear" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6 form-group">
        <strong>Год окончания</strong>
        <select name="universities[${index }].finishYear" class="form-control">
            <c:forEach begin="1960" end="${year}" var="i">
                <option value="${i}" ${i == university.finishYear ? ' selected="selected"' : ''}>${i}</option>
            </c:forEach>
        </select>
    </div>
    <div class="row" ><div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;"></div></div>
    <div class="col-xs-6 col-sm-6 col-md-6 value-container">
        <strong>Университет</strong>
        <input type="text" name="universities[${index}].name" value="${university.name}" />
        <form:errors path="universities[${index}].name" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6 value-container">
        <strong>Факультет</strong>
        <input type="text" name="universities[${index}].faculty" value="${university.faculty}" />
        <form:errors path="universities[${index}].faculty" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="row" ><div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;"><br></div></div>
</div>