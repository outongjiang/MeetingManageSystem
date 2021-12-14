<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/7
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="./plug/jquery-3.2.1.min.js"> </script>
    <style>
        body {
            background: lightgray;
        }
        .head {
            background: rgb(165, 162, 162);
            width: 100%;
            height: 100px;
            text-align: center;
            line-height: 100px;
            border-radius: 30px

        }
        .head>div>span:nth-child(2) {
            color: rgb(39, 33, 33);
            font-weight: bold
        }
        .head>div>span:nth-child(3) {
            color: rgb(133, 124, 124);
        }
        .head>div {
            position: absolute;
            right: 25px;
            top: 50px;
        }
        .img1 {

            background: url("./images/header.png") no-repeat;

            background-size: contain;

            width: 150px;

            height: 100px;

            position: absolute;

            top: 35px;

            left: 20px;

        }
        h1{
            text-shadow: 4px 4px 4px rgb(82, 80, 80);
        }
        a{
            text-decoration: none;
            color:rgb(51, 50, 50)
        }

    </style>
</head>
<body>
<div class="head">
    <h1>欢迎访问Cool-Meeting会议管理系统</h1>
    <div><span>欢迎您,</span> <span><%= request.getSession().getAttribute("username")%></span> <a href="./updatePassword.jsp" target="middle">[修改密码]</a><a href="LoginOutServlet" target="_top">退出登录</a> </div>
</div>
<div class="img1"></div>
</body>
</html>

