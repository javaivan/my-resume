<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>

registration
<br>
<form action="/registration" method="post" commandName="member">
    firstName<br>
    <input type="text" name="firstName" value="${member.firstName }" />
    <br>
    lastName <br>
    <input type="text" name="lastName" value="${member.lastName }" />
    <br>
    email<br>
    <input type="text" name="email" value="${member.email }" />
    <br>
    password<br>
    <input type="text" name="password" value="${member.password }" />
    <br>
    <input type="submit" class="btn btn-primary" value="Сохранить">
</form>