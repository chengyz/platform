<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>单位管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="admin">
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong>单位列表</strong>
		</div>
		<form id="unitForm" method="post" class="form-inline" style="width:100%;">
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
						<button type="button" class="button text-blue" onclick="openAddOrUpUnitWin(null);">
							<span class="icon-edit text-blue"></span>新增</button>
						<button type="button" class="button text-red" onclick="batchDel();">
							<span class="icon-trash-o text-red"></span>删除</button>
					</div>
				</div>
				<div class="button-toolbar">
					<div class="button-group button-group-little">
						<button type="button" class="button text-blue" onclick="batchChangeStatus(1);">
							<span class="icon-edit text-blue"></span>启用</button>
						<button type="button" class="button text-red" onclick="batchChangeStatus(0);">
							<span class="icon-trash-o text-red"></span>禁用</button>
					</div>
				</div>
				<div class="float-right">
					<div class="form-button">
						<button class="button" type="button" onclick="doQuery(false);">全部</button>
					</div>
					<div class="form-group">
						<div class="field">
							<input type="text" class="input" id="unitName" name="unitName" size="20" placeholder="单位（企业）名称" />
						</div>
					</div>
					<div class="form-group">
						<div class="field">
							<input type="text" class="input" id="unitCode" name="unitCode" size="20" placeholder="组织机构代码" />
						</div>
					</div>
					<div class="form-group">
						<div class="field">
							<input type="text" class="input" id="LicenseNo" name="LicenseNo" size="20" placeholder="营业执照号码" />
						</div>
					</div>
					<div class="form-button">
						<button class="button" type="button" onclick="doQuery(true);">查询</button>
					</div>
				</div>
			</div>
		</form>
		<table id="unitTable" class="table table-hover">
			<thead>
				<tr>
					<th width="60" field="checkBox">选择</th>
					<th width="60" field="rowNum">序号</th>
					<th width="80" field="unitName" limitTxtLen="10">单位名称</th>
					<th width="80" field="LegalRepresentative" limitTxtLen="10">法人</th> 
					<th width="120" field="unitCode" limitTxtLen="10">组织机构代码</th>
					<th width="120" field="LicenseNo" limitTxtLen="10">营业执照号码</th>
					<th width="120" field="unitAddress" limitTxtLen="10">详细地址</th>
					<th width="80" field="linkMan" limitTxtLen="10">联系人</th>
					<th width="120" field="contactNumber" limitTxtLen="11">联系电话</th>
 					<th width="120" format="formatUnitTrades" limitTxtLen="10">单位行业</th>
					<th width="120" format="formatLicenseType" limitTxtLen="10">工商执照类型</th>
					<th width="80" format="formatUnitStatus" limitTxtLen="10">状态</th> 
					<th width="100" format="formatUnitAction">操作</th>
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
			document.getElementById("unitForm").reset();
		}
		var url = '<%=path%>/system/unit/findUnitList?unitUUID=${sessionScope.unituuid}';
		initTableList(url,"unitTable","unitForm");
	}
	
	function addOrUpdateData(iframeWin,params){
		if (iframeWin.validate()){
			$.ajax({
				 url: '<%=path%>/system/unit/saveOrUpUnit',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery(false);
					 tempPath = "";
					 count = 1;
					 if (data.status=="1"){
						 if(params.unitUUID == null || params.unitUUID == ""){
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
	
	function editUnitByUUID(unitUUID){
		$.ajax({
			 url: '<%=path%>/system/unit/findUnit',
			 type: "POST",
			 cache: false,
			 data: {
				 uuid:unitUUID
			 },
			 success: function(data){
				 if(data){
					$.ajax({
					 url: '<%=path%>/system/user/findUser',
					 type: "POST",
					 cache: false,
					 data: {
					 	 userType:'3',
						 unitUUID:unitUUID
					 },
					 success: function(userData){
						 if(userData){
							openAddOrUpUnitWin(unitUUID,data,userData);
						 }else{
							layer.msg('查询数据失败！', {icon: 0});
						 }
					 },
					 error : function() {  
						 layer.msg('查询数据出现异常2！', {icon: 0}); 
					 }, 
					 dataType: 'json'
					});
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常1！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
	}
	
	function editUnitById(id){
		$.ajax({
			 url: '<%=path%>/system/unit/findUnit',
			 type: "POST",
			 cache: false,
			 data: {
				 id:id
			 },
			 success: function(data){
				 if(data){
					openAddOrUpUnitWin(data.unitUUID,data);
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
	function openAddOrUpUnitWin(unitUUID,data,userData){
		if ("0".indexOf("0")>=0){
			var winTitle = '<i class="icon-plus"></i> 添加单位 &nbsp;&nbsp;&nbsp;<font color="red">(新用户默认密码:000000)</font>';
			if(unitUUID!="" && unitUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改单位信息';
			}
			var url = 'PlatformAdmin/unitMng/addUnit.jsp';
			var area = ['60%','88%'];
			var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
			layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenEditUnitWin, {"unitUUID":unitUUID, "data":data,"userData":userData});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenEditUnitWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		var unitEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.unitUUID!="" && params.unitUUID != null){//添加
	    	if(params.data){
		    	iframeWin.initData(params.data,params.userData);
	    	}
	    }else {//修改
	    	unitEditForm.reset();
	    }
	}
	
		//弹出权限分配框
	function openPermissionEditWin(unitUUID){
		if ("0".indexOf("0")>=0){
			var winTitle = "";
			if(unitUUID!="" && unitUUID != null){
				winTitle = '<i class="icon-pencil"></i> 修改用户权限';
				var url = 'PlatformAdmin/unitMng/assignPermission.jsp?unitUUID='+unitUUID;
				var area = ['32%','50%'];
				var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
				layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdatePermission, afterOpenPermissionEditWin, {"unitUUID":unitUUID});
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
				 url: '<%=path%>/system/menuUnit/saveMenuUnit',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 doQuery();
					 if (data.status=="1"){
						 if(params.unitUUID == null || params.unitUUID == ""){
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
	function delUnitByUUID(uuid){
	if ("0".indexOf("0")>=0){
			if (uuid!=null||uuid!=""){
				var temp = uuid.toString().split("_");
				var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条文件信息吗?":"确认要删除这条文件信息吗?";
				layer.confirm(tip, function(index){
					$.ajax({
						 url: '<%=path%>/system/unit/delUnit',
						 type: "POST",
						 cache: false,
						 data: {
							 uuids:uuid
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
						 url: '<%=path%>/system/unit/delUnit',
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
	function formatUnitTrades(data){
		if(data.userType=="1"){
			return "类型1";
		}else if(data.userType=="2"){
			return "类型2";
		}else {
			return "未知";
		}
	}
	
	function formatLicenseType(data){
		if(data.userSex=="1"){
			return "类型1";
		}else if(data.userSex=="2"){
			return "类型2";
		}else {
			return "未知";
		}
	}
	
	function formatUnitStatus(data){
		if(data.status=="1"){
			return "启用";
		}else if(data.status=="0"){
			return "禁用";
		}else{
			return "未知";
		}
	}
	
	function formatUnitAction(data){
		var editHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="editUnitByUUID(\''+data.unitUUID +'\');"><i class="icon-edit"></i>&nbsp;修改</a>';
		var setMenuHTML = '';
		var changeStatusHTML = '';
		var delHTML = '';
		if ("${sessionScope.userinfo.userType}"=="0"||"${sessionScope.userinfo.userType}"=="1"){
			setMenuHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="openPermissionEditWin(\''+data.unitUUID +'\');"><i class="icon-edit"></i>&nbsp;分配权限</a>';
			if (data.status=="1"){
				changeStatusHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.unitUUID +'\',\''+ 0 +'\');"><i class="icon-edit"></i>&nbsp;禁用</a>';
			}else{
				changeStatusHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="changeStatusByUUID(\''+data.unitUUID +'\',\''+ 1 +'\');"><i class="icon-edit"></i>&nbsp;启用</a>';
			}
			delHTML = '<a class="button button-little border-yellow" href="javascript:void(0)" onclick="delUnitByUUID(\''+data.unitUUID + '\');"><i class="icon-minus"></i>&nbsp;删除</a>';
		}else{
			setMenuHTML = '';
			changeStatusHTML = '';
			delHTML = '';
		}
		return editHTML+"&nbsp;"+setMenuHTML+"&nbsp;"+ changeStatusHTML+"&nbsp;"+delHTML;
	}
	//双击方法
	function ondblClickTrHandler(dom, id) {
		editUnitById(id);
	}

	

</script>
	</div>
</body>
</html>
