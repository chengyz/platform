<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName=request.getSession().getAttribute("username")+"";
String user = request.getSession().getAttribute("userinfo")+"";
String userType = request.getSession().getAttribute("userType")+"";
String permissionStr = request.getSession().getAttribute("permissionStr")+"";

%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
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
			return $('#addDataForm').serialize();
		}
		function initData(data){
			$('#id').val(data.id);
			$('#timeUUID').val(data.timeUUID);
			$('#payTimeOut').val(data.payTimeOut);
			$('#payScanTime').val(data.payScanTime);
			$('#allUnconfirmedTime').val(data.allUnconfirmedTime);
			$('#vipUnconfirmedTime').val(data.vipUnconfirmedTime);
			$('#scanOrderTime').val(data.scanOrderTime);
			$('#createTime').val(data.createTime);
			$('#belongPlatform').val(data.belongPlatform);
			$('#payFirstScanTime').val(data.payFirstScanTime);
			$('#firstScanOrderTime').val(data.firstScanOrderTime);
			$('#noGetFirstScanTime').val(data.noGetFirstScanTime);
			$('#noGetScanTime').val(data.noGetScanTime);
			if(data.belongPlatform == 1){
				$('#belongPlatform1').val("好快当");
			}
			if(data.belongPlatform == 2){
				$('#belongPlatform1').val("高考大数据");
			}
			for(var i = 0;i<$('#belongPlatform1').children().length;i++){
				var v = $('#belongPlatform1').find('option').eq(i).val();
				if(v == data.belongPlatform){
					$('#belongPlatform1').find('option').eq(i).attr('selected','selected');	
				}
			}
		}
		function choose(){
			var belongPlatform=$("#belongPlatform1").find("option:selected").val();
			$('#belongPlatform').val(belongPlatform);
		}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="timeUUID" name="timeUUID">
					<input type="hidden" id="createTime" name="createTime">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="35%">
								支付在服务器启动时初次扫描时间/秒：
							</td>
							<td >
								<input type="text" class="input" id="payFirstScanTime" name="payFirstScanTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								支付超时时间/分钟：
							</td>
							<td >
								<input type="text" class="input" id="payTimeOut" name="payTimeOut"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								支付扫描间隔时间/秒：
							</td>
							<td>
								<input type="text" class="input" id="payScanTime" name="payScanTime" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								订单在服务器启动时初次扫描时间/秒：
							</td>
							<td>
								<input type="text" class="input" id="firstScanOrderTime" name="firstScanOrderTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								双方未确认订单的时间长度/天：
							</td>
							<td>
								<input type="text" class="input" id="allUnconfirmedTime" name="allUnconfirmedTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								跑客确认，派单者未确认的时间长度/天：
							</td>
							<td>
								<input type="text" class="input" id="vipUnconfirmedTime" name="vipUnconfirmedTime" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								未确认订单的扫描间隔时间/秒：
							</td>
							<td>
								<input type="text" class="input" id="scanOrderTime" name="scanOrderTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								未被抢订单首次扫描的时间/秒：
							</td>
							<td>
								<input type="text" class="input" id="noGetFirstScanTime" name="noGetFirstScanTime" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								未被抢订单的扫描间隔/秒：
							</td>
							<td>
								<input type="text" class="input" id="noGetScanTime" name="noGetScanTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="35%">
								所属平台：
							</td>
							<td>
								<input type="hidden" class="input" id="belongPlatform" name="belongPlatform"  style="width:99%;"/>
								<select id="belongPlatform1" style="width:99%;" class="input" type="text" onchange="choose()">
									<option value="">--选择所属平台--</option>
									<option value="1">好快当</option>
									<option value="2">高考大数据</option>
								</select>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
