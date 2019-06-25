<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>User Solutions</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>User Solutions.</h1>

        <c:choose>
            <c:when test="${userSolutions==null or empty userSolutions}">No user solutions.</c:when>
            <c:otherwise>
                <table>
                    <tr><td>Id.</td><td>Created.</td><td>Updated.</td><td>ExerciseId.</td><td>UsersId.</td></tr>
                    <c:forEach items="${userSolutions}" var="i">
                        <tr><td>${i.id}</td><td>${i.created}</td><td>${i.updated}</td><td>${i.exerciseId}</td><td>${i.usersId}</td><td><a href="showSolution?id=${i.id}">Details.</a></td></tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

        <%@include file="footer.jsp"%>
    </body>
</html>
