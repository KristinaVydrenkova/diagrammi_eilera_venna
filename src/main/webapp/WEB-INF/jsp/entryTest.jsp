<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Входной тест</title>
    <style>
        <%@include file="/resources/css/tests.css"%>
    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Oswald&display=swap"
          rel="stylesheet">
</head>
<body>
<form action="entryTest" method="post" id="testform">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="block_wrap">
        <div class="first_block">
            <h1>Вступительный тест по теме "Диаграммы Эйлера-Венна"</h1>
            <div class="text">Тест поможет Вам узнать, насколько хорошо Вы разбираетесь в данной теме. <br>В конце
                программа выдаст Вам оценку.
            </div>
            <br>
            <a class="sign" href="<c:url value="/"/>">На главную</a>
        </div>
        <div class="block">
            <div class="text">1.Что такое Диаграммы Эйлера-Венна?</div>
            <br>
            <input type="radio" id="q1_var1" name="q1" value=1 checked>
            <label class="variant" for="q1_var1">Объединение множеств</label>
            <br>
            <input type="radio" id="q1_var2" name="q1" value=2>
            <label class="variant" for="q1_var2">Сумма площадей кругов</label>
            <br>
            <input type="radio" id="q1_var3" name="q1" value=3>
            <label class="variant" for="q1_var3">Множество точек, равноудалённых от заданной точки</label>
            <br>
            <input type="radio" id="q1_var4" name="q1" value=4>
            <label class="variant" for="q1_var4">Схематическое изображение множеств</label>
        </div>
        <div class="block">
            <div class="text">2. Как с помощью диаграмм схематично изобразить пересечение?</div>
            <br>
            <input type="radio" id="q2_var1" name="q2" value=1 checked>
            <label class="variant" for="q2_var1">
                <img src="http://localhost:8080/resources/images/вход_воп2_вар1.PNG" width="240" height="140">
            </label>
            <input type="radio" id="q2_var2" name="q2" value=2>
            <label class="variant" for="q2_var2">
                <img src="http://localhost:8080/resources/images/вход_воп2_вар2.PNG" width="240" height="140">
            </label>
            <br>
            <input type="radio" id="q2_var3" name="q2" value=3>
            <label class="variant" for="q2_var3">
                <img src="http://localhost:8080/resources/images/вход_воп2_вар3.PNG" width="240" height="140">
            </label>
            <input type="radio" id="q2_var4" name="q2" value=4>
            <label class="variant" for="q2_var4">
                <img src="http://localhost:8080/resources/images/вход_воп2_вар4.PNG" width="240" height="140">
            </label>
        </div>
        <div class="block">
            <div class="text">3.Какая запись соответствует конъюнкции?</div>
            <br>
            <input type="radio" id="q3_var1" name="q3" value=1 checked>
            <label class="variant" for="q3_var1">A*B</label>
            <br>
            <input type="radio" id="q3_var2" name="q3" value=2>
            <label class="variant" for="q1_var2">A+B</label>
            <br>
            <input type="radio" id="q3_var3" name="q3" value=3>
            <label class="variant" for="q3_var3">A XOR B</label>
        </div>
        <div class="block">
            <div class="text">4. В таблице приведены запросы и количество страниц, которые нашел поисковый сервер по
                этим запросам в некотором сегменте Интернета. Сколько страниц найдено по запросу Котики&Пёсики?
            </div>
            <img src="http://localhost:8080/resources/images/вход_воп4.PNG" width="410" height="120">
            <br>
            <br>
            <input type="radio" id="q4_var1" name="q4" value=1 checked>
            <label class="variant" for="q4_var1">230</label>
            <br>
            <input type="radio" id="q4_var2" name="q4" value=2>
            <label class="variant" for="q4_var2">240</label>
            <br>
            <input type="radio" id="q4_var3" name="q4" value=3>
            <label class="variant" for="q4_var3">40</label>
            <br>
            <input type="radio" id="q4_var4" name="q4" value=4>
            <label class="variant" for="q4_var4">30</label>
            <br>
            <input type="radio" id="q4_var5" name="q5" value=5>
            <label class="variant" for="q4_var5">270</label>
        </div>
        <div class="block">
            <div class="text">5. Решите задачу:</div>
            <img src="http://localhost:8080/resources/images/вход_воп5.PNG" width="520" height="220">
            <br>
            <br>
            <input type="radio" id="q5_var1" name="q5" value=1 checked>
            <label class="variant" for="q5_var1">450</label>
            <br>
            <input type="radio" id="q5_var2" name="q5" value=2>
            <label class="variant" for="q5_var2">90</label>
            <br>
            <input type="radio" id="q5_var3" name="q5" value=3>
            <label class="variant" for="q5_var3">120</label>
            <br>
            <input type="radio" id="q5_var4" name="q5" value=4>
            <label class="variant" for="q5_var4">260</label>
            <br>
            <input type="radio" id="q5_var5" name="q5" value=5>
            <label class="variant" for="q5_var5">50</label>
        </div>
        <br>
        <input type="submit" id="somebutton" value="Закончить тест" class="submit">
    </div>
</form>

<%@include file="testsFooter.jsp" %>
<%@include file="testWindow.jsp" %>


</body>
</html>
