<%@ page import="com.example.model.bean.User" %>
<%@ page import="com.example.model.bean.FileUpload" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2023
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link href="./css/home.css" rel="stylesheet" type="text/css">
    <link href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>
<%
    User user = new User();
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if (session.getAttribute("user") == null)
        response.sendRedirect("login.jsp");
    else {
        user = (User) session.getAttribute("user");
    }
%>
<%
    if (session.getAttribute("message") != null) {
%>
<script>alert("<%=session.getAttribute("message")%>")</script>
<%
        session.setAttribute("message", null);
    }
%>
<%--<%--%>
<%--    List<FileUpload> files = (List<FileUpload>) request.getAttribute("Files");--%>
<%--%>--%>
<header>
    <nav>
        <ul class="nav_link">
            <li><a href="home.jsp">Trang chủ</a></li>
            <li><a href="/ConvertPdfServlet?action=FileServlet&userId=<%=user.getUserId()%>">About</a></li>
            <li><a href="/ConvertPdfServlet?action=LogoutServlet">Đăng xuất</a></li>
        </ul>
    </nav>
</header>

<div class="container">
    <div class="header">
        <i class="fa fa-file-pdf"></i>
        <h1>Chuyển PDF sang Word</h1>
    </div>
    <div class="main">
        <div class="submain">
            <div>
                <img src="img/PDF-to-Word.webp" alt="user" >
                <h3 style="text-align: center">Chọn File PDF cần chuyển đổi</h3>
            </div>
            <form action="/ConvertPdfServlet?action=UploadfileServlet" class="button" method="post"
                  enctype="multipart/form-data" >
                <input type="hidden" name="username" value=<%=user.getUsername()%>>
                <input type="file" id="file" name="files_upload" accept="application/pdf"  multiple>
                <label for="file"></label>
                <input class="submit" type="submit" value="SEND">
            </form>
<%--            <div>--%>
<%--                <h3 style="color: white; margin-top: 20px">History uploaded</h3>--%>
<%--                <table class="table" border="1">--%>
<%--                    <thead>--%>
<%--                    <tr>--%>
<%--                        <th>ID</th>--%>
<%--                        <th>File name</th>--%>
<%--                        <th>File status</th>--%>
<%--                    </tr>--%>
<%--                    </thead>--%>
<%--                    <tbody>--%>
<%--                    <%--%>
<%--                        for (int i = 0; i < files.size(); i++) {--%>
<%--                    %>--%>
<%--                    <tr>--%>
<%--                        <td><%=i + 1%>--%>
<%--                        </td>--%>
<%--                        <td><%=files.get(i).getFileName()%>--%>
<%--                        </td>--%>
<%--                        <td><%=files.get(i).getFileStatus()%>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <%--%>
<%--                        }--%>
<%--                    %>--%>
<%--                    </tbody>--%>
<%--                </table>--%>
<%--            </div>--%>
        </div>
    </div>
</div>
</body>
</html>
