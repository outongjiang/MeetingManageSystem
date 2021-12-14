<%@page import="model.MeetingRoom"%>
<%@page import="service.impl.MeetingRoomServiceimpl"%>
<%@ page language="java" contentType="text/html; utf-8"
pageEncoding="utf-8"%>
<%@page import="java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../plug/bootstrap.min.css">
    <script src="../plug/jquery-3.2.1.min.js"></script>
    <script src="../plug/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".skip").click(function () {
            $(this).val($(ww).val()-1);
        });
    })
</script>
<style>
 body{ background: lightgray;}
        .box{
            width: 70%;
            position: absolute;
            left:4px;
            top: 25px;;
            border:1px solid rgb(19, 20, 20);
            padding: 30px;}
        .tip{font-weight: bold;}
         tr td{height: 40px;text-align:center;font-size:10px;}
        thead td{font-weight:bold;font-size:15px;}
        .rr{
            position: relative;
            left: -20px;
        }
        #ww{
            width:50px;
        }

    </style>

<body>
<span class="tip">会议预订>查看会议室 </span>
   <div class="box">
<label for="basic-url">所有会议室:</label>
<br>
       <label for="basic-url" class="r">查询结果:</label><br>
       <label for="basic-url" class="r">共<%=request.getAttribute("sumPage")%>条结果，分别<%=Integer.parseInt(String.valueOf(request.getAttribute("sumPage")))%5==0?Integer.parseInt(String.valueOf(request.getAttribute("sumPage")))/5:Integer.parseInt((String) request.getAttribute("sumPage"))/5+1%>页显示，当前第<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))+1%>页</label>
       <br>
       <form class="navbar-form navbar-left l" role="search" action="allmeetingroomsServlet" method="get">
           <div class="form-group rr">
               <button type="submit" name="currPage" value="0" class="btn btn-default">首页</button>
               <button type="submit" name="currPage" value="<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))-1%>" class="btn btn-default">上页</button>
               <button type="submit" name="currPage" value="<%=Integer.parseInt(String.valueOf(request.getAttribute("currPage")))+1%>" class="btn btn-default">下页</button>
               <button type="submit" name="currPage" value="max" class="btn btn-default">末页</button>
               <span class="bl"> 跳转到</span>
               <input type="text"  id="ww" class="form-control w2" placeholder=""><span class="bl">页</span>
           </div>
           <button type="submit" name="currPage" value="max" class="btn btn-default skip">跳转</button>
       </form>
    <table class="table table-bordered container-fluid">
        <thead class="row">
            <td class="active col-md-2">门牌编号</td>
            <td class="success col-md-3">会议室名称</td>
            <td class="warning col-md-2">容纳人数</td>
            <td class="warning col-md-2">当前状态</td>
            <td class="warning col-md-3">操作</td>
        </thead>
        <% List<MeetingRoom> meetrRoom= (List<MeetingRoom>) request.getAttribute("meetrRoom");%>
        <%for (MeetingRoom m:meetrRoom){%>
			<tr>
                <td class="active"><%=m.getRoomnum()%></td>
                <td class="success"><%=m.getRoomname()%></td>
                <td class="warning"><%=m.getCapacity()%></td>
                <td class="warning"><%=m.getStatus().equals("0")?"可用":"不可用"%></td>
                <td class="info col-md-1"><a class="label label-info" href="updatemeetingroomsServlet?status=<%=m.getStatus()%>&roomid=<%=m.getRoomid()%>">修改状态</a></td>
            </tr>
            <%}%>
      	</table>
   </div>
</body>
</html>