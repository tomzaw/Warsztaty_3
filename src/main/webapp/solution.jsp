<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Solution</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1>Solution.</h1>
        
            <table>
                <tr><td>Id.</td><td>Created.</td><td>Updated.</td><td>Description.</td><td>ExerciseId.</td><td>UsersId.</td></tr>
                    <tr><td>${solution.id}</td><td>${solution.created}</td><td>${solution.updated}</td><td>${solution.description}</td><td>${solution.exerciseId}</td><td>${solution.usersId}</td></tr>
            </table>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
