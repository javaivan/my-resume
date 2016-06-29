<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>
<%@ attribute name="certificates" required="true" type="java.util.List" %>

<div class="panel panel-primary certificates">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-certificate"></i> Certificates
			<c:if test="${showEdit }"><a href="/edit/certificates" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="certificat" items="${certificates }">
			<a data-url="${certificat.bigImage }" data-title="${certificat.name }" href="#" class="thumbnail certificate-link">
				<img alt="${certificat.name }" src="${certificat.smallImage }" class="img-responsive">
				<span>${certificat.name }</span>
			</a>
			<div class="clear"></div>
		</c:forEach>
	</div>
</div>