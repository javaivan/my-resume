<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Некоторые работодатели уделяют внимание на хобби кандидата</h4>
        <hr />
        <form:form action="/edit/hobbies" method="post" commandName="hobbyForm">
            <div id="ui-block-container" class="hobby_box">
                <c:forEach var="hobby" items="${hobbyItem}" varStatus="status">
                    <input type="checkbox" name="items[${status.index}].name" value="${hobby.name}" id="hobbies_${status.index}">
                    <label for="hobbies_${status.index}">${hobby.name}</label>
                </c:forEach>
                <hr>
                <script>
                    var  checkboxChecked = [<c:forEach var="hobby" items="${hobbyForm.items}" varStatus="status">"${hobby.name}",</c:forEach>];
                </script>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>