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
	<script>
		function getFromSerialize(){
			return $('#addOrderForm').serialize();
		}
		function initData(data){
			$('#vipName').val(data.vipName);
			$('#vipMobile').val(data.vipMobile);
			$('#feedBackContent').val(data.feedBackContent);
			$('#createTime').val(data.createTime);
			if(data.status == 1){
				$('#status').val("已阅读");
			}else if(data.status == 2){
				$('#status').val("未阅读");
			}
			changeStatus(data.id);//改变查看状态
			if(data.img1){
				$("#img11").show();
				var a = '<%=path %>'+data.img1;
				$("#img11").attr("src", a);
			}
			if(data.img2){
				$("#img22").show();
				var a = '<%=path %>'+data.img2;
				$("#img22").attr("src", a);
			}
			if(data.img3){
				$("#img33").show();
				var a = '<%=path %>'+data.img3;
				$("#img33").attr("src", a);
			}
			if(data.img4){
				$("#img44").show();
				var a = '<%=path %>'+data.img4;
				$("#img44").attr("src", a);
			}
		}
		//改变查看状态
		function changeStatus(id){
			$.ajax({
				 url: 'hkdapp/feedBackInfo/changeStatus',
				 type: "POST",
				 cache:false,
				 data: {id:id},
				 success: function(data){
				 },
				 error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				 }, 
				 dataType: 'json'
				});
		}
		function showImage(type){
			var src = type.getAttribute("src");
			$("#businessImage").attr("src", src);
			$('#myDialog').hide();
			$('#showImages').show();
		}
		function closeImage(){
			$('#showImages').hide();
			$('#myDialog').show();
		}
	</script>
  </head> 
  	<body>
  		<div id="showImages" style="display:none;">
  			<img src="" id="businessImage" style="width:100%;height:100%; background-size: 100% 100%;" onclick="closeImage();">
  		</div>
		<div id="myDialog" >
			<div class="dialog-body margin-little">
				<form id="addOrderForm"  class="form-inline" style="width:100%;" method="post" enctype="multipart/form-data">
					<table class="table table-striped table-bordered table-condensed" width="100%">
						<tr>
							<td width="15%">
								会员姓名：
							</td>
							<td>
								<input type="text" class="input" id="vipName" name="vipName" style="width:99%;" readonly/>
							</td>
							<td width="15%">
								会员手机号：
							</td>
							<td>
								<input type="text" class="input" id="vipMobile" name="vipMobile"  style="width:99%;" readonly/>
							</td>
						</tr>
						<tr>
							<td width="15%">
								状态：
							</td>
							<td>
								<input type="text" class="input" id="status" name="status" style="width:99%;" readonly/>
							</td>
							<td width="15%">
								反馈时间：
							</td>
							<td>
								<input type="text" class="input" id="createTime" name="createTime" style="width:99%;" readonly/>
							</td>
						</tr>
						
						<tr>
							<td width="15%">
								反馈内容：
							</td>
							<td>
								<textarea rows="20" cols="20" type="text" style="height: 100px;width:250%;" class="input" id="feedBackContent" name="feedBackContent" ></textarea>
							</td>
						</tr>
						
						<tr>
							<td width="10%">
								Img1:
							</td>
							<td>
								<div>
									<img id="img11" src="" width="280px" height="90px" onclick="showImage(this);">
								</div>
							</td>
							<td width="10%">
								Img2：
							</td>
							<td>
								<div >
									<img id="img22" src="" width="280px" height="90px" onclick="showImage(this);">
								</div>
							</td>
						</tr>
						<tr>
							<td width="10%">
								Img3：
							</td>
							<td>
								<div>
									<img id="img33" src="" width="280px" height="90px" onclick="showImage(this);">
								</div>
							</td>
							<td width="10%">
								Img4：
							</td>
							<td>
								<div>
									<img id="img44" src="" width="280px" height="90px" onclick="showImage(this);">
								</div>
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
