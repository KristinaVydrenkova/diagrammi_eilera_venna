<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Видеоразборы">
<%@include file="header.jsp"%>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Видео
                <div class="line_tasks"></div>
            </div>
            <div class="video_block">
                <div class="left">
                    <iframe width="400" height="235" src="https://www.youtube.com/embed/ll6cpsIMgoE"
                            title="YouTube video player" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </div>
                <div class="video_title">
                    Низкий уровень сложности
                </div>
            </div>
            <div class="video_block">
                <div class="left">
                    <iframe width="400" height="235" src="https://www.youtube.com/embed/NNqqKleTcIg"
                            title="YouTube video player" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </div>
                <div class="video_title">
                    Возможное расположение диаграмм
                </div>
            </div>

        </div>
    </div>
    <div class="page_continue">
        <div class="information-continue">
            <div class="video_block">
                <div class="left">
                    <iframe width="400" height="235" src="https://www.youtube.com/embed/LrFd0nqILLU"
                            title="YouTube video player" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </div>
                <div class="video_title">
                    Средний уровень сложности
                </div>
            </div>
        </div>
    </div>
</t:layout>