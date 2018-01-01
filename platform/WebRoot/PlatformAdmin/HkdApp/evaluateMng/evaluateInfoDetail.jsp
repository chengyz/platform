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
    
    <title>评价详情</title>
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
			return $('#addDataForm').serialize();
		}
		function initData(data){
				$('#id').val(data.id);
				$('#evaluateUUID').val(data.evaluateUUID);
				$('#vipUUID').val(data.vipUUID);
				$('#getUUID').val(data.getUUID);
				$('#orderUUID').val(data.orderUUID);
				$('#content').val(data.content);
				$('#evaluateTime').val(data.evaluateTime);
				$('#starGrade').val(data.starGrade);
				$('#orderType').val(data.orderType);
				$('#evaluateName').val(data.evaluateName);
				for(var i = 0;i<$('#orderType1').children().length;i++){
					var v = $('#orderType1').find('option').eq(i).val();
					if(v == data.orderType){
						$('#orderType1').find('option').eq(i).attr('selected','selected');	
					}
				}
				if(data.img1){
					$('#img1').val(data.img1);
					$("#img11").show();
					var a = '<%=path %>'+data.img1;
					$("#img11").attr("src", a);
				}
				if(data.img2){
					$('#img2').val(data.img2);
					$("#img22").show();
					var a = '<%=path %>'+data.img2;
					$("#img22").attr("src", a);
				}
				if(data.img3){
					$('#img3').val(data.img3);
					$("#img33").show();
					var a = '<%=path %>'+data.img3;
					$("#img33").attr("src", a);
				}
				if(data.img4){
					$('#img4').val(data.img4);
					$("#img44").show();
					var a = '<%=path %>'+data.img4;
					$("#img44").attr("src", a);
				}
		}
		function chooseOrderType(){
			var orderType=$("#orderType1").find("option:selected").val();
			$('#orderType').val(orderType);
		}
		function fileChange(dom){
			var path  = dom.value;
			var suffix =  path.substring(path.lastIndexOf(".")).toLowerCase();
			if(suffix ==".png" || suffix ==".jpg" || suffix ==".jpeg" || suffix ==".gif" || suffix ==".bmp"){
				isOk = true;
				if(callbackImageFunc != null){
					callbackImageFunc.call(this, dom.name);
				}
				dom.outerHTML=dom.outerHTML;
				dom.value = "";
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
					<input type="hidden" id="getUUID" name="getUUID">
					<input type="hidden" id="vipUUID" name="vipUUID">
					<input type="hidden" id="orderUUID" name="orderUUID">
					<input type="hidden" id="evaluateUUID" name="evaluateUUID">
					<input type="hidden" id="img1" name="img1">
					<input type="hidden" id="img2" name="img2">
					<input type="hidden" id="img3" name="img3">
					<input type="hidden" id="img4" name="img4">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr id="imgNames">
							<td width="15%">
								订单类型：
							</td>
							<td>
							<div class="field">
					   	 		<input id="orderType" name="orderType" value="" type="hidden">
								<select id="orderType1" class="input" type="text" onchange="chooseOrderType()">
									<option value="">--选择订单类型--</option>
									<option value="1">帮我买</option>
									<option value="2">帮我送</option>
									<option value="3">帮我取</option>
								</select>
							</div>
							</td>
							<td width="15%">
								评价时间：
							</td>
							<td>
								<input type="text" class="input" id="evaluateTime" name="evaluateTime"  style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="15%">
								评价者名称：
							</td>
							<td>
								<input type="text" class="input" id="evaluateName" name="evaluateName"  style="width:99%;" />
							</td>
							<td width="15%">
								评价的星级：
							</td>
							<td>
								<input type="text" class="input" id="starGrade" name="starGrade" placeholder="请输入评价的星级：1、2、3、4、5" style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="15%">
								评价内容：
							</td>
							<td>
								<textarea rows="20" cols="20" type="text" style="height: 100px; width:250%;" class="input" id="content" name="content" placeholder="请输入评论内容" style="width:99%;"></textarea>
							</td>
						</tr>
						<tr>
							<td width="10%">
								Img1：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);">+ 浏览图片
						   				<input id="image1" name="1" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="img11" src="" width="280px" height="90px">
								</div>
							</td>
							<td width="10%">
								Img2：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);">+ 浏览图片
						   				<input id="image2" name="2" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="img22" src="" width="280px" height="90px">
								</div>
							</td>
						</tr>
						<tr>
							<td width="10%">
								Img3：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);">+ 浏览图片
						   				<input id="image3" name="3" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="img33" src="" width="280px" height="90px">
								</div>
							</td>
							<td width="10%">
								Img4：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);">+ 浏览图片
						   				<input id="image4" name="4" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="img44" src="" width="280px" height="90px">
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
		dateCell:"#evaluateTime",
		format:"YYYY-MM-DD  hh:mm:ss",
		isinitVal:false,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){}
	})
	</script>
</html>
