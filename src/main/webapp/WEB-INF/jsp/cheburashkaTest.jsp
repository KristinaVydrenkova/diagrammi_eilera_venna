<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Чебурашка</title>
    <style>
        <%@include file="/resources/css/tests.css"%>
    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Oswald&display=swap"
          rel="stylesheet">
</head>
<body>
<form action="cheburashka" id="testform" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="block_wrap">
        <div class="first_block">
            <h1>Тест по задачам типа "Чебурашка"</h1>
            <div class="text">Проверь свои навыки решения задач на 3 множества!<br>
                & - И<br>
                │ - ИЛИ<br>
                В конце программа выдаст Вам оценку.
            </div>
            <br>
            <a class="sign" href="<c:url value="/"/>">На главную</a>
        </div>
        <div class="block">
            <div class="text">1. Сколько страниц (в тыс.) найдется по запросу: Дэдпул & Железный человек?</div>
            <img src="http://localhost:8080/resources/images/чеб_воп1.PNG" width="520" height="220">
            <br>
            <br>
            <input type="radio" id="q1_var1" name="q1" value=1 checked>
            <label class="variant" for="q1_var1">50</label>
            <br>
            <input type="radio" id="q1_var2" name="q1" value=2>
            <label class="variant" for="q1_var2">75</label>
            <br>
            <input type="radio" id="q1_var3" name="q1" value=3>
            <label class="variant" for="q1_var3">135</label>
            <br>
            <input type="radio" id="q1_var4" name="q1" value=4>
            <label class="variant" for="q1_var4">60</label>
        </div>
        <div class="block">
            <div class="text">2. Какое количество страниц (в тыс.) будет выдано по запросу: Поттер│ Уизли │ Грейнджер?
            </div>
            <img src="http://localhost:8080/resources/images/чеб_воп1.PNG" width="520" height="220">
            <br>
            <br>
            <input name="q2" placeholder="Ответ">
        </div>
        <div class="block">
            <div class="text">3. Найдите области, соответствующие логическому выражению: (А & Б) │¬ (А │ Б)</div>
            <img src="http://localhost:8080/resources/images/чеб_воп3.PNG" width="520" height="220">
            <br>
            <br>
            <input type="radio" id="q3_var1" name="q3" value=1 checked>
            <label class="variant" for="q3_var1">1+3</label>
            <br>
            <input type="radio" id="q3_var2" name="q3" value=2>
            <label class="variant" for="q3_var2">2+5</label>
            <br>
            <input type="radio" id="q3_var3" name="q3" value=3>
            <label class="variant" for="q3_var3">3</label>
            <br>
            <input type="radio" id="q3_var4" name="q3" value=4>
            <label class="variant" for="q3_var4">4+5</label>
            <br>
            <input type="radio" id="q3_var5" name="q3" value=5>
            <label class="variant" for="q3_var5">1+2</label>
            <br>
            <input type="radio" id="q3_var6" name="q3" value=6>
            <label class="variant" for="q3_var6">1</label>
        </div>
        <div class="block">
            <div class="text">4. Сколько страниц (в тыс.) будет выдано по запросу: Пьер?</div>
            <img src="http://localhost:8080/resources/images/чеб_воп4.PNG" width="520" height="220">
            <br>
            <br>
            <input name="q4" placeholder="Ответ">
        </div>
        <div class="block">
            <div class="text">5. Сколько страниц (в тыс.) будет найдено по запросу: Кардашьян?</div>
            <img src="http://localhost:8080/resources/images/чеб_воп5.PNG" width="520" height="220">
            <br>
            <br>
            <input type="radio" id="q5_var1" name="q5" value=1 checked>
            <label class="variant" for="q5_var1">55</label>
            <br>
            <input type="radio" id="q5_var2" name="q5" value=2>
            <label class="variant" for="q5_var2">70</label>
            <br>
            <input type="radio" id="q5_var3" name="q5" value=3>
            <label class="variant" for="q5_var3">20</label>
            <br>
            <input type="radio" id="q5_var4" name="q1" value=4>
            <label class="variant" for="q5_var4">60</label>
        </div>
        <br>
        <input type="submit" value="Закончить тест" class="submit">
    </div>
</form>
<%@include file="testsFooter.jsp" %>
<%@include file="testWindow.jsp" %>
</body>
</html>
