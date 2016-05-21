<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

courses profile


<form:form action="/edit/university" method="post" commandName="courseForm">
    <div id="ui-block-container">


        <c:forEach var="universities" items="${universityForm.universities}" varStatus="status">


            <div id="ui-item-${status.index}" class="row ui-item educations-item">
                <input type="hidden" name="universities[${status.index }].id" value="${universities.id }" />

                <br>
                description
                <input type="text" name="universities[${status.index}].description" value="${universities.description }" />

                <br>
                name
                <input type="text" name="universities[${status.index}].name" value="${universities.name }" />

                <br>
                faculty
                <input type="text" name="universities[${status.index}].faculty" value="${universities.faculty }" />



                <br>
                beginYear
                <input type="text" name="universities[${status.index}].beginYear" value="${universities.beginYear }" />


                <br>
                finishYear
                <input type="text" name="universities[${status.index}].finishYear" value="${universities.finishYear }" />

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
