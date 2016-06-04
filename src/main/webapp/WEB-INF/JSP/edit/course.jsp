<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Курсы повышения квалифицации</h4>
        <hr />
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-xs-5 col-sm-4 col-md-2 text-center"><strong>Название Курса*</strong></div>
            <div class="col-xs-7 col-sm-8 col-md-10 text-center"><strong>Название школы / плащадки*</strong></div>
        </div>
        <form:form action="/edit/courses" method="post" commandName="courseForm" detiteEntityName="course">
            <div id="ui-block-container">
                <c:forEach var="сourse" items="${courseForm.courses}" varStatus="status">
                    <resume:edit-course-block index="${status.index}" сourse="${сourse}" />
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