<%@page import="service.impl.DepartmentServiceImpl"%>
<%@page import="java.util.*"%>
<%@page import="model.Department"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../plug/bootstrap.min.css">
    <script src="../plug/jquery-3.2.1.min.js"> </script>
    <script src="../plug/bootstrap.min.js"></script>
    <style>
        body{
            background: lightgray;
            font-weight:bold;
        }
        
        .box{
            width: 60%;
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
        .w{
            width: 200px;
        }
        h4{font-weight:bold;}
        .mybtn{
        	position:relative;
        	top:10px;
        	left:140px;
        }
        textarea{resize: none;}
    </style>
</head>
<body>
    <span class="tip">会议预定>添加会议室</span>
    <div class="box">
    <h4>会议室信息</h4>
        <form class="form-horizontal" method="GET" action="appMeetingRoomInfo">
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">门牌号:</label>
                <div class="col-sm-10">
                  <input type="text" name="roomnum" class="form-control w" id="inputname3" placeholder="例如：201">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">会议室名称:</label>
                <div class="col-sm-10">
                  <input type="text" name="roomname" class="form-control w" id="inputname3" placeholder="例如：第一会议室">
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">最多容纳人数:</label>
                <div class="col-sm-10">
                  <input type="text" name="opacity" class="form-control w" id="inputname3" placeholder="填写一个整数">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">当前状态:</label>
                <div class="col-sm-10">
                  <input type="radio" class="ra" name="status" id="inlineRadio1" value="0">启用&nbsp; 
        <input type="radio" class="ra" name="status" id="inlineRadio2" value="1">停用&nbsp;  
        <input type="radio" class="ra" name="status" id="inlineRadio3" value="-1">删除	
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">备注:</label>
                <div class="col-sm-10">
                  <textarea name="description" id="" cols="30" rows="3" resize="false"></textarea>
                </div>
                  <div class="input-group w mybtn">
            <button type="submit" class="btn btn-success">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-success">重置</button>
     </div>  
            </div>
          </form>
    </div>


      
</body>
</html>