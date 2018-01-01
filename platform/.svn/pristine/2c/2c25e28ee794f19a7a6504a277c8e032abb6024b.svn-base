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
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
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
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
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
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
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
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
	});
	
	$("#selectA").live("click", function () {
		$(this).remove();
		$("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
	});
	
	$("#selectB").live("click", function () {
		$(this).remove();
		$("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
	});
	
	$("#selectC").live("click", function () {
		$(this).remove();
		$("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
	});
	
	$("#selectD").live("click", function () {
		$(this).remove();
		$("#select4 .select-all").addClass("selected").siblings().removeClass("selected");
		var gkType = $("#selectA a").html();
		if(gkType == '理科'){
			gkType = 2;
		}else{
			gkType = 1;
		}
		var sclSengFeng = $("#selectB a").html();
		var gkBatch = $("#selectC a").html();
		if(gkBatch == '本科一批'){
			gkBatch = 1;
		}else if(gkBatch == '本科二批'){
			gkBatch = 2;
		}else if(gkBatch == '本科三批'){
			gkBatch = 3;
		}else if(gkBatch == '专科一批'){
			gkBatch = 4;
		}else if(gkBatch == '专科二批'){
			gkBatch = 5;
		}
		var gkYear = $("#selectD a").html();
		queryGkscoreNAjax(0,1,20,gkType,sclSengFeng,gkBatch,gkYear,null,1,null,null,null,null);
	});
	
	$(".select dd").live("click", function () {
		if ($(".select-result dd").length > 1) {
			$(".select-no").hide();
		} else {
			$(".select-no").show();
		}
	});
	
});