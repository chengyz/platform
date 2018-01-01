<%@page import="com.util.ReadProperties"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学习数据</title>
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
		window.UEDITOR_HOME_URL="<%=basePath %>"+"static/js/ueditor/";
		var ueditor_home_url=window.UEDITOR_HOME_URL;//方便配置 图片和附件 上传的位置，以便传递参数
		var folder_url = '<%=ReadProperties.getValue("imgUploadPath")%>';//文件上传路径
	</script>
	<script src="static/js/ueditor/editor_config.js"></script>
	<script src="static/js/ueditor/editor_all.js"></script>
	
	<script>
		function getFromSerialize(){
			return $('#addDataForm').serialize();
		}
		function initData(data){
			$('#id').val(data.id);
			$('#businessUUID').val(data.businessUUID);
			$('#unitUUID').val(data.unitUUID);
			$('#businessName').val(data.businessName);
			$('#businessFullName').val(data.businessFullName);
			$('#businessType').val(data.businessType);
			$('#businessTel').val(data.businessTel);
			$('#businessArea').val(data.businessArea);
			
			$('#businessAddr').val(data.businessAddr);
			$('#businessIntro').val(data.businessIntro);
			$('#businessCoordLongitude').val(data.businessCoordLongitude);
			$('#businessCoordLatitude').val(data.businessCoordLatitude);
			$('#businessTime').val(data.businessTime);
			$('#businessHot').val(data.businessHot);
			if(data.businessImg1){
				$('#businessImg1').val(data.businessImg1);
				$("#img11").show();
				var a = '<%=path %>'+data.businessImg1;
				$("#img11").attr("src", a);
			}
			if(data.businessImg2){
				$('#businessImg2').val(data.businessImg2);
				$("#img22").show();
				var a = '<%=path %>'+data.businessImg2;
				$("#img22").attr("src", a);
			}
			if(data.businessImg3){
				$('#businessImg3').val(data.businessImg3);
				$("#img33").show();
				var a = '<%=path %>'+data.businessImg3;
				$("#img33").attr("src", a);
			}
			if(data.businessImg4){
				$('#businessImg4').val(data.businessImg4);
				$("#img44").show();
				var a = '<%=path %>'+data.businessImg4;
				$("#img44").attr("src", a);
			}
			for(var i = 0;i<$('#businessHot1').children().length;i++){
				var v = $('#businessHot1').find('option').eq(i).val();
				if(v == data.businessHot){
					$('#businessHot1').find('option').eq(i).attr('selected','selected');	
				}
			}
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
		function showImage(type){
			var src = type.getAttribute("src");
			$("#businessImage").attr("src", src);
			$('#myDialog').hide();
			$('#showImages').show();
		}
		function deleteImage(type){
			if(type == 1){
				$('#businessImg1').val("");
				var src = "";
				$("#img11").attr("src", src);
			}
			if(type == 2){
				$('#businessImg2').val("");
				var src = "";
				$("#img22").attr("src", src);
			}
			if(type == 3){
				$('#businessImg3').val("");
				var src = "";
				$("#img33").attr("src", src);
			}
			if(type == 4){
				$('#businessImg4').val("");
				var src = "";
				$("#img44").attr("src", src);
			}
		}
		function closeImage(){
			$('#showImages').hide();
			$('#myDialog').show();
		}
		function choose(){
			var businessHot=$("#businessHot1").find("option:selected").val();
			if(businessHot == "是"){
				$('#businessHot').val(1);
			}
			if(businessHot == "否"){
				$('#businessHot').val(2);
			}
		}
	</script>
  </head> 
  	<body>
  		<div id="showImages" style="display:none;">
  			<img src="" id="businessImage" style="width:100%;height:100%; background-size: 100% 100%;" onclick="closeImage();">
  		</div>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addDataForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data" >
					<input type="hidden" id="id" name="id">
					<input type="hidden" id="businessUUID" name="businessUUID">
					<input type="hidden" id="businessHot" name="businessHot">
					<input type="hidden" id="businessImg1" name="businessImg1">
					<input type="hidden" id="businessImg2" name="businessImg2">
					<input type="hidden" id="businessImg3" name="businessImg3">
					<input type="hidden" id="businessImg4" name="businessImg4">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="10%">
								商家简称：
							</td>
							<td>
								<input type="text" class="input" id="businessName" name="businessName" placeholder="请输入商家简称" style="width:95%;"/>
							</td>
							<td width="10%">
								商家全称：
							</td>
							<td>
								<input type="text" class="input" id="businessFullName" name="businessFullName" placeholder="请输入商家全称" style="width:95%;"/>
							</td>
						</tr>
						<tr>
							
							<td width="10%">
								商家类型：
							</td>
							<td>
								<input style="width:95%;" class="input" id="businessType" name="businessType" placeholder="请输入商家类型"></input>
							</td>
							<td width="10%">
								商家电话：
							</td>
							<td>
								<input type="text" class="input" id="businessTel" name="businessTel" placeholder="请输入商家电话" style="width:95%;"/>
							</td>
						</tr>
						
						<tr>
							<td width="10%">
								商家所在区域：
							</td>
							<td>
								<input style="width:95%;" class="input" id="businessArea" name="businessArea" placeholder="请输入商家所在区域"></input>
							</td>
							<td width="10%">
								商家详细地址：
							</td>
							<td>
								<input type="text" class="input" id="businessAddr" name="businessAddr" placeholder="请输入商家详细地址" style="width:95%;"/>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家坐标经度：
							</td>
							<td>
								<input style="width:95%;" class="input" id="businessCoordLongitude" name="businessCoordLongitude" placeholder="请输入商家坐标经度"></input>
							</td>
							<td width="10%">
								商家坐标纬度：
							</td>
							<td>
								<input type="text" class="input" id="businessCoordLatitude" name="businessCoordLatitude" placeholder="请输入商家坐标玮度" style="width:95%;"/>
							</td>
						</tr>
						<tr>
							
							<td width="10%">
								商家添加时间：
							</td>
							<td>
								<input style="width:95%;" class="input" id="businessTime" name="businessTime" placeholder="请输入商家添加时间"></input>
							</td>
							<td width="10%">
								是否是热卖商家：
							</td>
							<td>
								<select id="businessHot1" style="width:95%;" class="input" type="text" onchange="choose()">
									<option value="">--选择是否是热卖商家--</option>
									<option value="1">是</option>
									<option value="2">否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="10%">
								商家备注：
							</td>
							<td>
								<input style="width:95%;" class="input" id="businessMark" name="businessMark" placeholder="请输入商家备注"></input>
							</td>
							<td width="10%">
								所属单位：
							</td>
							<td>
								<input style="width:95%;" class="input" id="unitUUID" name="unitUUID" placeholder="请输入商家所属单位"></input>
							</td>
						</tr>
						<tr>
							<td>
								商家介绍：
							</td>
							<td colspan="4">
								<textarea style="width:98%;" class="input" id="businessIntro" name="businessIntro" placeholder="请输入商家介绍"></textarea>
							</td>
						</tr>
						<tr>
							<td width="10%">
								Img1：
							</td>
							<td>
								<div style="display:inline">
									<a style="margin:10px 5px 60px 5px;" class="button input-file border-blue" href="javascript:void(0);">+ 浏览图片
						   				<input id="image1" name="1" onchange="fileChange(this);" type="file"/>
						   			</a>
									<a style="margin:30px 0px 0px -110px;" class="button input-file border-yellow" href="javascript:deleteImage(1);" >删除图片</a>
								</div>
								<div  style="display:inline">
									<img id="img11" src="" width="280px" height="90px" style="margin-left:15px;" onclick="showImage(this);">
								</div>
							</td>
							<td width="10%">
								Img2：
							</td>
							<td>
								<div style="display:inline">
							   		<a style="margin:10px 5px 60px 5px;" class="button input-file border-blue" href="javascript:void(0);">+ 浏览图片
						   				<input id="image2" name="2" onchange="fileChange(this);" type="file"/>
						   			</a>
						   			<a style="margin:30px 0px 0px -110px;" class="button input-file border-yellow" href="javascript:deleteImage(2);" >删除图片</a>
								</div>
								<div  style="display:inline">
									<img id="img22" src="" width="280px" height="90px" style="margin-left:15px;" onclick="showImage(this);">
								</div>
							</td>
						</tr>
						<tr>
							<td width="10%">
								Img3：
							</td>
							<td>
								<div style="display:inline">
							   		<a style="margin:10px 5px 60px 5px;" class="button input-file border-blue" href="javascript:void(0);">+ 浏览图片
						   				<input id="image3" name="3" onchange="fileChange(this);" type="file"/>
						   			</a>
						   			<a style="margin:30px 0px 0px -110px;" class="button input-file border-yellow" href="javascript:deleteImage(3);" >删除图片</a>
								</div>
								<div  style="display:inline">
									<img id="img33" src="" width="280px" height="90px" style="margin-left:15px;" onclick="showImage(this);">
								</div>
							</td>
							<td width="10%">
								Img4：
							</td>
							<td>
								<div style="display:inline">
							   		<a style="margin:10px 5px 60px 5px;" class="button input-file border-blue" href="javascript:void(0);">+ 浏览图片
						   				<input id="image4" name="4" onchange="fileChange(this);" type="file"/>
						   			</a>
						   			<a style="margin:30px 0px 0px -110px;" class="button input-file border-yellow" href="javascript:deleteImage(4);" >删除图片</a>
								</div>
								<div  style="display:inline">
									<img id="img44" src="" width="280px" height="90px" style="margin-left:15px;" onclick="showImage(this);">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
</html>
