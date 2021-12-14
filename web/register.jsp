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
        .w{
            width: 200px;
        }
    </style>
</head>
<body>
    <span class="tip">人员管理>员工注册 </span>
    <div class="box">
        <form class="form-horizontal" method="GET" action="RegisterServlet">
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-10">
                  <input type="text" name="employeename" class="form-control w" id="inputname3" placeholder="姓名">
                </div>
            </div>
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">账户名:</label>
              <div class="col-sm-10">
                <input  type="text" name="username"  class="form-control w" id="inputusername3" placeholder="账户名">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
              <div class="col-sm-10">
                <input type="password" name="password" class="form-control w" id="inputPassword3" placeholder="密码">
              </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">确认密码:</label>
                <div class="col-sm-10">
                  <input name="password" type="password" class="form-control w" id="inputPassword32" placeholder="确认密码">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">联系电话:</label>
                <div class="col-sm-10">
                  <input type="text" name="phone" class="form-control w" id="inputPhone3" placeholder="联系电话">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">电子邮件:</label>
                <div class="col-sm-10">
                  <input type="text" name="email" class="form-control w" id="inputEmail3" placeholder="电子邮件">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">所在部门:</label>
                <div class="col-sm-10">
                   <select name="departmentid" id="" size="1">
                  <% DepartmentServiceImpl departmentServiceImpl=new DepartmentServiceImpl();%>
                   	<%List<Department>deptSet=new ArrayList<Department>(); %>
                   	<%deptSet=departmentServiceImpl.selectDept(); %>
                   	<%for(Department dept:deptSet){%>
                   		<option value="<%=dept.getDepartmentid()%>"><%=dept.getDepartmentname()%></option>
                   	<% }%>
                 </select>
                </div>
            </div>
           <div class="mybtn">
            <button type="submit" class="btn btn-success">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-success">重置</button>
            
           </div>
          </form>
    </div>


      
</body>
</html>