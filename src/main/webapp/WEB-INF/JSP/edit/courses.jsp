<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

courses profile


    <form:form action="/edit/courses" method="post" commandName="courseForm">
        <div id="ui-block-container">


            <c:forEach var="courses" items="${courseForm.courses}" varStatus="status">


                <div id="ui-item-${status.index}" class="row ui-item courses-item">
                    <input type="hidden" name="courses[${status.index }].id" value="${courses.id }" />
                    <input type="text" name="courses[${status.index}].name" value="${courses.name }" />
                    <input type="text" name="courses[${status.index }].school" value="${courses.school }" />

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
