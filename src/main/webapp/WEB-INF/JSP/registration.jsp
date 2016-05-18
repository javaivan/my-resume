<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>

registration

<form action="/registration" method="post" commandName="member">

    <input type="text" name="firstName" value="${member.firstName }" />
    <span span:if="${fields.hasErrors('firstName')}" span:errors="*{firstName}">firstName Error</span>

    <input type="text" name="lastName" value="${member.lastName }" />
    <span span:if="${fields.hasErrors('lastName')}" span:errors="*{lastName}">lastName Error</span>

    <input type="text" name="email" value="${member.email }" />
    <span span:if="${fields.hasErrors('email')}" span:errors="*{email}">email Error</span>

    <input type="text" name="password" value="${member.password }" />
    <span span:if="${fields.hasErrors('password')}" span:errors="*{password}">password Error</span>

    <input type="submit" class="btn btn-primary" value="Сохранить">
</form>