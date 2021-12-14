<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<!DOCTYPE html>
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
        function submit(){
            if(confirm("是否需要保存账号密码")){
                document.getElementById("confirm").href="${pageContext.request.contextPath}/LoginServlet?msg=yy&username="+$("#name").val()+"&password="+$("#password").val()+"&checkcode="+$("#checkcode").val();
                $("#confirm>span").trigger("click");
                alert("进来了")
            }else {
            $("form").submit();}
        }
        $(function(){
            // setInterval(function () {
            //     $("#yzm").prop("src","CheckCode?"+new Date().getTime());
            // },1000)
            $("#yzm").click(function () {
                $("#yzm").prop("src","CheckCode?"+new Date().getTime());
            })
        })

    </script>
</head>
<body>
<a id="confirm" href="${pageContext.request.contextPath}/LoginServlet?msg=yy"><span>1</span></a>
<span class="tip">登录信息</span>
<div class="box">
    <form class="form-horizontal" method="Get" action="LoginServlet">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">账户名:</label>
            <div class="col-sm-10">
                <input  name="username"  type="text" class="form-control w" id="name" placeholder="账户名">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control w" id="password" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">验证码:</label>
            <div class="col-sm-10">
                <input type="text" name="checkcode" class="form-control w" id="checkcode" placeholder="验证码">
            </div><br><br><br>
            <img id="yzm" class="img" src="CheckCode" alt="验证码加载失败">
            <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="login.jsp" class="flush">看不清,刷新一下</a><br>
        </div>
        <div class="mybtn">
            <button type="button" class="btn btn-success"><a href="javascript:submit()">登录</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-success">返回</button>
        </div>
    </form>
</div>
</body>
</html>