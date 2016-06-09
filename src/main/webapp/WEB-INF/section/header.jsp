<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <h1 class="logo"><a href="/">My Resume</a></h1>
            </div>
            <div class="col-md-6 col-sm-6">
                <div class="search_holder">
                    <form>
                        <input type="text" placeholder="Search">
                        <input type="submit" value="Найти">
                    </form>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="principal" property="principal" />
                    <ul class="account_nav">
                        <li>${principal.username}</li>
                        <li><a href="/${principal.id}">Мой профиль</a></li>
                        <li><a href="/edit">Изменить</a></li>
                        <li><a href="/edit/password">Пароль</a></li>
                        <li><a href="/logout">Выйти</a></li>
                    </ul>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <ul class="account_nav">
                        <li><a href="/login">Войти</a></li>
                        <li><a href="/registration">Зарегистророватся</a></li>
                    </ul>
                </sec:authorize>
            </div>
        </div>
    </div>
</header>