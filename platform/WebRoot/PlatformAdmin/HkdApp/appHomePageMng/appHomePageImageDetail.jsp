<%@page import="com.util.ReadProperties"%>
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
    
    <title>好快当app首页图片显示详情</title>
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
	<script type="text/javascript">
		window.UEDITOR_HOME_URL="<%=basePath %>"+"static/js/ueditor/";
		var ueditor_home_url=window.UEDITOR_HOME_URL;//方便配置 图片和附件 上传的位置，以便传递参数
		var folder_url = '<%=ReadProperties.getValue("imgUploadPath")%>';//文件上传路径
	</script>
	<script>
		function getFromSerialize(){
			var imagePath = $('#imagePath').val();
			if(imagePath == ""){
				return null;
			}
			var flags = $('#flags').val();
			if(flags == "是"){
				$('#flag').val("1");
			}else if(flags == "否"){
				$('#flag').val("2");
			}
			var disables = $('#disables').val();
			if(disables == "是"){
				$('#disable').val("1");
			}else if(disables == "否"){
				$('#disable').val("2");
			}
			return $('#addDataForm').serialize();
		}
		function initData(data){
				$('#id').val(data.id);
				$('#pageUUID').val(data.pageUUID);
				$('#imageName').val(data.imageName);
				$('#link').val(data.link);
				$('#showStartTime').val(data.showStartTime);
				$('#showEndTime').val(data.showEndTime);
				$('#displayOrder').val(data.displayOrder);
				$('#remark').val(data.remark);
				$('#belongApp').val(data.belongApp);
				$('#imagePath').val(data.imagePath);
				if(data.flag == 1){
					$('#flags').val("是");
				}else if(data.flag == 2){
					$('#flags').val("否");
				}
				if(data.disable == 1){
					$('#disables').val("是");
				}else if(data.disable == 2){
					$('#disables').val("否");
				}
				if(data.imagePath){
					$("#imageShow").show();
					var a = '<%=path %>'+data.imagePath;
					$("#imageShow").attr("src", a);
				}
		}
		function fileChange(dom){
			var path  = dom.value;
			var suffix =  path.substring(path.lastIndexOf(".")).toLowerCase();
			if(suffix ==".png" || suffix ==".jpg" || suffix ==".jpeg" || suffix ==".gif" || suffix ==".bmp"){
				isOk = true;
				if(callbackImageFunc != null){
					callbackImageFunc.call(this);
				}
			}else{
				isOk = false;
				layer.msg('只能上传.png|.jpg|.jpeg|.gif|.bmp格式的文件', {icon: 2});
			}
	}
	</script>
  </head> 
  	<body>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="pageUUID" name="pageUUID">
					<input type="hidden" id="imagePath" name="imagePath">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr id="imgNames">
							<td width="10%">
								图片名称：
							</td>
							<td width="35%">
								<input type="text" class="input" id="imageName" name="imageName"  style="width:99%;" />
							</td>
						</tr>
						<tr id="imgNames">
							<td width="10%">
								跳转链接：
							</td>
							<td>
								<input type="text" class="input" id="link" name="link"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								是否为广告：
							</td>
							<td width="35%">
								<input type="hidden" id="flag" name="flag"/>
								<input type="text" class="input" id="flags" name="flags"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								是否已禁用：
							</td>
							<td>
								<input type="hidden" id="disable" name="disable"/>
								<input type="text" class="input" id="disables" name="disables"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								显示的开始时间：
							</td>
							<td>
								<input type="text" class="input" id="showStartTime" name="showStartTime"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								显示的结束时间：
							</td>
							<td>
								<input type="text" class="input" id="showEndTime" name="showEndTime"  style="width:99%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								显示顺序：
							</td>
							<td width="35%">
								<input type="text" class="input" id="displayOrder" name="displayOrder"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								所属App：
							</td>
							<td width="35%">
								<input type="text" class="input" id="belongApp" name="belongApp"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								备注：
							</td>
							<td>
								<input type="text" class="input" id="remark" name="remark"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="10%">
								图片展示：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);" >+ 浏览图片
						   				<input id="imaPath" name="imaPath" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="imageShow" src="" width="280px" height="90px">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
	<script src="static/js/jedate/jedate.js"></script>
	<script type="text/javascript">
	jeDate({
		dateCell:"#showEndTime",
		format:"YYYY-MM-DD  hh:mm:ss",
		isinitVal:false,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){}
	})
	jeDate({
		dateCell:"#showStartTime",
		format:"YYYY-MM-DD  hh:mm:ss",
		isinitVal:false,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){}
	})
	</script>
</html>
