<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Задачи">
<%@include file="header.jsp"%>

    <div class="intro">
        <div class="information">
            <div class="title_tasks">
                Задачи для самостоятельного решения
                <div class="line_tasks"></div>
            </div>
            <div class="text_tasks">
                <p>Как выучить теорию без практики? Специально для тебя мы подготовили несколько сайтов, на которых ты
                    найдёшь задачи для тренировки. </p>
                <br>
                <div class="text_with_image_tasks">
                    <div class="left">
                        <ul>
                            <li><a class="tasks_link" href="https://kpolyakov.spb.ru/school/ege/solver17.htm">Онлайн
                                тренажер</a></li>
                            <br>
                            <br>
                            <li><a class="tasks_link" href="http://kpolyakov.spb.ru/download/ege17.doc">Скачать задачи
                                ЕГЭ №17</a></li>
                            <br>
                            <br>
                            <li><a class="tasks_link" href="https://inf-ege.sdamgia.ru/">Онлайн тренажер</a></li>
                            <br>
                            <br>
                            <li><a class="tasks_link" href="https://learningapps.org/94521">Упражнение</a></li>
                        </ul>
                    </div>
                    <div class="right">
                        <img src="http://localhost:8080/resources/images/утконос.jpg" width="600" height="450"
                             alt="Как получить утоконоса">
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:layout>