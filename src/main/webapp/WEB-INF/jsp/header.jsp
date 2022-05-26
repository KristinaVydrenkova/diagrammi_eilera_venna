<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:layout title="Header">

    <div class="header">
        <div class="container">
            <div class="header_inner">
                <div class="logo"><a href="<c:url value="/"/>">Диаграммы Эйлера-Венна</a></div>
                <nav class="nav">
                    <a class="nav_link" href="<c:url value="/videos"/>"><b>Видеоразборы</b></a>
                    <a class="nav_link" href="<c:url value="/tasks"/>"><b>Задачи для самостоятельного решения</b></a>
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav_link" href="<c:url value="/tests"/>"><b>Тесты</b></a>
                    </sec:authorize>
                    <a class="nav_link" href="<c:url value="/book"/>"><b>Справочник</b></a>
                    <a class="nav_link" href="<c:url value="/aboutUs"/>"><b>О нас</b></a>
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav_link" href="<c:url value="/profile"/>"><b>Мой аккаунт</b></a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="nav_link" href="<c:url value="/signUp"/>"><b>Регистрация</b></a>
                        <a class="nav_link" href="<c:url value="/signIn"/>"><b>Войти</b></a>
                    </sec:authorize>

                </nav>
            </div>
        </div>
    </div>
</t:layout>