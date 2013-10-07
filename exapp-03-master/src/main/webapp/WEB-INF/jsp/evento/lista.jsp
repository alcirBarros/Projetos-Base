<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>
    </head>
    <body>
        <h1>Eventos</h1>
        <ul>
        <c:forEach items="${eventoList}" var="item">
            <li>${item.nome}</li>
        </c:forEach>
        </ul>
    </body>
</html>
