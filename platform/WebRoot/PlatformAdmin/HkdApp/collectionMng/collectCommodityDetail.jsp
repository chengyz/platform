<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收藏商品详情</title>
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
			$('#collectTime').val(data.collectTime);
			$('#cmdtName').val(data.cmdtName);
			$('#cmdtPrice').val(data.cmdtPrice);
			$('#cmdtIntroduce').val(data.cmdtIntroduce);
			$('#cmdtCount').val(data.cmdtCount);
			if(data.cmdtHot == 2){
				$('#cmdtHot').val("非热卖商品");
			}else if(data.cmdtHot == 1){
				$('#cmdtHot').val("热卖商品");
			}
			if(data.cmdtState == 1){
				$('#cmdtState').val("上架");
			}else if(data.cmdtState == 0){
				$('#cmdtState').val("下架");
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
								商品名称：
							</td>
							<td width="35%">
								<input type="text" class="input" id="cmdtName" name="cmdtName"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商品价格：
							</td>
							<td>
								<input type="text" class="input" id="cmdtPrice" name="cmdtPrice"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商品状态：
							</td>
							<td>
								<input type="text" class="input" id="cmdtState" name="cmdtState"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								是否热卖商品：
							</td>
							<td width="35%">
								<input type="text" class="input" id="cmdtHot" name="cmdtHot"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商品介绍：
							</td>
							<td>
								<input type="text" class="input" id="cmdtIntroduce" name="cmdtIntroduce"  style="width:99%;" readonly/>
							</td>
							<td width="10%">
								商品数量：
							</td>
							<td>
								<input type="text" class="input" id="cmdtCount" name="cmdtCount"  style="width:99%;" readonly/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
