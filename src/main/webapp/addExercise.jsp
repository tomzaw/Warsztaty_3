<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Exercise</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Add Exercise.</h1>

        <form method="post" action="exercisesManagement?action=add">
            Title.<br>
            <input type="text" name="title"><br><br>
            Description.<br>
            <input type="text" name="description"><br><br>
            <input type="submit" value="add">
        </form>

        <%@include file="footer.jsp"%>
    </body>
</html>
