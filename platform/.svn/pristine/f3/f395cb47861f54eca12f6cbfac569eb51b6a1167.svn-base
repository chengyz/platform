<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
    #userEditForm .autocompleter {
	    left: 0px;
	    margin-top:1px;
	}
</style>
	<link rel="stylesheet" href="static/css/pintuer.css">
	<link rel="stylesheet" href="static/css/admin.css">
	<link type="text/css" rel="stylesheet" href="static/js/autocompleter/jquery.autocompleter.css">
	<script src="static/js/jquery.js"></script>
	<script src="static/js/pintuer.js"></script>
	<script src="static/js/respond.js"></script>
	<script src="static/js/layer.js"></script>
	<script src="static/js/autocompleter/jquery.autocompleter.min.js"></script>
  </head>
  
<body>
	<div id="container" style="margin:0 auto"></div>
	<div id="myDialog" onload="onLoad()" style="margin-top:10px">
		<div class="dialog-body" style="margin-left:30px">
			<form id="userEditForm" method="post" class="form-small" style="width:94%;" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id">
				<input type="hidden" id="userUUID" name="userUUID">
				<input type="hidden" id="userPwd" name="userPwd">
				<input type="hidden" id="unitUUID" name="unitUUID">
				<input type="hidden" id="userTel" name="userTel">
				<input type="hidden" id="userEmail" name="userEmail">
				<input type="hidden" id="nickName" name="nickName">
				<input type="hidden" id="userSex" name="userSex">
				<input type="hidden" id="userStatus" name="userStatus">
				<input type="hidden" id="createTime" name="createTime">
				<input type="hidden" id="updateTime" name="updateTime">
				<input type="hidden" id="simpleSpelling" name="simpleSpelling">
				<input type="hidden" id="fullSpelling" name="fullSpelling">
				<input type="hidden" id="queryCombination" name="queryCombination">
				<input type="hidden" id="userPic" name="userPic">
				<input type="hidden" id="userDescription" name="userDescription">
				<input type="hidden" id="loginTime" name="loginTime">
				<input type="hidden" id="loginNum" name="loginNum">
				<div class="form-group">
					<div class="label">
						<label for="loginName"> 登录名 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="loginName" name="loginName" size="32" maxlength="32" value="" placeholder="请输入用户登录名">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="userName"> 姓名 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="userName" name="userName" size="50" maxlength="50" value="" placeholder="请输入用户姓名">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="unitName"> 所属单位（企业） </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="unitName" name="unitName" size="50" maxlength="50" value="" placeholder="请输入用户姓名">
					</div>
				</div>
					<div class="form-group">
						<div class="label">
							<label>
								性别</label>
						</div>
						<div class="field">
							<div class="button-group radio">
								<label class="button active">
									<input id="userSexM" name="userSex" value="1" checked="checked" type="radio"><span class="icon icon-male"></span> 先生
								</label>
								<label class="button">
									<input id="userSexF" name="userSex" value="2" type="radio"><span class="icon icon-female"></span> 女士
								</label>
							</div>
						</div>
					</div>
				<div class="form-group">
					<div class="label">
						<label for="userType"> 用户类型 </label>
					</div>
					<div class="field">
						<select class="input" id="userType" name="userType">
							
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="userMobile"> 手机 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="userMobile" name="userMobile" size="11" maxlength="11" value="" placeholder="请输入手机号码">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hidden">
		<script type="text/javascript">
		$(function(){
			loadUserType("${sessionScope.userType}");
			$("#unitName").autocompleter({
		   		source: '<%=path%>/system/unit/findUnitNameToAutoComplete',
		   		focusOpen:false,
		   		selectFirst:true,
		   		limit:200,
		   		changeWhenSelect:true,
		   		empty:false,
		   		highlightMatches:true,
		   		callback:function (value,index,selected){
		   			if (selected){
		   				$("#unitUUID").val(selected.hideValue);
		   			}
		   		}
			   	});
		   	$("#unitName").blur(function (){
		   		if ($("#unitUUID").val()==""){
		   			$("#unitName").val($("#unitUUID").val());
		   		}
		   	});
		});
			function validate() {
				if (!$('#loginName').val()) {
					layer.msg('用户登录名不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#userName').val()) {
					layer.msg('用户姓名不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#userMobile').val()) {
					layer.msg('用户电话不能为空！', {
						icon : 2
					});
					return false;
				}
				return true;
			}
			//初始化数据
			function getFromSerialize() {
				return $('#userEditForm').serialize();
			}
			//修改数据时
			function initData(data) {
				$('#id').val(data.id);
				$('#userUUID').val(data.userUUID);
				$('#loginName').val(data.loginName);
				$('#userPwd').val(data.userPwd);
				$('#unitUUID').val(data.unitUUID);
				$('#unitName').val(data.unitName);
				$('#userName').val(data.userName);
				$('#userType').val(data.userType);
				$('#userMobile').val(data.userMobile);
				$('#userTel').val(data.userTel);
				$('#userEmail').val(data.userEmail);
				$('#nickName').val(data.nickName);
				$('#userSex').val(data.userSex);
				$('#userStatus').val(data.userStatus);
				$('#createTime').val(data.createTime);
				$('#updateTime').val(data.updateTime);
				$('#simpleSpelling').val(data.simpleSpelling);
				$('#fullSpelling').val(data.fullSpelling);
				$('#queryCombination').val(data.queryCombination);
				$('#userPic').val(data.userPic);
				$('#userDescription').val(data.userDescription);
				$('#loginTime').val(data.loginTime);
				$('#loginNum').val(data.loginNum);
			}
			
			function loadUserType(userType){
				var htmlStr = "";
				if(userType=="0"){
					htmlStr = '<option value="1">一般管理员</option>\
							<option value="2">普通用户</option>\
							<option value="3">企业管理员</option>';
				}else if(userType=="1"){
					htmlStr = '<option value="2">普通用户</option>\
							<option value="3">企业管理员</option>';
				}else if(userType=="2"){
					htmlStr = '<option value="">无选项</option>';
				}else if(userType=="3"){
					htmlStr = '<option value="4">一般管理员</option>\
							<option value="5">普通用户</option>';
				}else if(userType=="4"){
					htmlStr = '<option value="5">普通用户</option>';
				}else if(userType=="5"){
					htmlStr = '<option value="">无选项</option>';
				}else {
					htmlStr = '<option value="">无选项</option>';
				}
				$("#userType").html(htmlStr);
			}
		</script>
	</div>
</body>
</html>
