<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findRecord_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="vipMobilePhone" type="text" class="input" name="vipMobilePhone" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
						<input id="vipName" type="text" class="input" name="vipName" size="20"  placeholder="请输入会员姓名查询" title="请输入会员姓名查询" />
					</div>
					<div class="field">
						<input id="startTime" class="input" type="text" name="startTime" size="25"  placeholder="请选取支付起始时间查询" title="请选取支付起始时间查询" />
					</div>
					<div class="field">
						<input id="endTime" class="input" type="text" name="endTime" size="25"  placeholder="请选取支付终止时间查询" title="请选取支付终止时间查询" />
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findRecord();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="recordTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
			    <th field="vipMobilePhone" limitTxtLen="11">会员手机号</th>
			    <th field="vipName" limitTxtLen="11">会员名称</th> 
			    <th field="tradeNo" limitTxtLen="30">交易流水号</th>	
			    <th field="consumptionMoney" limitTxtLen="15">消费金额</th>
			    <th field="consumptionTime" limitTxtLen="20">消费时间</th>
			    <th field="consumptionDetails" limitTxtLen="40">消费详情</th> 
			    <th field="moduleName" limitTxtLen="11">消费模块名称</th>
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

<script type="text/javascript">
	$(function(){
		var url = 'hkdapp/consumptionRecord/consumptionRecordList';
		initTableList(url,"recordTable", "findRecord_form");
	});
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
		var delHTML = '';
			delHTML='<a class="button border-blue button-little" href="javascript:openRecordWin(2, '+data.id+');">查看详情</a>';
		return delHTML;
	}
	
	//查询消费记录信息
	function findRecord(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/consumptionRecord/consumptionRecordList';
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		initTableList(url,"recordTable","findRecord_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipMobilePhone').val("");
		$('#vipName').val("");
		$('#endTime').val("");
		$('#startTime').val("");
		$('#currentPage').val("1");
		findRecord();
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
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
	
	function openRecordWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		if(type == 2){
			winTitle += "查看详细信息";
			var btn = null;
		}
		var url = 'PlatformAdmin/HkdApp/cashBalanceMng/consumptionRecordDetail.jsp';
		var area = ['40%', '50%'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	
	function delSendOrderByUUIDs(id){
	}

	function openImpSchoolWin(){
	}
</script>
