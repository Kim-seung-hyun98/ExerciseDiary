<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/05/02
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join</title>
</head>
<body>
Join Page
<form method="post" action="/join">
  <input type="text" placeholder="id" name="userId"><br>
  <input type="password" placeholder="pw" name="userPw"><br>
  <input type="passwordRe" placeholder="pw" name="userPwRe"><br>
  <input type="submit" value="Join">
</form>
</body>
</html>
