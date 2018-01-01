<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="static/css/pintuer.css">
	<link rel="stylesheet" href="static/css/admin.css">
	<link type="image/x-icon" href="static/images/logo.jpg" rel="shortcut icon" />
	<link href="static/images/favicon.ico" rel="bookmark icon" />
	
	<!--
	<script src="path"></script>
	-->
	<script src="static/js/jquery.js"></script>
	<script src="static/js/pintuer.js"></script>
	<script src="static/js/respond.js"></script>
	<script src="static/js/admin.js"></script>
	<script src="static/js/layer.js"></script>
	
	<script src="static/js/rsa/RSA.js"></script>
	<script src="static/js/rsa/BigInt.js"></script>
	<script src="static/js/rsa/Barrett.js"></script>
	<script src="static/js/rsa/rsaEncrypt.js"></script>
  </head>
  
  <body style="background-image: url(static/css/images/loginBg.jpg);">
		<div class="container">
			<div class="line">
				<div class="xs6 xm4 xs3-move xm4-move">
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<form id="loginForm" action="index.html" method="post">
						<input type="hidden" value="" name="modulus" id="modulus"/>
						<div class="panel padding">
							<div class="text-center">
								<br>
								<h2><strong>App管理平台管理</strong></h2></div>
							<div class="" style="padding:30px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="text" class="input" id="loginName" name="loginName" placeholder="登录账号" />
										<span class="icon icon-user padding"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input" id="userPwd" name="userPwd" placeholder="登录密码"  />
										<span class="icon icon-key padding"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<input type="text" class="input" id="passcode" name="passcode" placeholder="填写右侧的验证码"  />
										<img id="passcodeImg" src="" width="80" height="32" class="passcode" />
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<button class="button button-block bg-main text-big" type="submit" onclick="login();return false;">立即登录后台</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="hidden">
				<!-- Javascript -->
	<script src="static/assets/js/jquery-1.8.2.min.js"></script>
	<script src="static/assets/js/supersized.3.2.7.min.js"></script>
	<script src="static/assets/js/scripts.js"></script>
	<script type="text/javascript">
		$(function(){
			loadVCode();
			loadModulus();
		});
		//加载验证码
		function loadVCode() {
			$.post('<%=path%>/system/user/getVCode', function(data) {
				if (data != null) {
					$("#passcodeImg").attr("src",data);
				}
			});
		}
		//登陆
		function login(){
			var loginName = $('#loginName').val();
			var userPwd = $('#userPwd').val();
			if(loginName == ''){
				$('#loginName').focus();
			} else if(userPwd == ''){
				$('#userPwd').focus();
			}else if($('#passcode').val() == ''){
				$('#passcode').focus();
			}else{
				var modulus = $('#modulus').val().replace(/"/g,'');//替换掉双引号，否则后台解密后为null
				var name = rsaEncrypt(modulus,loginName);
				var password = rsaEncrypt(modulus,userPwd);
				var passcode = $('#passcode').val();
				//$('#loginName').val(name);
				//$('#userPwd').val(password);
				//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
				$.post("<%=path%>/system/user/findUserForLogin", {loginName:name,userPwd:password,passcode:passcode}, function(data){
					if("0" == data.status){
						layer.alert("登录失败！登陆名或密码为空！",{icon:2});
					}else if("1"==data.status){
						//layer.msg('成功!准备开始跳转', {icon: 1});
						window.location.href='<%=path%>/PlatformAdmin/index.jsp';
					} else if ("2" == data.status) {
						layer.alert("用户名或密码错误！", {
							icon : 0
						});
					} else if ("3" == data.status) {
						layer.alert("用户已注销！", {
							icon : 0
						});
					} else if ("4" == data.status) {
						layer.alert("用户已禁用！", {
							icon : 0
						});
					} else if ("5" == data.status) {
						layer.alert("用户末注册！", {
							icon : 0
						});
					} else if ("6" == data.status) {
						layer.alert("单位已注销！", {
							icon : 0
						});
					} else if ("7" == data.status) {
						layer.alert("单位已停用！", {
							icon : 0
						});
					} else if ("8" == data.status) {
						$('#passcode').val("");
						$('#userPwd').focus();
						layer.alert("验证码错误！", {
							icon : 0
						});
					}
					if ("1" != data.status) {
						loadVCode();
					}
				},"json");
			}
		}
	</script>
		</div>
	</body>

</html>
