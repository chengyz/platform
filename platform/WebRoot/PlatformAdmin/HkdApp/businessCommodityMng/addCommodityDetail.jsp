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
    
    <title>添加或修改商品</title>
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
	$(function(){
		//获取传递过来的参数
		var urlinfo=window.location.href; //获取当前页面的url
		var len=urlinfo.length;//获取url的长度
		var offset=urlinfo.indexOf("?");//设置参数字符串开始的位置
		var newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
		var newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割
		var newsid=newsids[1];//得到参数值
		if(newsid != null){
			$('#businessUUID').val(newsid);
		}
	});
		
		function getFromSerialize(){
			return $('#addDataForm').serialize();
		}
		function initData(data){
				$('#id').val(data.id);
				$('#cmdtUUID').val(data.cmdtUUID);
				$('#cmdtName').val(data.cmdtName);
				$('#businessUUID').val(data.businessUUID);
				$('#cmdtPrice').val(data.cmdtPrice);
				$('#cmdtCount').val(data.cmdtCount);
				$('#cmdtHot').val(data.cmdtHot);
				$('#cmdtState').val(data.cmdtState);
				$('#cmdtIntroduce').val(data.cmdtIntroduce);
				
				if(data.cmdtImg1){
					$('#cmdtImg1').val(data.cmdtImg1);
					$("#img11").show();
					var a = '<%=path %>'+data.cmdtImg1;
					$("#img11").attr("src", a);
				}
				if(data.cmdtImg2){
					$('#cmdtImg2').val(data.cmdtImg2);
					$("#img22").show();
					var a = '<%=path %>'+data.cmdtImg2;
					$("#img22").attr("src", a);
				}
				if(data.cmdtImg3){
					$('#cmdtImg3').val(data.cmdtImg3);
					$("#img33").show();
					var a = '<%=path %>'+data.cmdtImg3;
					$("#img33").attr("src", a);
				}
				if(data.cmdtImg4){
					$('#cmdtImg4').val(data.cmdtImg4);
					$("#img44").show();
					var a = '<%=path %>'+data.cmdtImg4;
					$("#img44").attr("src", a);
				}
				if(data.cmdtImg5){
					$('#cmdtImg5').val(data.cmdtImg5);
					$("#img55").show();
					var a = '<%=path %>'+data.cmdtImg5;
					$("#img55").attr("src", a);
				}
				for(var i = 0;i<$('#status1').children().length;i++){
					var v = $('#status1').find('option').eq(i).val();
					if(v == data.cmdtState){
						$('#status1').find('option').eq(i).attr('selected','selected');	
					}
				}
				for(var i = 0;i<$('#hot1').children().length;i++){
					var v = $('#hot1').find('option').eq(i).val();
					if(v == data.cmdtHot){
						$('#hot1').find('option').eq(i).attr('selected','selected');	
					}
				}
		}
		function chooseStatus(){
			var status=$("#status1").find("option:selected").val();
			$('#cmdtState').val(status);
		}
		function chooseHot(){
			var hot=$("#hot1").find("option:selected").val();
			$('#cmdtHot').val(hot);
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
					<input type="hidden" id="cmdtUUID" name="cmdtUUID">
					<input type="hidden" id="businessUUID" name="businessUUID">
					<input type="hidden" id="cmdtImg1" name="cmdtImg1">
					<input type="hidden" id="cmdtImg2" name="cmdtImg2">
					<input type="hidden" id="cmdtImg3" name="cmdtImg3">
					<input type="hidden" id="cmdtImg4" name="cmdtImg4">
					<input type="hidden" id="cmdtImg5" name="cmdtImg5">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="15%">
								商品名称：
							</td>
							<td>
								<input type="text" class="input" id="cmdtName" name="cmdtName" placeholder="请输入商品名称" style="width:99%;" />
							</td>
							<td width="15%">
								商品价格：
							</td>
							<td>
								<input type="text" class="input" id="cmdtPrice" name="cmdtPrice" placeholder="请输入商品价格" style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="15%">
								商品状态：
							</td>
							<td>
							<div class="field">
					   	 		<input id="cmdtState" name="cmdtState" value="" type="hidden">
								<select id="status1" style="width:99%;" class="input" type="text" onchange="chooseStatus()">
									<option value="">--选择商品状态--</option>
									<option value="1">上架</option>
									<option value="2">下架</option>
								</select>
							</div>
							</td>
							<td width="15%">
								商品数量：
							</td>
							<td>
								<input type="text" class="input" id="cmdtCount" name="cmdtCount" placeholder="请输入商品的数量" style="width:99%;" />
							</td>
						</tr>
						<tr>
							<td width="15%">
								是否热卖：
							</td>
							<td>
								<div class="field">
					   	 		<input id="cmdtHot" name="cmdtHot" value="" type="hidden">
								<select id="hot1" style="width:99%;" class="input" type="text" onchange="chooseHot()">
									<option value="">--选择是否热卖--</option>
									<option value="1">是</option>
									<option value="2">否</option>
								</select>
							</div>
							</td>
							<td width="15%">
								商品介绍：
							</td>
							<td>
								<input type="text" class="input" id="cmdtIntroduce" name="cmdtIntroduce" placeholder="请输入商品介绍" style="width:99%;" />
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
						<tr>
							<td width="10%">
								Img5：
							</td>
							<td>
								<div style="display:inline">
							   		<a class="button input-file" href="javascript:void(0);">+ 浏览图片
						   				<input id="image5" name="5" onchange="fileChange(this);" type="file"/>
						   			</a>
								</div>
								<div  style="display:inline">
									<img id="img55" src="" width="280px" height="90px">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>	
	</body>
	<script src="static/js/jedate/jedate.js"></script>
</html>
