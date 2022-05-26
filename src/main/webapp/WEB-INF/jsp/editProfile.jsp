<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout title="Редактировать">
    <%@include file="header.jsp" %>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Редактировать профиль
                <div class="line_tasks"></div>
            </div>
            <br>
            <br>
            <div><a class="back_link" href="<c:url value="/profile"/>">Назад</a></div>
            <form action="edit" method="post" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <label class="edit_label" for="email">Email</label><br>
                <input id="email" name="email" placeholder="Введите новый email" value="${user.email}">
                <br>
                <br>
                <label class="edit_label" for="dateOfBirth" value="<fmt:formatDate value="" pattern="dd.MM.yyyy"/>">Дата рождения</label><br>
                <input id="dateOfBirth" name="dateOfBirth" placeholder="Введите дату рождения" type="date" pattern="dd.MM.yy"/>
                <br>
                <br>
                <label class="edit_label" for="photo">Загрузите фото</label><br>
                <input type="file" id="photo" name="photo">
                <br>
                <br>
                <div class="message">${message}</div>
                <br>
                <input type="submit" value="Обновить данные" class="submit">
            </form>
        </div>
    </div>

</t:layout>
