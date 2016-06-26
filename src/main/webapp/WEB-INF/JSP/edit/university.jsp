<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header text-center">Образование</h4>
        <hr />
        <form:form action="/edit/university" method="post" commandName="universityForm"  detiteEntityName="university">
            <sec:csrfInput/>
            <div id="ui-block-container">
                <c:forEach var="university" items="${universityForm.universities}" varStatus="status">
                    <resume:edit-university-block index="${status.index}" university="${university}" />
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