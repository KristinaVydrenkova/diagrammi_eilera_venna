<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Мои баллы">
    <%@include file="header.jsp"%>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Мои баллы
                <div class="line_tasks"></div>
            </div>
            <br>
            <div><a class="back_link" href="<c:url value="/profile"/>">Назад</a></div>
            <table class="points_table">
                <tr>
                    <th>Тест</th>
                    <th>Баллы</th>
                    <th>Максимальный балл</th>
                </tr>
                <c:forEach items="${points}" var="point">
                <tr>
                    <td>${point.testName}</td>
                    <td>${point.scores}</td>
                    <td>${point.maxScore}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</t:layout>