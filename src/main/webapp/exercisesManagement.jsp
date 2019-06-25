<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Exercises Management</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Exercises.</h1>

        <br><a href="addExercise.jsp">Add.</a><br><br>

        <c:choose>
            <c:when test="${exercises==null or empty exercises}">No exercises.</c:when>
            <c:otherwise>
                <table>
                    <tr><td>Id.</td><td>Title.</td><td>Description.</td></tr>
                    <c:forEach items="${exercises}" var="i">
                        <tr>
                            <td>${i.id}</td><td>${i.title}</td><td>${i.description}</td>
                            <td><a href="editExercise.jsp?id=${i.id}">Edit.</a></td>
                            <td><a href="exercisesManagement?action=delete&id=${i.id}">Delete.</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

        <%@include file="footer.jsp"%>
    </body>
</html>
