<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		<form action="pc/pay/alipayapiAction" method="POST">
   			会员名称：<input name="" id="" value=""><br>
   			商品类型：<input name="" id="" value=""><br>
   			付款金额：<input name="" id="" value=""><br>
   			<button type="button" id="alipayAjaxButton" class="button button-big bg-main" style="width:185px;"><i class="icon-jpy"></i> 支付宝支付</button>
   		</form>
  </body>
  <script>
		$(function() {
	         $('#alipayAjaxButton').click(function() {
	        	 alert("hello");
				$('#alipayAjaxForm').ajaxSubmit(function() {
					alert("hello");
					$('#alipayAjaxForm').submit();
					alert("hello");
				});
			});
		});
	</script>
</html>
