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

<title>行业管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


</head>

<body>
	<div class="line-big">
		<div class="xl12 xm3">
			<div class="admin">
				<div class="panel admin-panel">
					<form id="tradeTreeForm" method="post">
						<input type="hidden" id="menuCode" name="areaCode" value="10"/><!-- 菜单编号 -->
						<input type="hidden" id="userUUIDS" name="userUUIDS" value="0"/><!--选择的userUUID集合 -->
						<div class="panel-head">
							<strong>行业树</strong>
						</div>
					</form>
					<div>
						<ul id="tradeTree" class="ztree"
							style="width:100%;height:100%; border: none; overflow: auto; margin-top:0px;overflow: auto"></ul>
					</div>
					<div class="panel-foot text-center"></div>
				</div>
				<br>
			</div>
			<br>
		</div>
		<div class="xl12 xm9">
			<div class="admin">
				<div class="panel admin-panel">
					<form id="tradeListForm" method="post">
						<input type="hidden" name="page" value="1" />
						<!-- 当前页 -->
						<input type="hidden" name="totalPage" value="1" />
						<!-- 总页数 -->
						<input type="hidden" name="pageRecord" value="10" />
						<!-- 每页显示条数 -->
						<input type="hidden" name="totalRecord" value="0" />
						<!-- 总条数 -->
						<div class="panel-head">
							<strong>权限列表</strong>
						</div>
					</form>
					<table id="tradeListTable" class="table table-hover">
						<thead>
							<tr>
								<th width="50" field="rowNum">序号</th>
								<th width="200" field="typeName" limitTxtLen="-1">行业名</th>
							    <th width="180" field="typeIntruduce" limitTxtLen="-1">行业简介</th>
							    <th width="100" format="formatMenuCZ">操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					<div class="panel-foot text-center">
						<ul class="pagination">
							<li><a title="首页"
								href="javascript:doQuery(1, queryStatus);"><span
									class="icon-step-backward"></span>&nbsp;首页</a></li>
							<li><a title="上一页"
								href="javascript:doQuery(perPage, queryStatus);"><span
									class="icon-chevron-left"></span>&nbsp;上一页</a></li>
						</ul>
						<ul class="pagination pagination-group" id=pageGroup>
						</ul>
						<ul class="pagination">
							<li><a title="下一页"
								href="javascript:doQuery(nextPage, queryStatus);">下一页&nbsp;<span
									class="icon-chevron-right"></span></a></li>
							<li><a title="尾页"
								href="javascript:doQuery(endPage, queryStatus);">尾页&nbsp;<span
									class="icon-step-forward"></span></a></li>
						</ul>
						<ul class="pagination">
							<li id="pageTotalMsg"><a>共计<strong class="text-yellow">0</strong>条记录。
							</a></li>
						</ul>
						<ul class="pagination">
							&nbsp;&nbsp;
							<li>跳转</li>
							<input id="gotoPageInput" class="input input-auto"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
								style="width: 50px; height: 25px"></input>
							<li>页</li>
							<li><a class="button border-main"
								href="javascript:gotoPage();">GO</a></li>
						</ul>
					</div>

					<div
						class="margin-top text-center show-l hidden-s hidden-b hidden-m">
						<span class="icon-chevron-down mobile-down"
							style="font-size: 24px;"></span>
					</div>
				</div>
				<br>
			</div>
			<br>
		</div>
	</div>




	<div class="hidden">
		<script>
	/*菜单树*/
	var selectNode;
	var zTree;
	$(function() {
		<%-- if ("null"=="${sessionScope.userinfo}"||""=="${sessionScope.userinfo}"){
			window.location = '<%=path%>/admin/login.jsp';
		}else{
			loadtradeTree();//初始化时加载区域树
			doQuery(null);
		} --%>
		loadtradeTree();//初始化时加载区域树
		doQuery(null);
	});
	//加载菜单树
	function loadtradeTree(){
		var url="<%=path%>/system/trade/findTradeTree";
		initZTree("tradeTree",url,addHoverDom,zTreeBeforeEditName,zTreeOnClick,zTreeBeforeRemove,setRenameBtn,setRemoveBtn);
	}
	//修改节点
	function zTreeBeforeEditName(treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("tradeTree");//获取节点树
		 var nodes = treeObj.getCheckedNodes(true);//获取选中的节点
	     var msg = "name--id--pid\n";
	     for (var i = 0; i < nodes.length; i++) {
	         msg += nodes[i].name+"--"+nodes[i].id+"--"+nodes[i].pId+"\n";
	     }
		//存储已选择节点
		selectNode = treeNode;
		//执行修改方法
		editTradeItemByUUID(selectNode.typeUUID);
		return false;
	}
	//单击选择节点
	function zTreeOnClick(event, treeId, treeNode) {
		//选择
		selectNode = treeNode;
		//加载菜单信息
		doQuery(selectNode.typeCode);
	};
	//删除节点
	function zTreeBeforeRemove(treeId, treeNode) {
		selectNode = treeNode;
		var url="<%=path%>/system/trade/delTrade?uuids="+treeNode.typeUUID;
		$.post(url,"",function(data){
			if(data){
				//操作成功
				layer.msg('操作成功！', {icon: 1});
				//刷新
				loadtradeTree();//初始化时加载区域树
				doQuery(null);
			}
		},'json');
		return false;
	};
	//修改节点按钮是否可用
	function setRenameBtn(treeId,treeNode){
		if(treeNode.orgParentCode=="-1"){
			return false;
		}
		return true;
	}
	function setRemoveBtn(treeId, treeNode) {
		//设置删除按钮是否显示 返回true则显示，返回fasle则不显示
		if(!treeNode.isParent){
			return true;
		}	
	}
	function addHoverDom(treeId, treeNode) {
	    var sObj = $("#" + treeNode.tId + "_span");
	    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='新增下级' onfocus='this.blur();'></span>";
	    sObj.after(addStr);
	    var btn = $("#addBtn_"+treeNode.tId);
	    //设置新增按钮
	    if (btn) btn.bind("click", function(){
			//存储已选择节点
			selectNode = treeNode;
	    	//执行新增方法
	    	openAddOrUpTradeItemWin(treeNode.typeCode,null,"1");
	    	//doAddPersonTreeInfo(treeNode.id);
	        return false;
	    });
	};
	function removeHoverDom(treeId, treeNode) {  
	   $("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	
	/*菜单项编辑*/
	//加载菜单列表
	function doQuery(typeCode){
		var url='<%=path%>/system/trade/findTradeList?typeCode='+typeCode;
		initTableList(url,"tradeListTable", "tradeListForm");
	}
	var layerOpenIndex;
	var iframeWin;
	
		function addOrUpdateData(iframeWin,params){
		if (iframeWin.validate()){
			$.ajax({
				 url: '<%=path%>/system/trade/saveTrade',
				 type: "POST",
				 cache:false,
				 data: iframeWin.getFromSerialize(),
				 success: function(data){
					layer.close(layerOpenIndex);
					loadtradeTree();
					doQuery(null);
					 if (data.status=="1"){
						 if(params.type != "0"){
							 layer.msg('数据添加成功！', {icon: 1});
						 }else{
							 layer.msg('数据修改成功！', {icon: 1});
						 }
					 }else{
						 layer.msg('添加数据时出现异常！', {icon: 0});
					 }
					 
					 
				},
				error : function() {  
					 layer.msg('添加或修改数据时出现异常！', {icon: 0}); 
				}, 
				dataType: 'json'
				});
		}
		
	}
	function editTradeItemByUUID(typeUUID){
		if ("0".indexOf("0")>=0){
			$.ajax({
			 url: '<%=path%>/system/trade/findTrade?uuid='+typeUUID,
			 type: "POST",
			 cache: false,
			 data: {
				 uuid:typeUUID
			 },
			 success: function(data){
				 if(data){
					openAddOrUpTradeItemWin(data.typeCode,data,"0");
				 }else{
					layer.msg('查询数据失败！', {icon: 0});
				 }
			 },
			 error : function() {  
				 layer.msg('查询数据出现异常！', {icon: 0}); 
			 }, 
			 dataType: 'json'
			});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
		
	}
	
	//弹出用户信息编辑框
	function openAddOrUpTradeItemWin(typeCode,data,type){
		if ("0".indexOf("0")>=0||"0".indexOf("0")>=0){
			var winTitle = '<i class="icon-plus"></i> 添加菜单项</font>';
			if(type=="0"){
				winTitle = '<i class="icon-pencil"></i> 修改菜单项';
			}
			var url = 'PlatformAdmin/tradeMng/addTrade.jsp';
			var area = ['35%','50%'];
			var btn = ['<i class="icon-save"></i> 确&nbsp;&nbsp;&nbsp;定', '<i class="icon-times"></i> 取&nbsp;&nbsp;&nbsp;消'];
			layerOpenIndex = openWin(url, winTitle, area, btn, addOrUpdateData, afterOpenEditTradeItemWin, {"typeCode":typeCode,"type":type, "data":data});
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
	}
	
	function afterOpenEditTradeItemWin(layero, index, params){
		var body = layer.getChildFrame('body', index);
		tradeEditForm = body.find('form')[0];
	    iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	    if(params.type=="0"){//修改
	    	if(params.data){
		    	iframeWin.initData(params.data);
	    	}
	    }else {//添加
	    	iframeWin.initDataForNew(params.typeCode);
	    }
	}
	
	function formatMenuCZ(data){
		var editHTML = '<a class="button button-little border-blue" href="javascript:void(0)" onclick="editTradeItemByUUID(\''+data.typeUUID +'\');"><i class="icon-pencil"></i>&nbsp;修改</a>';
		return "&nbsp;" + editHTML;
	}
	
	function deleteTrade(typeUUID){
		if ("0".indexOf("0")>=0){
			if(typeUUID==""){
				layer.alert("请选择需要删除的内容",{icon:0});
			}
			var url = "/system/trade/delTrade=uuids"+typeUUID;
			$.post(url,null,function(data){
				if(data){
					layer.msg("操作成功!",{icon:1});
					//刷新
					loadtradeTree();
					doQuery(null);
				}else{
					layer.alert("操作失败！",{icon:2});
				}
			},"json");
		}else{
			layer.msg('没有权限！', {icon: 0});
		}
		
	
	}
		</script>
	</div>
</body>
</html>
