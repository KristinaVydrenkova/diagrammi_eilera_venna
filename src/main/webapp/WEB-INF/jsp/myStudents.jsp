<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Мои ученики">
    <%@include file="header.jsp"%>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Мои ученики
                <div class="line_tasks"></div>
            </div>
            <br>
            <div><a class="back_link" href="<c:url value="/profile"/>">Назад</a></div>
            <table class="points_table">
                <tr>
                    <th>Номер</th>
                    <th>ФИО</th>
                    <th>Email</th>
                </tr>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.number}</td>
                        <td>${student.fio}</td>
                        <td>${student.email}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <br>
            <button><a href="<c:url value="/teaching/myStudents/edit"/>">Изменить список</a> </button>
        </div>
    </div>
</t:layout>
