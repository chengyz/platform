<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	<input type="hidden" value="" name="modulus" id="modulus"/>
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findWithdrawCash_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="vipName" type="text" class="input" name="vipName" size="20"  placeholder="请输入会员名称查询" title="请输入会员名称查询" />
					</div>
					<div class="field">
						<input id="vipPhoneNumber" type="text" class="input" name="vipPhoneNumber" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
						<input id="startTime" class="input" type="text" name="startTime" size="25"  placeholder="请选取申请起始时间查询" title="请选取申请起始时间查询" />
					</div>
					<div class="field">
						<input id="endTime" class="input" type="text" name="endTime" size="25"  placeholder="请选取申请终止时间查询" title="请选取申请终止时间查询" />
					</div>
					<div class="field">
			   	 		<input id="status" name="status" value="" type="hidden">
						<select id="status1" class="input" type="text" onchange="choose()">
							<option value="">--选择提现状态--</option>
							<option value="1">审核中</option>
							<option value="2">提现失败</option>
							<option value="3">提现成功</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findWithdrawCash();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="withdrawCashTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
				<!-- <th><input type="checkbox" value="" name=""></th> -->
			    <th field="vipName" limitTxtLen="11">会员名称</th> 
			    <th field="vipPhoneNumber" limitTxtLen="11">会员手机号</th>
			    <th field="vipBalance" limitTxtLen="10" style="color:#f00ac4">会员余额</th>
			    <th field="withdrawCashAmount" limitTxtLen="16" style="color:#40ea2e">申请提现金额</th>
			    <th field="canWithdrawCashAmount" limitTxtLen="16" style="color:#ec2257">可以提现金额</th>	
			    <th field="withdrawCashFee" limitTxtLen="12">提现手续费</th>
			    <th field="withdrawCashAccount" limitTxtLen="15">提现账号</th>
			    <th field="applyTime" limitTxtLen="20">申请时间</th>
			    <th field="withdrawCashTime" limitTxtLen="20">提现时间</th>
			    <th format="showStatus" limitTxtLen="20">提现状态</th>
			    <th format="editHandler">操作</th>
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
<script src="static/js/jedate/jedate.js"></script>

<script src="static/js/rsa/RSA.js"></script>
<script src="static/js/rsa/BigInt.js"></script>
<script src="static/js/rsa/Barrett.js"></script>
<script src="static/js/rsa/rsaEncrypt.js"></script>

<script type="text/javascript">
	$(function(){
		var url = 'hkdapp/withdrawCash/list';
		initTableList(url,"withdrawCashTable", "findWithdrawCash_form");
		loadModulus();
	});
	function choose(){
		var status=$("#status1").find("option:selected").val();
		$('#status').val(status);
	}
	 jeDate({
			dateCell:"#endTime",
			format:"YYYY-MM-DD  hh:mm:ss",
			isinitVal:false,
			isTime:true, //isClear:false,
			minDate:"2014-09-19 00:00:00",
			okfun:function(val){}
		})
		jeDate({
			dateCell:"#startTime",
			format:"YYYY-MM-DD  hh:mm:ss",
			isinitVal:false,
			isTime:true, //isClear:false,
			minDate:"2014-09-19 00:00:00",
			okfun:function(val){}
		})
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var delHTML ='';
		if(data.status == 1){
			var cashUUID = data.cashUUID;
			delHTML +='<a class="button border-green button-little" href="javascript:agreeWithdrawCash(\''+data.id+'\');">同意提现</a>';
			delHTML +='<a class="button border-blue button-little" href="javascript:openWithdrawCashWin(2, '+data.id+');">查看详情</a>';
			delHTML +='<a class="button border-yellow button-little" href="javascript:disAgreeWithdrawCash(\''+data.id+'\');">拒绝提现</a>';
		}else{
			delHTML +='<a class="button border-blue button-little" href="javascript:openWithdrawCashWin(2, '+data.id+')";>查看详情</a>';
		}
		return delHTML;
	}
	function showStatus(data){
		if(data.status == 1){
			return "审核中";
		}
		if(data.status == 2){
			return "提现失败";
		}
		if(data.status == 3){
			return "提现成功";
		}
	}
	//查询提现信息
	function findWithdrawCash(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/withdrawCash/list';
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		initTableList(url,"withdrawCashTable","findWithdrawCash_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#status1').val("");
		$('#status').val("");
		$('#vipPhoneNumber').val("");
		$('#vipName').val("");
		$('#endTime').val("");
		$('#startTime').val("");
		$('#currentPage').val("1");
		findWithdrawCash();
	}
	
	function addOrUpdateData(iframeWin, params){
		
	}
	
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addSchoolForm = body.find('form')[0];
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
	
	function openWithdrawCashWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		if(type == 2){
			winTitle += "查看详细信息";
			var btn = null;
		}
		var url = 'PlatformAdmin/HkdApp/cashBalanceMng/withdrawCashDetail.jsp';
		var area = ['35%', '65%'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function agreeWithdrawCash(id){
		var modulus = $('#modulus').val().replace(/"/g,'');//替换掉双引号，否则后台解密后为null
		alert(modulus);
		var uuids = datas[id].cashUUID;
		var uuid = rsaEncrypt(modulus, uuids);
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认同意提现"+(temp.length-1)+"吗?":"确认同意提现吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/withdrawCash/updateStatus',
				 type: "POST",
				 cache:false,
				 data: {'cashUUID':uuids,'status':3,'uuid':uuid},
				 success: function(data){
					 if(data){
						 layer.msg('同意提现操作成功！', {icon: 1});
						 findWithdrawCash();
					 }else{
						 layer.msg('同意提现操作失败！', {icon: 1});
					 }
				 },
				 error : function() {  
					 layer.msg('同意提现操作时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
			});
		}); 
		
		
	}
	function disAgreeWithdrawCash(id){
		var uuids = datas[id].cashUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认拒绝提现"+(temp.length-1)+"吗?":"确认拒绝提现吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/withdrawCash/updateStatus',
				 type: "POST",
				 cache:false,
				 data: {'cashUUID':uuids,'status':2},
				 success: function(data){
					 if(data){
						 layer.msg('拒绝提现操作成功！', {icon: 1});
						 findWithdrawCash();
					 }else{
						 layer.msg('拒绝提现操作失败！', {icon: 1});
					 }
				 },
				 error : function() {  
					 layer.msg('拒绝提现操作时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
			});
		}); 
	}
</script>
