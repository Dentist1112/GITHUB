<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listOrderItem.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1 align="center">购物车</h1><!-- 单价  数量 小计 -->
   <table  align="center"  cellspacing="1" border="1">
   <tr>
   <td>商品名</td>
   <td>单价</td>
   <td>数量</td>
   <td>小计</td>
   <td>delete</td>
   </tr>
    <c:forEach items="${ois}" var="oi"  varStatus="st">
    <tr>
   <td>${oi.product.name}</td>
   <td>${oi.product.price}</td>
   <td>${oi.num}</td>
   <td>${oi.num*oi.product.price}</td> 
   <td><a href="deleteOrderItem?pid=${oi.product.id} ">delete</a></td><!-- 获取产品id值 -->
   </tr>
   </c:forEach>
   <c:if test="${not empty ois }" >
   <tr  align="right">
   <a href="creatOrder">生成订单</a>
   </tr>
   
   </c:if>
   </table> 
    
  </body>
</html>
