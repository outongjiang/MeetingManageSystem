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
            width: 500px;
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
<span class="tip">会议预定>搜索员工 </span>
   <div class="box">
<form action="researchEmpServlet" method="get">
<label for="basic-url">搜索员工:</label>
<br>
    <div class="input-group w ">
        <span class="input-group-addon" id="basic-addon3">姓名:</span>
        <input name="employeename" type="text" class="form-control " aria-label="部门名称">
        <span 	class="input-group-addon" id="basic-addon3">账号名:</span>
        <input name="username" type="text" class="form-control " aria-label="部门名称">
    </div>
    <div class="input-group w t">
    <span class="input-group-addon zhuangtai" id="basic-addon3">状态:</span>
  &nbsp; 
        <input type="radio" class="ra" name="status" id="inlineRadio1" value="0">已批准
      
        &nbsp; 
        <input type="radio" class="ra" name="status" id="inlineRadio2" value="1">待审批
       &nbsp;  
      
        <input type="radio" class="ra" name="status" id="inlineRadio3" value="2">已关闭
      
      </div>
  
   <div class="input-group w mybtn">
            <button type="submit" class="btn btn-success">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-success">重置</button>
     </div>  
    
</form>
<br>

<label for="basic-url" class="r">查询结果:</label><br>
       <label for="basic-url" class="r">共<%=request.getAttribute("sumPage")%>条结果，分别<%=Integer.parseInt(String.valueOf(request.getAttribute("sumPage")))%5==0?Integer.parseInt(String.valueOf(request.getAttribute("sumPage")))/5:Integer.parseInt((String) request.getAttribute("sumPage"))/5+1%>页显示，当前第<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))+1%>页</label>
<br>
<form class="navbar-form navbar-left l" role="search" action="researchEmpServlet" method="get">
  <div class="form-group">
      <button type="submit" name="currPage" value="0" class="btn btn-default">首页</button>
      <button type="submit" name="currPage" value="<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))-1%>" class="btn btn-default">上页</button>
      <button type="submit" name="currPage" value="<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))+1%>" class="btn btn-default">下页</button>
      <button type="submit" name="currPage" value="max" class="btn btn-default">末页</button>
      <span class="bl"> 跳转到</span>
    <input type="text"  name="currPagetext" id="ww" class="form-control w2" placeholder=""><span class="bl">页</span>
  </div>
  <button type="submit" name="" value="" class="btn btn-default">跳转</button>
</form>

    <table class="table table-bordered container-fluid">
        <thead class="row">
            <td class="active col-md-2">姓名</td>
            <td class="success col-md-2">账号名</td>
            <td class="warning col-md-2">联系电话</td>
            <td class="success col-md-3">电子邮件</td>
            <td class="warning col-md-3">操作</td>
        </thead>
        <%  List<Employee> emp= (List<Employee>) request.getAttribute("employee"); %>
        <%for(Employee e:emp){%>
           <tr> <td class="active "><%=e.getEmployeename()%></td>
            <td class="success "><%=e.getUsername()%></td>
            <td class="warning "><%=e.getPassword()%></td>
            <td class="success "><%=e.getEmail()%></td>
            <td class="warning ">  <a class="label label-info" href="closeUserServlet?empid_f=<%=String.valueOf(e.getEmployeeid())%>">关闭账号</a></td></tr>
        <%}%>

      	</table>
   </div>
</body>
</html>