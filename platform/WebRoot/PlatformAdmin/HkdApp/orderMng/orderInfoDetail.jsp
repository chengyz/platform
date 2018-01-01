<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单详情</title>
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
			$('#buyOption').val(data.buyOption);
			$('#beginAddress').val(data.beginAddress);
			$('#sendAddress').val(data.sendAddress);
			$('#phoneNumber').val(data.phoneNumber);
			$('#endTime').val(data.endTime);
			$('#productPrice').val(data.productPrice);
			$('#createTime').val(data.createTime);
			$('#updateTime').val(data.updateTime);
			$('#audioFile').val(data.audioFile);
			if(data.audioFile != null && data.audioFile != "") {
				$('#audioFile').show();
				$('#audioFiles').hide();
				$('#audioFile').attr("href",'<%=path %>'+data.audioFile);
			}else{
				$('#audioFile').hide();
				$('#audioFiles').show();
			}
		    $('#payMode').val(data.payMode);
		    $('#payTime').val(data.payTime);
		    $('#outsidePayNo').val(data.outsidePayNo);
		    $('#outsideOrderNo').val(data.outsideOrderNo);
			$('#sendLongitude').val(data.sendLongitude);
			$('#beginLongitude').val(data.beginLongitude);
			$('#sendLatitude').val(data.sendLatitude);
			$('#beginLatitude').val(data.beginLatitude);
			$('#orderPrice').val(data.orderPrice);
			$('#vipPhoneNumber').val(data.vipPhoneNumber);
			$('#beginPhoneNumber').val(data.beginPhoneNumber);
			$('#beginHouseNumber').val(data.beginHouseNumber);
			$('#sendHouseNumber').val(data.sendHouseNumber);
			if(data.orderType == 1){
				$('#orderType').val("帮我买");
			}else if(data.orderType == 2){
				$('#orderType').val("帮我送");
			}else if(data.orderType == 3){
				$('#orderType').val("帮我取");
			}
			if(data.status == 2){
				$('#status').val("已失效");
			}else if(data.status == 1){
				$('#status').val("待支付");
			}else if(data.status == 3){
				$('#status').val("待接单");
			}else if(data.status == 4){
				$('#status').val("配送中");
			}else if(data.status == 5){
				$('#status').val("接单人确认");
			}else if(data.status == 6){
				$('#status').val("订单完成");
			}else if(data.status == 7){
				$('#status').val("已评价");
			}
			findVipInfo(data.vipUUID);
			findGetVipInfo(data.orderUUID);
		}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addOrderForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="vipUUID" name="vipUUID">
					<input type="hidden" id="getUUID" name="getUUID">
					<input type="hidden" id="orderUUID" name="orderUUID">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								订单编号：
							</td>
							<td>
								<input type="text" class="input" id="orderNumber" name="orderNumber" style="width:99%;" readonly/>
							</td>
							<td width="10%">
								购买项：
							</td>
							<td width="35%">
								<input type="text" class="input" id="buyOption" name="buyOption"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								派单者手机号：
							</td>
							<td>
								<input type="text" class="input" id="vipPhoneNumber" name="vipPhoneNumber" style="width:99%;" readonly/>
							</td>
							<td width="10%">
								派单者姓名：
							</td>
							<td width="35%">
								<input type="text" class="input" id="vipName" name="vipName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收货地址：
							</td>
							<td width="35%">
								<input type="text" class="input" id="sendAddress" name="sendAddress"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								联系电话：
							</td>
							<td>
								<input type="text" class="input" id="phoneNumber" name="phoneNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收货地址经度：
							</td>
							<td>
								<input type="text" class="input" id="sendLongitude" name="sendLongitude"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								收货地址玮度：
							</td>
							<td>
								<input type="text" class="input" id="sendLatitude" name="sendLatitude"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								送达时间：
							</td>
							<td>
								<input type="text" class="input" id="endTime" name="endTime"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								创建时间：
							</td>
							<td width="35%">
								<input type="text" class="input" id="createTime" name="createTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								出发地址：
							</td>
							<td>
								<input type="text" class="input" id="beginAddress" name="beginAddress"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								联系电话：
							</td>
							<td>
								<input type="text" class="input" id="beginPhoneNumber" name="beginPhoneNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								出发地址经度：
							</td>
							<td>
								<input type="text" class="input" id="beginLongitude" name="beginLongitude"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								出发地址玮度：
							</td>
							<td width="35%">
								<input type="text" class="input" id="beginLatitude" name="beginLatitude"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								订单价格：
							</td>
							<td>
								<input type="text" class="input" id="orderPrice" name="orderPrice"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								订单状态：
							</td>
							<td>
								<input type="text" class="input" id="status" name="status"  style="width:99%;" readonly/>
							</td>
						</tr>
					    <tr>
							<td width="10%">
								订单类型：
							</td>
							<td>
								<input type="text" class="input" id="orderType" name="orderType"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								音频文件：
							</td>
							<td>
								<a href="" class="input" id="audioFile" style="width:99%;" readonly>点击下载收听</a>
								<input class="input" id="audioFiles" style="width:99%;" readonly/>
							</td>
							
						</tr>
						<tr>
							<td width="10%">
								支付方式：
							</td>
							<td>
								<input type="text" class="input" id="payMode" name="payMode"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								支付时间：
							</td>
							<td>
								<input type="text" class="input" id="payTime" name="payTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								外部支付编号：
							</td>
							<td>
								<input type="text" class="input" id="outsidePayNo" name="outsidePayNo"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								外部订单号：
							</td>
							<td>
								<input type="text" class="input" id="outsideOrderNo" name="outsideOrderNo"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								接单者姓名：
							</td>
							<td>
								<input type="text" class="input" id="getName" name="getName"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								接单者手机号：
							</td>
							<td>
								<input type="text" class="input" id="loginName" name="loginName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								更新时间：
							</td>
							<td>
								<input type="text" class="input" id="updateTime" name="updateTime"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								出发地门牌号：
							</td>
							<td>
								<input type="text" class="input" id="beginHouseNumber" name="beginHouseNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收货地址门牌号：
							</td>
							<td>
								<input type="text" class="input" id="sendHouseNumber" name="sendHouseNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<script type="text/javascript">
		//查找派单者信息
		function findVipInfo(vipUUID){
			$.ajax({
				 url: 'system/vip/findVipByUUID',
				 type: "POST",
				 cache: false,
				 data: {"vipUUID":vipUUID},
				 success: function(data){
					 $('#vipName').val(data.vipName);
				 },
				 error : function() {  
				 }, 
				 dataType: 'json'
			});
		}
		//查找抢单者信息
		function findGetVipInfo(orderUUID){
			$.ajax({
				 url: 'system/vip/findVipByOrderUUID',
				 type: "POST",
				 cache: false,
				 data: {"orderUUID":orderUUID},
				 success: function(data){
					 $('#getName').val(data.vipName);
					 $('#loginName').val(data.loginName);
				 },
				 error : function() {  
				 }, 
				 dataType: 'json'
			});
		}
		</script>	
	</body>
</html>
