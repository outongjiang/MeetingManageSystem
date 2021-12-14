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
    <link rel="stylesheet" href="./plug/bootstrap.min.css">
    <script src="./plug/jquery-3.2.1.min.js"> </script>
    <script src="./plug/bootstrap.min.js"></script>
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
        h4{font-weight:bold; position:relative;
            top: -30px;}
        .mybtn{
        	position:relative;
        	top:-170px;
        	left:140px;
        }
        textarea{resize: none;}
        #s1{
        	width:140px;
        	position:relative;
        	top:10px;
        }
        .gt{
        	position:relative;
        	left:10px;
        	top:-130px
        }
        .lt{
        	position:relative;
        	left:154px;
        	top:-120px
        }
        .right{
        	psition:relative;
        	left:350px;
        	top:-240px
        }
    </style>
</head>
<body>
    <span class="tip">会议预定>预定会议</span>
    <div class="box">
    <h4>会议信息</h4>
        <form class="form-horizontal" method="GET" action="appRserveMeetingServlet">
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">会议名称:</label>
                <div class="col-sm-10">
                  <input type="text" name="roomname" class="form-control w" id="inputname3" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">预计参加人数:</label>
                <div class="col-sm-10">
                  <input type="text" name="numberofparticipants" class="form-control w" id="inputname3" placeholder="例如：100">
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">预计开始时间:</label>
                <div class="col-sm-10">
                  <input type="datetime-local" name="starttime" class="form-control w" id="inputname3" placeholder="填写一个整数">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">预计结束时间:</label>
                <div class="col-sm-10">
                  <input type="datetime-local" name="endtime" class="form-control w" id="inputname3" placeholder="年/月/日">
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">会议室名称:</label>
                <div class="col-sm-10">
                 	<select name="roomid" id="s1" >
    				<option value="">第一会议室
    					
    				</option>
    				<option value="">第二会议室
    						
    				</option>
 					</select>
                </div>
             </div>  
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">会议说明:</label>
                <div class="col-sm-10">
                  <textarea name="description" id="" cols="22" rows="3" resize="false"></textarea>
                </div>    
               
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">选择参会人员:</label>
                <div class="col-sm-10">
                <select name="" id="s1" >
    				<option value="">第一会议室</option>
    				<option value="">第二会议室</option>
                </select>
                </div>
                <div class="col-sm-10">
                <select name="" id="s1" size=10>
    				<option value="">第一会议室</option>
    				<option value="">第二会议室</option>
                </select>
 					 <button class="gt">></button><br>
      				<button class="lt">&lt;</button>
      				
                </div>  
               
               <div class="col-sm-10 right">
               <select name="" id="s1" size=11>
    				<option value=""></option>
    				<option value=""></option>
 					</select></div>

                  <div class="input-group w mybtn">
            <button type="submit" class="btn btn-success">预定会议</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-success">重置</button>
     </div>  
     
     
            </div>
          </form>
    </div>


      
</body>
</html>