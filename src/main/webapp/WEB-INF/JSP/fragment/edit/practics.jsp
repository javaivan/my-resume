<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div id="ui-item-${index}" class="row ui-item сourse-item">
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Должность</strong>
        <br>
        <input type="hidden" name="practics[${index }].id" value="" />
        <input class="form-control" type="text" name="practics[${index}].position" value="" />
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Компания или организация</strong>
        <br>
        <input class="form-control" type="text" name="practics[${index }].company" value="" />
        <form:errors path="practics[${index}].company" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-12 col-sm-12 col-md-12">
        <strong>Обязаности/Достижения</strong>
        <br>
        <textarea class="form-control" name="practics[${index}].responsibilities"></textarea>
        <form:errors path="practics[${index}].responsibilities" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Дата начала</strong>
        <br>
        <div class="col-xs-6 col-sm-6 col-md-6">
            <select name="practics[${index }].beginDateMonth" class="form-control">
                <c:forEach begin="1" end="12" var="i">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6">
            <select name="practics[${index }].beginDateYear" class="form-control">
                <c:forEach begin="1990" end="2016" var="i">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Дата завершения</strong>
        <br>
        <div class="col-xs-6 col-sm-6 col-md-6">
            <select name="practics[${index }].finishDateMonth" class="form-control">
                <c:forEach begin="1" end="12" var="i">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6">
            <select name="practics[${index }].finishDateYear" class="form-control">
                <c:forEach begin="1990" end="2016" var="i">
                    <option value="${i}"}>${i}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Ссылка на Демо</strong>
        <br>
        <input class="form-control" type="text" name="practics[${index}].demo" value="" />
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <strong>Исходный код</strong>
        <br>
        <input class="form-control" type="text" name="practics[${index }].src" value="" />
    </div>
</div><br><br>