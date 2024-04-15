<%@ page import="com.example.model.bean.User" %>
<%@ page import="com.example.model.bean.FileUpload" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.CONSTAINT.Constaint" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/28/2023
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="./css/file.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
  if (session.getAttribute("message") != null) {
%>
<script>alert("<%=session.getAttribute("message")%>")</script>
<%
    session.setAttribute("message", null);
  }
%>

<%
  User user = (User) session.getAttribute("user");
  List<FileUpload> files = (List<FileUpload>) request.getAttribute("Files");
%>
<header>
  <nav>
    <ul class="nav_link">
      <li><a href="home.jsp">Trang chủ</a></li>
      <li><a href="/ConvertPdfServlet?action=FileServlet&userId=<%=user.getUserId()%>">About</a></li>
      <li><a href="login.jsp">Đăng xuất</a></li>
    </ul>
  </nav>
</header>

<div class="Wrapper">
  <div class="left">
    <img src="img/default-profile-icon-24.jpg" alt="user" width="100">
    <h4><%=user.getFullname()%></h4>
  </div>
  <div class="right">
    <div class="info">
      <h3>Thông tin cá nhân</h3>
      <div class="info_data">
        <div class="data">
          <h4>Email</h4>
          <p><%=user.getEmail()%></p>
        </div>
        <div class="data">
          <h4>Điện thoại</h4>
          <p><%=user.getPhone()%></p>
        </div>
      </div>
    </div>
    <div class="projects">
      <h3>Projects</h3>
      <table>
        <thead>
        <tr>
          <td class="id"><b>ID</b></td>
          <td class="name"><b>File name</b></td>
          <td class="download"><b>Download</b></td>
        </tr>
        </thead>
        <tbody>
        <%
          for (int i = 0; i < files.size(); i++) {
        %>
        <tr>
          <td><%=i + 1%></td>
          <td><%=files.get(i).getFileName()%></td>
          <%
            int status = files.get(i).getFileStatus();

            switch (status) {
              case Constaint.PROCESSING:
          %>
          <td>Đang xử lý...</td>
          <%
              break;
            case Constaint.CONVERT_ERROR:
          %>
          <td><a style="color: blue;"
                 href="/ConvertPdfServlet?action=ShowErrorServlet?errorCode=<%=Constaint.CONVERT_ERROR%>&userId=<%=user.getUserId()%>"><i>Show error</i></a></td>
          <%
              break;
            case Constaint.SUCCESS:
          %>
          <td><a style="color: blue;"
                 href="/ConvertPdfServlet?action=DownloadFileServlet&fileId=<%=files.get(i).getFileId()%>"><i>Download</i></a></td>
          <%
              break;
            case Constaint.UPLOAD_ERROR:
          %>
          <td><a style="color: blue;"
                 href="/ConvertPdfServlet?action=ShowErrorServlet&errorCode=<%=Constaint.UPLOAD_ERROR%>&userId=<%=user.getUserId()%>"><i>Show error</i></a></td>
          <%
              break;
            default:
          %>
          <td><a style="color: blue;"
                 href="/ConvertPdfServlet?action=ShowErrorServlet&errorCode=4&userId=<%=user.getUserId()%>"><i>Show error</i></a></td>
          <%
                break;
            }
          %>
        </tr>
        <%
          }
        %>
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>
