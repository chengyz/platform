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
    
    <title>提现记录详情</title>
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
			$('#cashUUID').val(data.cashUUID);
			$('#vipUUID').val(data.vipUUID);
			$('#vipName').val(data.vipName);
			$('#vipPhoneNumber').val(data.vipPhoneNumber);
			$('#vipBalance').val(data.vipBalance);
			$('#withdrawCashAmount').val(data.withdrawCashAmount);
			$('#canWithdrawCashAmount').val(data.canWithdrawCashAmount);
			$('#withdrawCashFee').val(data.withdrawCashFee);
			$('#withdrawCashAccount').val(data.withdrawCashAccount);
			$('#applyTime').val(data.applyTime);
			$('#withdrawCashTime').val(data.withdrawCashTime);
			if(data.status == 1){
				$('#status').val("审核中");
			}else if(data.status == 2){
				$('#status').val("提现失败");
			}else if(data.status == 3){
				$('#status').val("提现成功");
			}
		}
		
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="cashUUID" name="cashUUID">
					<input type="hidden" id="vipUUID" name="vipUUID">
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
								<input type="text" class="input" id="vipPhoneNumber" name="vipPhoneNumber" style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								余额：
							</td>
							<td>
								<input type="text" class="input" id="vipBalance" name="vipBalance"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								提现金额：
							</td>
							<td>
								<input type="text" class="input" id="withdrawCashAmount" name="withdrawCashAmount"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								可提现金额：
							</td>
							<td>
								<input type="text" class="input" id="canWithdrawCashAmount" name="canWithdrawCashAmount"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								提现手续费：
							</td>
							<td>
								<input type="text" class="input" id="withdrawCashFee" name="withdrawCashFee"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								提现账号：
							</td>
							<td>
								<input type="text" class="input" id="withdrawCashAccount" name="withdrawCashAccount"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								申请时间：
							</td>
							<td>
								<input type="text" class="input" id="applyTime" name="applyTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								修改时间：
							</td>
							<td>
								<input type="text" class="input" id="updateTime" name="updateTime"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								提现状态：
							</td>
							<td>
								<input type="text" class="input" id="status" name="status"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
