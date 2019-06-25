<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Admin Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Navigation links.</h1>
        
        <ul style="font-size: 24">
            <li style="margin-bottom: 2%"><a style="text-decoration: none" href="exercisesManagement">Exercises Management.</a></li>
            <li style="margin-bottom: 2%"><a style="text-decoration: none" href="groupsManagement">Groups Management.</a></li>
            <li style="margin-bottom: 2%"><a style="text-decoration: none" href="usersManagement">Users Management.</a></li>
        </ul>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
