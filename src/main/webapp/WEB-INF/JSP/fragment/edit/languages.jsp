<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="row ui-item language-item">
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="items[${index }].id" value="" />
        <strong>Тип</strong>
        <input type="text" name="items[${index}].type" value="" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <strong>Язык</strong>
        <input type="text" name="items[${index}].name" value="" />
    </div>
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <strong>Уровень</strong>
        <input type="text" name="items[${index}].level" value="" />
    </div>
    <div class="row skill-delim" >
        <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
        </div>
    </div>
</div>