<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findCertificate_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="vipPhoneNumber" type="text" class="input" name="vipPhoneNumber" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
						<input id="trueName" type="text" class="input" name="trueName" size="20"  placeholder="请输入真实姓名查询" title="请输入真实姓名查询" />
					</div>
					<div class="field">
						<input id="userName" type="text" class="input" name="userName" size="20"  placeholder="请输入审核人查询" title="请输入审核人查询" />
					</div>
					<div class="field">
						<input id="startTime" class="input" type="text" name="startTime" size="25"  placeholder="请选取申请起始时间查询" title="请选取申请起始时间查询" />
					</div>
					<div class="field">
						<input id="endTime" class="input" type="text" name="endTime" size="25"  placeholder="请选取申请终止时间查询" title="请选取申请终止时间查询" />
					</div>
					<div class="field">
			   	 		<input id="transport" name="transport" value="" type="hidden">
						<select id="transport1" class="input" type="text" onchange="chooseTransport()">
							<option value="">--选择交通工具--</option>
							<option value="1">私家小轿车</option>
							<option value="2">摩托车</option>
							<option value="3">单车</option>
							<option value="4">其他</option>
						</select>
					</div>
					<div class="field">
			   	 		<input id="status" name="status" value="" type="hidden">
						<select id="status1" class="input" type="text" onchange="choose()">
							<option value="">--选择审核状态--</option>
							<option value="1">审核未通过</option>
							<option value="2">待审核</option>
							<option value="3">审核通过</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findCertificate();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="certificateTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
			    <th field="vipPhoneNumber" limitTxtLen="11">会员手机号</th>
			    <th field="trueName" limitTxtLen="5">真实姓名</th> 
			    <th field="idNumber" limitTxtLen="18">身份证号</th>	
			    <th format="transports" limitTxtLen="10">交通工具</th> 
			    <th field="phoneNumber" limitTxtLen="11">手机号码</th>
			    <th field="createTime" limitTxtLen="20">申请时间</th>
			    <th field="updateTime" limitTxtLen="20">修改时间</th>
			    <th field="userName" limitTxtLen="5">审核人</th> 
			    <th format="showStatus" limitTxtLen="7">审核状态</th>
			    <th field="reason" limitTxtLen="20">审核意见</th>	
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
		var url = 'hkdapp/certificate/findCertificateList';
		initTableList(url,"certificateTable", "findCertificate_form");
	});
	function choose(){
		var status=$("#status1").find("option:selected").val();
		$('#status').val(status);
	}
	function chooseTransport(){
		var transport=$("#transport1").find("option:selected").val();
		$('#transport').val(transport);
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
	function showStatus(data){
		if(data.status == 1){
			return "审核未通过";
		}else if(data.status == 2){
			return "待审核";
		}else if(data.status == 3){
			return "审核通过";
		}
	}
	 function transports(data){
		if(data.transport == 1){
			return "私家小轿车";
		}else if(data.transport == 2){
			return "摩托车";
		}else if(data.transport == 3){
			return "单车";
		}else if(data.transport == 4){
			return "其他";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var delHTML = '';
		if(data.status == 1 || data.status == 3){
			delHTML='<a class="button border-blue button-little" href="javascript:openCertificateWin(2, '+data.id+');">查看详情</a>';
		}else{
			delHTML = '<a class="button border-yellow button-little" href="javascript:openCertificateWin(1, '+data.id+');">审核</a>';
		}
		return delHTML;
	}
	
	//查询区域信息
	function findCertificate(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/certificate/findCertificateList';
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		initTableList(url,"certificateTable","findCertificate_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipPhoneNumber').val("");
		$('#trueName').val("");
		$('#userName').val("");
		$('#endTime').val("");
		$('#startTime').val("");
		$('#status1').val("");
		$('#status').val("");
		$('#transport1').val("");
		$('#transport').val("");
		$('#currentPage').val("1");
		findCertificate();
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			layer.msg('请填写审核不通过的原因！',{icon: 0});
		}else{
			$.ajax({
				url: 'hkdapp/certificate/updateCertificate',
				type: "POST",
				cache:false,
				data: iframeWin.getFromSerialize(),
				success: function(data){
					layer.close(layerOpenIndex);
					findCertificate();
					if(params.type == 1){
						layer.msg('审核成功！', {icon: 1});
					}else{
						layer.msg('审核失败！', {icon: 1});
					}
				},
				error : function() {  
					layer.msg('审核记录提交时出现异常！', {icon: 0}); 
				}, 
				dataType: 'json'
			});
		}
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
	
	function openCertificateWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		if(type == 2){
			winTitle += "查看详细信息";
			var btn = null;
		}
		if(type == 1){
			winTitle += "审核实名认证信息";
			var btn = ['确认', '取消'];
		}
		var url = 'PlatformAdmin/HkdApp/certificateMng/certificateDetail.jsp';
		var area = ['50%', '80%'];
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
