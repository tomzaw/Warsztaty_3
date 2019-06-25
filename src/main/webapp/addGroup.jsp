<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Group</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Add Group.</h1>

        <form method="post" action="groupsManagement?action=add">
            Name.<br>
            <input type="text" name="name"><br><br>
            <input type="submit" value="add">
        </form>

        <%@include file="footer.jsp"%>
    </body>
</html>
