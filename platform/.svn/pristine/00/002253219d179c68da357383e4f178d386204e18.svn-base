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

<title>会员列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;">
		<div class="float-right">
		    <form id="vipForm" method="post" class="form-inline">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->		
			    <div class="form-group">
					<div class="field">
						<input id="vipMobile" type="text" class="input" name="vipMobile" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
						<input id="vipName" type="text" class="input" name="vipName" size="20"  placeholder="请输入会员姓名查询" title="请输入会员姓名查询" />
					</div>
					<div class="field">
						<input id="loginName" type="text" class="input" name="loginName" size="20"  placeholder="请输入会员登录名查询" title="请输入会员登录名查询" />
					</div>
					<div class="field">
			   	 		<input id="vipType" name="vipType" value="" type="hidden">
						<select id="vipType1" class="input" type="text" onchange="choose()">
							<option value="">--选择会员类型--</option>
							<option value="0">超级会员</option>
							<option value="1">一般会员</option>
							<option value="2">普通会员</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findVipInfo();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
		<table id="vipTable" class="table table-hover">
			<thead>
				<tr>
					<th field="rowNum">序号</th>
					<th field="vipName" limitTxtLen="10">姓名</th>
					<th format="formatVipType" limitTxtLen="10">类型</th> 
					<th field="loginName" limitTxtLen="11">登录名</th>
					<th field="vipMobile" limitTxtLen="11">手机号</th>
					<th format="formatVipSex" limitTxtLen="10">性别</th>
					<th format="formatVipStatus" limitTxtLen="10" style="color:#ee7017;">会员状态</th>
					<th format="formatCertStatus" limitTxtLen="10" style="color:#3dec13;">实名认证状态</th>
					<th format="formatVipAction">操作</th>
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
	function choose(){
		var vipType=$("#vipType1").find("option:selected").val();
		$('#vipType').val(vipType);
	}
	function doQuery(flag){
		if (!flag){
			document.getElementById("vipForm").reset();
		}
		var url = '<%=path%>/system/vip/findVipList';
		initTableList(url,"vipTable","vipForm");
	}
	function findVipInfo(){
		var url = '<%=path%>/system/vip/findVipList';
		initTableList(url,"vipTable","vipForm");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipMobile').val("");
		$('#loginName').val("");
		$('#vipType').val("");
		$('#vipName').val("");
		$('#currentPage').val("1");
		$('#vipType1').val("");
		findVipInfo();
	}
	function addOrUpdateData(iframeWin,params){
		if (iframeWin.validate()){
			$.ajax({
				 url: '<%=path%>/system/vip/savaVip',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 tempPath = "";
					 count = 1;
					 if (data.status=="1"){
						 if(params.vipUUID == null || params.vipUUID == ""){
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
	
	function editVipByUUID(vipUUID){
	if ("0".indexOf("0")>=0){
		$.ajax({
			 url: '<%=path%>/system/vip/findVipByUUID',
			 type: "POST",
			 cache: false,
			 data: {
				 vipUUID:vipUUID
			 },
			 success: function(data){
				 if(data){
					openAddOrUpVipWin(vipUUID,data);
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
			 url: '<%=path%>/system/vip/findVipByMap',
			 type: "POST",
			 cache: false,
			 data: {
				 id:id
			 },
			 success: function(data){
				 if(data.info){
					openAddOrUpVipWin(data.info.vipUUID,data.info);
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
	function openAddOrUpVipWin(vipUUID,data){
		if ("0".indexOf("0")>=0 || "0".indexOf("0")>=0){
			var winTitle = '<i class="icon-plus"></i> 添加会员 &nbsp;&nbsp;&nbsp;<font color="red">(新会员默认密码:000000)</font>';
			if(vipUUID!="" && vipUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改会员信息';
			}
			var url = 'PlatformAdmin/vipMng/addVip.jsp';
			var area = ['28%','50%'];
			var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
			layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenEditVipWin, {"vipUUID":vipUUID, "data":data});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenEditVipWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		vipEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.vipUUID!="" && params.vipUUID != null){//添加
	    	if(params.data){
		    	iframeWin.initData(params.data);
	    	}
	    }else {//修改
	    	vipEditForm.reset();
	    }
	}
	
	//弹出权限分配框
	function openPermissionEditWin(vipUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(vipUUID!="" && vipUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/vipMng/assignPermission.jsp?vipUUID='+vipUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdatePermission, afterOpenPermissionEditWin, {"vipUUID":vipUUID});
			}else{
				layer.alert("请选择会员",{icon:0});
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
				 url: '<%=path%>/system/menuVip/saveMenuVip',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.vipUUID == null || params.vipUUID == ""){
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
	function openRoleEditWin(vipUUID,unitUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(vipUUID!="" && vipUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/userMng/assignRole.jsp?vipUUID='+vipUUID+'&unitUUID='+unitUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateRole, afterOpenRoleEditWin, {"vipUUID":vipUUID});
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
				 url: '<%=path%>/system/roleVip/saveRoleVip',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.vipUUID == null || params.vipUUID == ""){
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
	function delFileByUUID(uuid){
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
							 uuids:uuid
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
	function formatVipType(data){
		if(data.vipType=="0"){
			return "超级会员";
		}else if(data.vipType=="1"){
			return "一般会员";
		}else if(data.vipType=="2"){
			return "普通会员";
		}else {
			return "未知";
		}
	}
	
	function formatVipSex(data){
		if(data.userSex=="1"){
			return "男";
		}else if(data.userSex=="2"){
			return "女";
		}else {
			return "未知";
		}
	}
	
	function formatVipStatus(data){
		if(data.vipStatus == "1"){
			return "正常启用";
		}
		if(data.vipStatus == "2"){
			return "注销";
		}
		if(data.vipStatus == "3"){
			return "停用";
		}
		if(data.vipStatus == "4"){
			return "接单中";
		}
	}
	function formatCertStatus(data){
		if(data.certificateStatus == "1"){
			return "认证失败";
		}
		if(data.certificateStatus == "2"){
			return "认证中";
		}
		if(data.certificateStatus == "3"){
			return "认证成功";
		}
		if(data.certificateStatus == "4"){
			return "未认证";
		}
	}
	
	function formatVipAction(data){
		var editHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="editVipByUUID(\''+data.vipUUID +'\');"><i class="icon-edit"></i>&nbsp;修改</a>';
		var setMenuHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openPermissionEditWin(\''+data.vipUUID +'\');"><i class="icon-edit"></i>&nbsp;分配权限</a>';
		var setRoleHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openRoleEditWin(\''+data.vipUUID+'\',\''+data.unitUUID+'\');"><i class="icon-edit"></i>&nbsp;分配角色</a>';
		var changeStatusHTML = '';
		if (data.userStatus=="1"){
			changeStatusHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.vipUUID +'\',\''+ 0 +'\');"><i class="icon-edit"></i>&nbsp;禁用</a>';
		}else{
			changeStatusHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.vipUUID +'\',\''+ 1 +'\');"><i class="icon-edit"></i>&nbsp;启用</a>';
		}
		var delHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="delFileByUUID(\''+data.vipUUID + '\');"><i class="icon-minus"></i>&nbsp;删除</a>';
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
