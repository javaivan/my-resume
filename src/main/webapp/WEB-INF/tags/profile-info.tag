<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-info-circle"></i> Additional info
            <sec:authorize access="isAuthenticated()">
                <sec:authentication var="principal" property="principal" />
                <c:if test="${member.id.equals(principal.id)}">
                    <a class="edit-block" href="/edit/info">Edit</a>
                </c:if>
            </sec:authorize>
        </h3>
    </div>
    <div class="panel-body text-justify">Married, Two children</div>
</div>