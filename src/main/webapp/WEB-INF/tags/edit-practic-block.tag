<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="practic" required="false" type="com.ivanmix.resume.entity.Practic"%>

<div id="ui-item-${practic.id}" class="row ui-item course-item">
    <div class="panel-body ui-item">
        <div class="row">
            <div class="col-xs-12">
                <button type="button" class="close" onclick="detiteEntity(${practic.id });">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Должность</strong>
                <br>
                <input type="hidden" name="items[${index }].id" value="${practic.id }" />
                <input class="form-control" type="text" name="items[${index}].position" value="${practic.position }" />
                <form:errors path="items[${index}].position" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="col-xs-12 col-md-6 form-group ">
                <strong>Компания или организация</strong>
                <br>
                <input class="form-control" type="text" name="items[${index }].company" value="${practic.company}" />
                <form:errors path="items[${index}].company" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Дата начала</strong>
                <br>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].beginDateMonth" class="form-control">
                        <c:forEach begin="1" end="12" var="i">
                            <option value="${i}" ${i == practic.beginDateMonth ? ' selected="selected"' : ''}>${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].beginDateYear" class="form-control">
                        <c:forEach begin="1990" end="2016" var="i">
                            <option value="${i}" ${i == practic.beginDateYear ? ' selected="selected"' : ''}>${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 form-group ">
                <strong>Дата завершения</strong>
                <br>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].finishDateMonth" class="form-control">
                        <c:forEach begin="1" end="12" var="i">
                            <option value="${i}" ${i == practic.finishDateMonth ? ' selected="selected"' : ''}>${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].finishDateYear" class="form-control">
                        <c:forEach begin="1990" end="2016" var="i">
                            <option value="${i}" ${i == practic.finishDateYear ? ' selected="selected"' : ''}>${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-12 col-md-12">
                <strong>Обязаности/Достижения</strong>
                <br>
                <textarea class="form-control" name="items[${index}].responsibilities">${practic.responsibilities}</textarea>
                <form:errors path="items[${index}].responsibilities" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Ссылка на Демо</strong>
                <br>
                <input class="form-control" type="text" name="items[${index}].demo" value="${practic.demo }" />
                <form:errors path="items[${index}].demo" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Исходный код</strong>
                <br>
                <input class="form-control" type="text" name="items[${index }].src" value="${practic.src }" />
                <form:errors path="items[${index}].src" cssClass="alert alert-danger" element="div" />
            </div>
        </div>
    </div>
</div>