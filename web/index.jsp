<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/11/29
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <title>translate3D（）方法</title>
  <style>
    div#container {
      width: 320px;
      height: 320px;
      margin: 200px auto;
      perspective: 2000px;
    }
    div.picture{
      width: 320px;
      height: 320px;
      margin: 200px auto;
      position: relative;
      /* perspective: 8000px; */
      transform-style: preserve-3d;
      animation:move 6s linear infinite;
    }
    div.picture img{
      width:320px;
      height: 320px;

      position:absolute;
      left:0;
      top:0;
      opacity: 0.6;
    }
    div.picture img.no1{
      transform:translateZ(160px)

    }
    div.picture img.no2{
      transform:rotateX(90deg) translateZ(160px)
    }
    div.picture img.no3{
      transform:rotateX(-90deg) translateZ(160px)
    }
    div.picture img.no4{
      transform:rotateY(90deg) translateZ(160px)
    }
    div.picture img.no5{
      transform:rotateY(-90deg) translateZ(160px)
    }
    div.picture img.no6{
      transform:rotateY(180deg) translateZ(160px)
    }
    @keyframes move{
      0%{
        transform:rotate3d(1,1,0,0deg)
      }
      100%{
        transform:rotate3d(1,1,0,360deg)
      }
    }
    div.picture div{
      width:100px;
      height: 100px;
      background:gold;
      position: absolute;
      left:100px;
      top:100px;
      text-align: center;
      line-height: 100px;
      font-size: 80px;
      opacity: 0.6;
    }
    div.picture div:nth-of-type(1){
      transform:translateZ(50px);
    }
    div.picture div:nth-of-type(2){
      transform:rotateX(90deg) translateZ(50px);
    }
    div.picture div:nth-of-type(3){
      transform:rotateX(-90deg) translateZ(50px);
    }
    div.picture div:nth-of-type(4){
      transform:rotateY(90deg) translateZ(50px);
    }
    div.picture div:nth-of-type(5){
      transform:rotateY(-90deg) translateZ(50px);
    }
    div.picture div:nth-of-type(6){
      transform:rotateY(180deg) translateZ(50px);
    }


    div.picture:hover img.no1{
      transform:translateZ(320px)

    }
    div.picture:hover img.no2{
      transform:rotateX(90deg) translateZ(320px)
    }
    div.picture:hover img.no3{
      transform:rotateX(-90deg) translateZ(320px)
    }
    div.picture:hover img.no4{
      transform:rotateY(90deg) translateZ(320px)
    }
    div.picture:hover img.no5{
      transform:rotateY(-90deg) translateZ(320px)
    }
    div.picture:hover img.no6{
      transform:rotateY(180deg) translateZ(320px)
    }


    div.picture:hover div:nth-of-type(1){
      transform:translateZ(100px);
    }
    div.picture:hover div:nth-of-type(2){
      transform:rotateX(90deg) translateZ(100px);
    }
    div.picture:hover div:nth-of-type(3){
      transform:rotateX(-90deg) translateZ(100px);
    }
    div.picture:hover div:nth-of-type(4){
      transform:rotateY(90deg) translateZ(100px);
    }
    div.picture:hover div:nth-of-type(5){
      transform:rotateY(-90deg) translateZ(100px);
    }
    div.picture:hover div:nth-of-type(6){
      transform:rotateY(180deg) translateZ(100px);
    }
  </style>
</head>

<body>
<div id="container">
  <div class="picture">

    <img class="no1" src="./images/微信图片_20211205200317.jpg" alt="1">
    <img class="no2" src="./images/微信图片_20211205200337.jpg" alt="2">
    <img class="no3" src="./images/微信图片_20211205200347.jpg" alt="2">
    <img class="no4" src="./images/微信图片_20211205200359.jpg" alt="2">
    <img class="no5" src="./images/微信图片_20211205200406.jpg" alt="2">
    <img class="no6" src="./images/微信图片_20211205200317.jpg" alt="2">
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
  </div>
</div>


</body>

</html>