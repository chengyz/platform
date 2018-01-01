<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
			return $('#addOrderForm').serialize();
		}
		function initData(data){
			$('#id').val(data.id);
			$('#addressUUID').val(data.addressUUID);
			$('#longitude').val(data.longitude);
			$('#latitude').val(data.latitude);
			$('#flag').val(data.flag);
		}
		function fileChange(dom){
			var path  = dom.value;
			var suffix =  path.substring(path.lastIndexOf(".")).toLowerCase();
			if(suffix ==".amr" || suffix ==".3gp" || suffix ==".wav" || suffix ==".aac" || suffix ==".amr"){
				isOk = true;
				if(callbackImageFunc != null){
					callbackImageFunc.call(this);
				}
			}else{
				isOk = false;
				layer.msg('只能上传.amr|.3gp|.wav|.aac|.amr格式的文件', {icon: 2});
			}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addOrderForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="addressUUID" name="addressUUID">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								地址：
							</td>
							<td width="35%">
								<input type="text" class="input" id="address" name="address" placeholder="请输入地址名称" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								经度：
							</td>
							<td width="35%">
								<input type="text" class="input" id="longitude" name="longitude" placeholder="请输入经度" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								玮度：
							</td>
							<td>
								<input type="text" class="input" id="latitude" name="latitude" placeholder="请输入玮度" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								收货地址/购买地址：
							</td>
							<td>
								<input type="text" class="input" id="flag" name="flag" placeholder="收货地址请填  1、购买地址请填  0" style="width:99%;"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
