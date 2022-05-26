<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:layout title="Редактировать">
    <%@include file="header.jsp" %>
    <div class="page">
        <div class="information">
            <div class="title_tasks">
                Редактировать задания
                <div class="line_tasks"></div>
            </div>
            <div><a class="back_link" href="<c:url value="/teaching/tasks"/>">Назад</a></div>
            <form:form method="POST" action="delete" cssClass="students_form" modelAttribute="deleteTaskForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <h1>Удалить задания</h1>
                <label class="edit_label" for="deleteTasks">Выберите задания,которые хотите убрать из списка</label><br>
                <select multiple name="deleteTasks" id="deleteTasks">
                    <c:forEach items="${tasks}" var="task">
                        <option label="задание" value="${task.id}">${task.id} ${task.task}</option>
                    </c:forEach>
                </select>
                <form:errors path="deleteTasks" cssClass="message"/>
                <div class="message">${messageForDelete}</div>
                <br>
                <input type="submit" value="Удалить задания" class="submit">
            </form:form>

            <form:form method="POST" action="add" cssClass="students_form" modelAttribute="addTaskForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <h1>Добавить задание</h1>
                <label class="edit_label" for="addTask">Введите текст задания, которое хотите добавить</label><br>
                <input id="addTask" name="task" class="input_tasks">
                <form:errors path="task" cssClass="message"/><br>
                <label class="edit_label" for="deadline" value="<fmt:formatDate value="" pattern="dd.MM.yyyy"/>">Введите дату сдачи</label><br>
                <input id="deadline" name="deadline" class="input_delete_id" type="date" pattern="dd.MM.yy"/>
                <form:errors path="deadline" cssClass="message"/><br>
                <div class="messageForAdd">${message}</div>
                <br>
                <input type="submit" value="Добавить задание" class="submit">
            </form:form>
        </div>
    </div>

</t:layout>
