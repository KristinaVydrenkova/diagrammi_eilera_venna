<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="О нас">
<%@include file="header.jsp"%>
<div class="page">
    <div class="information">
        <div class="title_tasks">
            О нас
            <div class="line_tasks"></div>
        </div>
        <div class="block">
            <div class="left">
                <img src="http://localhost:8080/resources/images/резюме1.jpg" alt="Кристина" width="200" height="300">
            </div>
            <div class="right">
                <div class="text_tasks">
                    <p>Пришло время рассказать о себе.</p>
                    <p>Нас зовут Кристина и Вероника. Мы вместе работали над школьным проектом, в результате которого и родилась<br>идея создать сайт.</p>
                    <p>Мы не понаслышке знаем, что такое готовиться к экзаменам, и именно поэтому можем объяснить Вам что к чему.</p>
                    <p>Надеемся, что наш сайт поможет вам улучшить свои знания, а наши смешные картиночки поднимут Вам настроение:)</p>
                </div>
            </div>
        </div>
        <div class="block_down">
            <div class="left">
                <img src="http://localhost:8080/resources/images/резюме2.jpg" alt="Вероника" width="200" height="210">
            </div>
            <div class="right_for_short">
                <div class="text_tasks">
                    Если есть вопросы и предложения, пишите в директ:
                    <ul>
                        <li>Вероника - @nika2002nika</li>
                        <li>Кристина - @k_mooooole</li>
                    </ul>
                    Или на почту:
                    <ul>
                        <li>Вероника - nikafill00@gmail.com</li>
                        <li>Кристина - kristinavydrenkova@gmail.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</t:layout>