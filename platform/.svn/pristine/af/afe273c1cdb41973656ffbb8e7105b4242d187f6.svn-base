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
    
    <title>消费记录详情</title>
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
			$('#UUID').val(data.UUID);
			$('#vipUUID').val(data.vipUUID);
			$('#vipName').val(data.vipName);
			$('#vipMobilePhone').val(data.vipMobilePhone);
			$('#tradeNo').val(data.tradeNo);
			$('#moduleUUID').val(data.moduleUUID);
			$('#moduleName').val(data.moduleName);
			$('#auditTime').val(data.auditTimeTime);
			$('#consumptionMoney').val(data.consumptionMoney);
			$('#consumptionTime').val(data.consumptionTime);
			$('#consumptionDetails').val(data.consumptionDetails);
		}
		
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="userUUID" name="userUUID">
					<input type="hidden" id="certUUID" name="certUUID">
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
								交易流水号：
							</td>
							<td>
								<input type="text" class="input" id="tradeNo" name="tradeNo"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								模块名称：
							</td>
							<td>
								<input type="text" class="input" id="moduleName" name="moduleName"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								消费金额：
							</td>
							<td>
								<input type="text" class="input" id="consumptionMoney" name="consumptionMoney"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								消费时间：
							</td>
							<td>
								<input type="text" class="input" id="consumptionTime" name="consumptionTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								消费详情：
							</td>
							<td>
								<input type="text" class="input" id="consumptionDetails" name="consumptionDetails"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
