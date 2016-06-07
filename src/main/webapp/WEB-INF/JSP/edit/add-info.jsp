<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">О Себе</h4>
        <hr />
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-xs-12 col-sm-12 col-md-12 text-center"><strong>Несколько слов о себе, которые предоставят Вам преимущества перед другими кандидатами</strong></div>
        </div>
        <form:form action="/edit/add-info" method="post" commandName="addInfoForm">
            <div id="ui-block-container">
                <textarea name="description" class="form-control pull-right" required="required" rows="2">${description}</textarea>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>
