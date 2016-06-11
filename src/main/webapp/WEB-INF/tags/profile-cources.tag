<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-book"></i> Courses
			<c:if test="${showEdit }"><a href="/edit/courses" class="edit-block">Edit</a></c:if>
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