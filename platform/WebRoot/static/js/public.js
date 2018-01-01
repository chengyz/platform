var layerTipIndex;
var oldBackGound;
/**
 * 基于layer的 打开窗口通用方法（hshzh封装）
 * @param url 页面地址 'admin/schoolMng/impSchool.jsp'
 * @param title 头部标题可包含图标 '<i class="icon-sign-in"></i> 导入学校数据'
 * @param area 大小 ['600px','200px']
 * @param btn 页面上的按钮(['导入','取消'])
 * @param yesCallback 点击确认的回调方法，返回参数为iframeWin窗口对象
 */
function openWin(url,title,area,btn, yesCallback, afterOpenWinCallBack, params){
	var layeroPublic;
	var index=layer.open({
		content: url,
		title:title,
		type: 2,
		area: area,
		btn: btn,
		yes : function() {//点击确认
			 var iframeWin = window[layeroPublic.find('iframe')[0]['name']];
			 return yesCallback(iframeWin, params);
		},
		skin: 'layui-layer-lan', //样式类名
		closeBtn: 1, //不显示关闭按钮
		shift: 2,
		maxmin: true,//最大化最小化
		shadeClose: true, //开启遮罩关闭
		success: function(layero, index){//窗口打开成功
			layeroPublic = layero;
			afterOpenWinCallBack(layero, index, params);
		}
	});
	return index;
}

/**
 * 分页处理（hshzh 依赖initTableList方法）
 * @param url
 * @param page
 * @param tableId
 * @param queryFormid
 */
function doQueryPage(url,page,tableId,queryFormid){
	$("#"+queryFormid).find("[name='page']").val(page);//设置当前页
	initTableList(url,tableId,queryFormid);
}
/**
 * 初始化表格（hshzh封装）
 * @param url
 * @param tableId
 * @param queryFormid
 */
function initTableList(url,tableId,queryFormid){
	var pageRecord = $("#"+queryFormid).find("[name='pageRecord']").val();//获取每页显示的条数
	var page = $("#"+queryFormid).find("[name='page']").val();//获取当前页
	var totalPage=$("#"+queryFormid).find("[name='totalPage']").val();//获取总页数
	var totalRecord=$("#"+queryFormid).find("[name='totalRecord']").val();//获取总条数
	$.post(url, $("#"+queryFormid).serialize(),function(data) {
		if(data && data.totalRecord > 0) {
			var str = '';
			var pageStr = '';
			var rows = data.rows;
			totalRecord = data.totalRecord; 
			totalPage = data.totalPage;
			page = data.page;
			pageRecord = data.pageRecord;
			//设置分页表单
			$("#"+queryFormid).find("[name='pageRecord']").val(data.pageRecord);//每页显示的条数
			$("#"+queryFormid).find("[name='page']").val(data.page);//当前页
			$("#"+queryFormid).find("[name='totalPage']").val(data.totalPage);//总页数
			$("#"+queryFormid).find("[name='totalRecord']").val(data.thisPageRecord);//总条数
			if(page==1){
				//上一页和首页不可用
				$("a[title='上一页']").removeAttr("href");
				$("a[title='首页']").removeAttr("href");	
				oldBackGound = $("a[title='上一页']").css("background");
				$("a[title='上一页']").css("background","#ddd");
				$("a[title='首页']").css("background","#ddd");	
			}else{
				//上一页和首页可用
				var npage = page-1;
				$("a[title='上一页']").attr("href","javascript:doQueryPage('"+url+"','"+npage+"','"+tableId+"','"+queryFormid+"');");					
				$("a[title='首页']").attr("href","javascript:doQueryPage('"+url+"','1','"+tableId+"','"+queryFormid+"');");				
				$("a[title='上一页']").css("background",oldBackGound);
				$("a[title='首页']").css("background",oldBackGound);	
			}
			if(page==totalPage){
				//下一页和尾页不可用
				$("a[title='下一页']").removeAttr("href");
				$("a[title='尾页']").removeAttr("href");	
				$("a[title='下一页']").css("background","#ddd");
				$("a[title='尾页']").css("background","#ddd");	
			}else{
				//下一页和尾页可用
				var npage = page+1;
				$("a[title='下一页']").attr("href","javascript:doQueryPage('"+url+"','"+npage+"','"+tableId+"','"+queryFormid+"');");
				$("a[title='尾页']").attr("href","javascript:doQueryPage('"+url+"','"+totalPage+"','"+tableId+"','"+queryFormid+"');");
				$("a[title='下一页']").css("background",oldBackGound);
				$("a[title='尾页']").css("background",oldBackGound);	
			}
			//设置页面跳转
			$("a[title='GO']").attr("href","javascript:gotoPage('"+url+"','"+tableId+"','"+queryFormid+"');");
			$("[name='selectPageRow']").attr("onchange","javascript:getPageRow(this.value,'"+url+"','"+tableId+"','"+queryFormid+"');");
			if(rows && rows.length > 0) {
				for(var i = 0; i < rows.length; i++) {
					var onClickTrHandler="";
					var varTr1 = "";
					var varTr = "";
					$("#"+tableId).find("thead tr th").each(function(){
						if($(this).attr("field") == 'checkBox'){//
							varTr += '<td data-title="'+$(this).text()+'">';
							varTr += '<input type="checkbox" id="'+rows[i].id+'" value="'+rows[i].id+'" onclick="onCheckBoxHandler(this, '+rows[i].id+');" />';
						}else if($(this).attr("field") == 'rowNum'){//序号
							varTr += '<td data-title="'+$(this).text()+'">' +((data.page-1)*data.pageRecord + i+1);
						}else{
							varTr += '<td data-title="'+$(this).text()+'" ondblclick="ondblClickTdHandler(this, '+rows[i].id+')" onmouseout="closeTip();"';
							var field = $(this).attr("field");
							if($(this).attr("field")!=undefined){
								if($(this).attr("limitTxtLen")!=undefined){
									var len = parseInt($(this).attr("limitTxtLen"));
									varTr += 'onmouseover="tipText(this, '+len+');"  tipText="'+eval("rows[i]."+field)+'">';
									varTr += limitLenText(eval("rows[i]."+field), len);
								}else{
									varTr += 'onmouseover="tipText(this, 4);"  tipText="'+eval("rows[i]."+field)+'">';
									varTr += limitLenText(eval("rows[i]."+field), 4);//默认显示长度
								}
							}else{
								varTr += '>';
							}
						}						
						if($(this).attr("format")!=undefined){
							var func=eval($(this).attr("format"));
							varTr += func.call(this,rows[i]);
						}
						if($(this).attr("onclickformat")!=undefined){
							var func=eval($(this).attr("onclickformat"));
							onClickTrHandler = func.call(this,rows[i]);
							varTr1 = '<tr ondblclick="ondblClickTrHandler(this, '+rows[i].id+');" onclick="'+onClickTrHandler+'">';
						}else{
							varTr1 = '<tr ondblclick="ondblClickTrHandler(this, '+rows[i].id+');">';
						}
						varTr +='</td>';						
					});
					varTr += '</tr>';
					str +=varTr1 + varTr;
				}
			}
			$("#"+tableId).find("tbody").html(str);
			if($("#"+tableId).find("tbody").attr("loadSucc")){
				var loadSuccFunc=eval($("#"+tableId).find("tbody").attr("loadSucc"));
				loadSuccFunc.call(this,rows);
			}
			pageStr += '<li id="page'+page+'"><a class="text-yellow" title="第'+page+'页" href="javascript:void(0)" >'+page+"/"+totalPage+'</a></li>';
			$('#pageGroup').html(pageStr);
			$('#pageTotalMsg').html('<a>共计<strong class="text-yellow">' + totalRecord + '</strong>条记录，共有<strong class="text-yellow">' + totalPage + '</strong>页</a>');
			$('#page' + page).attr('class', 'active');//设置选中状态				
		} else {
			$("#"+tableId).find("tbody").html("");
			$('#'+tableId).find("tbody").html('<td colspan="14" style="vertical-align: middle;">没有数据</td>');
			$('#pageGroup').html('<li class="active"><a title="第1页" href="#">1</a></li>');
			$('#pageTotalMsg').html('<a>共计<strong class="text-yellow">0</strong>条记录。</a>');
		}			
	}, 'json');
}

/**
 * 页面跳转
 */
function gotoPage(url,tableId,queryFormid){
	var page = 1;
	if($('#gotoPageInput').val() > eval($("[name='totalPage']").val())){
		$('#gotoPageInput').val($("[name='totalPage']").val());
		page = $("[name='totalPage']").val();
	}else if($('#gotoPageInput').val() < 1){
		$('#gotoPageInput').val(1);
		page = 1;
	}else{
		page = $('#gotoPageInput').val();
	}
	$("[name='page']").val(page);
	initTableList(url,tableId,queryFormid);
}
/**
 * 选择每页条数
 * @param value
 * @param url
 * @param tableId
 * @param queryFormid
 */
function getPageRow(value, url,tableId,queryFormid){
	$("[name='pageRecord']").val(value);
	doQueryPage(url,"1",tableId,queryFormid);
}
/**
 * 取部分字符串
 */
function limitLenText(txt, len){
	if(txt != null && txt != "undefined"){
		if(len == 0){
			return "";
		}else if(len < 0){
			return txt;
		}else{
			if(txt.length > len){
				return txt.substr(0, len) + "...";
			}else{
				return txt;
			}
		}
	}else{
		return "";
	}
}
/**
 * 表格中弹出提示框
 * @param dom
 */
function tipText(dom, len){
 	var txt = $(dom).attr('tipText');
 	if(txt != null && txt != "undefined" && len > 0 && txt.length > len){
 		layerTipIndex = layer.open({
 			type : 4,
 			tips : [ 1, '#3595CC' ],
 			content : [ txt, dom ],
 			closeBtn : !1,
 			time : 0,//0不会关闭，单位毫秒
 			shade : !1,
 			maxWidth : 600
 			//使用layer.tips最大宽只有210
 		});
 	}
}


function closeTip(){
	layer.close(layerTipIndex);
}
/*
function onClickTrHandler(dom, id){
	//留空，页面请覆盖此函数
}
*/
function ondblClickTrHandler(dom, id){
	//留空，页面请覆盖此函数
}

function onCheckBoxHandler(id){
	//留空，页面请覆盖此函数
}

function ondblClickTdHandler(dom, id){
	//留空，页面请覆盖此函数
}

/**
 * 初始化ZTree
 * hshzh 封装
 * treeId 树的id
 * url 请求地址
 * addHoverDom 添加按钮的回调方法，参数为（treeId, treeNode）返回false则不显示添加按钮
 * zTreeBeforeEditName 修改按钮的回调方法，参数为（treeId, treeNode）
 * zTreeOnClick 单击节点的回调方法，参数为（event, treeId, treeNode）
 * zTreeBeforeRemove  删除按钮的回调方法，参数为（treeId, treeNode）
 * setRenameBtn 是否设置修改按钮的回调方法，参数为（treeId, treeNode），返回false则不显示修改按钮
 * setRemoveBtn 是否设置删除按钮的回调方法，参数为（treeId, treeNode），返回false则不显示删除按钮
 */
function initZTree(treeId,url,addHoverDom,zTreeBeforeEditName,zTreeOnClick,zTreeBeforeRemove,setRenameBtn,setRemoveBtn) {
		var setting = {
			     check: {
			          enable: true,
			          chkStyle: "checkbox",
			          chkboxType: { "Y": "", "N": "" }/**（1）Y、N、"p"和“s”说明 Y 属性定义 checkbox 被勾选后的情况；
			           											 N 属性定义 checkbox 取消勾选后的情况；  
																"p" 表示操作会影响父级节点；  
																"s" 表示操作会影响子级节点。

																（2）chkboxType: { "Y": "s", "N": "ps" }
																        表示checkbox勾选操作，只影响子节点；取消勾选操作，影响父子节点*/
			     },
		         view: {
		        	 addDiyDom: null,//用于在节点上固定显示用户自定义控件 function addDiyDom(treeId, treeNode),数据量大时影响性能
		             addHoverDom: addHoverDom,//用于当鼠标移动到节点上时，显示用户自定义控件(目前只自定义了添加按钮)，显示隐藏状态同 zTree 内部的编辑、删除按钮
		             removeHoverDom: removeHoverDom,//用于当鼠标移出节点时，隐藏用户自定义控件，显示隐藏状态同 zTree 内部的编辑、删除按钮
		             selectedMulti: false,//设置是否允许同时选中多个节点。
		             autoCancelSelected: false,//点击节点时，按下 Ctrl 或 Cmd 键是否允许取消选择操作。
		             dblClickExpand: true,//双击节点时，是否自动展开父节点的标识
		             expandSpeed: "normal",//节点展开、折叠时的动画速度，三种预定速度之一的字符串("slow", "normal", or "fast")
		             fontCss : {},//个性化文字样式，只针对 在节点上显示的<a>对象。默认值：{},{color:"red"},也可以是回调函数function setFontCss(treeId, treeNode) {return treeNode.level == 0 ? {color:"red"} : {};};
		             showIcon: true,//设置是否显示节点的图标,也可以是回调函数
		             showLine: true//是否显示节点之间的连线
		         },
		         callback : {
		        	 beforeAsync: null,//用于捕获异步加载之前的事件回调函数
		        	 beforeCheck: null,//用于捕获 勾选 或 取消勾选 之前的事件回调函数，并且根据返回值确定是否允许 勾选 或 取消勾选
		        	 beforeClick: null,//用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作
		        	 beforeCollapse: null,//用于捕获父节点折叠之前的事件回调函数，并且根据返回值确定是否允许折叠操作
		        	 beforeDblClick: null,//用于捕获鼠标双击之前的事件回调函数，并且根据返回值确定触发 onDblClick 事件回调函数
		        	 beforeDrag: null,//用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
		        	 beforeDragOpen: null,//用于捕获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作
		        	 beforeDrop: null,//用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
		        	 beforeEditName : zTreeBeforeEditName,//用于捕获节点编辑按钮的 click 事件，并且根据返回值确定是否允许进入名称编辑状态
		        	 onClick: zTreeOnClick,//用于捕获节点被点击的事件回调函数
		        	 beforeRemove : zTreeBeforeRemove//用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
		         },
		         async: {
			     		enable: true,//是否开启异步加载模式
			     		url:url,//Ajax获取数据的 URL地址
			     		type:"post",//Ajax的http请求模式(get,post)
			     		dataType:"json",//Ajax获取的数据类型(text,json)
			     		contentType: "application/json",//Ajax 提交参数的数据类型
		     	 },
		         data: {
		             simpleData: {
		                 enable: true//数据是否采用简单数据模式
		             }
		         },
		         edit: {
		             enable: true,//设置zTree是否处于编辑状态
		             removeTitle: "删除",//删除按钮的 Title 辅助信息
		 			 renameTitle: "修改",//编辑名称按钮的 Title 辅助信息
		 			 showRemoveBtn: setRemoveBtn,//设置是否显示删除按钮
		 			 showRenameBtn: setRenameBtn//设置是否显示修改按钮
		         }
		     };
		    function removeHoverDom(treeId, treeNode) {
	           $("#addBtn_"+treeNode.tId).unbind().remove();
	        };
			return $.fn.zTree.init($("#"+treeId),setting);
	}