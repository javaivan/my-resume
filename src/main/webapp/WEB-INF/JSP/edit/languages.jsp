<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

languages profile


<form:form action="/edit/languages" method="post" commandName="courseForm">
    <div id="ui-block-container">


        <c:forEach var="languages" items="${languageForm.languages}" varStatus="status">


            <div id="ui-item-${status.index}" class="row ui-item languages-item">
                <input type="hidden" name="languages[${status.index }].id" value="${languages.id }" />

                <br>
                type
                <input type="text" name="languages[${status.index}].type" value="${languages.type }" />

                <br>
                name
                <input type="text" name="languages[${status.index}].name" value="${languages.name }" />

                <br>
                level
                <input type="text" name="languages[${status.index}].level" value="${languages.level }" />
            <hr><hr>
            </div>


        </c:forEach>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <a href="javascript:void(0);">+ Добавить Сертификат</a>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-xs-12 text-center">
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </div>
    </div>
</form:form>
