<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Edit User</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Edit User.</h1>

        <form method="post" action="usersManagement?action=edit?id=${param.id}">
            Username.<br>
            <input type="text" name="username"><br><br>
            Email.<br>
            <input type="text" name="email"><br><br>
            Password.<br>
            <input type="text" name="password"><br><br>
            GroupId<br>
            <input type="number" name="groupId"><br><br>
            <input type="submit" value="edit">
        </form>

        <%@include file="footer.jsp"%>
    </body>
</html>
