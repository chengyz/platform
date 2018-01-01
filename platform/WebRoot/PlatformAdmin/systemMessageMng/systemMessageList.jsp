<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel"  style="height:50px;">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findSystemMessage" method="post" class="form-inline">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
						<select class="input" id="belongLists" name="belongApp" style="width:150px;">
						</select>
			    	</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findSystemMessage();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="orderTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px" field="rowNum" >序号</th>
			    <th width="90px" field="messageTitle" limitTxtLen="10">消息标题</th>
			    <th width="90px" field="messageContent" limitTxtLen="10">消息内容</th>	
			    <th width="90px" field="createTime" limitTxtLen="11">创建时间</th> 
			    <th width="90px" field="belongApp" limitTxtLen="11">所属App</th> 
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
		var url = 'hkdapp/systemMessage/list';
		initTableList(url,"orderTable", "findSystemMessage");
	});
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var delHTML = '';
		if(data.status == 1){
			delHTML='<a class="button border-blue button-little" href="javascript:openFeedBackWin(2, '+data.id+');">查看详情</a>';
		}else{
			delHTML = '<a class="button border-yellow button-little" href="javascript:openFeedBackWin(1, '+data.id+');">点击查看</a>';
		}
		return delHTML;
	}
	//查找系统消息所属的app列表并装入下拉列表中
	function findBelongList(){
		var htmlMessageStr = "";
		$.ajax({
			 url: 'hkdapp/systemMessage/appList',
			 type: "POST",
			 cache: false,
			 data: {},
			 success: function(data){
				 if (data != null){
					 htmlMessageStr+='<option class="optionStyle" value="" name="">--请选择所属App--</option>';
				 	 var apps = data.apps;
				 	 if(apps.length > 0 && apps != null && apps != "" && apps != "null"){
				 		for(var i=0;i<apps.length;i++){
							htmlMessageStr+='<option class="optionStyle" value="'+apps[i].businessArea+'" name="'+apps[i].belongApp+'">'+apps[i].belongApp+'</option>';
						}
				 	 }
				 	$("#belongLists").html(htmlMessageStr);
				 }else{
				 	 htmlAreaStr+='<option class="optionStyle" value="1">--请选择所属App--</option>';
				 	 $("#belongLists").html(htmlMessageStr);
				 }
			 },
			 error : function() {  
			 }, 
			 dataType: 'json'
			});
		return false;
	}
	function findSystemMessage(){
		//设置当前页
		//var page = $('#currentPage').val();
		//$("[name='page']").val(page);
		var url = 'hkdapp/systemMessage/list';
		initTableList(url,"orderTable","findFeedBack");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#belongApp').val("");
		$('#currentPage').val("1");
		findSystemMessage();
	}
	
	function ondblClickTrHandler(dom, id){
		openBuyOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('所属平台、消息标题、消息内容不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/systemMessage/saveOrUpdate',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findSystemMessage();
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
		winTitle += "查看系统消息";
		btn = null;
		var url = 'PlatformAdmin/HkdApp/systemMessageMng/addOrUpdate.jsp?v='+Math.random();
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
