<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<resume:edit-tab-header selected="courses" />

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Курсы повышения квалифицации</h4>
        <hr />
        <form:form action="/edit/courses" method="post" commandName="courseForm" detiteEntityName="course">
            <div id="ui-block-container">
                <c:forEach var="course" items="${courseForm.items}" varStatus="status">
                    <resume:edit-course-block index="${status.index}" course="${course}" />
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