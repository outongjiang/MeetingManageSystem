<%@page import="model.Employee"%>
<%@page import="service.impl.EmployeeServiceImpl"%>
<%@page import="model.Meeting"%>
<%@page import="java.util.List"%>
<%@page import="service.impl.MeetingServiceimpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./plug/bootstrap.min.css">
    <script src="./plug/jquery-3.2.1.min.js"></script>
    <script src="./plug/bootstrap.min.js"></script>
    <style>
        tr td{height: 40px;text-align:center;font-size:10px;}
        thead td{font-weight:bold;font-size:15px;}
         body{ background: lightgray;}
        .box{
            width: 80%;
            position: absolute;
            left:4px;
            top: 25px;;
            border:1px solid rgb(19, 20, 20);
            padding: 30px;}
        .tip{font-weight: bold;}
        h4{font-weight: bold;}
    </style>
</head>
<body>
 <span class="tip">人员管理>注册审批</span>
   <div class="box">
    <h4>所有待审批注册信息</h4>
    <table class="table table-bordered">
        <thead>
            <td class="active col-md-2">姓名</td>
            <td class="success col-md-2">账号名</td>
            <td class="warning col-md-3">联系电话</td>
            <td class="info col-md-3">电子邮件</td>
            <td class="danger col-md-2">操作</td>
        </thead> 
        <%EmployeeServiceImpl esil=new 	EmployeeServiceImpl();
        	List<Employee>regiterinfo=esil.selectRegiterInfo();%>
      			<% for(Employee e:regiterinfo){%>
      			<tr>
        <td class="active col-md-2"><%=e.getEmployeename()%></td>
        <td class="success col-md-2"><%=e.getUsername()%></td>
        <td class="warning col-md-3"><%=e.getPhone()%></td>
        <td class="info col-md-3"><%=e.getEmail()%></td>
        <td class="danger col-md-2">
            <a class="label label-info" href="ExamEmpRegisterServlet?Exam_registerInfo=<%=e.getEmployeeid()%>">通过</a>
            <a class="label label-info" href="DelEmpRegisterServlet?del_registerInfo=<%=e.getEmployeeid()%>">删除</a>
        </td>
        </tr>
        <% }%>
      </table>
      </div>
</body>
</html>