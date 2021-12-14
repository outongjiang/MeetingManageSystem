<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/9
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>菜单栏</title>
    <link rel="stylesheet" href="./plug/bootstrap.min.css">
    <script src="./plug/jquery-3.2.1.min.js"> </script>
    <script src="./plug/bootstrap.min.js"></script>
    <style>
        body{
            background: lightgrey;
        }
        ul{
            list-style: none;
            font-size: 25px;
            font-weight: bold;
        }
        li{
            font-size: 15px;
            font-weight:100;
            line-height: 20px;
        }
        a{
            color: rgb(77, 73, 73);
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="left">

    <ul>个人中心

        <li> <a href="Welcome.jsp" target="middle">最新通知</a> </li>

        <li> <a href="myReservation.jsp" target="middle">我的预定</a> </li>

        <li> <a href="myMeeting.jsp" target="middle">我的会议</a> </li>

    </ul>



    <ul>人员管理

        <li> <a href="deptManage.jsp" target="middle">部门管理</a> </li>
        <li><a href="register.jsp" target="middle">员工注册</a></li>
        <li> <a href="registerExamine.jsp" target="middle">注册审批</a> </li>
        <li> <a href="researchEmpServlet" methods="doPost" target="middle">搜索员工</a> </li>
    </ul>

    <ul>会议预定

        <li> <a href="/jsp/appMeetingRoom.jsp" target="middle">添加会议室</a> </li>

        <li> <a href="/servlet/allmeetingroomsServlet" target="middle">查看会议室</a> </li>

        <li> <a href="ReserveMeeting.jsp" target="middle">预定会议</a> </li>

        <li> <a href="researchMeeting.jsp" target="middle">搜索会议</a> </li>

    </ul>

</div>
</body>
</html>