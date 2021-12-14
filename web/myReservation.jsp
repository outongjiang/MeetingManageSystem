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
 <span class="tip">个人中心>我的预定</span>
   <div class="box">
    <h4>我预定的会议</h4>
    <table class="table table-bordered">
        <thead>
            <td class="active col-md-3">会议名称</td>
            <td class="success col-md-2">会议室</td>
            <td class="warning col-md-2">起始时间</td>
            <td class="info col-md-2">结束时间</td>
            <td class="danger col-md-2">会议预定时间</td>
            <td class="info col-md-1">操作</td>
        </thead> 
          <% MeetingServiceimpl msi=new MeetingServiceimpl();
      		List<Meeting>meetings=msi.selectMeeting();%>
      		<%for(Meeting m:meetings){%>
      			<tr>
                <td class="active col-md-3"><%=m.getMeetingname()%></td>
                <td class="success col-md-2"><%=m.getRoomname()%></td>
                <td class="warning col-md-2"><%=m.getStarttime()%></td>
                <td class="info col-md-2"><%=m.getEndtime()%></td>
                <td class="danger col-md-2"><%=m.getReservationtime()%></td>
                <td class="info col-md-1"><a class="label label-info" href="">查看详情</a></td>
              </tr>
      		<% }%>
          
      </table></div>
</body>
</html>