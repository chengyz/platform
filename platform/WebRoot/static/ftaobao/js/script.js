$(document).ready(function(){
							
	$("#select1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectA").length > 0) {
				$("#selectA a").html($(this).text());
			} else {
				$(".select-result dl").append(copyThisA.attr("id", "selectA"));
			}
		}
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		$('#gkNameID').val('');
		queryAllPostAjax(1,$(this).text(),sclFeature,sclType,sclAddr);
	});
	
	$("#select2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectB").remove();
		} else {
			var copyThisB = $(this).clone();
			if ($("#selectB").length > 0) {
				$("#selectB a").html($(this).text());
			} else {
				$(".select-result dl").append(copyThisB.attr("id", "selectB"));
			}
		}
		var sclRank = $("#selectA a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		$('#gkNameID').val('');
		queryAllPostAjax(1,sclRank,$(this).text(),sclType,sclAddr);
	});
	
	$("#select3 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#selectC").length > 0) {
				$("#selectC a").html($(this).text());
			} else {
				$(".select-result dl").append(copyThisC.attr("id", "selectC"));
			}
		}
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		$('#gkNameID').val('');
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	
	$("#select4 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		if ($(this).hasClass("select-all")) {
			$("#selectD").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#selectD").length > 0) {
				$("#selectD a").html($(this).text());
			} else {
				$(".select-result dl").append(copyThisC.attr("id", "selectD"));
			}
		}
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		$('#gkNameID').val('');
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	
	$("#selectA").live("click", function () {
		$(this).remove();
		$("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	
	$("#selectB").live("click", function () {
		$(this).remove();
		$("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	
	$("#selectC").live("click", function () {
		$(this).remove();
		$("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	$("#selectD").live("click", function () {
		$(this).remove();
		$("#select4 .select-all").addClass("selected").siblings().removeClass("selected");
		var sclRank = $("#selectA a").html();
		var sclFeature = $("#selectB a").html();
		var sclType = $("#selectC a").html();
		var sclAddr = $("#selectD a").html();
		queryAllPostAjax(1,sclRank,sclFeature,sclType,sclAddr);
	});
	$(".select dd").live("click", function () {
		if ($(".select-result dd").length > 1) {
			$(".select-no").hide();
		} else {
			$(".select-no").show();
		}
	});
	
});