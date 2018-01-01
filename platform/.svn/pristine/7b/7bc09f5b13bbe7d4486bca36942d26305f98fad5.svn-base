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
    
    <title>收入记录详情</title>
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
		function initData(data){
			$('#id').val(data.id);
			$('#recordUUID').val(data.recordUUID);
			$('#vipUUID').val(data.vipUUID);
			$('#vipName').val(data.vipName);
			$('#vipMobilePhone').val(data.vipMobilePhone);
			$('#earnMoney').val(data.earnMoney);
			$('#earnTime').val(data.earnTime);
			$('#orderUUID').val(data.orderUUID);
			$('#earnDetails').val(data.earnDetails);
		}
		
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="recordUUID" name="recordUUID">
					<input type="hidden" id="vipUUID" name="vipUUID">
					<input type="hidden" id="orderUUID" name="orderUUID">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								会员名称：
							</td>
							<td width="35%">
								<input type="text" class="input" id="vipName" name="vipName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								会员手机号：
							</td>
							<td>
								<input type="text" class="input" id="vipMobilePhone" name="vipMobilePhone" style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								所得金额：
							</td>
							<td>
								<input type="text" class="input" id="earnMoney" name="earnMoney"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收入的时间：
							</td>
							<td>
								<input type="text" class="input" id="earnTime" name="earnTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收入详情：
							</td>
							<td>
								<input type="text" class="input" id="earnDetails" name="earnDetails"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
