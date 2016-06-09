<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Новый пароль для аккаунта</h4>
        <hr />
        <form:form action="/edit/password" method="post" commandName="addInfoForm">
            <div id="ui-block-container">
                <input type="text" name="password" value="${changePasswordForm.password }" /><Br>
                <form:errors path="password" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>