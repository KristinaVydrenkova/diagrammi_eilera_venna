<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        <%@include file="/resources/css/signup.css"%>
    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Oswald&display=swap"
          rel="stylesheet">
</head>
<body>
<div class="registration_block">
    <h1>Регистрация</h1>

    <form:form method="POST" cssClass="form" action="/signUp" modelAttribute="signUpForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <input id="firstName" name="firstName" placeholder="Имя" class="button">
        <form:errors path="firstName" cssClass="message"/><br>
        <br>
        <input id="lastName" name="lastName" placeholder="Фамилия" class="button">
        <form:errors path="lastName" cssClass="message"/><br>
        <br>
        <input id="patronymic" name="patronymic" placeholder="Отчество" class="button">
        <form:errors path="patronymic" cssClass="message"/><br>
        <br>
        <input id="email" type="email" name="email" placeholder="Почта" class="button">
        <form:errors path="email" cssClass="message"/><br>
        <br>
        <input id="password" type="password" name="password" placeholder="Пароль" class="button">
        <form:errors path="password" cssClass="message"/><br>
        <br>
        <input id="repeatPassword" type="password" name="repeatPassword" placeholder="Повторите пароль" class="button">
        <form:errors path="repeatPassword" cssClass="message"/><br>
        <br>
        <form:label path="role" cssClass="label">Выберите роль</form:label><br>
        <select name="role" id="role" class="role_button" >
            <option disabled>Выберите роль:</option>
            <option label="ученик" value="STUDENT">Ученик</option>
            <option label="учитель" value="TEACHER">Учитель</option>
        </select>

        <div class="message">${message}</div>
        <br>
        <input type="submit" value="Создать аккаунт" class="submit"/>
        <p class="text">Уже есть аккаунт? <a href="<c:url value="/signIn"/>">Войти</a> <a href="<c:url value="/"/>">На
            главную</a></p>

    </form:form>
</div>


</body>
</html>
