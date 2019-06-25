<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Edit Exercise</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Edit Exercise.</h1>

        <form method="post" action="exercisesManagement?action=edit?id=${param.id}">
            Title.<br>
            <input type="text" name="title"><br><br>
            Description.<br>
            <input type="text" name="description"><br><br>
            <input type="submit" value="edit">
        </form>

        <%@include file="footer.jsp"%>
    </body>
</html>
