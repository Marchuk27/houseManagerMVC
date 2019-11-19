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

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <img class="navbar-left" alt="gavniWE" src="https://i.ibb.co/qm4cXtK/logo-site.png" style="width: 40px; height: 40px;">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">HOUSE MANAGER</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/house.manager/">Авторизация</a></li>
                <li><a href="/house.manager/user-registration/">Регистрация</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <form class="form-signin" action="/house.manager/user-registration" method="POST" accept-charset="UTF-8" role="form">
        <h3 class="form-signin-heading">Регистрация</h3>
        <div class="registration-code">
            <h4 class="advice">Введите код доступа для регистрации</h4>
            <div class="form-group">
                <input class="form-control" placeholder="Код регистрации" required autofocus name = "accessCode">
            </div>
        </div>
        <div class="registration-fio">
            <h4 class="advice">Введите фамилию, имя и отчество</h4>
            <div class="form-group">
                <input class="form-control first" placeholder="Фамилия" name = "lastName">
                <input class="form-control between" placeholder="Имя" name = "firstName">
                <input class="form-control last" placeholder="Отчество" name = "fatherName">
            </div>
        </div>
        <div class="registration-contact">
            <h4 class="advice">Введите номер квартиры, e-mail и номер мобильного телефона</h4>
            <div class="form-group">
                <input class="form-control first" placeholder="Номер квартиры" name = "roomNumb">
                <input type="email" class="form-control between" placeholder="E-mail" name = "eMail">
                <input type="tel" class="form-control last" placeholder="Номер телефона" name = "phoneNumb">
            </div>
        </div>
        <div class="registration-account">
            <h4 class="advice">Придумайте логин и пароль</h4>
            <div class="form-group">
                <input class="form-control first" placeholder="Логин" name = "login">
                <input type="password" class="form-control between" placeholder="Пароль"name = "password">
                <input type="password" class="form-control last" placeholder="Повторите пароль"name = "password2">
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>