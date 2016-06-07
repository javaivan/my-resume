<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Сертификаты</h4>
        <hr />
        <form:form action="/edit/certificates" method="post" commandName="certificateForm" detiteEntityName="certificate">
            <div id="ui-block-container">
                <c:forEach var="certificate" items="${certificateForm.items}" varStatus="status">
                    <resume:edit-certificat-block
                            index="${status.index}"
                            certificate="${certificate}" />
                </c:forEach>
            </div>
        </form:form>
        <br>
        <hr>
        <div th:if="${message}">
            <h2 th:text="${message}"/>

        <form:form action="/edit/certificates" method="post" commandName="uploadFileForm" enctype="multipart/form-data">
            <input type="text" name="name" value="${uploadFileForm.name}" />
            <form:errors path="name" cssClass="alert alert-danger" element="div" />
            <input type="file" name="images" value="${uploadFileForm.images}" />
            <form:errors path="images" cssClass="alert alert-danger" element="div" />
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form:form>

    </div>
</div>