<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
		<div class="float-right">
		    <form id="findData_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->
				<div class="form-group">
					<div class="field">
						<input id="cmdtName" type="text" class="input" name="cmdtName" size="20"  placeholder="请输入商品名称查询" title="请输入商品名称查询" />
					</div>
					<div class="field">
			   	 		<input id="cmdtState" name="cmdtState" value="" type="hidden">
						<select id="cmdtState1" class="input" type="text" onchange="chooseCmdtStates()">
							<option value="">--选择商品状态--</option>
							<option value="1">上架</option>
							<option value="2">下架</option>
						</select>
					</div>
					<div class="field">
			   	 		<input id="cmdtHot" name="cmdtHot" value="" type="hidden">
						<select id="cmdtHot1" class="input" type="text" onchange="chooseCmdtHots()">
							<option value="">--选择是否热卖--</option>
							<option value="1">热卖商品</option>
							<option value="2">非热卖商品</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findCommodity();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>			
			</form>
		</div>
	</div>
	<table id="commodityTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
			    <th field="cmdtName" limitTxtLen="10">商品名称</th>
			    <th field="cmdtPrice" limitTxtLen="10">商品价格</th>
			    <th format="showStates" limitTxtLen="20">商品状态</th>
			    <th field="cmdtCount" limitTxtLen="10">商品数量</th>
			    <th field="cmdtCreateTime" limitTxtLen="20">创建时间</th>
			    <th format="isOrNotHot" limitTxtLen="10">是否热卖</th>
			    <th field="cmdtIntroduce" limitTxtLen="20">商品介绍</th>
			    <th format="showImg1">商品图片</th>
			    <th format="editHandler">操作</th>
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
		var url = 'hkdapp/commodity/findCommodityList';
		initTableList(url,"commodityTable", "findData_form");
	});
	function showImg1(data){
		var modifHTML = '<img style="width:180px;height:60px;" src=<%=path %>/'+data.cmdtImg1+'></img>';
		return modifHTML;
	}
	function isOrNotHot(data){
		if(data.cmdtHot == 1){
			return "是";
		}else{
			return "否";
		}
	}
	function showStates(data){
		if(data.cmdtState == 1){
			return "上架";
		}else{
			return "下架";
		}
	}
	function chooseCmdtHots(){
		var cmdtHot=$("#cmdtHot1").find("option:selected").val();
		$('#cmdtHot').val(cmdtHot);
	}
	function chooseCmdtStates(){
		var cmdtState=$("#cmdtState1").find("option:selected").val();
		$('#cmdtState').val(cmdtState);
	}
	function findCommodity(){
		var url = 'hkdapp/commodity/findCommodityList';
		initTableList(url,"commodityTable", "findData_form");
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	//清空查询条件
	function clearQueryCondition(){
		$('#cmdtState1').val("");
		$('#cmdtState').val("");
		$('#cmdtName').val("");
		$('#cmdtHot1').val("");
		$('#cmdtHot').val("");
		$('#currentPage').val("1");
		findCommodity();
	}
	
	function ondblClickTrHandler(dom, id){
		openSendOrderWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('商品名称不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/commodity/saveOrUpdate',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findCommodity();
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
	function openCommodityWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加商品":"修改商品";
		var url = 'PlatformAdmin/HkdApp/businessCommodityMng/addCommodityDetails.jsp';
		var area = ['43%', '69%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openCommodityWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delCommodityByUUIDs('+data.id+');">删除</a>';
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
			url:'<%=path%>/hkdapp/commodity/uploadImages',
			type:'post',
			beforeSubmit:function(){
				return iframeWin.isOk;
			},
			success : function(data) {
				if(data){
					if(type == 1){
						$("#cmdtImg1", iframeWin.document).val(data);
						$("#img1", iframeWin.document).show();
						$("#img1", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 2){
						$("#cmdtImg2", iframeWin.document).val(data);
						$("#img2", iframeWin.document).show();
						$("#img2", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 3){
						$("#cmdtImg3", iframeWin.document).val(data);
						$("#img3", iframeWin.document).show();
						$("#img3", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 4){
						$("#cmdtImg4", iframeWin.document).val(data);
						$("#img4", iframeWin.document).show();
						$("#img4", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 5){
						$("#cmdtImg5", iframeWin.document).val(data);
						$("#img5", iframeWin.document).show();
						$("#img5", iframeWin.document).attr("src", '<%=path %>'+data)
					}
				}
			},
	        error: function (msg) {
	        }
	   });
	}
	
	function delCommodityByUUIDs(id){
		var uuids = datas[id].cmdtUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/commodity/delCommodity',
				 type: "POST",
				 cache: false,
				 data: {
					 cmdtUUID:uuids
				 },
				 success: function(data){
					 if(data){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	findCommodity();
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
