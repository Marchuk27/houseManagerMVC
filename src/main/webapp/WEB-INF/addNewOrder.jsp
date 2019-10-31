<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/simplmvcapp_war/add-new-order" method="POST">
     <label>ID</label>
    <input type="text" name="id">
    <label>Full Name</label>
    <input type="text" name="fullName">
    <label>Birth Date</label>
    <input type="text" name="birthDate">
    <input type="submit" value="Add in DB">
</form>
</body>
</html>