<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Groups Management</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Groups.</h1>

        <br><a href="addGroup.jsp">Add.</a><br><br>

        <c:choose>
            <c:when test="${groups==null or empty groups}">No groups.</c:when>
            <c:otherwise>
                <table>
                    <tr><td>Id.</td><td>Name.</td></tr>
                    <c:forEach items="${groups}" var="i">
                        <tr>
                            <td>${i.id}</td><td>${i.name}</td>
                            <td><a href="editGroup.jsp?id=${i.id}">Edit.</a></td>
                            <td><a href="groupsManagement?action=delete&id=${i.id}">Delete.</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

        <%@include file="footer.jsp"%>
    </body>
</html>
