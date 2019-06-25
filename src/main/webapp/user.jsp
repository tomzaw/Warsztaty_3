<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>User Page.</h1>
        
            <table>
                <tr><td>Id.</td><td>Username.</td><td>Email.</td><td>GroupId.</td></tr>
                    <tr><td>${user.id}</td><td>${user.username}</td><td>${user.email}</td><td>${user.groupId}</td><td><a href="userSolutions?id=${user.id}">Solutions.</a></td></tr>
            </table>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
