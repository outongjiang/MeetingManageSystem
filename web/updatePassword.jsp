<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/7
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="plug/bootstrap.min.css">
    <script src="plug/jquery-3.2.1.min.js"> </script>
    <script src="plug/bootstrap.min.js"></script>
    <style>
        body{
            background: lightgray;
        }
        .w{
            width: 200px;
        }
        .box{
            width: 50%;
            position: absolute;
            left:4px;
            top: 25px;;
            border:1px solid rgb(19, 20, 20);

            padding: 30px;
        }
        .mybtn{
            position:relative;
            left: 114px;
        }
        .tip{
            font-weight: bold;
        }
        .img{
            width:150px;
            height:30px;
            position:relative;
            left:120px;
        }
        a{
            color: rgb(77, 73, 73);
            text-decoration: none;
            font-weight: bold;
        }
    </style>
    <script>
        $(function(){
            $("#sm").click(function(event){
                var a=$("#p1").val();
                var a2=$("#p2").val();
                if(a!=a2){
                    alert("两次密码不一致");
                    event.preventDefault();
                }

            })

        })
    </script>
</head>
<body>
<span class="tip">登录信息</span>
<div class="box">
    <form class="form-horizontal" method="Get" action="UpdatePasswordServlet">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">旧密码:</label>
            <div class="col-sm-10">
                <input name="oldpassword"  type="text" class="form-control w" id="" placeholder="旧密码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">新密码:</label>
            <div class="col-sm-10">
                <input type="password" name="newpassword" class="form-control w" id="p1" placeholder="密码">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">确认新密码:</label>
            <div class="col-sm-10">
                <input type="password" name="newpassword2" class="form-control w" id="p2" placeholder="密码">
            </div>
        </div>
        <div class="mybtn">
            <button id="sm" type="submit" class="btn btn-success">确定修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button  type="button" class="btn btn-success"> <a href="login.jsp" target="middle">返回首页</a> </button>
        </div>
    </form>
</div>
</body>
</html>