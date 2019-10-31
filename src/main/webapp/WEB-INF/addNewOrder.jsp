<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Сервис УК - Жильцы</title>

    <!-- Bootstrap core CSS -->

    <!-- Fonts-->
    <link href="http://allfont.ru/allfont.css?fonts=montserrat" rel="stylesheet" type="text/css" />
    <style>
        <%@include file="bootstrap.css"%>
    </style>
    <style>
        <%@include file="bootstrap.min.css"%>
    </style>
    <style>
        <%@include file="navigation.css"%>
    </style>
    <style>
        <%@include file="registration.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="bootstrap.min.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="jquery.min.js"%>
    </script>

    <script src="bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" ></script>
</head>
<body>
<form action="/simplmvcapp_war/add-new-order" method="POST" accept-charset="UTF-8">
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