<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" >
	   <div class="button-group" style=""></div>
		<div class="float-right">
		    <form id="findEvaluate_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
				</div>
				<div class="form-button button-group">
				</div>
			</form>
		</div>
	</div>
	<table id="evaluateTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px" field="rowNum" >序号</th>
			    <th width="90px" format="showOrderType" limitTxtLen="10">订单类型</th>
			    <th width="90px" field="starGrade" limitTxtLen="10">星级</th>
			    <th width="220px" field="evaluateTime" limitTxtLen="20">评价时间</th>
			    <th width="90px" field="evaluateName" limitTxtLen="10">评价者名称</th>
			    <th width="150px" field="content" limitTxtLen="15">评价内容</th>
			    <th width="90px" format="editHandler">操作</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div class="panel-foot text-left hidden-l">
			<input type="hidden" value="4" id="imageValue">
			<ul class="pagination">
				<li><a title="首页"><span class="icon-step-backward"></span>&nbsp;首页</a></li>
				<li><a title="上一页"><span class="icon-chevron-left"></span>&nbsp;上一页</a></li>
			</ul>
			<ul class="pagination pagination-group" id="pageGroup"></ul>
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
		var url = 'hkdapp/evaluateInfo/evaluatesLists';
		initTableList(url,"evaluateTable", "findEvaluate_form");
	});
	function showOrderType(data){
		if(data.orderType == 1){
			return "帮我买";
		} else if(data.orderType == 2){
			return "帮我送";
		} else if(data.orderType == 3){
			return "帮我取";
		} else {
			return "";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function findEvaluate(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/evaluateInfo/evaluatesLists';
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		initTableList(url,"evaluateTable","findEvaluate_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipPhoneNumber').val("");
		$('#businessName').val("");
		$('#endTime').val("");
		$('#startTime').val("");
		$('#currentPage').val("1");
		findCollect();
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('图片不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/evaluateInfo/saveOrUpEvaluate',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findEvaluate();
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
	function openEvaluateWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加评价":"修改评价";
		var url = 'PlatformAdmin/HkdApp/evaluateMng/evaluateInfoDetail.jsp?v='+Math.random();
		var area = ['43%', '65%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openEvaluateWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delEvaluateByUUIDs('+data.id+');">删除</a>';
		return modifHTML + delHTML;
	}
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addDataForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    //$("#imageShow", iframeWin.document).hide();
	    if(params.type == 2 || params.type == 1){
	    	if(params.row){
		    	iframeWin.initData(params.row);
	    	}
	    }
	    iframeWin.callbackImageFunc = uploadImageData;
	}
	function uploadImageData(type){
		$("#addDataForm", iframeWin.document).ajaxSubmit({
			url:'<%=path%>/hkdapp/evaluateInfo/uploadImages',
			type:'post',
			beforeSubmit:function(){
				return iframeWin.isOk;
			},
			success : function(data) {
				if(data){
					if(type == 1){
						$("#img1", iframeWin.document).val(data);
						$("#img11", iframeWin.document).show();
						$("#img11", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 2){
						$("#img2", iframeWin.document).val(data);
						$("#img22", iframeWin.document).show();
						$("#img22", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 3){
						$("#img3", iframeWin.document).val(data);
						$("#img33", iframeWin.document).show();
						$("#img33", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 4){
						$("#img4", iframeWin.document).val(data);
						$("#img44", iframeWin.document).show();
						$("#img44", iframeWin.document).attr("src", '<%=path %>'+data)
					}
				}
			},
	        error: function (msg) {
	        }
	   });
	}
	
	function delEvaluateByUUIDs(id){
		var uuids = datas[id].evaluateUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/evaluateInfo/deleteEvaluate',
				 type: "POST",
				 cache: false,
				 data: {
					 evaluateUUID:uuids
				 },
				 success: function(data){
					 if(data){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	findEvaluate();
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
