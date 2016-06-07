<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"  tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Дополнительные контакты: Skype, ссылки на социальные профили, и т.д.</h4>
        <hr />
        <form action="/edit/contact-social" method="post" commandName="contactSocialForm">

            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>Skype</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.skype" value="${contactSocial.skype }" />
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>vkontakte</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.vkontakte" value="${contactSocial.vkontakte }" />
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>facebook</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.facebook" value="${contactSocial.facebook }" />
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>linkedin</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.linkedin" value="${contactSocial.linkedin }" />
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>github</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.github" value="${contactSocial.github }" />
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-5 col-sm-4 col-md-2"><strong>stackoverflow</strong></div>
                <div class="col-xs-7 col-sm-8 col-md-10">
                    <input type="text" name="memberContactSocial.stackoverflow" value="${contactSocial.stackoverflow }" />
                </div>
            </div>
            <input type="submit" value="submit">
        </form>
    </div>
</div>
