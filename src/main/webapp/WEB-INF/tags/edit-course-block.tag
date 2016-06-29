<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="course" required="false" type="com.ivanmix.resume.entity.Course"%>

<div id="ui-item-${course.id}" class="row ui-item course-item">
    <input type="hidden" name="items[${index }].id" value="${course.id }" />
    <div class="panel-body ui-item">
        <div class="row">
            <div class="col-xs-12">
                <button type="button" class="close" onclick="detiteEntity(${course.id });">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6 col-md-4 form-group ">
                <label class="control-label" for="items${index }name">Название курса*</label>
                <input type="text" class="form-control"  id="items${index }name" name="items[${index}].name" value="${course.name }" required="required"/>
            </div>
            <div class="col-xs-6 col-md-4 form-group">
                <label class="control-label" for="items${index }school">Название школы / площадки*</label>
                <input type="text" class="form-control"  id="items${index }school" name="items[${index }].school" value="${course.school }" required="required" />
            </div>
            <div class="col-xs-12 col-md-4 form-group">
                <label for="items${index }finishDate">Дата окончания</label>
                <div class="row">
                    <div class="col-xs-6">
                        <select id="items${index }finishDateMonth" name="items[${index }].finishDateMonth" class="form-control">
                            <c:forEach begin="1" end="12" var="i">
                                <option value="${i}" ${i == course.finishDateMonth ? ' selected="selected"' : ''}>${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-xs-6">

                        <select name="items[${index }].finishDateYear" class="form-control">
                            <c:forEach begin="1990" end="2016" var="i">
                                <option value="${i}" ${i == course.finishDateYear ? ' selected="selected"' : ''}>${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <form:errors path="items[${index}].*" cssClass="alert alert-danger" element="div" />
    </div>
</div>
