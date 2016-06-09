<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary certificates">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-certificate"></i> Certificates
			<sec:authorize access="isAuthenticated()">
				<sec:authentication var="principal" property="principal" />
				<c:if test="${member.id.equals(principal.id)}">
					<a class="edit-block" href="/edit/certificates">Edit</a>
				</c:if>
			</sec:authorize>
		</h3>
	</div>
	<div class="panel-body">
		<a data-url="/media/certificates/10e5b86b-fd5b-490a-9090-6e71270ed40f.jpg" data-title="Jee certificate" href="#" class="thumbnail certificate-link">
			<img alt="Jee certificate" src="/media/certificates/10e5b86b-fd5b-490a-9090-6e71270ed40f-sm.jpg" class="img-responsive"> <span>Jee certificate</span>
		</a>
	</div>
</div>