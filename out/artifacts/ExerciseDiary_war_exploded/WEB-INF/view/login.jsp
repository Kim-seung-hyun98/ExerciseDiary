<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/05/02
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
login Page
<form method="post" action="/login">
  <input type="text" placeholder="id" name="userId"><br>
  <input type="password" placeholder="pw" name="userPw"><br>
  <input type="submit" value="log in">
</form>
</body>
</html>
