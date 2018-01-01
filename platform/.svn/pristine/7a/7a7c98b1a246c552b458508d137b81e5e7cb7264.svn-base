<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="panel admin-panel">
	<div class="panel-head" style="height:50px;margin-bottom: 5px;" >
	    <div class="button-group"></div>
		<div class="float-right">
		    <form id="findAddress_form" method="post" class="form-inline" style="margin-top:-6px;">
		    	<input type="hidden" name="vipUUID" id="vipUUID" value=""/><!-- 当前页 -->
		    	<input type="hidden" name="page" id="currentPage" value="1"/><!-- 当前页 -->
				<input type="hidden" name="totalPage" value="1"/><!-- 总页数 -->
				<input type="hidden" name="pageRecord" value="8"/><!-- 每页显示条数 -->
				<input type="hidden" name="totalRecord" value="0"/><!-- 总条数 -->				
			    <div class="form-group">
					<div class="field">
						<input id="address" type="text" class="input" name="address" size="20"  placeholder="请输入地址查询" title="请输入地址查询" />
					</div>
					<div class="field">
						<input id="vipPhoneNumber" type="text" class="input" name="vipPhoneNumber" size="20"  placeholder="请输入会员手机号查询" title="请输入会员手机号查询" />
					</div>
				</div>
				<div class="form-button button-group">
					<button class="button border-main" type="button" onclick="findAddressInfo();">查询</button>
					<button class="button border-main" type="button" onclick="clearQueryCondition()">清空</button>
				</div>
			</form>
		</div>
	</div>
	<table id="addressTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="50px"  field="rowNum" >序号</th>
				<th width="150px" field="vipPhoneNumber" limitTxtLen="11">会员手机号</th>	
			    <th width="260px" field="address" limitTxtLen="25">地址</th>
			    <th width="200px"  field="longitude" limitTxtLen="10">经度</th>
			    <th width="200px"  field="latitude" limitTxtLen="10">玮度</th>	
			    <th width="200px"  field="collectTime" limitTxtLen="20">收藏时间</th>	
			    <th width="100px" format="flagAddress">地址类型</th>
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
		var url = 'hkdapp/addressInfo/findAddressList';
		initTableList(url,"addressTable", "findAddress_form");
	});
	
	function getCommendedName(data){
		if(data.sclIsrecommended){
			if(data.sclIsrecommended == 1){
				return "是";
			}else{
				return "否";
			}
		}
		
		return data.sclIsrecommended;
	}
	function flagAddress(data){
		var showHTML = "";
		if(data.flag == 1){
			return showHTML="收货地址";
		}else if(data.flag == 0){
			return showHTML="购买地址";
		}else if(data.flag == 2){
			return showHTML="发货地址";
		}else{
			return showHTML="取货地址";
		}
	}
	var datas = new Object();
	var layerOpenIndex;
	var iframeWin;
	function editHandler(data){
		return "";
	}
	
	//查询区域信息
	function findAddressInfo(){
		//设置当前页
		var page = $('#currentPage').val();
		$("[name='page']").val(page);
		var url = 'hkdapp/addressInfo/findAddressList';
		initTableList(url,"addressTable","findAddress_form");
	}
	//清空查询条件
	function clearQueryCondition(){
		$('#vipPhoneNumber').val("");
		$('#address').val("");
		findAddressInfo();
	}
	
	function ondblClickTrHandler(dom, id){
		openOrderInfoWin(2, id);
	}
	
	function addOrUpdateData(iframeWin, params){
	}
	
	function afterOpenWin(layero, index, params){
	}
	
	function uploadImageData(){
	}

	function openOrderInfoWin(type, id) {
	}
	function openImpSchoolWin(){
	}
</script>