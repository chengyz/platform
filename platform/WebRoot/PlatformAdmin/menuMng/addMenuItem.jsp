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
			<form id="menuItemEditForm" method="post" class="form-small" style="width:94%;" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id">
				<input type="hidden" id="menuUUID" name="menuUUID">
				<input type="hidden" id="menuCode" name="menuCode">
				<input type="hidden" id="menuParentCode" name="menuParentCode">
				<input type="hidden" id="menuType" name="menuType">
				<input type="hidden" id="isShow" name="isShow">
				<input type="hidden" id="menuHaveLowerNode" name="menuHaveLowerNode">
				<div class="form-group">
					<div class="label">
						<label for="menuName"> 菜单名称 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="menuName" name="menuName" size="100" maxlength="100" value="" placeholder="菜单名称">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="menuPermission"> 权限标识 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="menuPermission" name="menuPermission" size="100" maxlength="100" value="" placeholder="权限标识符">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="menuUrl"> 链接地址 </label>
					</div>
					<div class="field">
						<input type="text" class="input" id="menuUrl" name="menuUrl" size="50" maxlength="50" value="" placeholder="链接地址（没有时输入“#”）">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hidden">
		<script type="text/javascript">
			function validate() {
				if (!$('#menuName').val()) {
					layer.msg('菜单名称不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#menuPermission').val()) {
					layer.msg('权限标识不能为空！', {
						icon : 2
					});
					return false;
				}
				return true;
			}
			//初始化数据
			function getFromSerialize() {
				return $('#menuItemEditForm').serialize();
			}
			//新增处理
			function initDataForNew(menuCode) {
				$("#menuParentCode").val(menuCode);
			}
		                        	    	
			//修改数据时
			function initData(data) {
				$('#id').val(data.id);
				$('#menuUUID').val(data.menuUUID);
				$('#menuCode').val(data.menuCode);
				$('#menuParentCode').val(data.menuParentCode);
				$('#menuPermission').val(data.menuPermission);
				$('#menuName').val(data.menuName);
				$('#menuUrl').val(data.menuUrl);
				$('#menuType').val(data.menuType);
				$('#isShow').val(data.isShow);
				$('#menuHaveLowerNode').val(data.menuHaveLowerNode);
			}
		</script>
	</div>
</body>
</html>
