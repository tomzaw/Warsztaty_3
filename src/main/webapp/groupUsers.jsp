<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Group Users</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Group Users.</h1>
        
        <c:choose>
            <c:when test="${groupUsers==null or empty groupUsers}">No group users.</c:when>
            <c:otherwise>
                <table>
                    <tr><td>Id.</td><td>Username.</td><td>GroupId.</td></tr>
                    <c:forEach items="${groupUsers}" var="i">
                        <tr><td>${i.id}</td><td>${i.username}</td><td>${i.groupId}</td><td><a href="user?id=${i.id}">Details.</a></td></tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
