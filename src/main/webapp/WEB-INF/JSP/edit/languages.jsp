<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Уровни владения иностранными языками</h4>
        <hr />
        <form:form action="/edit/languages" method="post" commandName="languageForm" detiteEntityName="language">
            <sec:csrfInput/>
            <div id="ui-block-container" class="edit-languages">
                <c:forEach var="language" items="${languageForm.items}" varStatus="status">
                    <resume:edit-language-block index="${status.index}" language="${language}" />
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <a href="#" onclick="addNewEntity();" >+ Добавить навык</a>
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>