<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume"  tagdir="/WEB-INF/tags"%>




<div class="panel panel-default">
    <div class="panel-body">
        <h4 class="data-header">Дополнительные контакты: skype, ссылки на социальные профили, и т.д. </h4>
        <form action="/edit/contact-social" method="post" commandName="contactSocialForm">
            <div class="row">
                <div class="col-sm-7">
                    <div class="form-group">
                        <label for="inputSkype" class="col-sm-4 control-label">Skype</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputSkype" name="memberContactSocial.skype" value="${contactSocial.skype }" />
                        </div>
                    </div>
                </div>
                <div class="col-sm-5 help-block">
                    <blockquote>
                        1. Желательно, чтобы skype содержал Ваше имя и фамилию как указано в загран паспорте. Если указанное имя уже занято, возможны сокращения.<br />
                        2. Не рекомендуется использовать креативные skype, например TheBestDeveloper, lackomka, etc.<br />
                        3. Если у Вас нет адекватного skype-имени, значит пришло время его создать
                    </blockquote>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-7">
                    <div class="form-group}">
                        <label for="inputVkontakte" class="col-sm-4 control-label">Vkontakte</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputVkontakte" name="memberContactSocial.vkontakte" value="${contactSocial.vkontakte }" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFacebook" class="col-sm-4 control-label">Facebook</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputFacebook" name="memberContactSocial.facebook" value="${contactSocial.facebook }" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLinkedin" class="col-sm-4 control-label">Linkedin</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputLinkedin" name="memberContactSocial.linkedin" value="${contactSocial.linkedin }" />
                        </div>
                    </div><Br>
                    <div class="form-group">
                        <label for="inputGithub" class="col-sm-4 control-label">Github</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" if="inputGithub" name="memberContactSocial.github" value="${contactSocial.github }" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputStackoverflow" class="col-sm-4 control-label">Stackoverflow</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputStackoverflow" name="memberContactSocial.stackoverflow" value="${contactSocial.stackoverflow }" />
                        </div>
                    </div>
                </div>
                <div class="col-sm-5 help-block">
                    <blockquote>
                        1. Для получения полной информации о кандидате HR-менеджер может поискать его профиль в социальной сети. Для того, чтобы Ваш профиль был быстрее всего найден,
                        укажите ссылки на него в Ваших дополнительных контактах<br />
                        2. Указывая профиль, убедитесь что в нем нет информации противоречашей Вашему резюме, так как такие несоответствия видны невооруженным глазом <br />
                        3. Просмотрите Ваш профиль со стороны и убедитесь, что в нем нет неприличных фотографий Вашей бурной студенческой жизни - это информация некчему при поиске работы<br/>
                        4. Если Вы состоите в сомнительных группах, которые компрометируют Вас как адекватного человека, пришло время покинуть эти сообщества <br/>
                        5. В настройках современных социальных сетях есть возможность создания именованных ссылок на профиль, вместо id12345678, поэтому имеет смысл
                        воспользоваться данными возможностями
                    </blockquote>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-7">
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </form>
    </div>
</div>