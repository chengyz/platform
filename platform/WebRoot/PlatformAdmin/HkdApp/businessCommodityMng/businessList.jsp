<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;">
	   <div class="button-group">
		</div>
		<div class="float-right">
		    <form id="findBusiness_form" method="post" class="form-inline">
		    	<input type="hidden" id="currentPage" name="page" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
			    <div class="field">
						<input id="businessAddr" type="text" class="input" name="businessAddr" size="20"  placeholder="请输入商家地址查询" title="请输入商家地址查询" />
					</div>
					<div class="field">
						<input id="businessName" type="text" class="input" name="businessName" size="20"  placeholder="请输入商家名称查询" title="请输入商家名称查询" />
					</div>
					<div class="field">
						<input id="unitUUID" type="text" class="input" name="unitUUID" size="23"  placeholder="请输入商家所属单位查询" title="请输入商家所属单位查询" />
					</div>
					<div class="form-group">
						<select class="input" id="areaLists" name="businessArea" style="width:160px;">
						</select>
			    	</div>
			    	<div class="form-group">
						<select class="input" id="typeLists" name="businessType" style="width:150px;">
						</select>
			    	</div>
					<div class="field">
			   	 		<input id="businessHot" name="businessHot" value="" type="hidden">
						<select id="businessHot1" class="input" type="text" onchange="choose()">
							<option value="">--选择是否热卖--</option>
							<option value="1">热卖</option>
							<option value="2">非热卖</option>
						</select>
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findBusiness();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="businessTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px" field="rowNum">序号</th>
			    <th field="businessName" limitTxtLen="20">商家简称</th> 
			    <th field="businessFullName" limitTxtLen="15">商家全名称</th>
			    <th field="businessType" limitTxtLen="20">商家类别</th>	
			    <th field="businessTel" limitTxtLen="20">商家电话</th>
			    <th field="businessArea" limitTxtLen="20">所在区域</th>
			    <th field="businessAddr" limitTxtLen="20">详细地址</th>	
			    <th field="businessCoordLongitude" limitTxtLen="20">坐标经度</th>
			    <th field="businessCoordLatitude" limitTxtLen="20">坐标纬度</th>	
			    <th field="businessTime" limitTxtLen="20">添加时间</th>
			    <th format="isOrNotHot" limitTxtLen="24">热卖商家</th>
			    <th field="unitUUID" limitTxtLen="24">所属单位</th>
			    <th field="businessMark" limitTxtLen="20">备注</th>	
			    <th format="editHandler">操作</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div class="panel-foot text-left hidden-l">
			<input type="hidden" value="1" id="pageHelp"/>
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
		
		var businessAddr = $("#businessAddrs").val();
		var businessName = $("#businessNames").val();
		var unitUUID = $("#unitUUIDs").val();
		
		if(businessAddr != null && businessAddr != ""){
			$("[name='businessAddr']").val(businessAddr);
		}
		if(businessName != null && businessName != ""){
			$("[name='businessName']").val(businessName);
		}
		if(unitUUID != null && unitUUID != ""){
			$("[name='unitUUID']").val(unitUUID);
		}
		
		if(!findTypeAreaList()) {
			findBusiness();
		}
		//查询商家列表放在查询商家类型和商家所属区域里面，可以实现从条件查询的商家进入当前商家的列表之后点击返回按钮回来仍然是进入商品列表前的商家列表
		//var url = 'hkdapp/business/findBussinessList';
		//initTableList(url,"businessTable", "findBusiness_form");
	});
	function isOrNotHot(data){
		if(data.businessHot){
			if(data.businessHot == 1){
				return "是";
			}else{
				return "否";
			}
		}
	}
	
	function choose(){
		var businessHot=$("#businessHot1").find("option:selected").val();
		$('#businessHot').val(businessHot);
		$('#businessHots').val(businessHot);
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		datas[data.id] = data;
		var modifHTML = '<a class="button border-blue button-little" href="javascript:openBusinessWin(2, '+data.id+');">修改</a>';
		var delHTML = '<a class="button border-yellow button-little" href="javascript:delBusinessByUUIDs('+data.id+');">删除</a>';
		var link = '<a class="button border-blue button-little" href="javascript:loadMainCommodity(\''+data.businessUUID+'\');">商品管理</a>';
		return modifHTML + delHTML + link;
	}
	//查找商家类型和区域并装入下拉列表中
	function findTypeAreaList(){
		var htmlAreaStr = "";
		var htmlTypeStr = "";
		$.ajax({
			 url: 'hkdapp/business/findTypeAreaList',
			 type: "POST",
			 cache: false,
			 data: {},
			 success: function(data){
				 if (data != null){
					 htmlAreaStr+='<option class="optionStyle" value="" name="">--请选择商家所属区域--</option>';
					 htmlTypeStr+='<option class="optionStyle" value="" name="">--请选择商家类型--</option>';
				 	 var areas = data.areas;
				 	 var types = data.types;
				 	 if(areas.length > 0 && areas != null && areas != "" && areas != "null"){
				 		for(var i=0;i<areas.length;i++){
							htmlAreaStr+='<option class="optionStyle" value="'+areas[i].businessArea+'" name="'+areas[i].businessArea+'">'+areas[i].businessArea+'</option>';
						}
				 	 }
				 	$("#areaLists").html(htmlAreaStr);
					 if(types.length > 0){
						 for(var i=0;i<types.length;i++){
							 if(types[i].businessType == "其他"){
								 var end = types[types.length - 1].businessType;
								 var change = "";
								 change = types[i].businessType;
								 types[i].businessType = end;
								 types[types.length - 1].businessType = change;
							 }
							 htmlTypeStr+='<option class="optionStyle" value="'+types[i].businessType+'" name="'+types[i].businessType+'">'+types[i].businessType+'</option>';
						 }
						 $("#typeLists").html(htmlTypeStr);
					 }
					 //商家类型
					 var businessType = $("#businessTypes").val();
					 if(businessType != null && businessType != "") {
						 for(var i = 0;i<$('#typeLists').children().length;i++){
							var v = $('#typeLists').find('option').eq(i).val();
							if(v == businessType){
								$('#typeLists').find('option').eq(i).attr('selected','selected');	
							}
						}
					 }
					 //商家所属区域
					 var businessArea = $("#businessAreas").val();
					 if(businessArea != null && businessArea != "") {
						 for(var i = 0;i<$('#areaLists').children().length;i++){
							var v = $('#areaLists').find('option').eq(i).val();
							if(v == businessArea){
								$('#areaLists').find('option').eq(i).attr('selected','selected');	
							}
						}
					 }
					 //是否热卖商家
					 var businessHot = $("#businessHots").val();
					 $("#businessHot").val(businessHot);
					 if(businessHot != null && businessHot != "") {
						 for(var i = 0;i<$('#businessHot1').children().length;i++){
							var v = $('#businessHot1').find('option').eq(i).val();
							if(v == businessHot){
								$('#businessHot1').find('option').eq(i).attr('selected','selected');	
							}
						}
					 }
					 var pages = $("#businessPage").val();
						if(pages != null && pages != ""){
							$("[name='page']").val(pages);
						}
					 //查询商家
					 findBusinesss();
					 return true;
				 }else{
				 	 htmlAreaStr+='<option class="optionStyle" value="1">--请选择商家所属区域--</option>';
				 	 $("#areaLists").html(htmlAreaStr);
				 	 htmlTypeStr+='<option class="optionStyle" value="1">--请选择商家类型--</option>';
					 $("#typeLists").html(htmlTypeStr);
				 }
			 },
			 error : function() {  
			 }, 
			 dataType: 'json'
			});
		return false;
	}
	function loadMainCommodity(uuid){
		//在index.jsp页面上写隐藏的input，便于从商家管理进入商品管理的时候点击返回能够回到商家管理的当前页
		var page = $('#currentPage').val();
		var businessAddr = $('#businessAddr').val();
		var businessName = $('#businessName').val();
		var unitUUID = $('#unitUUID').val();
		var businessArea = $('#businessArea').val();
		var businessType = $('#businessType').val();
		var businessHot = $('#businessHot').val();
		var businessType=$("#typeLists").find("option:selected").val();
		var businessArea=$("#areaLists").find("option:selected").val();
		$("#businessPage").val(page);
		$("#businessAddrs").val(businessAddr);
		$("#businessNames").val(businessName);
		$("#unitUUIDs").val(unitUUID);
		$("#businessAreas").val(businessArea);
		$("#businessTypes").val(businessType);
		$("#businessHots").val(businessHot);
		
		$("#mainContent").html("");
	    $("#mainContent").load('PlatformAdmin/HkdApp/businessCommodityMng/commodityList.jsp');
		$("#businessUUIDS").val(uuid);
		var tmpArr = '02_0202_020208'.split("_");
		var temp = "";
		for(var i = 0; i<tmpArr.length; i++){
			temp += '<li>' + $("#item"+tmpArr[i]).text() + '</li>';
		}
	    $("#indexBread").html('<li><a href="admin/index.jsp" class="icon-home"> 首页</a></li>' + temp);
	}
	//查询商家信息、查询按钮触发
	function findBusiness(){
		//var page = $('#currentPage').val();
		//设置当前页
		$("[name='page']").val(1);
		var url = 'hkdapp/business/findBussinessList';
		initTableList(url,"businessTable","findBusiness_form");
	}
	//查询商家信息、商品列表页面返回按钮触发
	function findBusinesss(){
		var url = 'hkdapp/business/findBussinessList';
		initTableList(url,"businessTable","findBusiness_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#areaLists').val("");
		$('#typeLists').val("");
		$('#businessName').val("");
		$('#unitUUID').val("");
		$('#businessHot').val("");
		$('#businessHot1').val("");
		$('#businessAddr').val("");
		$("[name='page']").val(1);
		findBusiness();
	}
	
	function ondblClickTrHandler(dom, id){
		openBusinessWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
		if(iframeWin.getFromSerialize() == null){
			 layer.msg('商家名称、商家地址不能为空！', {icon: 0}); 
		}else{
			$.ajax({
				 url: 'hkdapp/business/updateBusiness',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					 layer.close(layerOpenIndex);
					 findBusiness();
					 if(data.status == 1){
						 layer.msg('数据操作成功！', {icon: 1});
					 }else{
						 layer.msg('数据操作失败！', {icon: 1});
					 }
					 
				 },
				 error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
				});
		}
		
	}

	function openBusinessWin(type, id) {
		var winTitle = '<i class="icon-search"></i>';
		winTitle += type == 1?"添加商家信息":"修改商家信息";
		var url = 'PlatformAdmin/HkdApp/businessCommodityMng/addBusinessInfo.jsp';
		var area = ['58%', '75%'];
		var btn = ['确定', '取消'];
		var row = null;
		if(id){
			row = datas[id];
		}
		layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenWin, {"type":type, "row":row});
	}
	function afterOpenWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		addSchoolForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    //iframeWin.test();
	    $("#imageShow", iframeWin.document).hide();
	    if(params.type == 1){//添加
	    	//iframeWin.addData();
	    	addSchoolForm.reset();
	    }else if(params.type == 2){//修改
	    	if(params.row){
		    	iframeWin.initData(params.row);
	    	}
	    }
	    iframeWin.callbackImageFunc = uploadImageData;
	}
	function delBusinessByUUIDs(id){
		var uuids = datas[id].businessUUID;
		var temp = uuids.toString().split("_");
		var tip = temp.length >2?"确认要删除这"+(temp.length-1)+"条数据吗?":"确认要删除该条数据吗?";
		layer.confirm(tip, function(index){
			$.ajax({
				 url: 'hkdapp/business/delBusinessInfo',
				 type: "POST",
				 cache: false,
				 data: {
					 businessUUID:uuids
				 },
				 success: function(data){
					 if(data){
						 	layer.msg('数据删除成功！', {icon: 1}); 
						 	findBusiness();
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
	function uploadImageData(type){
		$("#addDataForm", iframeWin.document).ajaxSubmit({
			url:'<%=path%>/hkdapp/business/uploadImages',
			type:'post',
			beforeSubmit:function(){
				return iframeWin.isOk;
			},
			success : function(data) {
				if(data){
					if(type == 1){
						$("#businessImg1", iframeWin.document).val(data);
						$("#img11", iframeWin.document).show();
						$("#img11", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 2){
						$("#businessImg2", iframeWin.document).val(data);
						$("#img22", iframeWin.document).show();
						$("#img22", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 3){
						$("#businessImg3", iframeWin.document).val(data);
						$("#img33", iframeWin.document).show();
						$("#img33", iframeWin.document).attr("src", '<%=path %>'+data)
					}
					if(type == 4){
						$("#businessImg4", iframeWin.document).val(data);
						$("#img44", iframeWin.document).show();
						$("#img44", iframeWin.document).attr("src", '<%=path %>'+data)
					}
				}
			},
	        error: function (msg) {
	        }
	   });
	}
	function openImpSchoolWin(){
	}
</script>