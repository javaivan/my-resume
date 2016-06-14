<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"  tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="language" required="false" type="com.ivanmix.resume.entity.Language"%>

<div id="ui-item-${language.id}" class="row ui-item language-item">
    <div class="panel-body">
        <div class="row">
            <div class="col-xs-12">
                <button type="button" class="close" onclick="detiteEntity(${language.id });"><span aria-hidden="true">&times;</span></button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-3 form-group">
                <div class="row">
                    <div class="col-xs-6 form-group" style="padding-right:0px;">
                        <input type="hidden" name="items[${index }].id" value="${language.id }" />
                        <strong>Тип</strong><br>
                        <select name="items[${index}].type" class="form-control">
                            <c:forEach var="type" items="${languageType }">
                                <option value="${type}" ${language.type==type ? ' selected="selected"': ''}>${type}</option>
                            </c:forEach>
                        </select>
                        <form:errors path="items[${index}].type" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-xs-6 form-group ${hasError ? 'has-error has-feedback' : ''}" style="padding-right:8px;">
                        <strong>Язык</strong>
                        <input class="form-control" type="text" name="items[${index}].name"  placeholder="Example: English" value="${language.name }" required="required" />
                        <form:errors path="items[${index}].name" cssClass="alert alert-danger" element="div" />
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-9">
                <strong>Уровень</strong><br>
                <select name="items[${index}].level" class="form-control">
                    <c:forEach var="level" items="${languageLevel }">
                        <option value="${level}" ${language.level==level ? ' selected="selected"': ''}>${level}</option>
                    </c:forEach>
                </select>
                <form:errors path="items[${index}].level" cssClass="alert alert-danger" element="div" />
            </div>
        </div>
    </div>
</div>