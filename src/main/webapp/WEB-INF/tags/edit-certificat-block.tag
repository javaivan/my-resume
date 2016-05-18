<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"	tagdir="/WEB-INF/tags"%>

<%@ attribute name="index" required="true" type="java.lang.Object"%>
<%@ attribute name="certificat" required="false" type="com.ivanmix.resume.entity.Certificate"%>

<div id="ui-item-${index}" class="row ui-item certificates-item">
    <input type="hidden" name="certificates[${index }].id" value="${certificat.id }" />
    <input type="text" name="certificates[${index}].name" value="${certificat.name }" />
    <input type="text" name="certificates[${index }].images" value="${certificat.images }" />

</div>