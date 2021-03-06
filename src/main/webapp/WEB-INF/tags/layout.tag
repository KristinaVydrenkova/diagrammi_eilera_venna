<%@tag description="basic layout" pageEncoding="UTF-16" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style>
        <%@include file="/resources/css/main.css"%>
    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Oswald&display=swap" rel="stylesheet">
    <t:head/>
</head>
<body class="body">
<jsp:doBody/>
</body>
</html>