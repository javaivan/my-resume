<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<div class="panel panel-info small-center-block">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-unlock-alt"></i> Новый пароль для аккаунта
        </h3>
    </div>
    <div class="panel-body edit-password">
        <form:form action="/edit/password" commandName="passwordForm" method="post">
            <form:errors path="*"  cssClass="alert alert-danger" element="div" />

            <div class="help-block">Введите Ваш новый пароль и подтвердите его </div>
            <div class="form-group">
                <label class="control-label" for="password">Новый пароль</label>
                <input type="password" id="password" name="password" value="${passwordForm.password}"   class="form-control" required="required"/>
                <form:errors path="password" cssClass="alert alert-danger" element="div" />
            </div>


            <div class="form-group">
                <label class="control-label" for="confirmPassword">Подтверждение пароля</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value="${passwordForm.confirmPassword}"   class="form-control"  required="required"/>
                <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div" />
            </div>
            <button type="submit" class="btn btn-primary">Обновить пароль</button>
        </form:form>
    </div>
</div>