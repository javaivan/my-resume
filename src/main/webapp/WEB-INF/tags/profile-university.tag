<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<%@ attribute name="universities" required="true" type="java.util.List" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-graduation-cap"></i> Education
			<c:if test="${showEdit }"><a href="/edit/university" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<ul class="timeline">
			<c:forEach var="university" items="${universities }">
			<li>
				<div class="timeline-badge warning">
					<i class="fa fa-graduation-cap"></i>
				</div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">${university.description }</h4>
						<p>
							<small class="dates"><i class="fa fa-calendar"></i>
									${university.beginYear } -
							</small>
						</p>
					</div>
					<div class="timeline-body">
						<p>${university.faculty }, ${university.name }</p>
					</div>
				</div>
			</li>
			</c:forEach>

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