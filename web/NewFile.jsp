<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="en">



<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Document</title>

</head>

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

/* border: 1px solid cornsilk; */

border-radius: 30px

}

.head>div>span:nth-child(1) {}

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

ul {

font-size: 20px;

list-style: none;

font-weight: bold;

}

li {

font-size: 15px;

position: relative;

left: 20px;

font-weight: 100;

color: rgb(128, 121, 121);

}

.right>div {

position: absolute;

left: 320px;

top: 200px;

border: 1px solid rgb(121, 110, 110);

width: 80%;

padding: 20px;

}

.right>div::before {

content: "登录信息";

position: absolute;

top: -11px;

left: 20px;

font-weight: bold;

color: black

}

form {

font-weight: bold;

}

.foot>div {

background: url("./images/footer.png") no-repeat;

background-size: contain;

width: 100px;

height: 100px;

position: absolute;

top: 35px;

left: 1060px;

}

.foot {

position: absolute;

bottom: 0;

width: 100%;

text-align: center;

line-height: 100px;

}

.foot>span {

color: grey;

}

.login {

position: absolute;

left: 322px;

top: 151px;

}

</style>



<body>

<div class="login">登录</div>

<div class="head">



<h1>欢迎访问Cool-Meeting会议管理系统</h1>

<div><span>欢迎您,</span> <span>admin</span><span>[修改密码]</span> </div>

</div>

<div class="img1"></div>

<div class="body">

<div class="left">

<ul>个人中心

<li>最新通知</li>

<li>我的预定</li>

<li>我的会议</li>

</ul>



<ul>人员管理

<li>部门管理</li>

<li>员工注册</li>

<li>注册审批</li>

<li>搜索员工</li>

</ul>

<ul>个人中心

<li>添加会议室</li>

<li>查看会议室</li>

<li>预定会议</li>

<li>搜索会议</li>

</ul>

</div>

<div class="right">



<div>

<form action="LoginServlet" method="Post">

账户名：<input type="text" name="username"><br> <br> 密码：&nbsp;&nbsp;

<input type="password" name="password"><br><br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="submit" value="返回">

</form>



</div>




</div>

</div>



<div class="foot">

<hr> 更多问题，欢迎联系 <span>管理员</span>

<div></div>

</div>

</body>



</html>

