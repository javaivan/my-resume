<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<c:set var="showEdit" value="${principal.id == member.id}" />
</sec:authorize>


<div class="container">
	<div class="row">
		<div class="col-md-4 col-sm-6">
			<resume:profile-main
					showEdit="${showEdit}" />
			<div class="hidden-xs">
				<resume:profile-languages
						showEdit="${showEdit}" />
				<resume:profile-hobbies
						showEdit="${showEdit}" />
				<resume:profile-info
						showEdit="${showEdit}" />
			</div>
		</div>
		<div class="col-md-8 col-sm-6">
			<resume:profile-objective
					showEdit="${showEdit}" />
			<resume:profile-skills
					showEdit="${showEdit}" />
			<resume:profile-practics
					showEdit="${showEdit }" />
			<resume:profile-certificates
					showEdit="${showEdit}"/>
			<resume:profile-cources
					showEdit="${showEdit}" />
			<resume:profile-university
					showEdit="${showEdit}" />
		</div>
		<div class="col-xs-12 visible-xs-block">
			<resume:profile-languages
					showEdit="${showEdit}" />
			<resume:profile-hobbies
					showEdit="${showEdit}" />
			<resume:profile-info
					showEdit="${showEdit}" />
		</div>
	</div>
</div>