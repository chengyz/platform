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
<style>
    #unitFormContent .autocompleter {
	    left: 0px;
	    margin-top:1px;
	}
</style>
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/fixedPintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<link type="text/css" rel="stylesheet" href="static/js/autocompleter/jquery.autocompleter.css">
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
<script src="static/js/respond.js"></script>
<script src="static/js/admin.js"></script>
<script src="static/js/layer.js"></script>
<script src="static/js/autocompleter/jquery.autocompleter.min.js"></script>
</head>

<body>
	<div id="container" style="margin:0 auto">
		<div class="line-big" style="margin-left:30px">
			<form id="unitEditForm" method="post" style="width:94%;" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id"> 
				<input type="hidden" id="unitUUID" name="unitUUID"> 
				<input type="hidden" id="tradeUUID" name="tradeUUID"> 
				<input type="hidden" id="createTime" name="createTime"> 
				<input type="hidden" id="createUserUUID" name="createUserUUID"> 
				<input type="hidden" id="createUserName" name="createUserName"> 
				<input type="hidden" id="updateTime" name="updateTime"> 
				<input type="hidden" id="updateUserUUID" name="updateUserUUID"> 
				<input type="hidden" id="updateUserName" name="updateUserName"> 
				<input type="hidden" id="status" name="status">
				<div class="xl12 xm12 padding-big radius-big">
					<div class="padding-big bg radius-big text-center">
						<h1>
							单位基本信息
						</h1>
						<br>
					</div>
				</div>
				<div id="unitFormContent" class="xl12 xm12 padding-big radius-big">
					<div class="xl12 xm6 padding-big radius-big">
						<div class="padding-big bg radius-big">
							<div class="form-group" id="unitCodeDom">
								<div class="label">
									<label for="unitCode"> 组织机构代码 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitCode" name="unitCode" maxlength="15" value=""
										placeholder="输入组织机构代码"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="LicenseNoDom">
								<div class="label">
									<label for="LicenseNo"> 营业执照号码 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="LicenseNo" name="LicenseNo" maxlength="18" value=""
										placeholder="输入营业执照号码"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitNameDom">
								<div class="label">
									<label for="unitName"> 单位名称 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitName" name="unitName" maxlength="15" value=""
										placeholder="输入单位名称"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="LegalRepresentativeDom">
								<div class="label">
									<label for="LegalRepresentative"> 法定代表人 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="LegalRepresentative" name="LegalRepresentative"
										maxlength="18" value="" placeholder="输入法定代表人"><span
										class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitRegionCodeDom">
								<div class="label">
									<label for="unitRegionCode"> 区域编码 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitRegionCode" name="unitRegionCode" maxlength="18"
										value="" placeholder="输入所在区域编码"><span
										class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitRegionNameDom">
								<div class="label">
									<label for="unitRegionName"> 区域名称 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitRegionName" name="unitRegionName" maxlength="18"
										value="" placeholder="输入所在区域名称 "><span
										class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitAddressDom">
								<div class="label">
									<label for="unitAddress"> 详细地址 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitAddress" name="unitAddress" maxlength="15" value=""
										placeholder="输入详细地址"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="linkManDom">
								<div class="label">
									<label for="linkMan"> 联系人 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="linkMan" name="linkMan" maxlength="18" value=""
										placeholder="输入联系人"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="contactNumberDom">
								<div class="label">
									<label for="contactNumber"> 联系电话 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="contactNumber" name="contactNumber" maxlength="18"
										value="" placeholder="输入联系人电话"><span
										class="addon text-red">*</span>
								</div>
							</div>
							<br>
						</div>
					</div>
					<div class="xl12 xm6 padding-big radius-big">
						<div class="padding-big bg radius-big">
							<div class="form-group" id="unitSubjectionDom">
								<div class="label">
									<label for="unitSubjection"> 隶属关系 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitSubjection" name="unitSubjection" maxlength="15"
										value="" placeholder="输入隶属关系"><span
										class="addon text-red">*</span>
								</div>
							</div>

							<div class="form-group" id="unitNatureDom">
								<div class="label">
									<label for="unitNature"> 单位性质</label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitNature" name="unitNature" maxlength="15" value=""
										placeholder="输入单位（企业）性质 "><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitTradesDom">
								<div class="label">
									<label for="unitTrades"> 所属行业 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitTrades" name="unitTrades" maxlength="18" value=""
										placeholder="输入所属行业"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="streetDom">
								<div class="label">
									<label for="street"> 街道（乡镇） </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="street" name="street" maxlength="15" value=""
										placeholder="输入街道（乡镇）"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="villageDom">
								<div class="label">
									<label for="village"> 村（社区） </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="village" name="village" maxlength="18" value=""
										placeholder="输入村（社区）"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="licenseTypeDom">
								<div class="label">
									<label for="licenseType"> 工商执照类型 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="licenseType" name="licenseType" maxlength="15" value=""
										placeholder="输入工商执照类型"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitKeyplaceDom">
								<div class="label">
									<label for="unitKeyplace"> 重点场所 </label>
								</div>
								<div class="field input-group">
									<input type="text" class="input" style="width: 100%;"
										id="unitKeyplace" name="unitKeyplace" maxlength="18" value=""
										placeholder="输入单位重点场所"><span class="addon text-red">*</span>
								</div>
							</div>
							<div class="form-group" id="unitDescribeDom">
								<div class="label">
									<label for="unitDescribe"> 备 注 </label>
								</div>
								<div class="field" style="width: 100%;">
									<textarea rows="6" cols="60" class="input" id="unitDescribe"
										name="unitDescribe" placeholder="单位（企业）简要描述"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="xl12 xm12 padding-big radius-big">
					<div class="padding-big bg radius-big text-center">
						<h1>
							管理员账号信息
						</h1>
						<br>
					</div>
				</div>
				<div id="unitFormContent" class="xl12 xm12 padding-big radius-big">
					<div class="xl12 xm6 padding-big radius-big">
						<div class="padding-big bg radius-big">
						<input type="hidden" id="userId" name="userId">
				<input type="hidden" id="userUUID" name="userUUID">
				<input type="hidden" id="userPwd" name="userPwd">
				<input type="hidden" id="userUnitUUID" name="userUnitUUID">
				<input type="hidden" id="userUnitName" name="userUnitName">
				<input type="hidden" id="userTel" name="userTel">
				<input type="hidden" id="userType" name="userType" value="3">
				<input type="hidden" id="userEmail" name="userEmail">
				<input type="hidden" id="nickName" name="nickName">
				<input type="hidden" id="userSex" name="userSex">
				<input type="hidden" id="userStatus" name="userStatus">
				<input type="hidden" id="userCreateTime" name="userCreateTime">
				<input type="hidden" id="userUpdateTime" name="userUpdateTime">
				<input type="hidden" id="simpleSpelling" name="simpleSpelling">
				<input type="hidden" id="fullSpelling" name="fullSpelling">
				<input type="hidden" id="queryCombination" name="queryCombination">
				<input type="hidden" id="userPic" name="userPic">
				<input type="hidden" id="userDescription" name="userDescription">
				<input type="hidden" id="loginTime" name="loginTime">
				<input type="hidden" id="loginNum" name="loginNum">
							<div class="form-group">
								<div class="label">
									<label for="loginName"> 登录名 </label>
								</div>
								<div class="field">
									<input type="text" class="input" id="loginName" name="loginName" size="32" maxlength="32" value="" placeholder="请输入用户登录名">
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label for="userName"> 姓名 </label>
								</div>
								<div class="field">
									<input type="text" class="input" id="userName" name="userName" size="50" maxlength="50" value="" placeholder="请输入用户姓名">
								</div>
							</div>
							<br>
						</div>
					</div>
					<div class="xl12 xm6 padding-big radius-big">
						<div class="padding-big bg radius-big">
							<div class="form-group">
							<div class="label">
								<label>
									性别</label>
							</div>
							<div class="field">
								<div class="button-group radio">
									<label class="button active">
										<input id="userSexM" name="userSex" value="1" checked="checked" type="radio"><span class="icon icon-male"></span> 先生
									</label>
									<label class="button">
										<input id="userSexF" name="userSex" value="2" type="radio"><span class="icon icon-female"></span> 女士
									</label>
								</div>
							</div>
						</div>
					<div class="form-group">
						<div class="label">
							<label for="userMobile"> 手机 </label>
						</div>
						<div class="field">
							<input type="text" class="input" id="userMobile" name="userMobile" size="11" maxlength="11" value="" placeholder="请输入手机号码">
						</div>
					</div>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>


	<div class="hidden">
		<script type="text/javascript">
		$(function (){
			$("#unitTrades").autocompleter({
		   		source: '<%=path%>/system/trade/findTypeNameToAutoComplete',
		   		focusOpen:false,
		   		selectFirst:true,
		   		limit:200,
		   		changeWhenSelect:true,
		   		empty:false,
		   		highlightMatches:true,
		   		callback:function (value,index,selected){
		   			if (selected){
		   				$("#tradeUUID").val(selected.hideValue);
		   			}
		   		}
			   	});
		   	$("#unitTrades").blur(function (){
		   		if ($("#tradeUUID").val()==""){
		   			$("#unitTrades").val($("#tradeUUID").val());
		   		}
		   	});
		});
			function validate() {
				if (!$('#unitCode').val()) {
					layer.msg('单位（企业）机构代码不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#LicenseNo').val()) {
					layer.msg('单位（企业）营业执照不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitName').val()) {
					layer.msg('单位（企业）名称不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#LegalRepresentative').val()) {
					layer.msg('单位（企业）法人代表不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitRegionCode').val()) {
					layer.msg('单位（企业）所属区域编码不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitRegionName').val()) {
					layer.msg('单位（企业）所属区域不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitAddress').val()) {
					layer.msg('单位（企业）地址不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#linkMan').val()) {
					layer.msg('联系人不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#contactNumber').val()) {
					layer.msg('联系人电话不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitSubjection').val()) {
					layer.msg('单位（企业）所属关系不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitNature').val()) {
					layer.msg('单位（企业）性质不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitTrades').val()) {
					layer.msg('单位（企业）所属行业不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#street').val()) {
					layer.msg('街道（乡镇）不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#village').val()) {
					layer.msg('村（社）不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#licenseType').val()) {
					layer.msg('单位（企业）工商执照登记类型不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitKeyplace').val()) {
					layer.msg('单位（企业）重点场所不能为空！', {
						icon : 2
					});
					return false;
				}
				if (!$('#unitDescribe').val()) {
					layer.msg('单位（企业）描述不能为空！', {
						icon : 2
					});
					return false;
				}
				return true;
			}
			//初始化数据
			function getFromSerialize() {
				return $('#unitEditForm').serialize();
			}

			//修改数据时
			function initData(data,userData) {
				$('#id').val(data.id);
				$('#unitUUID').val(data.unitUUID);
				$('#unitCode').val(data.unitCode);
				$('#LicenseNo').val(data.LicenseNo);
				$('#unitName').val(data.unitName);
				$('#LegalRepresentative').val(data.LegalRepresentative);
				$('#unitRegionCode').val(data.unitRegionCode);
				$('#unitRegionName').val(data.unitRegionName);
				$('#unitAddress').val(data.unitAddress);
				$('#linkMan').val(data.linkMan);
				$('#contactNumber').val(data.contactNumber);
				$('#unitSubjection').val(data.unitSubjection);
				$('#unitNature').val(data.unitNature);
				$('#tradeUUID').val(data.tradeUUID);
				$('#unitTrades').val(data.unitTrades);
				$('#village').val(data.village);
				$('#licenseType').val(data.licenseType);
				$('#unitKeyplace').val(data.unitKeyplace);
				$('#unitDescribe').val(data.unitDescribe);
				$('#createTime').val(data.createTime);
				$('#createUserUUID').val(data.createUserUUID);
				$('#createUserName').val(data.createUserName);
				$('#updateTime').val(data.updateTime);
				$('#updateUserUUID').val(data.updateUserUUID);
				$('#updateUserName').val(data.updateUserName);
				$('#status').val(data.status);
				//用户信息
				$('#userId').val(userData.id);
				$('#userUUID').val(userData.userUUID);
				$('#loginName').val(userData.loginName);
				$('#userPwd').val(userData.userPwd);
				$('#userUnitUUID').val(userData.unitUUID);
				$('#userUnitName').val(userData.unitName);
				$('#userName').val(userData.userName);
				$('#userType').val(userData.userType);
				$('#userMobile').val(userData.userMobile);
				$('#userTel').val(userData.userTel);
				$('#userEmail').val(userData.userEmail);
				$('#nickName').val(userData.nickName);
				$('#userSex').val(userData.userSex);
				$('#userStatus').val(userData.userStatus);
				$('#userCreateTime').val(userData.createTime);
				$('#userUpdateTime').val(userData.updateTime);
				$('#simpleSpelling').val(userData.simpleSpelling);
				$('#fullSpelling').val(userData.fullSpelling);
				$('#queryCombination').val(userData.queryCombination);
				$('#userPic').val(userData.userPic);
				$('#userDescription').val(userData.userDescription);
				$('#loginTime').val(userData.loginTime);
				$('#loginNum').val(userData.loginNum);
			}
		</script>
	</div>

</body>
</html>
