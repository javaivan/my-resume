<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-language"></i> Foreign languages
            <c:if test="${showEdit }"><a href="/edit/languages" class="edit-block">Edit</a></c:if>
        </h3>
    </div>
    <div class="panel-body">
        <strong>English:</strong> Intermediate<br>
    </div>
</div>