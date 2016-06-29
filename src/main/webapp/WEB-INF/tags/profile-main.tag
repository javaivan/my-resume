<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-primary">

	<c:choose>
		<c:when test="${showEdit }">
			<a href="/edit">
				<img alt="photo" src="${member.memberContact.photo}" class="img-responsive photo">
			</a>
			<h1 class="text-center"><a href="/edit" style="color:black;">${member.fullName}</a></h1>
		</c:when>
		<c:otherwise>
			<img alt="photo" src="${member.memberContact.photo}" class="img-responsive photo">
			<h1 class="text-center">${member.fullName}</h1>
		</c:otherwise>
	</c:choose>
	<h6 class="text-center">
		<strong>${member.memberContact.city}, ${member.memberContact.country}</strong>
	</h6>
<%--	<h6 class="text-center">
		<strong>Age:</strong> 27, <strong>Birthday: </strong> Feb 26, 1989
	</h6>--%>
	<div class="list-group contacts">
		<c:if test="${member.memberContact.phone != null }">
			<a class="list-group-item" href="tel:${member.memberContact.phone}"><i class="fa fa-phone"></i>${member.memberContact.phone}</a>
		</c:if>
		<a class="list-group-item" href="mailto:${member.email}"><i class="fa fa-envelope"></i> ${member.email}</a>

		<c:if test="${member.memberContact.memberContactSocial.skype != null }">
			<a class="list-group-item" href="javascript:void(0);"><i class="fa fa-skype"></i>${member.memberContact.memberContactSocial.skype}</a>
		</c:if>
		<c:if test="${member.memberContact.memberContactSocial.vkontakte != null }">
			<a target="_blank" class="list-group-item" href="${member.memberContact.memberContactSocial.vkontakte}"><i class="fa fa-vk"></i> ${member.memberContact.memberContactSocial.vkontakte}</a>
		</c:if>
		<c:if test="${member.memberContact.memberContactSocial.facebook != null }">
			<a target="_blank" class="list-group-item" href="${member.memberContact.memberContactSocial.facebook}"><i class="fa fa-facebook"></i> ${member.memberContact.memberContactSocial.facebook}</a>
		</c:if>
		<c:if test="${member.memberContact.memberContactSocial.linkedin != null }">
			<a target="_blank" class="list-group-item" href="${member.memberContact.memberContactSocial.linkedin}"><i class="fa fa-linkedin"></i> ${member.memberContact.memberContactSocial.linkedin}</a>
		</c:if>
		<c:if test="${member.memberContact.memberContactSocial.github != null }">
			<a target="_blank" class="list-group-item" href="${member.memberContact.memberContactSocial.github}"><i class="fa fa-github"></i> ${member.memberContact.memberContactSocial.github}</a>
		</c:if>
		<c:if test="${member.memberContact.memberContactSocial.skype != null }">
			<a target="_blank" class="list-group-item" href="${member.memberContact.memberContactSocial.stackoverflow}"><i class="fa fa-stack-overflow"></i> ${member.memberContact.memberContactSocial.stackoverflow}</a>
		</c:if>
	</div>
</div>