<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="member" required="false" type="com.ivanmix.resume.entity.Member"%>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-code"></i> Technical Skills
            <sec:authorize access="isAuthenticated()">
                <sec:authentication var="principal" property="principal" />
                <c:if test="${member.id.equals(principal.id)}">
                    <a class="edit-block" href="/edit/practics">Edit</a>
                </c:if>
            </sec:authorize>
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <tbody>
            <tr>
                <th style="width: 140px;">Category</th>
                <th>Frameworks and technologies</th>
            </tr>
            <tr>
                <td>Languages</td>
                <td>Java, SQL, PLSQL</td>
            </tr>
            <tr>
                <td>DBMS</td>
                <td>Postgresql, Mysql</td>
            </tr>
            <tr>
                <td>Web</td>
                <td>HTML, CSS, JS, Bootstrap, JQuery, Foundation</td>
            </tr>
            <tr>
                <td>Java</td>
                <td>Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+
                    Social API, Threads, IO, JAXB, GSON</td>
            </tr>
            <tr>
                <td>IDE</td>
                <td>Eclipse for JEE Developer</td>
            </tr>
            <tr>
                <td>CVS</td>
                <td>Git, Github</td>
            </tr>
            <tr>
                <td>Web Servers</td>
                <td>Tomcat, Nginx</td>
            </tr>
            <tr>
                <td>Build system</td>
                <td>Maven</td>
            </tr>
            <tr>
                <td>Cloud</td>
                <td>AWS,OpenShift</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>