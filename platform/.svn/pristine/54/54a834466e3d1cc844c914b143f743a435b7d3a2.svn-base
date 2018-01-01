<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>异常订单处理详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		
	<link rel="stylesheet" href="static/css/pintuer.css">
	<link rel="stylesheet" href="static/css/admin.css">
	
	<link type="image/x-icon" href="static/images/logo.png" rel="shortcut icon" />
	<link href="static/images/favicon.ico" rel="bookmark icon" />

	<script src="static/js/jquery.js"></script>
	<script src="static/js/pintuer.js"></script>
	<script src="static/js/respond.js"></script>
	<script src="static/js/admin.js"></script>
	<script src="static/js/layer.js"></script>
	<script >
		
	</script>
	<script src="static/js/ueditor/editor_config.js"></script>
	<script src="static/js/ueditor/editor_all.js"></script>
	
	<script>
		function getFromSerialize(){
			return $('#addOrderForm').serialize();
		}
		function initData(data){
			$('#id').val(data.id);
			$('#orderNumber').val(data.orderNumber);
			$('#vipUUID').val(data.vipUUID);
			$('#orderUUID').val(data.orderUUID);
			$('#uuid').val(data.uuid);
			$('#applicant').val(data.applicant);
			$('#vipName').val(data.vipName);
			$('#vipMobile').val(data.vipMobile);
			$('#getVipUUID').val(data.getVipUUID);
			$('#getVipName').val(data.getVipName);
			$('#getVipModile').val(data.getVipModile);
			$('#applayReason').val(data.applayReason);
			$('#handleUserUUID').val(data.handleUserUUID);
		    $('#handleUserName').val(data.handleUserName);
		    $('#applayTime').val(data.applayTime);
		    $('#handleTime').val(data.handleTime);
			if(data.orderType == 1){
				$('#orderType').val("帮我买");
			}else if(data.orderType == 2){
				$('#orderType').val("帮我送");
			}else if(data.orderType == 3){
				$('#orderType').val("帮我取");
			}
			if(data.handleStatus == 2){
				$('#handleStatus').val("已处理");
			}else if(data.status == 1){
				$('#handleStatus').val("待处理");
			}
		}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addOrderForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="vipUUID" name="vipUUID">
					<input type="hidden" id="orderUUID" name="orderUUID">
					<input type="hidden" id="uuid" name="uuid">
					<input type="hidden" id="getVipUUID" name="getVipUUID">
					<input type="hidden" id="handleUserUUID" name="handleUserUUID">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								订单编号：
							</td>
							<td>
								<input type="text" class="input" id="orderNumber" name="orderNumber" style="width:99%;" readonly/>
							</td>
							<td width="10%">
								申请方：
							</td>
							<td width="35%">
								<input type="text" class="input" id="applicant" name="applicant"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								会员姓名：
							</td>
							<td>
								<input type="text" class="input" id="vipName" name="vipName" style="width:99%;" readonly/>
							</td>
							<td width="10%">
								会员手机号：
							</td>
							<td width="35%">
								<input type="text" class="input" id="vipMobile" name="vipMobile"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								跑客名称：
							</td>
							<td width="35%">
								<input type="text" class="input" id="getVipName" name="getVipName"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								跑客手机号：
							</td>
							<td>
								<input type="text" class="input" id="getVipModile" name="getVipModile"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								处理状态：
							</td>
							<td>
								<input type="text" class="input" id="handleStatus" name="handleStatus"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								申请时间：
							</td>
							<td width="35%">
								<input type="text" class="input" id="applayTime" name="applayTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								处理人：
							</td>
							<td>
								<input type="text" class="input" id="handleUserName" name="handleUserName"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								处理时间：
							</td>
							<td>
								<input type="text" class="input" id="handleTime" name="handleTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						
						<tr>
							<td width="10%">
								申请理由：
							</td>
							<td>
								<textarea rows="10" cols="20" type="text" style="height: 100px; width:95%;" class="input" id="applayReason" name="applayReason"  style="width:90%;"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			
		</script>	
	</body>
</html>
