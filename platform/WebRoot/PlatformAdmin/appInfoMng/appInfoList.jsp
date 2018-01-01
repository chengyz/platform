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

<title>app信息列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="admin">
	<div class="panel admin-panel">
		<form id="dataForm" method="post">
			<input type="hidden" name="page" value="1"/><!-- 当前页 -->
			<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
			<input type="hidden" name="pageRecord" value="10"/><!-- 每页显示条数 -->
			<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->	
			<div class="panel-head">
				<strong>app信息列表</strong>
			</div>
			<div class="padding border-bottom">
				<input type="button" class="button button-small border-blue" onclick="openAppInfoWin(1);" value="添加app" > 
			</div>
		</form>
		<table id="dataTable" class="table table-hover">
			<thead>
				<tr>
					<th field="rowNum">序号</th>
					<th field="appName" limitTxtLen="10">app名称</th>
					<th field="appVersion" limitTxtLen="10">app版本号</th>
					<th field="outsideDownloadAddress" limitTxtLen="30">app更新地址</th>
					<th format="download" limitTxtLen="30">直接下载到本地</th>
					<th field="appType" style="color:#ee7017;" limitTxtLen="10">app类型</th>
					<th field="updateTime" limitTxtLen="20">更新时间</th>
					<th field="userName" limitTxtLen="10">提交者</th>
					<th format="showIosAuditStatus" limitTxtLen="10">ios审核状态</th>
					<th field="iosAuditVersion" limitTxtLen="10">ios正在审核的版本</th> 
					<th format="editHandler">操作</th>
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
	<script src="static/js/jquery-form.js"></script>
	<script>
	$(function(){
		var url = 'hkdapp/appInfo/findAppInfoList';
		initTableList(url,"dataTable", "dataForm");
	});
	function download(data){
		var htmls = '<a href=<%=path %>'+data.directDownloadAddress+'>直接下载</a>';
		return htmls;
	}
	function showIosAuditStatus(data){
		if(data.iosAuditStatus == 1){
			return "审核通过";
		}else if(data.iosAuditStatus == 2){
			return "审核中";
		}else{
			return "";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openAppInfoWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delAppByUUIDs('+data.id+');">删除</a>';
		return modifHTML+delHTML;
	}
	function appInfoList(){
		var url = 'hkdapp/appInfo/findAppInfoList';
		initTableList(url,"dataTable", "dataForm");
	}
	function ondblClickTrHandler(dom, id){
		openBusinessWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('app名称、版本号不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/appInfo/addOrUpAppInfo',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 appInfoList();
					 if(data.status == 1){
						 layer.msg('数据添加成功！', {icon: 1});
					 }else if(data.status == 2){
						 layer.msg('数据修改成功！', {icon: 1});
					 }else{
						 layer.msg('数据添加或修改失败！', {icon: 1});
					 }
				 },
				 error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
				});
		}
	}
	function delAppByUUIDs(id){
		var uuids = datas[id].appUUID;
		var appName = datas[id].appName;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/appInfo/deleteApp',
				 type: "POST",
				 cache: false,
				 data: {
					 appUUID:uuids,appName:appName
				 },
				 success: function(data){
					 if(data.status == 1){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	appInfoList();
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
	}
	function openAppInfoWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加app信息":"修改app信息";
		var url = 'PlatformAdmin/appInfoMng/addAppInfo.jsp';
		var area = ['48%', '80%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addDataForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.type == 1){//添加
	    	iframeWin.addData();
	    	addDataForm.reset();
	    }else if(params.type == 2){//修改
	    	if(params.row){
		    	iframeWin.initData(params.row);
	    	}
	    }
	    iframeWin.callbackImageFunc = uploadAppData;
	}
	function uploadAppData(type){
		$("#addDataForm", iframeWin.document).ajaxSubmit({
			url:'<%=path%>/hkdapp/appInfo/uploadApp?type='+type,
			type:'post',
			beforeSubmit:function(){
				return iframeWin.isOk;
			},
			success : function(data) {
				if(data){
					$("#uploadRate", iframeWin.document).val("上传成功");
					$("#outsideDownloadAddress", iframeWin.document).val(data);
					$("#directDownloadAddress", iframeWin.document).val(data);
				}
			},
	        error: function (msg) {
	        }
	   });
	}
	function openImpSchoolWin(){
	}
	</script>
	</div>
</body>
</html>
