<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel"  style="height:50px;">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findOrder_form" method="post" class="form-inline">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="orderNumber" type="text" class="input" name="orderNumber" size="20"  placeholder="请输入订单编号查询" title="请输入订单编号查询" />
					</div>
					<div class="field">
						<input id="vipMobile" type="text" class="input" name="vipMobile" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
			   	 		<input id="orderType" name="orderType" value="" type="hidden">
						<select id="orderType1" class="input" type="text" onchange="chooseOrderType()">
							<option value="">--选择订单类型--</option>
							<option value="1">帮我买</option>
							<option value="2">帮我送</option>
							<option value="3">帮我取</option>
						</select>
					</div>
					<div class="field">
			   	 		<input id="handleStatus" name="handleStatus" value="" type="hidden">
						<select id="handleStatus1" class="input" type="text" onchange="chooseHandleStatus()">
							<option value="">--选择处理状态--</option>
							<option value="1">待处理</option>
							<option value="2">已处理</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findExceptionOrder();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="orderTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px" field="rowNum" >序号</th>
			    <th width="90px" field="orderNumber" limitTxtLen="17">订单号</th> 
			    <th width="90px" field="applicant" limitTxtLen="11">申请方</th>
			    <th width="120px" field="vipName" limitTxtLen="10">会员姓名</th>
			    <th width="120px" field="vipMobile" limitTxtLen="10">会员手机号</th>	
			    <th width="90px" field="getVipName" limitTxtLen="11">跑客姓名</th> 
			    <th width="90px" field="getVipModile" limitTxtLen="20">跑客手机号</th>
			    <th width="90px" format="showType" limitTxtLen="10">订单类型</th>
			    <th width="90px" field="applayReason" limitTxtLen="10">申请理由</th>
			    <th width="90px" field="applayTime" limitTxtLen="20">申请时间</th>
			    <th width="90px" format="showStatus" limitTxtLen="10">处理状态</th>
			    <th width="90px" field="handleUserName" limitTxtLen="20">处理人</th>	
			    <th width="90px" field="handleTime" limitTxtLen="15">处理时间</th>
			    <th width="90px" format="editHandler">操作</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div class="panel-foot text-left hidden-l">
			<ul class="pagination">
				<li><a title="首页"><span class="icon-step-backward"></span>&nbsp;首页</a></li>
				<li><a title="上一页"><span class="icon-chevron-left"></span>&nbsp;上一页</a></li>
			</ul>
			<ul class="pagination pagination-group" id=pageGroup></ul>
			<ul class="pagination">
				<li><a title="下一页">下一页&nbsp;<span class="icon-chevron-right"></span></a></li>
				<li><a title="尾页">尾页&nbsp;<span class="icon-step-forward"></span></a></li>
			</ul>
			<ul class="pagination">
				<li id="pageTotalMsg"><a>共计<strong class="text-yellow">0</strong>条记录。</a></li>
			</ul>
			<ul class="pagination">&nbsp;&nbsp;&nbsp;&nbsp;
			    <li>跳转到</li>
				<input id="gotoPageInput" class="input input-auto" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" style="width: 50px; height: 25px"></input>
				<li>页</li>
				<li><a title="GO" class="button border-main">走</a></li>
			</ul>
			<div class="button-group float-right">
				<select class="input" name="selectPageRow">
					<option value="10">10条</option>
					<option value="20">20条</option>
					<option value="40">40条</option>
					<option value="80">80条</option>
					<option value="160">160条</option>
					<option value="320">320条</option>
				</select>
			</div>
	</div>
</div>
<div id="mydialog"></div>
<script src="static/js/jquery-form.js"></script>

<script type="text/javascript">
	$(function(){
		var url = 'hkdapp/exceptionOrder/list';
		initTableList(url,"orderTable", "findOrder_form");
	});
	function chooseExceptionOrder(){
		var handleStatus=$("#handleStatus1").find("option:selected").val();
		$('#handleStatus').val(handleStatus);
	}
	function chooseOrderType(){
		var orderType=$("#orderType1").find("option:selected").val();
		$('#orderType').val(orderType);
	}
	function showStatus(data){
		if(data.status == 2){
			return "已处理";
		} else {
			return "待处理";
		}
	}
	function showOrderType(data){
		if(data.orderType == 1){
			return "帮我买";
		}else if(data.orderType == 2){
			return "帮我送";
		}else if(data.orderType == 3){
			return "帮我取";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var delHTML = '';
		if(data.handleStatus == 2){
			delHTML='<a class="button border-blue button-little" href="javascript:openExceptionOrderWin(2, '+data.id+');">查看详情</a>';
		}else{
			delHTML = '<a class="button border-yellow button-little" href="javascript:openExceptionOrderWin(1, '+data.id+');">处理</a>';
		}
		return delHTML;
	}
	
	//查询订单信息
	function findExceptionOrder(){
		//设置当前页
		//var page = $('#currentPage').val();
		//$("[name='page']").val(page);
		var url = 'hkdapp/exceptionOrder/list';
		initTableList(url,"orderTable","findOrder_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipMobile').val("");
		$('#orderNumber').val("");
		$('#handleStatus1').val("");
		$('#orderType1').val("");
		$('#handleStatus').val("");
		$('#orderType').val("");
		$('#currentPage').val("1");
		findExceptionOrder();
	}
	
	function ondblClickTrHandler(dom, id){
		openBuyOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
	}
	
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addSchoolForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    $("#imageShow", iframeWin.document).hide();
	    if(params.type == 2){//修改
	    	if(params.row){
		    	iframeWin.initData(params.row);
	    	}
	    }
	    iframeWin.callbackImageFunc = uploadImageData;
	}
	
	function uploadImageData(){
	}
	
	function openExceptionOrderWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		var btn;
		if(type == 2){
			winTitle += "查看订单处理详细信息";
			btn = null;
		}else{
			btn = ['确定', '取消'];
		}
		var url = 'PlatformAdmin/HkdApp/exceptionOrderMng/handleDetail.jsp?v='+Math.random();
		var area = ['55%', '65%'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	
	function delBuyOrderByUUIDs(id){
	}

	function openImpSchoolWin(){
	}
</script>
