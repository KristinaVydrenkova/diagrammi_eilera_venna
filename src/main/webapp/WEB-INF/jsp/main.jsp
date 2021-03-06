<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Главная страница">
    <%@include file="header.jsp" %>

    <div class="intro">
        <div class="intro_inner">
            <span>Диаграммы</span>
            <div class="line_main"></div>
            <span>Эйлера-Венна</span>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="text">
        <div class="hello"><b>Привет!</b></div>
        <p>На данном сайте ты найдёшь всё, что поможет тебе разобраться в теме "Диаграммы Эйлера-Венна" и успешно решить
            задание В17 ЕГЭ и №18 ОГЭ.</p>
        <p>Чтобы узнать свои знания в данной области, ты можешь пройти входной тест. Для этого тебе нужно
        <a class="sign" href="<c:url value="/signUp"/>">зарегистрироваться</a> или
            <a class="sign" href="<c:url value="/signIn"/>">войти</a> в аккаунт.</p>

        <div>
            <p>
                <img src="http://localhost:8080/resources/images/мышь.jpg" width="329" height="330"
                     alt="Мышь" class="left">
                Если ты уверен, что тебе необходимо "устранить пробелы", то переходи в раздел "Видеоразборы задач ЕГЭ"
                или скачай наш Справочник.
            </p>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div>
            <p>
                <img src="http://localhost:8080/resources/images/собака.jpg" width="440" height="340"
                     alt="Иллюстрация" class="right">
                Поверь, к заданию №17 ЕГЭ и №18 ОГЭ можно подготовиться и без помощи репетитора. Вместо того чтобы
                тратить деньги на репетитора, лучше купи кроссовки за 40к!
                <br>
                <br>
                Мы всё-таки придерживаемся теории о том, что человек усваивает только то, что показалось ему интересным,
                смешным и запоминающимся. Именно поэтому наш сайт наполнен кучей смешных картинок и мемов.
            </p>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <p>
            Да-да, такие давно гуляющие по Интернету картинки Вы встретите только на нашем образовательном сайте!!!
        </p>
        <br>
        <p>
            <img src="http://localhost:8080/resources/images/майчуница.jpg" alt="Иллюстрация" width="100%">
        </p>
        <p>Стоит обратить внимание на то, что данный сайт полезен также и для учителей. </p>
        <p>
            Согласитесь, от нудных лекций хочется зевать? В наше время ученики сами могут развивать свой кругозор,
            используя интерактивные учебники,
            задания, видео. Так что если тебе понравилось просвещаться в теме "Диаграммы Эйлера-Венна", то скорее беги
            рассказывать о нашем сайте
            своим любимым одноклассникам и учителю по информатике.
        </p>
    </div>
</t:layout>
<%@include file="footer.jsp" %>