<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<% response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");%>
<link rel="stylesheet" href="Style.css">
</head>
<body>

<div class="signup-form">
      <h5 style="color:green"> ${msg}</h5>
      <form class="" action="UserController" method="post" enctype="multipart/form-data"><!-- nessecary for image -->
      <input type="hidden" name="command" value="ADD">
        <h1>Sign Up</h1>=
        <input type="text" name="userId" placeholder="User Id" class="txtb" required="required">
        <input type="password" name="password" placeholder="Password" class="txtb" required="required"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
        <input type="text" name="firstName" placeholder="First Name" class="txtb" required="required" pattern="[A-Za-z]{3,}" title="Must contain at least 3 or more characters">
        <input type="text" name="lastName" placeholder="Last Name" class="txtb" required="required" pattern="[A-Za-z]{3,}" title="Must contain at least 3 or more characters">
        <input type="text" name="address" placeholder="Address" class="txtb" required="required">
        <input type="text" name="city" placeholder="City" class="txtb" required="required">
        <input type="file" name="photo" size=50 ><!-- broswe of image -->
        <input type="submit" value="Create Account" class="signup-btn" >
        <a href="login.jsp">Already Have one ?</a>
      </form>
    </div>


</body>
</html>