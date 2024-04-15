<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/12/2023
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>
<c:url var="urlUpdatePage" value="/ProductServlet?action=edit"/>
<c:url var="urlDelete" value="/ProductServlet?action=delete"/>
<a class="btn btn-success" href="/ProductServlet?action=create" role="button">Create</a>
<br>
<form method="post" action="ProductServlet?action=search">
    <input type="text" placeholder="Enter a product name" name="productName"  size="45"/>
    <input type="submit" value="search"/>
</form>

<table id="tableProduct" class="table table-bordered" style="text-align: center">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.categoryName}</td>
            <td>${product.description}</td>
            <td><a href="${urlUpdatePage}&id=${product.id}">
                <button class="btn btn-primary">Edit</button>
            </a>
            <a href="/ProductServlet?action=delete&id=${product.id}">
                <button type="submit" class="btn btn-danger">Delete</button></a>
            </td>

        </tr>
    </c:forEach>
    </tbody>

</table>
<script>
    $(document).ready(function () {
        $('#tableProduct').DataTable({
            'pageLength' : 2,
            pagingType: 'full_numbers',
            'searching':false
        });
    });
</script>
</body>
</html>
