<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-graduation-cap"></i> Education
			<sec:authorize access="isAuthenticated()">
				<sec:authentication var="principal" property="principal" />
				<c:if test="${member.id.equals(principal.id)}">
					<a class="edit-block" href="/edit/university">Edit</a>
				</c:if>
			</sec:authorize>
		</h3>
	</div>
	<div class="panel-body">
		<ul class="timeline">
			<li>
				<div class="timeline-badge warning">
					<i class="fa fa-graduation-cap"></i>
				</div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">The specialist degree in Electronic Engineering</h4>
						<p>
							<small class="dates"><i class="fa fa-calendar"></i> 2006 - 2011</small>
						</p>
					</div>
					<div class="timeline-body">
						<p>Computer Science, Kharkiv National Technical University, Ukraine</p>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>