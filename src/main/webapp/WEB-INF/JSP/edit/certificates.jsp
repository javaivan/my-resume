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


        <form:form action="/edit/certificates" method="post" commandName="uploadFileForm" enctype="multipart/form-data">
            <input type="text" name="name" value="${uploadFileForm.name}" />
            <form:errors path="name" cssClass="alert alert-danger" element="div" />
            <input type="file" name="images" value="${uploadFileForm.images}" />
            <form:errors path="images" cssClass="alert alert-danger" element="div" />
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form:form>
    </div>
</div><%--
<a href="javascript:resume.certificates.showUploadDialog();">+ Добавить сертификат</a>
<form:form action="/edit/certificates/upload" method="post" commandName="certificateForm" detiteEntityName="certificate">
    <div id="certificateUploader" class="modal fade" role="dialog" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Загрузить файл сертификата</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 form-group">
                            <input id="certificateFile" name="certificateFile" type="file" multiple placeholder="Выберите файл-картинку сертификата" >
                        </div>
                        <div class="col-xs-12 form-group">
                            <input id="certificateName" name="certificateName" class="form-control" placeholder="Название сертификата" required="required">
                        </div>
                        <div class="col-xs-12 text-center">
                            <a href="javascript:resume.certificates.add()" class="btn btn-primary" >Добавить сертификат</a>
                        </div>

                        <input type="submit" class="btn btn-primary" value="Сохранить">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="submit" class="btn btn-primary" value="Сохранить">
</form:form>
--%>