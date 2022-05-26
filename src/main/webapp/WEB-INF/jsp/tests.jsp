<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Тесты">
<%@include file="header.jsp"%>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Тесты
                <div class="line_tasks"></div>
            </div>
            <div class="test_block">
                <ol>
                    <li class="li_test">
                        <a class="test_link" href="<c:url value="/tests/entryTest"/>">Входной тест</a><br>
                        <div class="test_caption">Начни с проверки своих знаний. Может ты сверхразум.</div>
                    </li>
                    <li class="li_test">
                        <a class="test_link" href="<c:url value="/tests/cheburashka"/>">Тест на 3 множества</a><br>
                        <div class="test_caption">Пройдя этот тест, ты поймешь, умеешь ли ты решать задачки с тремя
                            множествами:)
                        </div>
                    </li>
                    <li class="li_test">
                        <a class="test_link" href="#">Тест по 3-м пересекающимся множествам</a><br>
                        <div class="test_caption">Проверь, каковы твои навыки в решении задач, где все три множества
                            пересекаются!
                        </div>
                    </li>
                    <li class="li_test">
                        <a class="test_link" href="#">Задачи для олимпиадной подготовки 5,6,7 и 8 классов</a><br>
                        <div class="test_caption">В наше время олимпиадники в почёте. Наверно, если ты готовишься к ЕГЭ,
                            то задачки 5-8 классов должен решать с лёгкостью.
                        </div>
                    </li>
                    <li class="li_test">
                        <a class="test_link" href="#">Задачи типа "Множество в множестве"</a><br>
                        <div class="test_caption">Существуют и более сложные варианты расположения кругов Венна. На ЕГЭ
                            нужно быть готовым ко всему.
                        </div>
                    </li>
                </ol>
            </div>
        </div>
    </div>
</t:layout>