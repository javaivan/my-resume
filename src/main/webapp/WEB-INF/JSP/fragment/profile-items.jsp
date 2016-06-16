<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="profile" items="${profiles }">
    <div class="panel panel-default profile-item">
        <div class="media panel-body">
            <div class="media-left media-top">
                <a href="/${profile.id }">${profile.id }</a>
            </div>
            <div class="media-body search-result-item">
                <a href="/${profile.id }" class="btn btn-primary pull-right">Детали</a>
                <h4 class="media-heading">
                    <a href="/${profile.id }">${profile.id}) ${profile.fullName }</a>
                </h4>
                <strong>${profile.id }</strong>
                <p>${profile.id },${profile.id }</p>
                <blockquote>
                    <small>${profile.id }</small>
                </blockquote>
            </div>
        </div>
    </div>
</c:forEach>