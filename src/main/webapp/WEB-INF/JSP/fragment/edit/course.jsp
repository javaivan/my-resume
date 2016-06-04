<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="row ui-item сourse-item">
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="courses[${id }].id" value="" />
        <input type="text" name="courses[${id}].name" value="" />
    </div>
    <div class="col-xs-7 col-sm-8 col-md-10 value-container">
        <input type="text" name="courses[${id}].school" value="" />
    </div>
</div>
<div class="row сourse-delim" >
    <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
    </div>
</div>