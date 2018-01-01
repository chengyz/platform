<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收藏商家详情</title>
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
			$('#vipPhoneNumber').val(data.vipPhoneNumber);
			$('#businessName').val(data.businessName);
			$('#businessFullName').val(data.businessFullName);
			$('#businessType').val(data.businessType);
			$('#businessTel').val(data.businessTel);
			$('#businessArea').val(data.businessArea);
			$('#businessAddr').val(data.businessAddr);
			$('#businessIntro').val(data.businessIntro);
			$('#businessCoordLongitude').val(data.businessCoordLongitude);
			$('#businessCoordLatitude').val(data.businessCoordLatitude);
			$('#businessMark').val(data.businessMark);
		    $('#collectTime').val(data.collectTime);
			if(data.businessHot == 2){
				$('#businessHot').val("非热卖商家");
			}else if(data.businessHot == 1){
				$('#businessHot').val("热卖商家");
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
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
						<td width="10%">
								会员手机号：
							</td>
							<td>
								<input type="text" class="input" id="vipPhoneNumber" name="vipPhoneNumber" style="width:99%;" readonly/>
							</td>
							<td width="10%">
								收藏时间：
							</td>
							<td width="35%">
								<input type="text" class="input" id="collectTime" name="collectTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家简称：
							</td>
							<td width="35%">
								<input type="text" class="input" id="businessName" name="businessName"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商家全称：
							</td>
							<td>
								<input type="text" class="input" id="businessFullName" name="businessFullName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家类型：
							</td>
							<td>
								<input type="text" class="input" id="businessType" name="businessType"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商家电话：
							</td>
							<td width="35%">
								<input type="text" class="input" id="businessTel" name="businessTel"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家所在区域：
							</td>
							<td>
								<input type="text" class="input" id="businessArea" name="businessArea"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商家地址：
							</td>
							<td>
								<input type="text" class="input" id="businessAddr" name="businessAddr"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家地址经度：
							</td>
							<td>
								<input type="text" class="input" id="businessCoordLongitude" name="businessCoordLongitude"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商家地址玮度：
							</td>
							<td width="35%">
								<input type="text" class="input" id="businessCoordLatitude" name="businessCoordLatitude"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家介绍：
							</td>
							<td>
								<input type="text" class="input" id="businessIntro" name="businessIntro"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商家备注：
							</td>
							<td>
								<input type="text" class="input" id="businessMark" name="businessMark"  style="width:99%;" readonly/>
							</td>
						</tr>
					    <tr>
							<td width="10%">
								是否为热卖商家：
							</td>
							<td>
								<input type="text" class="input" id="businessHot" name="businessHot"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
