<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="row skill-item">
    <div class="col-xs-5 col-sm-4 col-md-2 form-group">
        <input type="hidden" name="items[${id}].id" value="" />
        <select name="items[${id}].name" class="form-control">
            <c:forEach var="category" items="${skillCategories }">
                <option value="${category.name }">${category.name }</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-xs-7 col-sm-8 col-md-10 value-container">
        <textarea name="items[${id}].description" class="form-control pull-right" required="required" rows="2"></textarea>
    </div>
</div>
<div class="row skill-delim" >
    <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-2 col-xs-7 col-sm-8 col-md-10" style="padding-left:0px;">
    </div>
</div>