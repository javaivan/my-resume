<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<resume:edit-tab-header selected="hobbies" />

<div id="hobbyContainer" class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Некоторые работодатели уделяют внимание на хобби кандидата</h4>
     <%--   <h6 class="text-center help-block">Выберите не более &lt;%&ndash;${maxHobbies}&ndash;%&gt; пунктов!</h6>--%>
        <hr />
        <form:form action="/edit/hobbies" method="post" commandName="hobbies">
            <div id="ui-block-container" class="row"  <%--data-max-hobbies="${maxHobbies}"--%>>
                <c:forEach var="hobby" items="${hobbies}" varStatus="status">
                    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                        <input type="checkbox" name="items[${status.index}].name" value="${hobby.name}" ${hobby.selected ? 'checked' : '' } id="hobbies_${status.index}">
                        <label for="hobbies_${status.index}" class="fa hobby hobby-${hobby.cssClassName }">${hobby.name}</label>
                    </div>
                </c:forEach>
            </div>
            <hr />
            <div id="errorAlert" class="alert alert-danger" role="alert" style="display:none;">
                <button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>Ошибка сохранения!</strong> Выберите не более <%--${maxHobbies}--%> пунктов!
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
    <script>
        var  checkboxChecked = [<%--<c:forEach var="hobby" items="${hobbyForm.items}" varStatus="status">"${hobby.name}",</c:forEach>--%>];
    </script>
</div>





<%--

<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Некоторые работодатели уделяют внимание на хобби кандидата</h4>
        <hr />
        <form:form action="/edit/hobbies" method="post" commandName="hobbies">
            <div id="uier" class="hobby_box">
                <c:forEach var="hobby" items="${hobbies}" varStatus="status">
                    <input type="checkbox" name="items[${status.index}].name" value="${hobby.name}" id="hobbies_${status.index}">
                    <label for="hobbies_${status.index}">${hobby.name}</label>
                </c:forEach>
                <hr>
                <script>
                    var  checkboxChecked = [&lt;%&ndash;<c:forEach var="hobby" items="${hobbyForm.items}" varStatus="status">"${hobby.name}",</c:forEach>&ndash;%&gt;];
                </script>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>--%>
