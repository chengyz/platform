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

<title>角色管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="admin">
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong>角色列表</strong>
		</div>
		<form id="roleForm" method="post" class="form-inline" style="width:100%;">
			<input type="hidden" name="page" value="1"/><!-- 当前页 -->
			<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
			<input type="hidden" name="pageRecord" value="10"/><!-- 每页显示条数 -->
			<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->	
			
			<div class="padding-big border-bottom">
				<div class="button-toolbar">
					<div class="button-group button-group-little">
						<a href="javascript:checkAllBox(!isCheckBox);" class="button button-small border-blue text-blue" name="checkall" checkfor="id"> <span class="icon-check-circle text-blue"></span> 全选</a>
					</div>
				</div>
				<div class="button-toolbar">
					<div class="button-group button-group-little">
						<button type="button" class="button text-blue" onclick="openAddOrUpRoleWin(null);">
							<span class="icon-edit text-blue"></span>新增</button>
						<button type="button" class="button text-red" onclick="batchDel();">
							<span class="icon-trash-o text-red"></span>删除</button>
					</div>
				</div>
			</div>
		</form>
		<table id="roleTable" class="table table-hover">
			<thead>
				<tr>
					<th width="100" field="checkBox">选择</th>
					<th width="100" field="rowNum">序号</th>
					<th width="200" field="roleName" limitTxtLen="10">角色名称</th>
					<th width="300" field="roleMark" limitTxtLen="10">角色备注</th>
					<th width="180" format="formatRoleAction">操作</th>
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
	var selectedList = "";
	var iframeWin;
	var layerOpenIndex;
	var isCheckBox = false;
	
	$(function(){
		<%-- if ("null"=="${sessionScope.userinfo}"||""=="${sessionScope.userinfo}"){
			window.location = '<%=path%>/admin/login.jsp';
		}else{
			doQuery(false);
		} --%>
		doQuery(false);	
	});
	
	function doQuery(flag){
		if (!flag){
			document.getElementById("roleForm").reset();
		}
		var url = '<%=path%>/system/role/findRoleList?unitUUID=${sessionScope.unituuid}';
		initTableList(url,"roleTable","roleForm");
	}
	
	function addOrUpdateData(iframeWin,params){
		if (iframeWin.validate()){
			$.ajax({
				 url: '<%=path%>/system/role/saveRole',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery(false);
					 if (data.status=="1"){
						 if(params.roleUUID == null || params.roleUUID == ""){
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
	
	function editRoleByUUID(roleUUID,unitUUID){
		$.ajax({
			 url: '<%=path%>/system/role/findRole',
			 type: "POST",
			 cache: false,
			 data: {
				 roleUUID:roleUUID,
				 unitUUID:unitUUID
			 },
			 success: function(data){
				 if(data){
					openAddOrUpRoleWin(data.roleUUID,data);
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
	}
	
	function editRoleById(id){
		$.ajax({
			 url: '<%=path%>/system/role/findRole',
			 type: "POST",
			 cache: false,
			 data: {
				 id:id
			 },
			 success: function(data){
				 if(data){
					openAddOrUpRoleWin(data.roleUUID,data);
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
	}

	//弹出用户信息编辑框
	function openAddOrUpRoleWin(roleUUID,data){
		if ("0".indexOf("0")>=0){
			var winTitle = '<i class="icon-plus"></i> 添加角色';
			if(roleUUID != "" && roleUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改角色信息';
			}
			var url = 'PlatformAdmin/roleMng/addRole.jsp';
			var area = ['40%','40%'];
			var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
			layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenEditRoleWin, {"roleUUID":roleUUID, "data":data});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenEditRoleWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		var roleEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.roleUUID!="" && params.roleUUID != null){//添加
	    	if(params.data){
		    	iframeWin.initData(params.data);
	    	}
	    }else {//修改
	    	roleEditForm.reset();
	    	iframeWin.initDataForAdd("${sessionScope.unituuid}");
	    	
	    }
	}
	
	//弹出权限分配框
	function openPermissionEditWin(roleUUID,unitUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(roleUUID!="" && roleUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/roleMng/assignPermission.jsp?roleUUID='+roleUUID+'&unitUUID='+unitUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdatePermission, afterOpenPermissionEditWin, {"roleUUID":roleUUID});
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
				 url: '<%=path%>/system/menuRole/saveMenuRole',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.roleUUID == null || params.roleUUID == ""){
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
	function delRoleByUUID(roleUUID,unitUUID){
	if ("0".indexOf("0")>=0){
			if (roleUUID!=null||roleUUID!=""){
				var temp = roleUUID.toString().split("_");
				var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条文件信息吗?":"确认要删除这条文件信息吗?";
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/role/delRole',
						 type: "POST",
						 cache: false,
						 data: {
							 roleUUID:roleUUID,
							 unitUUID:unitUUID
						 },
						 success: function(data){
							 if(data){
							 	layer.msg('文件信息删除成功！', {icon: 1}); 
							 	selectedList = "";
							 	doQuery(false);
							}else{
								layer.msg('文件信息删除失败！', {icon: 1}); 
							}
						 },
						 error : function() {  
							 layer.msg('删除文件信息时出现异常！', {icon: 0});  
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
	
	function delUnitById(ids){
	if ("0".indexOf("0")>=0){
			if (ids!=null||ids!=""){
				var temp = ids.toString().split("_");
				var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条文件信息吗?":"确认要删除这条文件信息吗?";
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/role/delRole',
						 type: "POST",
						 cache: false,
						 data: {
							 ids:ids
						 },
						 success: function(data){
							 if(data){
							 	layer.msg('文件信息删除成功！', {icon: 1}); 
							 	selectedList = "";
							 	doQuery(false);
							}else{
								layer.msg('文件信息删除失败！', {icon: 1}); 
							}
						 },
						 error : function() {  
							 layer.msg('删除文件信息时出现异常！', {icon: 0});  
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
						 url: '<%=path%>/system/unit/changeUnitStatus',
						 type: "POST",
						 cache: false,
						 data: {
							 uuids:uuid,
							 status:status
						 },
						 success: function(data){
							 if(data){
								 	layer.msg('类型'+tipMsg+'成功！', {icon: 1}); 
								 	selectedList = "";
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
	
		function changeStatusById(ids, status){
		if ("0".indexOf("0")>=0){
			if(ids!=null||ids!=""){
				var temp = ids.toString().split("_");
				var tipMsg = (status == 1)?"启用":"禁用";
				var tip = temp.length >2?("确认要"+tipMsg+"这"+(temp.length-1)+"个类型吗?"):("确认要"+tipMsg+"这个类型吗?");
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/unit/changeUnitStatus',
						 type: "POST",
						 cache: false,
						 data: {
							 ids:ids,
							 status:status
						 },
						 success: function(data){
							 if(data){
								 	layer.msg('类型'+tipMsg+'成功！', {icon: 1}); 
								 	selectedList = "";
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
	
		//批量改变状态
	function batchChangeStatus(status){
		if ("0".indexOf("0")>=0){
			if(selectedList){
				changeStatusById(selectedList, status);
			}else{
				layer.msg('请先勾选数据！', {icon: 0});  
			} 
		}else{
			layer.msg('没有权限！', {icon: 0});  
		}
	}
	
			//批量改变状态
	function batchDel(){
		if ("0".indexOf("0")>=0){
			if(selectedList){
				delUnitById(selectedList);
			}else{
				layer.msg('请先勾选数据！', {icon: 0});  
			} 
		}else{
			layer.msg('没有权限！', {icon: 0});  
		}
	}
	
	//数据勾选
	//单选
	function onCheckBoxHandler(dom, id){
		if($(dom).prop('checked')){
			selectedList += id + "_";
		}else{
			selectedList = selectedList.replace(id + "_", "");
		}
	}
	//全选
	function checkAllBox(isBox){
		isCheckBox = isBox;
		selectedList = "";
		 $('input:checkbox').each(function() {
		       $(this).prop('checked', isBox);//使用prop方法，而不是attr
		       if(isBox){
		    	   selectedList += $(this).val() + "_";
		       }else{
		    	   selectedList = selectedList.replace($(this).val() + "_", "");
		       }
		});
	}
	
	//数据展示
	function formatUnitStatus(data){
		if(data.status=="1"){
			return "启用";
		}else if(data.status=="0"){
			return "禁用";
		}else{
			return "未知";
		}
	}
	
	function formatRoleAction(data){
		var editHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="editRoleByUUID(\''+data.roleUUID +'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;修改</a>';
		var setMenuHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openPermissionEditWin(\''+data.roleUUID +'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;分配权限</a>';
		var delHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="delRoleByUUID(\''+data.roleUUID +'\',\''+data.unitUUID+'\');"><i class="icon-minus"></i>&nbsp;删除</a>';
		return editHTML+"&nbsp;"+setMenuHTML+"&nbsp;"+delHTML;
	}
	//双击方法
	function ondblClickTrHandler(dom, id) {
		editUnitById(id);
	}

	

</script>
	</div>
</body>
</html>
