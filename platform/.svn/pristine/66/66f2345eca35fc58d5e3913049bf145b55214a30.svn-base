<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单信息编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="static/css/pintuer.css">
	<link rel="stylesheet" href="static/css/admin.css">
	
	<script src="static/js/jquery.js"></script>
	<script src="static/js/pintuer.js"></script>
	<script src="static/js/respond.js"></script>
	<script src="static/js/layer.js"></script>
  </head>
  
<body>
	<div id="container" style="margin:0 auto"></div>
	<div id="myDialog" onload="onLoad()" style="margin-top:10px">
		<div class="dialog-body" style="margin-left:30px">
			<form id="roleItemEditForm" method="post" class="form-small" style="width:94%;" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id">
				<input type="hidden" id="roleUUID" name="roleUUID">
				<input type="hidden" id="unitUUID" name="unitUUID">
				<input type="hidden" id="createTime" name="createTime">
				<input type="hidden" id="createUserUUID" name="createUserUUID">
				<input type="hidden" id="createUserName" name="createUserName">
				<div class="form-group">
					<div class="label">
						<label for="roleName"> 角色名称 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="roleName" name="roleName" size="100" maxlength="100" value="" placeholder="请输入角色名称">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="roleMark"> 角色备注 </label>
					</div>
					<div class="field">
						<textarea rows="8" cols="20" id="roleMark" name="roleMark" type="text" maxlength="500" style="width: 100%; class="input" placeholder="请输入角色备注" ></textarea>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hidden">
		<script type="text/javascript">
			function validate() {
				if (!$('#roleName').val()) {
					layer.msg('角色名不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#roleMark').val()) {
					layer.msg('角色备注不能为空！', {
						icon : 2
					});
					return false;
				}
				return true;
			}
			//初始化数据
			function getFromSerialize() {
				return $('#roleItemEditForm').serialize();
			}
		    function initDataForAdd(data) {
				$('#unitUUID').val("${sessionScope.unituuid}");
			}                    	    	
			//修改数据时
			function initData(data) {
				$('#id').val(data.id);
				$('#roleUUID').val(data.roleUUID);
				$('#roleName').val(data.roleName);
				$('#roleMark').val(data.roleMark);
				$('#unitUUID').val(data.unitUUID);
				$('#createTime').val(data.createTime);
				$('#createUserUUID').val(data.createUserUUID);
				$('#createUserName').val(data.createUserName);
			}
		</script>
	</div>
</body>
</html>
