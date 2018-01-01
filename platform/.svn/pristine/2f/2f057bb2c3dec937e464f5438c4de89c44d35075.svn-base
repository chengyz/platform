<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel"  style="height:50px;">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findFeedBack" method="post" class="form-inline">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="vipName" type="text" class="input" name="vipName" size="20"  placeholder="请输入会员名称查询" title="请输入会员名称查询" />
					</div>
					<div class="field">
						<input id="vipMobile" type="text" class="input" name="vipMobile" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
					<div class="field">
			   	 		<input id="status" name="status" value="" type="hidden">
						<select id="handleStatus1" class="input" type="text" onchange="chooseFeedBack()">
							<option value="">--选择状态--</option>
							<option value="1">已查看</option>
							<option value="2">未查看</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findFeedBackInfo();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="orderTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px" field="rowNum" >序号</th>
			    <th width="90px" field="vipName" limitTxtLen="10">会员姓名</th>
			    <th width="90px" field="vipMobile" limitTxtLen="11">会员手机号</th>	
			    <th width="90px" field="createTime" limitTxtLen="20">反馈时间</th> 
			    <th width="90px" field="feedBackContent" limitTxtLen="20">反馈内容</th>
			    <th width="90px" field="contactWay" limitTxtLen="20">联系方式</th>
			    <th width="90px" format="showStatus" limitTxtLen="10">状态</th>
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
		var url = 'hkdapp/feedBackInfo/list';
		initTableList(url,"orderTable", "findFeedBack");
	});
	function chooseFeedBack(){
		var status=$("#handleStatus1").find("option:selected").val();
		$('#status').val(status);
	}
	function showStatus(data){
		if(data.status == 2){
			return "未查看";
		} else {
			return "已查看";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		 var delHTML='<a class="button border-blue button-little" href="javascript:openFeedBackWin(2, '+data.id+');">查看详情</a>';
		return delHTML;
	}
	
	//查询反馈信息
	function findFeedBackInfo(){
		//设置当前页
		//var page = $('#currentPage').val();
		//$("[name='page']").val(page);
		var url = 'hkdapp/feedBackInfo/list';
		initTableList(url,"orderTable","findFeedBack");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipMobile').val("");
		$('#vipName').val("");
		$('#handleStatus1').val("");
		$('#status').val("");
		$('#currentPage').val("1");
		findFeedBackInfo();
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
	
	function openFeedBackWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		var btn;
		winTitle += "查看反馈信息";
		btn = null;
		var url = 'PlatformAdmin/HkdApp/feedBackInfoMng/detail.jsp?v='+Math.random();
		var area = ['45%', '65%'];
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
