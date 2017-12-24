<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listProduct.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	$(function(){
	$("input.addCartButton").click(function(){
		$(this).attr("disabled","disabled");
			var button=$(this);
			var pid=$(this).attr("pid");
			var number=$("input.number[pid="+pid+"]").val();
			var page="addOrderItem";
			$.get( 
			page,
			{"num":number,"pid":pid},
			function(result){
			$("#addCartSuccessMessage").fadeIn(1200);
			$("#addCartSuccessMessage").fadeOut(1200,function(){
						button.removeAttr("disabled")
						});
			}
		);
	});
$("#addCartSuccessMessage").hide();
});
	</script>
  </head>
  <body>
   <c:if test="${not empty user}">
   <div align="center">
   当前用户为：${user.name} <br>
   </div>
   </c:if>
   <div align="center" style="height:20px;width:100px;margin:0 100px 0 ;"  ><span style="color:red" id="addCartSuccessMessage">添加购物车成功</span></div>
   <table align="center" cellspacing="1" border="1">
   <tr>
   <td>id</td> <td>商品名</td> <td>价格</td> <td>购买</td>
   </tr>
   <c:forEach items="${products}" var="product" varStatus="st">
   <tr>
    <td>${product.id} </td> 
    <td>${product.name} </td> 
    <td>${product.price}</td>
    <!-- 添加购买按钮 --><td>数量<input pid="${product.id}" type="text" value="1"  name="num" class="number"/>
    <input type="submit"  class="addCartButton"  value="加入购物车" pid="${product.id}"  /></td>
   </tr>
   </c:forEach>
   <tr>
   <td><a href="listOrderItem.jsp">查看购物车</a></td></tr>
   </table>
  </body>
</html>
