<%@page import="service.impl.DepartmentServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Department"%>
<%@page import="model.Employee"%>
<%@page import="service.impl.DepartmentServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>部门管理</title>
   <link rel="stylesheet" href="./plug/bootstrap.min.css">
    <script src="./plug/jquery-3.2.1.min.js"></script>
    <script src="./plug/bootstrap.min.js"></script>
    <script>
        $(function(){
        	$(".ip").prop("readOnly",true);
			  $(".ip").prop("disabled",true);
        	//$("#ip").css("background-color","");
        	$("#app").click(function(){
                alert("添加成功")
            })
			  $(".edit").click(function(){
				  var input=$(this).parent().parent().children(".success").children(".ip");
				  var cancel=$(this).parent().children("#cancel");
				  input.prop("readOnly",false);
				  input.prop("disabled",false);
				  input.css("background-color","white");
				  input.focus();
				  cancel.css("display","inline-block");
        })
        $(".ip").blur(function(){
				 var input=$(this);
				  var cancel=$(this).parent().parent().children(".warning").children(".cancel");
				  input.prop("readOnly",true);
				  input.prop("disabled",true);
				  input.css("background-color","#dff0d8");
				  //input.focus();
				  cancel.css("display","none");
				 // $(this).parent().children(".a").trigger("click");
				 
				  window.location.href="UpdDeptnameServlet?deptinfo="+$(this).attr("name")+":"+$(this).val();
				  
		})
        	  
        });
    </script>
<style type="text/css">
	
 body{ background: lightgray;}
        .box{
            width: 90%;
            position: absolute;
            left:4px;
            top: 25px;;
            border:1px solid rgb(19, 20, 20);
            padding: 30px;
            
            }
        .tip{font-weight: bold;}
        .w{
            width: 750px;
            height:30px;
           
           	
        }
        .b{font-weight:blod;}
          tr td{height: 40px;text-align:center;font-size:10px;}
        thead td{font-weight:bold;font-size:15px;}
        .ip{
        	border:none;
        	background:#dff0d8;
        }
        .cancel{
        	display:none;
        }
        .r{
        	text-align:center;
        }
        .fl{
        	float:right;
        	
        }
        .ra{
        	line-height:30px ;
        	position: relative;
            top: 6px;
        	
        }
        .zhuangtai{
        	height:30px;
        }
        .t{
        	position: relative;
            top: 2px;
        }
        .mybtn{
        	position: relative;
            top: 5px;
            left:2px
        }
        .btn{
        	 background: rgb(80, 76, 76);
        	 border: 1px solid rgb(83, 83, 83);
        	 color:white
        }
        .input-group-addon{
        background: rgb(80, 76, 76);
        color:white;
        }
        .l{
        	position:relative;
        	left:-14px
        }
        #ww{
        	width:40px;
        }
        .bl{
        	font-weight:bold;
        }
        	
</style>
</head>

<body>
<span class="tip">会议预定>搜索会议</span>
   <div class="box">
<form action="appDeptServlet" method="get">
<label for="basic-url">搜索会议:</label>
<br>
    <div class="input-group w ">
    <span class="input-group-addon" id="basic-addon3">会议姓名:</span>
    <input name="deptname" type="text" class="form-control " aria-label="部门名称" placeholder="例如：探讨会议"> 
    <span 	class="input-group-addon" id="basic-addon3">会议室名称:</span>
    <input name="deptname" type="text" class="form-control " aria-label="部门名称" placeholder="例如：201会议室">
    <span 	class="input-group-addon" id="basic-addon3">预定者姓名:</span>
    <input name="deptname" type="text" class="form-control " aria-label="部门名称" placeholder="例如：张三">
    </div>
     <div class="input-group w ">
    <span class="input-group-addon" id="basic-addon3">预定日期:&nbsp;&nbsp;&nbsp;&nbsp;从</span>
    <input name="deptname" type="datetime-local" class="form-control " aria-label="部门名称"> 
    <span 	class="input-group-addon" id="basic-addon3">到</span>
    <input name="deptname" type="datetime-local" class="form-control " aria-label="部门名称">
    </div>
  
  <div class="input-group w ">
    <span class="input-group-addon" id="basic-addon3">会议日期:&nbsp;&nbsp;&nbsp;&nbsp;从</span>
    <input name="deptname" type="datetime-local" class="form-control " aria-label="部门名称"> 
    <span 	class="input-group-addon" id="basic-addon3">到</span>
    <input name="deptname" type="datetime-local" class="form-control " aria-label="部门名称">
    </div>
  
   <div class="input-group w mybtn">
            <button type="submit" class="btn btn-success">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-success">重置</button>
     </div>  
    
</form>
<br>
<label for="basic-url" class="r">查询结果:</label><br>
<label for="basic-url" class="r">共54条结果，分别6页显示，当前第1页</label>
<br>
<form class="navbar-form navbar-left l" role="search">
  <div class="form-group">
  <button type="submit" class="btn btn-default">首页</button>
  <button type="submit" class="btn btn-default">上页</button>
  <button type="submit" class="btn btn-default">下页</button>
  <button type="submit" class="btn btn-default">末页</button>
 <span class="bl"> 跳转到</span>
    <input type="text" id="ww" class="form-control w2" placeholder=""><span class="bl">页</span>
  </div>
  <button type="submit" class="btn btn-default">跳转</button>
</form>

    <table class="table table-bordered container-fluid">
        <thead class="row">
            <td class="active col-md-2">会议名称</td>
            <td class="success col-md-2">会议室名称</td>
            <td class="warning col-md-2">会议开始时间</td>
            <td class="success col-md-2">会议结束时间</td>
            <td class="warning col-md-2">会议预定时间</td>
            <td class="warning col-md-1">预定者</td>
            <td class="warning col-md-1">操作</td>
        </thead>
            <td class="active col-md-2">会议名称</td>
            <td class="success col-md-2">会议室名称</td>
            <td class="warning col-md-2">会议开始时间</td>
            <td class="success col-md-2">会议结束时间</td>
            <td class="warning col-md-2">会议预定时间</td>
            <td class="warning col-md-1">预定者</td>
            <td class="warning col-md-1"> <a class="label label-info" href="">查看详情</a></td>
      	</table>
   </div>
</body>
</html>