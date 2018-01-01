<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>反馈信息详情</title>
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
			$('#uuid').val(data.uuid);
			$('#messageTitle').val(data.messageTitle);
			$('#messageContent').val(data.messageContent);
			$('#createTime').val(data.createTime);
			$('#belongApp').val(data.belongApp);
		}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addOrderForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="uuid" name="uuid">
					<input type="hidden" id="createTime" name="createTime">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								所属App：
							</td>
							<td>
								<input type="text" class="input" id="belongApp" name="belongApp" style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								消息标题：
							</td>
							<td>
								<input type="text" class="input" id="messageTitle" name="messageTitle"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								消息内容：
							</td>
							<td>
								<textarea rows="10" cols="20" type="text" style="height: 100px; width:95%;" class="input" id="messageContent" name="messageContent"  style="width:90%;"></textarea>
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
