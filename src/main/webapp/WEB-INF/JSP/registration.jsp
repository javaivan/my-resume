<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-info small-center-block">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-user-plus"></i> Укажите Ваши персональные данные
        </h3>
    </div>
    <div class="panel-body">
        <form:form action="/registration" commandName="registrationForm" method="post">
            <form:errors path="*"  cssClass="alert alert-danger" element="div" />
            <div class="help-block text-justify">
                Имейте ввиду, что введенные Вами имя и фамилия не смогут быть изменены в будущем! Поэтому предоставляйте реальные имя и фамилию!
            </div>

            <div class="form-group">
                <label for="nickname">Прозвище</label>
                <input type="text" id="nickname" name="nickname" value="${registrationForm.nickname}"   class="form-control" placeholder="Example: Richard" required="required"/>
                <form:errors path="nickname" cssClass="alert alert-danger" element="div" />
            </div>


            <div class="form-group">
                <label for="firstName">Email</label>
                <input type="text" id="email" name="email" value="${registrationForm.email}"   class="form-control" placeholder="Example: example@example.com" required="required"/>
                <form:errors path="email" cssClass="alert alert-danger" element="div" />
            </div>


            <div class="form-group">
                <label for="firstName">Имя</label>
                <input type="text" id="firstName" name="firstName" value="${registrationForm.firstName}"   class="form-control" placeholder="Example: Richard" required="required"/>
                <form:errors path="firstName" cssClass="alert alert-danger" element="div" />
            </div>

            <div class="form-group">
                <label for="lastName">Фамилия</label>
                <input type="text" id="lastName" name="lastName" value="${registrationForm.lastName}"   class="form-control" placeholder="Example: Hendricks" required="required"/>
                <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
            </div>

            <div class="form-group">
                <label class="control-label" for="password">Новый пароль</label>
                <input type="password" id="password" name="password" value="${registrationForm.password}"   class="form-control" required="required"/>
                <form:errors path="password" cssClass="alert alert-danger" element="div" />
            </div>

            <div class="form-group ">
                <label class="control-label" for="confirmPassword">Подтверждение пароля</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value="${registrationForm.confirmPassword}"   class="form-control"  required="required"/>
                <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div" />
            </div>
            <button type="submit" class="btn btn-success">Зарегистрироваться</button>
            <a href="/fbSignUp" class="btn btn-primary pull-right"><i class="fa fa-facebook"></i>&nbsp;&nbsp;Sign up with Facebook</a>
        </form:form>
    </div>
</div>