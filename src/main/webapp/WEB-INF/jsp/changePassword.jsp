<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:layout title="Смена пароля">
    <%@include file="header.jsp" %>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Поменять пароль
                <div class="line_tasks"></div>
            </div>
            <br>
            <br>
            <div><a class="back_link" href="<c:url value="/profile"/>">Назад</a></div>

            <form action="changePassword" method="post" id="passwordform">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <label class="edit_label" for="oldPassword">Введите старый пароль</label><br>
                <input id="oldPassword" type="password" name="oldPassword" placeholder="Старый пароль">
                <br>
                <br>
                <label class="edit_label" for="newPassword">Введите новый пароль</label><br>
                <input id="newPassword" type="password" name="newPassword" placeholder="Новый пароль">
                <br>
                <br>
                <label class="edit_label" for="repeatPassword">Повторите пароль</label><br>
                <input id="repeatPassword" type="password" name="repeatPassword" placeholder="Новый пароль">
                <br>
                <br>
                <div class="message">${message}</div>
                <br>
                <input type="submit" value="Обновить данные" class="submit">
            </form>
        </div>
    </div>
    <%@include file="changePasswordFooter.jsp"%>
    <%@include file="changePasswordWindow.jsp"%>
</t:layout>
