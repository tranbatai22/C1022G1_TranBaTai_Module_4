
<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 14/12/2022
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/exchange" method="get">
  <input type="number" name="money" placeholder="Input USD"> (USD) <br><br>
  <button type="submit">Convert</button><br><br>
  <input type="text" value="${result}"> (VNĐ)
</form>
</body>
</html>