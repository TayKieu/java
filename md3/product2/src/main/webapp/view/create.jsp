<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/25/2023
  Time: 3:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/static/css/bootstrap.css">
    <title>create new product</title>
</head>
<body>

<form method="post" style="align-content: center">
  <table border="1" cellpadding="5" >
    <caption>
      <h2>Add New Product</h2>
    </caption>
    <tr>
      <th>Product Name:</th>
      <td>
        <input type="text" name="name" id="name" size="45"/>
        <small style="display: none" id="inputName" class="form-text text-danger">
          Name must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
        </small>
      </td>
    </tr>
    <tr>
      <th> Price:</th>
      <td>
        <input type="text" name="price" id="price" size="45"/>
        <small style="display: none" id="inputPrice" class="form-text text-danger">
          Price must be inputed
        </small>
      </td>
    </tr>
    <tr>
      <th>Quantity:</th>
      <td>
        <input type="text" name="quantity" id="quantity" size="15"/>
        <small style="display: none" id="inputQuantity" class="form-text text-danger">
          Quantity must be inputed
        </small>
      </td>
    </tr>
    <tr>
      <th>Color:</th>
      <td>
        <input type="text" name="color" id="color" size="15"/>
        <small style="display: none" id="inputColor" class="form-text text-danger">
          Color must be inputed
        </small>
      </td>
    </tr>
    <tr>
      <th>Description:</th>
      <td>
        <input type="text" name="description" id="description" size="15"/>
      </td>
    </tr>
    <tr>
      <th>Category:</th>
      <td>
        <select class="form-control" id="form1Example7" name="categoryId" >
          <option value="1">Phone</option>
          <option value="2">Television</option>
          <option value="3">Ipad</option>
          <option value="4">Laptop</option>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2" >
        <button class="btn btn-primary" onclick="validForm(event)" type="submit">Create</button>
        <a href="/ProductServlet">
          <button class="btn btn-dark">Back</button>
        </a>
      </td>
    </tr>
  </table>
</form>
</body>
<script>
  function validForm(event){
    const name =document.getElementById("name");
    const price = document.getElementById("price")
    let regExp = /^[a-zA-Z]+$/;
    let a = /^[0-9]{9}$/;
    if (name.value.trim().length == 0 || !regExp.test(name.value)) {
      alert("Tên không được bỏ trống và phải là chữ!");
      name.value = "";
      name.focus();
      inputName.style.display = 'block';
      event.preventDefault();
      return false;
    }
    if(price.value.trim().length == 0  ) {
      alert("lương không được bỏ trống !");
      price.value = "";
      price.focus();
      inputPrice.style.display = 'block';
      event.preventDefault();
      return false;
    }
    let regPhone = /^090\d{7}$/
    if(phone.value.trim().length == 0 || !regPhone.test(phone.value)){
      alert("số điện thoại phải bắt đầu bằng 090 hoặc  không được bỏ trống !");
      phone.value = "";
      phone.focus();
      inputPhone.style.display = 'block';
      event.preventDefault();
      return false;
    }
    let regExp1 = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.value.trim().length == 0 || !regExp1.test(email.value)){
      alert("giá trị email không được bỏ trống");
      email.value = "";
      email.focus();
      inputEmail.style.display = 'block';
      return false;
    }
    if(address.value.trim().length == 0 || !regExp.test(name.address)){
      alert("giá trị address không được bỏ trống");
      email.value = "";
      email.focus();
      inputAddress.style.display = 'block';
      return false;
    }
    alert("Dữ liệu hợp lệ!");
    return true;
  }
</script>
</html>
