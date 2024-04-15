<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2023
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login page</title>
  <link href="./css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Cache-Control", "no-store");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", 0);

  if (session.getAttribute("user") != null)
    response.sendRedirect("home.jsp");
%>
<%
  if (session.getAttribute("message") != null) {
%>
<script>alert("<%=session.getAttribute("message")%>")</script>
<%
    session.setAttribute("message", null);
  }
%>
<div class="form">
  <h1>Login</h1>
  <form action="/ConvertPdfServlet?action=CheckLoginServlet" method="post" class="txt_contain">
    <div class="txt_field">
      <input type="text" name="username" placeholder="Tên đăng nhập">
    </div>
    <div class="txt_field">
      <input type="password" name="password" placeholder="Password">
    </div>
    <input type="submit" name="submit" value="Đăng nhập" >
  </form>
</div>
</body>
</html>
