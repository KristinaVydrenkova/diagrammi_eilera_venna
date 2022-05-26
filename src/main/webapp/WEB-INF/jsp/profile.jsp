<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Мой аккаунт">
<%@include file="header.jsp"%>
    <div class="page">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="information">
            <div class="title_tasks">
                Мой аккаунт
                <div class="line_tasks"></div>
            </div>
            <div class="info_nav">
                <a class="tasks_link" href="<c:url value="/profile"/>">Личные данные</a><br>
                <br>
                <c:choose>
                    <c:when test="${user.role=='STUDENT'}">
                        <a class="tasks_link" href="<c:url value="/studying/points"/>">Мои баллы</a><br>
                        <br>
                        <a class="tasks_link" href="<c:url value="/studying/tasks"/>">Мои задания</a><br>
                        <br>
                    </c:when>
                    <c:otherwise>
                        <a class="tasks_link" href="<c:url value="/teaching/myStudents"/>">Мои ученики</a><br>
                        <br>
                        <a class="tasks_link" href="<c:url value="/teaching/tasks"/>">Задания</a><br>
                        <br>
                    </c:otherwise>
                </c:choose>
                <a class="tasks_link" href="<c:url value="/profile/edit"/>">Редактировать профиль</a><br>
                <br>
                <a class="tasks_link" href="<c:url value="/profile/changePassword"/>">Поменять пароль</a><br>
                <br>
                <a class="tasks_link" href="<c:url value="/logout"/>">Выйти</a><br>
                <br>
                <a class="tasks_link" href="<c:url value="/signout"/>">Удалить аккаунт</a>
            </div>
            <div class="info_block">
                <div class="right">
                    <img src="http://localhost:8080/resources/images/users/${user.photoName}" height="430" width="350">
                </div>
                <br>
                <div class="right_for_short">
                    <label for="firstName">Имя</label><br>
                    <div class="text_info" id="firstName">${user.firstName}</div>
                </div>
                <br>
                <div class="right_for_short">
                    <label for="lastName">Фамилия</label><br>
                    <div class="text_info" id="lastName">${user.lastName}</div>
                </div>
                <br>
                <div class="right_for_short">
                    <label for="patronymic">Отчество</label>
                    <div class="text_info" id="patronymic">${user.patronymic}</div>
                </div>
                <br>
                <div class="right_for_short">
                    <label for="email">Email</label><br>
                    <div class="text_info" id="email">${user.email}</div>
                </div>
                <br>
                <div class="right_for_short">
                    <label for="dateOfBirth">Дата рождения</label><br>
                    <c:if test="${user.dateOfBirth!=null}">
                        <div class="text_info" id="dateOfBirth">${user.dateOfBirth}</div>
                    </c:if>
                    <c:if test="${user.dateOfBirth==null}">
                        <div class="text_info" id="dateOfBirth"> -</div>
                    </c:if>
                    <br>
                </div>
                <br>
                <br>
                <br>
                <br>
                <div class="right_for_short">
                    <div class="text_info">${user.role=='TEACHER' ? "Учитель":"Ученик"}</div>
                </div>
            </div>
        </div>
    </div>
</t:layout>
