<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="row course-item">
    <div class="panel-body ui-item">
        <div class="row">
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Должность</strong>
                <br>
                <input type="hidden" name="items[${index }].id" value="" />
                <input class="form-control" type="text" name="items[${index}].position" value="" />
            </div>
            <div class="col-xs-12 col-md-6 form-group ">
                <strong>Компания или организация</strong>
                <br>
                <input class="form-control" type="text" name="items[${index }].company" value="" />
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <strong>Обязаности/Достижения</strong>
                <br>
                <textarea class="form-control" name="items[${index}].responsibilities"></textarea>
            </div>

            <div class="col-xs-12 col-md-6 form-group">
                <strong>Дата начала</strong>
                <br>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].beginDateMonth" class="form-control">
                        <c:forEach begin="1" end="12" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].beginDateYear" class="form-control">
                        <c:forEach begin="1990" end="2016" var="i">
                            <option value="${i}">${i}</option>
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
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <select name="items[${index }].finishDateYear" class="form-control">
                        <c:forEach begin="1990" end="2016" var="i">
                            <option value="${i}"}>${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Ссылка на Демо</strong>
                <br>
                <input class="form-control" type="text" name="items[${index}].demo" value="" />
            </div>
            <div class="col-xs-12 col-md-6 form-group">
                <strong>Исходный код</strong>
                <br>
                <input class="form-control" type="text" name="items[${index }].src" value="" />
            </div>
        </div>
    </div>
</div>