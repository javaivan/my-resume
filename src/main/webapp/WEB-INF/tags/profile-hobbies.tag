<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-heart"></i> Hobbi
			<c:if test="${showEdit }"><a href="/edit/hobbies" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<div class="hobbies">
			<table class="table table-bordered">
				<tbody>
				<tr>
					<td><i class="fa fa-heart"></i></td>
					<td>Computer games</td>
				</tr>
				<tr>
					<td><i class="fa fa-heart"></i></td>
					<td>Football</td>
				</tr>
				<tr>
					<td><i class="fa fa-heart"></i></td>
					<td>Handball</td>
				</tr>
				<tr>
					<td><i class="fa fa-heart"></i></td>
					<td>Shooting</td>
				</tr>
				<tr>
					<td><i class="fa fa-heart"></i></td>
					<td>Skateboarding</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>