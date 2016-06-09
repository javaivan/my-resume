<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-book"></i> Courses
			<sec:authorize access="isAuthenticated()">
				<sec:authentication var="principal" property="principal" />
				<c:if test="${member.id.equals(principal.id)}">
					<a class="edit-block" href="/edit/courses">Edit</a>
				</c:if>
			</sec:authorize>
		</h3>
	</div>
	<div class="panel-body">
		<ul class="timeline">
			<li>
				<div class="timeline-badge success">
					<i class="fa fa-book"></i>
				</div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">Java Advanced Course at SourceIt</h4>
						<p>
							<small class="dates"><i class="fa fa-calendar"></i> <strong>Finish Date:</strong> <strong class="label label-danger">Not finished yet</strong> </small>
						</p>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>