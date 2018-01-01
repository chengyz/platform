<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="admin">
	<div class="panel admin-panel">
		<form id="userForm" method="post">
			<input type="hidden" name="page" value="1"/><!-- 当前页 -->
			<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
			<input type="hidden" name="pageRecord" value="10"/><!-- 每页显示条数 -->
			<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->	
			<div class="panel-head">
				<strong>用户列表</strong>
			</div>
			<div class="padding border-bottom">
				<input type="button" class="button button-small border-blue" onclick="openAddOrUpUserWin(null);" value="添加用户" > 
			</div>
		</form>
		<table id="userTable" class="table table-hover">
			<thead>
				<tr>
					<th width="40" field="rowNum">序号</th>
					<th width="80" field="userName" limitTxtLen="10">姓名</th>
					<th width="80" field="loginName" limitTxtLen="10">登录名</th>
					<th width="80" format="formatUserType" limitTxtLen="10">类型</th> 
					<th width="80" field="userMobile" limitTxtLen="10">手机号</th>
					<th width="120" format="formatUserSex" limitTxtLen="10">性别</th>
					<th width="80" format="formatUserStatus" limitTxtLen="10">状态</th>
					<th width="100" format="formatUserAction">操作</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		<div class="panel-foot text-center">
			<ul class="pagination">
				<li><a title="首页" href="javascript:doQuery(1, queryStatus);"><span
						class="icon-step-backward"></span>&nbsp;首页</a></li>
				<li><a title="上一页"
					href="javascript:doQuery(perPage, queryStatus);"><span
						class="icon-chevron-left"></span>&nbsp;上一页</a></li>
			</ul>
			<ul class="pagination pagination-group" id=pageGroup>
			</ul>
			<ul class="pagination">
				<li><a title="下一页"
					href="javascript:doQuery(nextPage, queryStatus);">下一页&nbsp;<span
						class="icon-chevron-right"></span></a></li>
				<li><a title="尾页"
					href="javascript:doQuery(endPage, queryStatus);">尾页&nbsp;<span
						class="icon-step-forward"></span></a></li>
			</ul>
			<ul class="pagination">
				<li id="pageTotalMsg"><a>共计<strong class="text-yellow">0</strong>条记录。
				</a></li>
			</ul>
			<ul class="pagination">&nbsp;&nbsp;
				<li>跳转</li>
				<input id="gotoPageInput" class="input input-auto" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" style="width: 50px; height: 25px"></input>
				<li>页</li>
				<li><a class="button border-main" href="javascript:gotoPage();">GO</a></li>
			</ul>
		</div>

		<div class="margin-top text-center show-l hidden-s hidden-b hidden-m">
			<span class="icon-chevron-down mobile-down" style="font-size: 24px;"></span>
		</div>
	</div>
	<br>
	</div>
	<div class="hidden">
	<script>
	var iframeWin;
	var layerOpenIndex;
	
	$(function(){
	<%-- 	if ("null"=="${sessionScope.userinfo}"||""=="${sessionScope.userinfo}"){
			window.location = '<%=path%>/admin/login.jsp';
		}else{
			doQuery(false);
		} --%>
		doQuery(false);		
	});
	
	function doQuery(flag){
		if (!flag){
			document.getElementById("userForm").reset();
		}
		var url = '<%=path%>/system/user/findUserList?unitUUID=${sessionScope.unituuid}';
		initTableList(url,"userTable","userForm");
	}
	
	function addOrUpdateData(iframeWin,params){
		if (iframeWin.validate()){
			$.ajax({
				 url: '<%=path%>/system/user/saveUser',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 tempPath = "";
					 count = 1;
					 if (data==true){
						 if(params.userUUID == null || params.userUUID == ""){
							 layer.msg('数据添加成功！', {icon: 1});
						 }else{
							 layer.msg('数据修改成功！', {icon: 1});
						 }
					 }else{
						 layer.msg('添加数据时出现异常！', {icon: 0});
					 }
					 
					 
				},
				error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				}, 
				dataType: 'json'
				});
		}
		
	}
	
	function editUserByUUID(userUUID,unitUUID){
	if ("0".indexOf("0")>=0){
		$.ajax({
			 url: '<%=path%>/system/user/findUser',
			 type: "POST",
			 cache: false,
			 data: {
				 userUUID:userUUID,
				 unitUUID:unitUUID
			 },
			 success: function(data){
				 if(data){
					openAddOrUpUserWin(userUUID,data);
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
	}else{
		layer.msg('没有权限！', {icon: 0});
	}
	}
	
	function editUserById(id){
	if ("0".indexOf("0")>=0){
		$.ajax({
			 url: '<%=path%>/system/user/findUser',
			 type: "POST",
			 cache: false,
			 data: {
				 id:id
			 },
			 success: function(data){
				 if(data){
					openAddOrUpUserWin(data.userUUID,data);
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
	}else{
		layer.msg('没有权限！', {icon: 0});
	}
	}

	//弹出用户信息编辑框
	function openAddOrUpUserWin(userUUID,data){
		if ("0".indexOf("0")>=0 || "0".indexOf("0")>=0){
			var winTitle = '<i class="icon-plus"></i> 添加用户 &nbsp;&nbsp;&nbsp;<font color="red">(新用户默认密码:000000)</font>';
			if(userUUID!="" && userUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户信息';
			}
			var url = 'PlatformAdmin/userMng/addUser.jsp';
			var area = ['28%','60%'];
			var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
			layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenEditUserWin, {"userUUID":userUUID, "data":data});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenEditUserWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		userEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.userUUID!="" && params.userUUID != null){//添加
	    	if(params.data){
		    	iframeWin.initData(params.data);
	    	}
	    }else {//修改
	    	userEditForm.reset();
	    }
	}
	
	//弹出权限分配框
	function openPermissionEditWin(userUUID,unitUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(userUUID!="" && userUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/userMng/assignPermission.jsp?userUUID='+userUUID+'&unitUUID='+unitUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdatePermission, afterOpenPermissionEditWin, {"userUUID":userUUID});
			}else{
				layer.alert("请选择用户",{icon:0});
			}
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenPermissionEditWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		permissionForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	}
	
	function addOrUpdatePermission(iframeWin,params){
		if (iframeWin.validate()){
			iframeWin.initData();
			$.ajax({
				 url: '<%=path%>/system/menuUser/saveMenuUser',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.userUUID == null || params.userUUID == ""){
							 layer.msg('数据添加成功！', {icon: 1});
						 }else{
							 layer.msg('数据修改成功！', {icon: 1});
						 }
					 }else{
						 layer.msg('添加数据时出现异常！', {icon: 0});
					 }
					 
					 
				},
				error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				}, 
				dataType: 'json'
				});
		}
	}
	
	//弹出角色分配框
	function openRoleEditWin(userUUID,unitUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(userUUID!="" && userUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/userMng/assignRole.jsp?userUUID='+userUUID+'&unitUUID='+unitUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateRole, afterOpenRoleEditWin, {"userUUID":userUUID});
			}else{
				layer.alert("请选择用户",{icon:0});
			}
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenRoleEditWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		roleEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	}
	
	function addOrUpdateRole(iframeWin,params){
		if (iframeWin.validate()){
			iframeWin.initData();
			$.ajax({
				 url: '<%=path%>/system/roleUser/saveRoleUser',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.userUUID == null || params.userUUID == ""){
							 layer.msg('数据添加成功！', {icon: 1});
						 }else{
							 layer.msg('数据修改成功！', {icon: 1});
						 }
					 }else{
						 layer.msg('添加数据时出现异常！', {icon: 0});
					 }
					 
					 
				},
				error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				}, 
				dataType: 'json'
				});
		}
	}
	
	
	//删除
	function delFileByUUID(uuid,unitUUID){
	if ("0".indexOf("0")>=0){
			if (uuid!=null||uuid!=""){
				var temp = uuid.toString().split("_");
				var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除这条数据吗?";
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/user/delUser',
						 type: "POST",
						 cache: false,
						 data: {
							 uuids:uuid,
							 unitUUID:unitUUID
						 },
						 success: function(data){
							 if(data){
							 	layer.msg('数据删除成功！', {icon: 1}); 
							 	doQuery(false);
							}else{
								layer.msg('数据删除失败！', {icon: 1}); 
							}
						 },
						 error : function() {  
							 layer.msg('删除数据时出现异常！', {icon: 0});  
						 }, 
						 dataType: 'json'
						});
				}); 
			}else{
				layer.msg('请先勾选数据！', {icon: 0});
			}
		}else{
			layer.msg('没有权限！', {icon: 0});  
		}
	}
	
	//status: 1为启用0为禁用 
	function changeStatusByUUID(uuid, status){
		if ("0".indexOf("0")>=0){
			if(uuid!=null||uuid!=""){
				var temp = uuid.toString().split("_");
				var tipMsg = (status == 1)?"启用":"禁用";
				var tip = temp.length >2?("确认要"+tipMsg+"这"+(temp.length-1)+"个类型吗?"):("确认要"+tipMsg+"这个类型吗?");
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/user/upUserStatus',
						 type: "POST",
						 cache: false,
						 data: {
							 uuids:uuid,
							 status:status
						 },
						 success: function(data){
							 if(data){
								 	layer.msg('类型'+tipMsg+'成功！', {icon: 1}); 
								 	doQuery(false);
								 }else{
									layer.msg('类型'+tipMsg+'失败！', {icon: 1}); 
								 }
						 },
						 error : function() {  
							 layer.msg(tipMsg + '类型时出现异常！', {icon: 0});  
						 }, 
						 dataType: 'json'
						});
				}); 
			}else{
				layer.msg('请先勾选数据！', {icon: 0});  
			} 
		}else{
			layer.msg('没有权限！', {icon: 0});  
		}
		
	}
	//数据展示
	function formatUserType(data){
		if(data.userType=="0"){
			return "平台超级管理员";
		}else if(data.userType=="1"){
			return "平台普通管理员";
		}else if(data.userType=="2"){
			return "平台普通用户";
		}else if(data.userType=="3"){
			return "企业超级管理员";
		}else if(data.userType=="4"){
			return "企业普通管理员";
		}else if(data.userType=="5"){
			return "企业普通用户";
		}else {
			return "未知";
		}
	}
	
	function formatUserSex(data){
		if(data.userSex=="1"){
			return "男";
		}else if(data.userSex=="2"){
			return "女";
		}else {
			return "未知";
		}
	}
	
	function formatUserStatus(data){
		if(data.userStatus=="1"){
			return "启用";
		}else if(data.userStatus=="0"){
			return "禁用";
		}else{
			return "未知";
		}
	}
	
	function formatUserAction(data){
		var editHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="editUserByUUID(\''+data.userUUID +'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;修改</a>';
		var setMenuHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openPermissionEditWin(\''+data.userUUID +'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;分配权限</a>';
		var setRoleHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openRoleEditWin(\''+data.userUUID+'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;分配角色</a>';
		var changeStatusHTML = '';
		if (data.userStatus=="1"){
			changeStatusHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.userUUID +'\',\''+ 0 +'\');"><i class="icon-edit"></i>&nbsp;禁用</a>';
		}else{
			changeStatusHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.userUUID +'\',\''+ 1 +'\');"><i class="icon-edit"></i>&nbsp;启用</a>';
		}
		var delHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="delFileByUUID(\''+data.userUUID +'\',\''+data.unitUUID+'\');"><i class="icon-minus"></i>&nbsp;删除</a>';
		return editHTML + "&nbsp;"+setMenuHTML+"&nbsp;"+setRoleHTML+"&nbsp;"+changeStatusHTML+"&nbsp;"+delHTML;
	}
	//双击方法
	function ondblClickTrHandler(dom, id) {
		if ("0".indexOf("0")>=0){
			editUserById(id);
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}

	

</script>
	</div>
</body>
</html>
