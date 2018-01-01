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

<title>时间列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>

	<div class="admin">
	<div class="panel admin-panel">
		<form id="timeForm" method="post">
			<input type="hidden" id="currentPage" name="page" value="1"/><!-- 当前页 -->
			<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
			<input type="hidden" name="pageRecord" value="10"/><!-- 每页显示条数 -->
			<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->	
			<div class="panel-head">
				<strong>时间列表</strong>
			</div>
			<div class="padding border-bottom">
				<input type="button" class="button button-small border-blue" onclick="openTimeWin(1);" value="添加时间记录" > 
			</div>
		</form>
		<table id="timeTable" class="table table-hover" style="text-align:center;">
			<thead style="text-align:center;">
				<tr >
					<th width="" field="rowNum" style="text-align:center;">序号</th>
					<th width="" field="payFirstScanTime" limitTxtLen="20" style="text-align:center;">支付初次扫描/秒</th>
					<th width="" field="payTimeOut" limitTxtLen="20" style="text-align:center;">支付超时时间/分钟</th>
					<th width="" field="payScanTime" limitTxtLen="20" style="text-align:center;">支付扫描间隔/秒</th>
					<th width="" field="allUnconfirmedTime" limitTxtLen="20" style="text-align:center;">均未确认订单的时间/天</th> 
					<th width="" field="vipUnconfirmedTime" limitTxtLen="20" style="text-align:center;">跑客确认，派单者未确认的时间/天</th>
					<th width="" field="firstScanOrderTime" limitTxtLen="20" style="text-align:center;">未确认订单初次扫描/秒</th>
					<th width="" field="scanOrderTime" limitTxtLen="20" style="text-align:center;">未确认订单扫描间隔/秒</th>
					<th width="" field="noGetFirstScanTime" limitTxtLen="20" style="text-align:center;">无人接单首次扫描/秒</th>
					<th width="" field="noGetScanTime" limitTxtLen="20" style="text-align:center;">无人接单扫描间隔/秒</th>
					<th width="" field="createTime" limitTxtLen="20" style="text-align:center;">创建时间</th>
					<th width="" field="updateTime" limitTxtLen="20" style="text-align:center;">修改时间</th>
					<th width="" format="showPlatform" style="text-align:center;">所属平台</th>
					<th width="" format="editHandler" style="text-align:center;">操作</th>
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
	$(function(){
		var url = 'hkdapp/changeTime/timeList';
		initTableList(url,"timeTable", "timeForm");
	});
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function findTime(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/changeTime/timeList';
		initTableList(url,"timeTable", "timeForm");
	}
	function showPlatform(data){
		if(data.belongPlatform == 1){
			return "好快当";
		}
	}
	//清空查询条件
	function clearQueryCondition(){
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('图片不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/changeTime/saveOrUpTime',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findTime();
					 if(params.type == 1){
						 layer.msg('数据添加成功！', {icon: 1});
					 }else{
						 layer.msg('数据修改成功！', {icon: 1});
					 }
					 
				 },
				 error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
				});
		}
		
	}
	function openTimeWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加时间记录":"修改时间记录";
		var url = 'PlatformAdmin/timeMng/addOrUpTime.jsp';
		var area = ['40%', '60%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openTimeWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delTimeByUUIDs('+data.id+');">删除</a>';
		return modifHTML + delHTML;
	}
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addDataForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    $("#imageShow", iframeWin.document).hide();
	    if(params.type == 2 || params.type == 1){
	    	if(params.row){
		    	iframeWin.initData(params.row);
	    	}
	    }
	    iframeWin.callbackImageFunc = uploadImageData;
	}
	
	function uploadImageData(){
	}
	
	function delTimeByUUIDs(id){
		var uuids = datas[id].timeUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/changeTime/deleteTime',
				 type: "POST",
				 cache: false,
				 data: {
					 timeUUID:uuids
				 },
				 success: function(data){
					 if(data){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	findTime();
						 }else{
							layer.msg('数据删除成功！', {icon: 1}); 
						 }
				 },
				 error : function() {  
					 layer.msg('删除数据时出现异常！', {icon: 0});  
				 }, 
				 dataType: 'json'
				});
		}); 
	}
</script>
	</div>
</body>
</html>
