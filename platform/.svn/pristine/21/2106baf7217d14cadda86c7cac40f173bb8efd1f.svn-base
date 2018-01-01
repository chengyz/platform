<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加单位</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/fixedPintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
<script src="static/js/respond.js"></script>
<script src="static/js/admin.js"></script>
<script src="static/js/layer.js"></script>
</head>

<body>
	<div id="container" style="margin:0 auto">
		<div class="line-big" style="margin-left:30px">
			<form id="tradeEditForm" method="post" style="width:94%;" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id">
				<input type="hidden" id="typeUUID" name="typeUUID">
				<input type="hidden" id="typeCode" name="typeCode">
				<input type="hidden" id="typeParentCode" name="typeParentCode">
				<input type="hidden" id="typeParentName" name="typeParentName">
				<input type="hidden" id="typeUrl" name="typeUrl">
				<input type="hidden" id="typeType" name="typeType">
				<input type="hidden" id="isShow" name="isShow">
				<input type="hidden" id="typeHaveLowerNode" name="typeHaveLowerNode">
				<input type="hidden" id="typeCreateTime" name="typeCreateTime">
				<input type="hidden" id="typeCreateUserUUID" name="typeCreateUserUUID">
				<input type="hidden" id="typeCreateUserName" name="typeCreateUserName">
				<input type="hidden" id="typeUpTime" name="typeUpTime">
				<input type="hidden" id="typeUpUserUUID" name="typeUpUserUUID">
				<input type="hidden" id="typeUpUserName" name="typeUpUserName">
				<div id="tradeFormContent" class="xl12 xm12 padding-big radius-big">
					<div class="padding-big bg radius-big">
						<div class="form-group">
							<div class="label">
								<label for="typeName"> 行业名称 </label>
							</div>
							<div class="field">
								<input type="text" class="input" id="typeName" name="typeName" size="100" maxlength="100" value="" placeholder="请输入行业名称">
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="typeIntruduce"> 行业介绍 </label>
							</div>
							<div class="field">
								<textarea rows="8" cols="20" id="typeIntruduce" name="typeIntruduce" type="text" maxlength="500" style="width: 100%; class="input" placeholder="请输入行业介绍" ></textarea>
							</div>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>


	<div class="hidden">
		<script type="text/javascript">
			function validate() {
				if (!$('#typeName').val()) {
					layer.msg('行业类型不能为空！', {
						icon : 2
					});
					return false;
				}
				return true;
			}
			//初始化数据
			function getFromSerialize() {
				return $('#tradeEditForm').serialize();
			}

			//新增处理
			function initDataForNew(typeCode) {
				$("#typeParentCode").val(typeCode);
			}

			//修改数据时
			function initData(data) {
				$('#id').val(data.id);
				$('#typeUUID').val(data.typeUUID);
				$('#typeCode').val(data.typeCode);
				$('#typeName').val(data.typeName);
				$('#typeParentCode').val(data.typeParentCode);
				$('#typeParentName').val(data.typeParentName);
				$('#typeUrl').val(data.typeUrl);
				$('#typeType').val(data.typeType);
				$('#isShow').val(data.isShow);
				$('#typeHaveLowerNode').val(data.typeHaveLowerNode);
				$('#typeIntruduce').val(data.typeIntruduce);
				$('#typeCreateTime').val(data.typeCreateTime);
				$('#typeCreateUserUUID').val(data.typeCreateUserUUID);
				$('#typeCreateUserName').val(data.typeCreateUserName);
				$('#typeUpTime').val(data.typeUpTime);
				$('#typeUpUserUUID').val(data.typeUpUserUUID);
				$('#typeUpUserName').val(data.typeUpUserName);

			}
		</script>
	</div>

</body>
</html>
