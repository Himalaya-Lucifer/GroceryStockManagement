<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<% response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");%>
<link rel="stylesheet" href="Style2.css">
</head>
<body>

<div class="login-form">
      <form action="UserController" method="post" enctype="multipart/form-data"><!-- nessecary for image -->
      <input type="hidden" name="command" value="USER">
      <h4 style="color: white;">${msg}</h4>
        <h1>Log In</h1>
        <input type="text" name="userId" placeholder="Username" class="txtb">
        <input type="password" name="password" placeholder="Password" class="txtb">
        <label><input type="checkbox" checked="checked" name="remember">Remember me</label>
        <input type="submit" value="Sing in" class="login-btn">
      </form>
    </div>


</body>
</html>