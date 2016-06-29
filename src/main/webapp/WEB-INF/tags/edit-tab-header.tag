<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ attribute name="selected" required="true" type="java.lang.String" %>

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" ${selected == 'edit'     ? 'class="active"' : ''}><a href="/edit">Основное</a></li>
    <li role="presentation" ${selected == 'contact-social'     ? 'class="active"' : ''}><a href="/edit/contact-social">Contacts</a></li>
    <li role="presentation" ${selected == 'skills'     ? 'class="active"' : ''}><a href="/edit/skills">Skills</a></li>
    <li role="presentation" ${selected == 'practics'     ? 'class="active"' : ''}><a href="/edit/practics">Practic</a></li>
    <li role="presentation" ${selected == 'certificates'     ? 'class="active"' : ''}><a href="/edit/certificates">Сertificates</a></li>
    <li role="presentation" ${selected == 'courses'     ? 'class="active"' : ''}><a href="/edit/courses">Сourses</a></li>
    <li role="presentation" ${selected == 'university'     ? 'class="active"' : ''}><a href="/edit/university">University</a></li>
    <li role="presentation" ${selected == 'languages'     ? 'class="active"' : ''}><a href="/edit/languages">Languages</a></li>
    <li role="presentation" ${selected == 'hobbies'     ? 'class="active"' : ''}><a href="/edit/hobbies">Hobby</a></li>
    <li role="presentation" ${selected == 'info'     ? 'class="active"' : ''}><a href="/edit/info">Additional Information</a></li>
</ul>