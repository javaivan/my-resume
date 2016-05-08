<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<div class="panel panel-primary">
	<a href="/edit"><img class="img-responsive photo" src="/media/avatar/7dd3413a-b88a-4037-bcbd-f217db454082.jpg" alt="photo"></a>
	<h1 class="text-center">
		<a style="color: black;" href="/edit">${member.email}</a>
	</h1>
	<h2>${uid}</h2>
	<select name="members" class="form-control">
		<c:forEach var="m" items="${members}">
			<option value="${m.id}">${m.id}</option>
		</c:forEach>
	</select>

	<select name="category" class="form-control">
		<c:forEach var="category" items="${skillCategories }">
			<option value="${category.id }">${category.name }</option>
		</c:forEach>
	</select>

	<h6 class="text-center">
		<strong>Odessa, Ukraine</strong>
	</h6>
	<h6 class="text-center">
		<strong>Age:</strong> 27, <strong>Birthday: </strong> Feb 26, 1989
	</h6>
	<div class="list-group contacts">
		<a class="list-group-item" href="tel:+380507525137"><i class="fa fa-phone"></i> +380507525137</a>
		<a class="list-group-item" href="mailto:richard-hendricks@gmail.com"><i class="fa fa-envelope"></i> richard-hendricks@gmail.com</a>
		<a class="list-group-item" href="javascript:void(0);"><i class="fa fa-skype"></i>richard-hendricks</a>
		<a target="_blank" class="list-group-item" href="https://vk.com/richard-hendricks"><i class="fa fa-vk"></i> https://vk.com/richard-hendricks</a>
		<a target="_blank" class="list-group-item" href="https://facebook.com/richard-hendricks"><i class="fa fa-facebook"></i> https://facebook.com/richard-hendricks</a>
		<a target="_blank" class="list-group-item" href="https://linkedin.com/richard-hendricks"><i class="fa fa-linkedin"></i> https://linkedin.com/richard-hendricks</a>
		<a target="_blank" class="list-group-item" href="https://github.com/richard-hendricks"><i class="fa fa-github"></i> https://github.com/richard-hendricks</a>
		<a target="_blank" class="list-group-item" href="https://stackoverflow.com/richard-hendricks"><i class="fa fa-stack-overflow"></i> https://stackoverflow.com/richard-hendricks</a>
	</div>
</div>