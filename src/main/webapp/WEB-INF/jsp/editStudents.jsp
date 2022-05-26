<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout title="Редактировать">
    <%@include file="header.jsp" %>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Редактировать студентов
                <div class="line_tasks"></div>
            </div>
            <br>
            <br>
            <div><a class="back_link" href="<c:url value="/teaching/myStudents"/>">Назад</a></div>
            <form:form method="POST" action="delete" cssClass="students_form" modelAttribute="deleteStudentsForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                <label class="edit_label" for="deleteStudents">Выберите учеников, которых хотите удалить</label><br>
                <select multiple name="deleteStudents" id="deleteStudents">
                    <c:forEach items="${students}" var="student">
                        <option label="ученик" name = "email" value="${student.email}">${student.number} ${student.fio}</option>
                    </c:forEach>
                </select>
                <br>
                <form:errors path="deleteStudents" cssClass="message"/>
                <div class="message">${messageForDelete}</div>
                <br>
                <input type="submit" value="Удалить" class="submit">
            </form:form>
            <form:form method="POST" action="add" cssClass="students_form" modelAttribute="addStudentsForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                <label class="edit_label" for="addStudents">Введите через пробел email учеников, которых хотите добавить</label><br>
                <input id="addStudents" name="emails" class="input_students">
                <br>
                <form:errors path="emails" cssClass="message"/>
                <div class="message">${messageForAdd}</div>
                <br>
                <input type="submit" value="Обновить список" class="submit">
            </form:form>

<%--            <form action="delete" method="post" class="students_form">--%>
<%--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
<%--                <label class="edit_label" for="deleteStudents">Выберите учеников, которых хотите удалить</label><br>--%>
<%--                <select multiple name="deleteStudents" id="deleteStudents">--%>
<%--                    <c:forEach items="${students}" var="student">--%>
<%--                    <option label="ученик" name = "email" value="${student.email}">${student.number} ${student.fio}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--                <br>--%>
<%--                <div class="message">${messageForDelete}</div>--%>
<%--                <br>--%>
<%--                <input type="submit" value="Удалить" class="submit">--%>
<%--            </form>--%>
<%--            <form action="add" method="post" class="students_form">--%>
<%--                <br>--%>
<%--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
<%--                <label class="edit_label" for="addStudents">Введите через пробел email учеников, которых хотите добавить</label><br>--%>
<%--                <input id="addStudents" name="emails" class="input_students">--%>
<%--                <br>--%>
<%--                <div class="message">${messageForAdd}</div>--%>
<%--                <br>--%>
<%--                <input type="submit" value="Обновить список" class="submit">--%>
<%--            </form>--%>
        </div>
    </div>

</t:layout>
