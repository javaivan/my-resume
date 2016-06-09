<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Rickhard Hendricks</h4>

        <form:form action="/edit/photo" method="post" commandName="uploadPhotoForm" enctype="multipart/form-data">
            <input type="file" name="images" value="${uploadFileForm.images}" />
            <form:errors path="images" cssClass="alert alert-danger" element="div" />
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form:form><br><br>
        <form:form action="/edit" method="post" commandName="contactForm" detiteEntityName="skill">
            <div id="ui-block-container">
                <div class="col-xs-12 col-sm-12 col-md-12 value-container">
                    <strong>Страна</strong><br>
                    <input type="text" name="items.country" value="${contactForm.country}" />
                    <form:errors path="country" cssClass="alert alert-danger" element="div" />
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 value-container">
                    <strong>Город</strong><br>
                    <input type="text" name="items.city" value="${contactForm.city}" />
                    <form:errors path="city" cssClass="alert alert-danger" element="div" />
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 value-container">
                    <strong>Телефон</strong><br>
                    <input type="text" name="items.phone" value="${contactForm.phone}" />
                    <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 value-container">
                    <strong>Желаемая должность</strong><br>
                    <input type="text" name="items.objective" value="${contactForm.objective}" />
                    <form:errors path="objective" cssClass="alert alert-danger" element="div" />
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 value-container">
                    <strong>Ваша квалификация</strong><br>
                    <textarea name="items.qualification" class="form-control pull-right" required="required" rows="2">${contactForm.qualification}</textarea>
                    <form:errors path="qualification" cssClass="alert alert-danger" element="div" />
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>