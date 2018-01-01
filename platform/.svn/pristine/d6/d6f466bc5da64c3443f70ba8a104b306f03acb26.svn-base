<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findBalance_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="vipName" type="text" class="input" name="vipName" size="20"  placeholder="请输入真实姓名查询" title="请输入真实姓名查询" />
					</div>
					<div class="field">
						<input id="vipPhoneNumber" type="text" class="input" name="vipPhoneNumber" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findBalance();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="balanceTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
			    <th field="vipName" limitTxtLen="11">会员名称</th> 
			    <th field="vipPhoneNumber" limitTxtLen="11">会员手机号</th>
			    <th field="vipBalance" limitTxtLen="10">余额</th>	
			    <th field="createTime" limitTxtLen="15">创建时间</th>
			    <th field="updateTime" limitTxtLen="20">修改时间</th>
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
		var url = 'hkdapp/vipBalance/list';
		initTableList(url,"balanceTable", "findBalance_form");
	});
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
	}
	
	//查询会员余额信息
	function findBalance(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/vipBalance/list';
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		initTableList(url,"balanceTable","findBalance_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipPhoneNumber').val("");
		$('#vipName').val("");
		$('#currentPage').val("1");
		findBalance();
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		
	}
	
	function afterOpenWin(layero, index, params){
	}
	
	function uploadImageData(){
	}
	
	function openCertificateWin(type, id) {
	}
	
	function delSendOrderByUUIDs(id){
	}

	function openImpSchoolWin(){
	}
</script>
