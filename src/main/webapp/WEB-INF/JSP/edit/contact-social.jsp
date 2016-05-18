<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

contacts profile
<form action="/edit/contact-social" method="post" commandName="contactSocialForm">

    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        Skype
        <input type="text" name="memberContactSocial.skype" value="${contactSocial.skype }" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        vkontakte
        <input type="text" name="memberContactSocial.vkontakte" value="${contactSocial.vkontakte }" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        facebook
        <input type="text" name="memberContactSocial.facebook" value="${contactSocial.facebook }" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        linkedin
        <input type="text" name="memberContactSocial.linkedin" value="${contactSocial.linkedin }" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        github
        <input type="text" name="memberContactSocial.github" value="${contactSocial.github }" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        stackoverflow
        <input type="text" name="memberContactSocial.stackoverflow" value="${contactSocial.stackoverflow }" />
    </div>

    <input type="submit" value="submit">
</form>