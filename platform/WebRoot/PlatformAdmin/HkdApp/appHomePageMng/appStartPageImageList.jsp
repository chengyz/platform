<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" >
		<div class="button-group">
			<a href="javascript: openImageWin(1);" class="button button-small border-blue" ><span class="icon-plus"></span> 添加</a> 
		</div>
		<div class="float-right">
		    <form id="findImage_form" method="post" class="form-inline" style="margin-top:-6px;">
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
	<table id="imagesTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th field="rowNum" >序号</th>
			    <th field="imageName" limitTxtLen="10">图片名称</th>
			    <th field="createTime" limitTxtLen="20">创建时间</th>
			    <th field="displayOrder" limitTxtLen="10">显示顺序</th>
			    <th field="belongApp" limitTxtLen="10">所属App</th>
			    <th field="remark" limitTxtLen="20">备注</th>
			    <th format="yesOrNoAdvert">是否为广告</th>
			    <th format="yesOrNoDisable">是否禁用</th>
			    <th format="showImage">图片展示</th>
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
		var url = 'hkdapp/appStartPage/imagesList';
		initTableList(url,"imagesTable", "findImage_form");
	});
	function showImage(data){
		var modifHTML = '<img style="width:200px;height:80px;" src=<%=path %>/'+data.imagePath+'></img>';
		return modifHTML;
	}
	function yesOrNoAdvert(data){
		if(data.flag == 1){
			return "是";
		}
		if(data.flag == 2){
			return "否";
		}
	}
	function yesOrNoDisable(data){
		if(data.disable == 1){
			return "是";
		}
		if(data.disable == 2){
			return "否";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	//查询提现信息
	function findImage(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/appStartPage/imagesList';
		initTableList(url,"imagesTable","findImage_form");
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
				 url: 'hkdapp/appStartPage/updateImages',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findImage();
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
	function openImageWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加图片信息":"修改图片信息";
		var url = 'PlatformAdmin/HkdApp/appHomePageMng/appStartPageImageDetail.jsp';
		var area = ['40%', '70%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openImageWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delImageByUUIDs('+data.id+');">删除</a>';
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
		$("#addDataForm", iframeWin.document).ajaxSubmit({
			url:'<%=path%>/hkdapp/appStartPage/uploadImages',
			type:'post',
			beforeSubmit:function(){
				return iframeWin.isOk;
			},
			success : function(data) {
				if(data){
					$("#imagePath", iframeWin.document).val(data);
					$("#imageShow", iframeWin.document).show();
					$("#imageShow", iframeWin.document).attr("src", '<%=path %>'+data)
				}
			},
	        error: function (msg) {
	        }
	   });
	}
	
	function delImageByUUIDs(id){
		var uuids = datas[id].pageUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/appStartPage/deleteImages',
				 type: "POST",
				 cache: false,
				 data: {
					 pageUUID:uuids
				 },
				 success: function(data){
					 if(data){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	findImage();
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
