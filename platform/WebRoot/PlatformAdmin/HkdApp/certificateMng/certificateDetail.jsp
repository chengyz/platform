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
    
    <title>实名认证详情</title>
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
			var status = $('#status').val();
			if(status == "1"){
				if($('#reason2').val() == ""){
					return null;
				}
			}
			return $('#addDataForm').serialize();
		}
		function initData(data){
			$('#id').val(data.id);
			$('#certUUID').val(data.certUUID);
			$('#trueName').val(data.trueName);
			$('#vipPhoneNumber').val(data.vipPhoneNumber);
			$('#vipUUID').val(data.vipUUID);
			$('#idNumber').val(data.idNumber);
			$('#phoneNumber').val(data.phoneNumber);
			$('#transport').val(data.transport);
			$('#emergencyContact').val(data.emergencyContact);
			$('#emergencyNumber').val(data.emergencyNumber);
			$('#updateTime').val(data.updateTime);
			$('#auditResult').val(data.auditResult);
			if(data.userName == null || data.userName == ""){
				var userName = "${sessionScope.userinfo.userName}";
				$('#userName').val(userName);
				var userUUID = "${sessionScope.userinfo.userUUID}";
				$('#userUUID').val(userUUID);
			}else{
				$('#userName').val(data.userName);
				$('#userUUID').val(data.userUUID);
			}
			$('#createTime').val(data.createTime);
			$('#faceCard').val(data.faceCard);
			$('#reverseCard').val(data.reverseCard);
			$('#handleCard').val(data.handleCard);
			$('#face').html('<img src='+'<%=basePath%>'+data.faceCard+' style="width:330px;height:210px;"></img>');
			$('#reverse').html('<img src='+'<%=basePath%>'+data.reverseCard+' style="width:330px;height:210px;"></img>');
			$('#handle').html('<img src='+'<%=basePath%>'+data.handleCard+' style="width:330px;height:210px;"></img>');
			if(data.status == 2){
				$('#auditOption').show();
				$('#reason1').hide();
				$('#reason2').show();
			}else{
				$('#auditOption').hide();
				$('#reason2').hide();
				$('#reason1').show();
				$('#reason1').val(data.reason);
			}
			if(data.transport == 1){
				$('#transports').val("私家小轿车");
			}
			if(data.transport == 2){
				$('#transports').val("摩托车");
			}
			if(data.transport == 3){
				$('#transports').val("单车");
			}
			if(data.transport == 4){
				$('#transports').val("其他");
			}
		}
		
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="vipUUID" name="vipUUID">
					<input type="hidden" id="userUUID" name="userUUID">
					<input type="hidden" id="certUUID" name="certUUID">
					<input type="hidden" id="status" name="status">
					<input type="hidden" id="transport" name="transport">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								会员手机号：
							</td>
							<td width="35%">
								<input type="text" class="input" id="vipPhoneNumber" name="vipPhoneNumber"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								真实姓名：
							</td>
							<td>
								<input type="text" class="input" id="trueName" name="trueName" style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								身份证号：
							</td>
							<td>
								<input type="text" class="input" id="idNumber" name="idNumber"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								手机号码：
							</td>
							<td width="35%">
								<input type="text" class="input" id="phoneNumber" name="phoneNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								紧急联系人：
							</td>
							<td width="35%">
								<input type="text" class="input" id="emergencyContact" name="emergencyContact"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								紧急联系人手机号：
							</td>
							<td>
								<input type="text" class="input" id="emergencyNumber" name="emergencyNumber"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								创建时间：
							</td>
							<td>
								<input type="text" class="input" id="createTime" name="createTime"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								修改时间：
							</td>
							<td>
								<input type="text" class="input" id="updateTime" name="updateTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								交通工具：
							</td>
							<td width="35%">
								<input type="text" class="input" id="transports" name="transports"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								审核人：
							</td>
							<td>
								<input type="text" class="input" id="userName" name="userName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%" style="vertical-align: middle;">
								<input type="hidden" id="handleCard" name="handleCard"/>
								手持身份证：
							</td>
							<td id="handle">
							</td>
							<td width="10%" style="vertical-align: middle;">
								<input type="hidden" id="faceCard" name="faceCard"/>
								身份证正面：
							</td>
							<td id="face">
							</td>
						</tr>
						<tr>
							<td width="10%" style="vertical-align: middle;">
								<input type="hidden" id="reverseCard" name="reverseCard"/>
								身份证反面：
							</td>
							<td id="reverse">
							</td>
							<td width="10%" style="vertical-align: middle;">
								审核意见：
							</td>
							<td >
								<p id="auditOption">
									<input id="pass" class="button border-blue button-little"  type="button" style="width:80px;height:35px;margin:10px 0 0 20px;" value="通过"/>
									<input id="passing" class="button border-blue button-little"  type="button" style="width:80px;height:35px;margin:10px 0 0 20px;" value="审核中"/>
									<input id="noPass" class="button border-yellow button-little" type="button" style="width:80px;height:35px;margin:10px 0 0 20px;" value="不通过"/>
								</p>
								<textarea rows="10" cols="20"  type="text" style="height: 200px; width:99%;margin-top:0px;" class="input" id="reason1" name="reasons" style="width:99%;"></textarea>
								<textarea rows="10" cols="20"  type="text" style="height: 150px; width:99%;margin-top:0px;" class="input" id="reason2" name="auditResult" style="width:99%;"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
	<script type="text/javascript">
	$('#noPass').click(function(){
		$('#status').val("1");
	});
	$('#pass').click(function(){
		$('#status').val("3");
	});
	$('#passing').click(function(){
		$('#status').val("2");
	});
	</script>
</html>
