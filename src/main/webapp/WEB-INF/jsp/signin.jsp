<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Sign In</title>
    <style>
        <%@include file="/resources/css/signup.css"%>
    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Oswald&display=swap" rel="stylesheet">
</head>
<body>
<div class="signin">
    <h1>Вход в аккаунт</h1>
    <form:form method="POST" cssClass="form" action="/signIn" modelAttribute="signInForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <input id="email" type="email" name="email" placeholder="Email" class="button">
        <form:errors path="email" cssClass="message"/><br>
        <br>
        <input id="password" type="password" name="password" placeholder="Пароль" class="button">
        <form:errors path="password" cssClass="message"/><br>
        <br>
        <br>
        <input type="submit" value="Войти" class="submit_signin">
        <br>
        <label class="text">
            <input type="checkbox" name="rememberMe">Запомнить меня
        </label>
        <br>
        <br>
        <c:if test="${param.error != null}">
            <div class="message">Неправильный логин или пароль</div>
        </c:if>
        <p class="text">Еще нет аккаунта? <a href="<c:url value="/signUp"/>">Зарегистрироваться</a></p>
        <br>
        <p class="back"><a href="<c:url value="/"/>">На главную</a></p>

    </form:form>

</div>

</body>
</html>
