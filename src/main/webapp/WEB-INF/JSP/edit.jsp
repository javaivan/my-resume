<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>


<div class="panel panel-default edit-profile">
    <div class="panel-body">
        <h4 class="data-header">Rickhard Hendricks</h4>

      <%--  <form:form action="/edit/photo" method="post" commandName="uploadPhotoForm" enctype="multipart/form-data">
            <input type="file" name="images" value="${uploadFileForm.images}" />
            <form:errors path="images" cssClass="alert alert-danger" element="div" />
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form:form><br><br>

        <div class="form-group">
            <label for="inputPhoto" class="col-sm-2 control-label">Фото*</label>
            <div class="col-sm-5">
                <img id="currentPhoto" src="" class="edit-photo" /><br />
                <input type="file" name="profilePhoto" id="profilePhoto" />
            </div>
            <div class="col-sm-5 help-block">
                <blockquote>
                    1. Фотография может многое рассказать о кандидате: начиная от его эстетических качеств и заканчивая его отношением к поиску серьезной работы<br />
                    2. Фотография как на паспорт или в костюме необязательна, главное адекватность и ухоженный, акууратный внешний вид<br />
                    3. В качестве примеров Вы можете посмотреть на фотографии демонстрационных резюме в данном приложении<br />
                    4. Размер фотографии должен быть не меньше чем 400x400 <br />
                    5. Файл должен быть в формате jpg <br />
                </blockquote>
            </div>
        </div>
--%>


        <form:form action="/edit" method="post" commandName="contactForm" detiteEntityName="skill">
            <div id="ui-block-container">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Фото*</label>
                    <div class="col-sm-5">
                        <img id="currentPhoto" src="${contactForm.photo}" class="edit-photo" /><br />
                        <a class="btn btn-primary"id=""  href="javascript:resume.edit.showUploadDialog();">Upload Imagas</a>
                    </div>
                    <div class="col-sm-5 help-block">
                        <blockquote>
                            1. Фотография может многое рассказать о кандидате: начиная от его эстетических качеств и заканчивая его отношением к поиску серьезной работы<br />
                            2. Фотография как на паспорт или в костюме необязательна, главное адекватность и ухоженный, акууратный внешний вид<br />
                            3. В качестве примеров Вы можете посмотреть на фотографии демонстрационных резюме в данном приложении<br />
                            4. Размер фотографии должен быть не меньше чем 400x400 <br />
                            5. Файл должен быть в формате jpg <br />
                        </blockquote>
                    </div>
                </div>
                <div class="clear"></div>
                <br/><hr><br/>
                <div class="form-group">
                    <label for="inputCountry" class="col-sm-2 control-label">Страна*</label>
                    <div class="col-sm-5">
                        <input type="text" id="inputCountry" class="form-control" name="items.country" value="${contactForm.country}" />
                        <form:errors path="country" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-sm-5 help-block"></div>
                </div>
                <br/><hr><br/>
                <div class="form-group">
                    <label for="inputCity" class="col-sm-2 control-label">Город*</label>
                    <div class="col-sm-5">
                        <input type="text" id="inputCity" class="form-control" name="items.city" value="${contactForm.city}" />
                        <form:errors path="city" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-sm-5 help-block"></div>
                </div>
                <br/><hr><br/>
                <div class="form-group">
                    <label for="inputPhone" class="col-sm-2 control-label">Телефон*</label>
                    <div class="col-sm-5">
                        <input type="text" id="inputPhone" class="form-control"name="items.phone" value="${contactForm.phone}" />
                        <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-sm-5 help-block">
                        <blockquote>Номер телефона должен быть рабочим и тем номером с которого Вы будете отвечать на звонки с неизвестных Вам номеров.
                            Номер телефона нужно предоставлять в формате <a href="https://ru.wikipedia.org/wiki/E.164" target="_blank">E.164</a>, например: +380501234567</blockquote>
                    </div>
                </div>
                <br/><hr><br/>
                <div class="form-group">
                    <label for="inputObjective" class="col-sm-2 control-label">Желаемая должность*</label>
                    <div class="col-sm-5">
                        <input type="text" id="inputObjective" class="form-control"name="items.objective" value="${contactForm.objective}" />
                        <form:errors path="objective" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-sm-5 help-block">
                        <blockquote>В данном разделе нужно указать желаемую должность, максимально кратно и понятно</blockquote>
                    </div>
                </div>
                <br/>
                <div class="form-group">
                    <label for="inputSummary" class="col-sm-2 control-label">Ваша квалификация*</label>
                    <div class="col-sm-5">
                        <textarea name="items.qualification" id="inputSummary" class="form-control pull-right" required="required" rows="2">${contactForm.qualification}</textarea>
                        <form:errors path="qualification" cssClass="alert alert-danger" element="div" />
                    </div>
                    <div class="col-sm-5 help-block">
                        <blockquote>
                            1. В данном разделе необходимо описать Ваш опыт (практический или теоретический) по тому направлению в котором Вы ищите работу.<br />
                            2. Если Вы работали фотографом и хотите изменить профиль своей деятельности не нужно описывать Ваши достижения в фотографии при поиске работы программистом<br />
                            3. Если во желаемой должности у Вас нет достижений, это повод пройти какие-либо курсы в данном направлении или самостоятельно изучить основы будущей профессии
                        </blockquote>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </div>
            </div>
        </form:form>
    </div>
</div>
<form:form action="/edit/photo" method="POST" commandName="photoUploader" enctype="multipart/form-data">
    <div id="photoUploaderBox" class="modal fade" role="dialog" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Загрузить Фотографию</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 form-group">
                            <input id="photoFile" name="photoFile" type="file" multiple placeholder="Выберите файл-картинку" >
                        </div>
                        <div class="col-xs-12 text-center">
                            <a href="javascript:resume.edit.uploadPhoto()" class="btn btn-primary" >Загрузить Фотографию</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
