<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Users Management</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Users.</h1>

        <br><a href="addUser.jsp">Add.</a><br><br>

        <c:choose>
            <c:when test="${users==null or empty users}">No users.</c:when>
            <c:otherwise>
                <table>
                    <tr><td>Id.</td><td>Username.</td><td>Email.</td><td>GroupId.</td></tr>
                    <c:forEach items="${users}" var="i">
                        <tr>
                            <td>${i.id}</td><td>${i.username}</td><td>${i.email}</td><td>${i.groupId}</td>
                            <td><a href="editUser.jsp?id=${i.id}">Edit.</a></td>
                            <td><a href="usersManagement?action=delete&id=${i.id}">Delete.</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

        <%@include file="footer.jsp"%>
    </body>
</html>
