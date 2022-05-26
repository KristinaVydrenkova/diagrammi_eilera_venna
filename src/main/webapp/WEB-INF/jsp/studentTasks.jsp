<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Мои задания">
    <%@include file="header.jsp"%>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Мои задания
                <div class="line_tasks"></div>
            </div>
            <br>
            <div><a class="back_link" href="<c:url value="/profile"/>">Назад</a></div>
            <table class="teacher_task_table">
                <tr>
                    <th>Учитель</th>
                    <th>Задание</th>
                    <th>Срок сдачи</th>
                </tr>
                <c:forEach items="${tasks}" var="task">
                    <tr>
                        <td>${task.teacherName}</td>
                        <td>${task.task}</td>
                        <td>${task.deadline}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</t:layout>
