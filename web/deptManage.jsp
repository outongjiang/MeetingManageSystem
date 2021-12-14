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
            width: 70%;
            position: absolute;
            left:4px;
            top: 25px;;
            border:1px solid rgb(19, 20, 20);
            padding: 30px;}
        .tip{font-weight: bold;}
        .w{
            width: 350px;
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
</style>
</head>

<body>
<span class="tip">人员管理>部门管理 </span>
   <div class="box">
<form action="appDeptServlet" method="get">
<label for="basic-url">添加部门:</label>
    <div class="input-group w ">
    <span class="input-group-addon" id="basic-addon3">部门名称:</span>
        <input name="deptname" type="text" class="form-control " aria-label="部门名称">
        <div class="input-group-btn ">
        	<button type="submit" class="btn btn-info " id="app">添加</button>
          <!-- Buttons -->
        </div>
      </div>
</form>
<br>
<label for="basic-url">所有部门:</label>
    <table class="table table-bordered container-fluid">
        <thead class="row">
            <td class="active col-md-2">部门编号</td>
            <td class="success col-md-5">部门名称</td>
            <td class="warning col-md-5">操作</td>
        </thead>  
         
                <% DepartmentServiceImpl departmentServiceImpl=new DepartmentServiceImpl();%>
                <%List<Department>deptSet=new ArrayList<Department>(); %>
                <%deptSet=departmentServiceImpl.selectDept(); %>
                <%for(Department dept:deptSet){%>
                     <tr>
                      <td class="active "><%=dept.getDepartmentid() %></td>
                      <td class="success ">
                      <%String deptinfo=dept.getDepartmentid()+":"+dept.getDepartmentname(); %>
                      <input name="<%=dept.getDepartmentid()%>" class="ip" id="ip" type="text" value="<%=dept.getDepartmentname()%>">
                      </td>
                      <td class="warning "><a  class="label label-info del" href="DelDeptServlet?medicine_message1=<%=dept.getDepartmentid()%>" target="middle">删除</a>
                      <a id="edit" class="label label-info edit" href="..." onclick="return false">编辑</a>
                      <a id="cancel" class="label label-info cancel" href="..." onclick="return false">取消</a> 
                      </td>
                    </tr>
                 <% }%>
                 
            
      	</table>
   </div>
</body>
</html>