<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/calendar.js' />"></script>
<script type="text/javascript">

$(document).ready(function(){
	searchCodeMasterList();
	
	$("#btnSearch").click(searchCodeMasterList);
	$("#btnMasterNew").click(function(){ setMasterDetailInfo('new'); });
	$("#btnMasterSave").click(selectBtnMasterSave);
	$("#btnDetailNew").click(function(){ setDetailDetailInfo('new'); });
	$("#btnDetailSave").click(selectBtnDetailSave);
	
	$("#masterCodeNameSrch").keyup(function(e){
		$("#masterCodeSrch").val('');
		if(e.which == 13)
			searchCodeMasterList();
	});
	$("#masterCodeSrch").keyup(function(e){
		$("#masterCodeNameSrch").val('');
		var vOrig = $("#masterCodeSrch").val();
		var vResult = getOnlyNumber(vOrig);
		if(vOrig != vResult){
			alert("<spring:message code='message.onlyNumber' />");
			$("#masterCodeSrch").val(vResult);
		}else{
			if(e.which == 13)
				searchCodeMasterList();
		}
	});
	$("#masterCode").keyup(function(){
		if($("#masterCode").attr("readonly") == 'readonly')
			return;
		
		var vOrig = $("#masterCode").val();
		var vResult = getOnlyNumber(vOrig);
		if(vOrig != vResult){
			alert("<spring:message code='message.onlyNumber' />");
			$("#masterCode").val(vResult);
		}
	});
	$("#detailCode").keyup(function(){
		if($("#detailCode").attr("readonly") == 'readonly')
			return;
		
		var vOrig = $("#detailCode").val();
		var vResult = getOnlyNumber(vOrig);
		if(vOrig != vResult){
			alert("<spring:message code='message.onlyNumber' />");
			$("#detailCode").val(vResult);
		}
	});
	$("#detailOrderNum").keyup(function(){
		var vOrig = $("#detailOrderNum").val();
		var vResult = getOnlyNumber(vOrig);
		if(vOrig != vResult){
			alert("<spring:message code='message.onlyNumber' />");
			$("#detailOrderNum").val(vResult);
		}
	});
});

//조회중 버튼처리
function chngBtnSearch(bValue){
	if(bValue == 'start'){
		document.getElementById("btnSearch").src ="<c:url value='/images/button/btn_searching.gif' />";
		document.getElementById("btnSearch").disabled = true;
	}else{
		document.getElementById("btnSearch").src ="<c:url value='/images/button/btn_search.gif' />";
		document.getElementById("btnSearch").disabled = false;
	}
}

//마스터코드 리스트 조회
function searchCodeMasterList(){
	chngBtnSearch('start');
	
	$("#codeSearchVO").attr("target","iframeMasterCodeList");
	$("#codeSearchVO").attr("action","<c:url value='/system/codeManageMasterList.do'/>");
	$("#codeSearchVO").submit();
	
	setMasterDetailInfo('init');
}

//상세코드 리스트 조회
function searchCodeDetailList(){
	$("#codeSearchVO").attr("target","iframeDetailCodeList");
	$("#codeSearchVO").attr("action","<c:url value='/system/codeManageDetailList.do'/>");
	$("#codeSearchVO").submit();
	
	setDetailDetailInfo('init');
}

//마스터코드 저장버튼 클릭 - 저장/수정 기능 분기
function selectBtnMasterSave(){
	if($("#masterCode").attr("readonly") == 'readonly'){
		clickBtnModifyMaster();
	}else{
		clickBtnSaveMaster();
	}
}

//마스터코드 수정버튼 클릭
function clickBtnModifyMaster() {
	if($('#masterCodeName').val() == ''){
		alert("<spring:message code='message.inputMasterName' />");
		$('#masterCodeName').focus();
		return;
	}
	
	var vMasterDeleteYn = (document.getElementsByName("masterDeleteYn")[0].checked) ? '1' : '0';
	var param = "masterCode="+$("#masterCode").val()
	  + "&masterCodeName="+$("#masterCodeName").val()
	  + "&masterDetailInfo="+$("#masterDetailInfo").val()
	  + "&masterDeleteYn="+vMasterDeleteYn
	;
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/system/updateCodeManageMaster.do'/>",
		data: param,
		success: updateCodeManageMasterCallBack,
		error: function(e){  
			alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
		}  
	});
}

//마스터코드 수정버튼 클릭(callback)
function updateCodeManageMasterCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS") {
		alert("<spring:message code='groupManagerMain.alert.updateSuccess' />");
		searchCodeMasterList();
	} else {
		alert("<spring:message code='groupManagerMain.alert.fail' />");
	}
}

//마스터코드 저장버튼 클릭
function clickBtnSaveMaster() {
	if($('#masterCode').val() == ''){
		alert("<spring:message code='message.inputMaster' />");
		$('#masterCode').focus();
		return;
	}else if($('#masterCodeName').val() == ''){
		alert("<spring:message code='message.inputMasterName' />");
		$('#masterCodeName').focus();
		return;
	}
	
	var param = "masterCode="+$("#masterCode").val()
	  + "&masterCodeName="+$("#masterCodeName").val()
	  + "&masterDetailInfo="+$("#masterDetailInfo").val()
	;
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/system/insertCodeManageMaster.do'/>",
		data: param,
		success: insertCodeManageMasterCallBack,
		error: function(e){  
			alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
		}  
	});
}

//마스터코드 저장버튼 클릭(callback)
function insertCodeManageMasterCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS") {
		alert("<spring:message code='groupManagerMain.alert.insertSuccess' />");
		searchCodeMasterList();
	} else {
		alert("<spring:message code='groupManagerMain.alert.fail' />");
	}
}

//상세코드 저장버튼 클릭 - 저장/수정 기능 분기
function selectBtnDetailSave(){
	if($("#detailCode").attr("readonly") == 'readonly'){
		clickBtnModifyDetail();
	}else{
		clickBtnSaveDetail();
	}
}

//상세코드 수정버튼 클릭
function clickBtnModifyDetail() {
	if($('#detailCodeName').val() == ''){
		alert("<spring:message code='message.inputCodeName' />");
		return;
	}
	
	var vDetailDeleteYn = (document.getElementsByName("detailDeleteYn")[0].checked) ? '1' : '0';
	var param = "detailCode="+$("#detailCode").val()
	  + "&detailCodeName="+$("#detailCodeName").val()
	  + "&detailOrderNum="+$("#detailOrderNum").val()
	  + "&detailDetailInfo="+$("#detailDetailInfo").val()
	  + "&detailDeleteYn="+vDetailDeleteYn
	  + "&masterCode="+$("#masterCode").val()
	;
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/system/updateCodeManageDetail.do'/>",
		data: param,
		success: updateCodeManageDetailCallBack,
		error: function(e){  
			alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
		}  
	});
}

//상세코드 수정버튼 클릭(callback)
function updateCodeManageDetailCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS") {
		alert("<spring:message code='groupManagerMain.alert.updateSuccess' />");
		searchCodeDetailList();
	} else {
		alert("<spring:message code='groupManagerMain.alert.fail' />");
	}
}

//상세코드 저장버튼 클릭
function clickBtnSaveDetail() {
	if($('#detailCode').val() == ''){
		alert("<spring:message code='message.inputCodeValue' />");
		$('#detailCode').focus();
		return;
	}else if($('#detailCodeName').val() == ''){
		alert("<spring:message code='message.inputCodeName' />");
		$('#detailCodeName').focus();
		return;
	}
	
	var param = "detailCode="+$("#detailCode").val()
	  + "&detailCodeName="+$("#detailCodeName").val()
	  + "&detailOrderNum="+$("#detailOrderNum").val()
	  + "&detailDetailInfo="+$("#detailDetailInfo").val()
	  + "&masterCode="+$("#masterCode").val()
	;
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/system/insertCodeManageDetail.do'/>",
		data: param,
		success: insertCodeManageDetailCallBack,
		error: function(e){  
			alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
		}  
	});
}

//상세코드 저장버튼 클릭(callback)
function insertCodeManageDetailCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS") {
		alert("<spring:message code='groupManagerMain.alert.insertSuccess' />");
		searchCodeDetailList();
	} else {
		alert("<spring:message code='groupManagerMain.alert.fail' />");
	}
}

//마스터코드 상세정보 폼속성 변경
function setMasterDetailInfo(status){
	
	switch(status){
	case "init" :	//리스트 조회한 상태
		$('#masterCode').val('');
		$('#masterCodeName').val('');
		$('#masterDetailInfo').val('');
		$('#masterCode').attr('readonly', true);
		$('#masterCodeName').attr('readonly', true);
		$('#masterDetailInfo').attr('readonly', true);
		$('#masterCode').removeClass('detail_value_writable');
		$('#masterCodeName').removeClass('detail_value_writable');
		$('#masterDetailInfo').removeClass('detail_value_writable');
		$('#masterCode').addClass('detail_value_readonly');
		$('#masterCodeName').addClass('detail_value_readonly');
		$('#masterDetailInfo').addClass('detail_value_readonly');
		
		$("input[name=masterDeleteYn]").attr('checked', false);
		
		//$('#btnMasterNew').attr('disabled', false);
		//$('#btnMasterSave').attr('disabled', true);
		//$('#btnMasterModify').attr('disabled', true);
		//$('#btnDetailNew').attr('disabled', true);
		//$('#btnDetailSave').attr('disabled', true);
		break;
	case "new" :		//신규버튼 눌렀을 때
		$('#masterCode').val('');
		$('#masterCodeName').val('');
		$('#masterDetailInfo').val('');
		$('#masterCode').attr('readonly', false);
		$('#masterCodeName').attr('readonly', false);
		$('#masterDetailInfo').attr('readonly', false);
		$('#masterCode').removeClass('detail_value_readonly');
		$('#masterCodeName').removeClass('detail_value_readonly');
		$('#masterDetailInfo').removeClass('detail_value_readonly');
		$('#masterCode').addClass('detail_value_writable');
		$('#masterCodeName').addClass('detail_value_writable');
		$('#masterDetailInfo').addClass('detail_value_writable');
		$("input[name=masterDeleteYn]").attr('checked', false);
		
		//$('#btnMasterNew').attr('disabled', true);
		//$('#btnMasterSave').attr('disabled', false);
		//$('#btnMasterModify').attr('disabled', true);
		//$('#btnDetailNew').attr('disabled', true);
		//$('#btnDetailSave').attr('disabled', true);
		break;
	case "modify" :		//리스트에서 특정항목 선택했을 때
		$('#masterCode').attr('readonly', true);
		$('#masterCodeName').attr('readonly', false);
		$('#masterDetailInfo').attr('readonly', false);
		$('#masterCode').removeClass('detail_value_writable');
		$('#masterCodeName').removeClass('detail_value_readonly');
		$('#masterDetailInfo').removeClass('detail_value_readonly');
		$('#masterCode').addClass('detail_value_readonly');
		$('#masterCodeName').addClass('detail_value_writable');
		$('#masterDetailInfo').addClass('detail_value_writable');
		
		$("input[name=masterDeleteYn]").attr('checked', false);
		
		//$('#btnMasterNew').attr('disabled', false);
		//$('#btnMasterSave').attr('disabled', false);
		//$('#btnMasterModify').attr('disabled', false);
		//$('#btnDetailNew').attr('disabled', true);
		$('#btnDetailSave').attr('disabled', true);
		break;
	}
}

//상세코드 상세정보 폼속성 변경
function setDetailDetailInfo(status){
	
	switch(status){
	case "init" :		//리스트 조회한 상태
		$('#detailCode').val('');
		$('#detailCodeName').val('');
		$('#detailOrderNum').val('');
		$('#detailDetailInfo').val('');
		$('#detailCode').attr('readonly', true);
		$('#detailCodeName').attr('readonly', true);
		$('#detailOrderNum').attr('readonly', true);
		$('#detailDetailInfo').attr('readonly', true);
		$('#detailCode').removeClass('detail_value_writable');
		$('#detailCodeName').removeClass('detail_value_writable');
		$('#detailOrderNum').removeClass('detail_value_writable');
		$('#detailDetailInfo').removeClass('detail_value_writable');
		$('#detailCode').addClass('detail_value_readonly');
		$('#detailCodeName').addClass('detail_value_readonly');
		$('#detailOrderNum').addClass('detail_value_readonly');
		$('#detailDetailInfo').addClass('detail_value_readonly');
		
		$("input[name=detailDeleteYn]").attr('checked', false);
		
		$('#btnDetailNew').attr('disabled', false);
		$('#btnDetailSave').attr('disabled', false);
		//$('#btnDetailModify').attr('disabled', true);
		break;
	case "new" :		//신규버튼 눌렀을 때
		if($('#masterCode').val() == ''){
			alert("<spring:message code='message.selectMasterCode' />");
			break;
		}
		$('#detailCode').val('');
		$('#detailCodeName').val('');
		$('#detailOrderNum').val('');
		$('#detailDetailInfo').val('');
		$('#detailCode').attr('readonly', false);
		$('#detailCodeName').attr('readonly', false);
		$('#detailOrderNum').attr('readonly', false);
		$('#detailDetailInfo').attr('readonly', false);
		$('#detailCode').removeClass('detail_value_readonly');
		$('#detailCodeName').removeClass('detail_value_readonly');
		$('#detailOrderNum').removeClass('detail_value_readonly');
		$('#detailDetailInfo').removeClass('detail_value_readonly');
		$('#detailCode').addClass('detail_value_writable');
		$('#detailCodeName').addClass('detail_value_writable');
		$('#detailOrderNum').addClass('detail_value_writable');
		$('#detailDetailInfo').addClass('detail_value_writable');
		$("input[name=detailDeleteYn]").attr('checked', false);
		
		$('#btnDetailNew').attr('disabled', true);
		$('#btnDetailSave').attr('disabled', false);
		//$('#btnDetailModify').attr('disabled', true);
		break;
	case "modify" :		//리스트에서 특정항목 선택했을 때
		$('#detailCode').attr('readonly', true);
		$('#detailCodeName').attr('readonly', false);
		$('#detailOrderNum').attr('readonly', false);
		$('#detailDetailInfo').attr('readonly', false);
		$('#detailCode').removeClass('detail_value_writable');
		$('#detailCodeName').removeClass('detail_value_readonly');
		$('#detailOrderNum').removeClass('detail_value_readonly');
		$('#detailDetailInfo').removeClass('detail_value_readonly');
		$('#detailCode').addClass('detail_value_readonly');
		$('#detailCodeName').addClass('detail_value_writable');
		$('#detailOrderNum').addClass('detail_value_writable');
		$('#detailDetailInfo').addClass('detail_value_writable');
		
		$("input[name=detailDeleteYn]").attr('checked', false);
		
		$('#btnDetailNew').attr('disabled', false);
		$('#btnDetailSave').attr('disabled', false);
		//$('#btnDetailModify').attr('disabled', false);
		break;
	}
}

</script>
</head>

<body style="margin:0px" bgcolor="#FFFFFF" >
<form:form  commandName="codeSearchVO" name="codeSearchVO" method="post">
<table align="left" width="1249px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
	<td>
		<table align="left" width="1198px" height="730px" cellpadding="0" cellspacing="0" border="0" >
<!-- 네비게이션 시작 -->
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_code.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
<!-- 네비게이션 끝 -->
		<tr valign="top">
			<td width="100%">
	<!-- 마스터코드 상세코드 좌우구분 시작 -->
			<table width="1198px" cellpadding="0" cellspacing="0" border="0">
			<tr valign="top">
		<!-- 마스터코드 -->
				<td width="604px">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<!-- 마스터코드 검색조건 -->
					<tr>
						<td style="padding:20px 0px 14px 14px">
							<table width="576px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
							<tr>
								<td>
									<table width="576px" cellpadding="0" cellspacing="0" border="0" >
									<tr valign="top" height="23px">
										<td>
											<table width="100%" height="23px" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td>
													<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="search_title">
													<tr>
														<td width=""></td>
													</tr>
													</table>
												</td>
												<td align="right"><img id=btnSearch class="button" src="<c:url value='/images/button/btn_search.gif' />" /></td>
											</tr>
											</table>
										</td>
									</tr>
									<tr valign="top">
										<td>
											<table width="576px" cellpadding="0" cellspacing="0" border="0" class="search_area">
											<tr height="15px">
												<td></td>
											</tr>
											<tr valign="top">
												<td>
													<table cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse">
													<tr>
														<td width="14px"></td>
														<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
														<td width="5px"></td>
														<td width="65px" class="search_condition"><spring:message code='code.name.mastercode' /></td>
														<td width="6px"></td>
														<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
														<td width="14px"></td>
														<td width="100px"><input type="text" id="masterCodeNameSrch" name="masterCodeNameSrch" maxlength="50" class="search_value" style="width:100px; " /></td>
														<td width="100px" style="padding-left:3px;"><input type="text" id="masterCodeSrch" name="masterCodeSrch" maxlength="5" class="search_value" style="width:70px; " /></td>
													</tr>
													</table>
												</td>
											</tr>
											<tr height="15px">
												<td></td>
											</tr>
											</table>
										</td>
									</tr>
									<tr valign="top" height="6px">
										<td>
											<table width="100%" height="6px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_shadow.gif' />">
											<tr>
												<td></td>
											</tr>
											</table>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
				<!-- 상세코드 가로경계1 -->
					<tr height="4px">
						<td>
							<table width="100%" height="100%" border="1px" class="screen_bar">
							<tr>
							<td>
							</td>
							</tr>	
							</table>
						</td>
					</tr>
				<!-- 마스터코드 리스트 -->
					<tr>
						<td style="padding:20px 0px 14px 14px">
							<iframe id="iframeMasterCodeList" name="iframeMasterCodeList" frameborder="0" style="width:576px; height:350px; border:none;" scrolling="no"></iframe>
						</td>
					</tr>
				<!-- 상세코드 가로경계2 -->
					<tr height="4px">
						<td>
							<table width="100%" height="100%" border="1px" class="screen_bar">
							<tr>
							<td>
							</td>
							</tr>	
							</table>
						</td>
					</tr>
				<!-- 마스터코드 상세 -->
					<tr>
						<td style="padding:20px 0px 14px 14px">
							<table width="576px" height="" cellpadding="0" cellspacing="0" border="0">
								<tr valign="top">
									<td>
										<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
										<tr>
											<td> </td>
										</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table width="576px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
										<tr>
											<td width="150px" class="detail_column"><spring:message code='code.name.mastercode' /></td>
											<td class="detail_description">
												<form:input path="masterCode" maxlength="5" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.mastercodename' /></td>
											<td class="detail_description">
												<form:input path="masterCodeName" maxlength="50" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.detailinfo' /></td>
											<td class="detail_description">
												<form:input path="masterDetailInfo" maxlength="100" cssClass="detail_value_readonly"  cssStyle="width:360px"  readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.deleteyn' /></td>
											<td class="detail_description">
												<form:checkbox path="masterDeleteYn" value="check" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"></td>
											<td class="detail_description">
												&nbsp;
											</td>
										</tr>
										</table>
									</td>
								</tr>
								<tr height="5px">
									<td/>
								</tr>
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td width="495px"> </td>
											<td width="42px"><img id="btnMasterNew" class="button" src="<c:url value='/images/button/btn_new.gif' />" /></td>
											<td width="39px"><img id="btnMasterSave" class="button" src="<c:url value='/images/button/btn_save.gif' />" /></td>
										</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td width="4px" height="100%" valign="top" >
					<table width="4px" height="720px" class="screen_bar">
						<tr>
						<td>
						</td>
						</tr>
					</table>
				</td>
		<!-- 상세코드 -->
				<td width="590px">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<!-- 상세코드 리스트 -->
					<tr>
						<td style="padding:20px 0px 14px 14px">
							<iframe id="iframeDetailCodeList" name="iframeDetailCodeList" frameborder="0" style="width:576px; height:471px; border:none;" scrolling="no"></iframe>
						</td>
					</tr>
				<!-- 상세코드 가로경계 -->
					<tr height="4px">
						<td>
							<table width="100%" height="100%" border="1px" class="screen_bar">
							<tr>
							<td>
							</td>
							</tr>	
							</table>
						</td>
					</tr>
				<!-- 상세코드 상세 -->
					<tr>
						<td style="padding:20px 0px 14px 14px">
							<table width="576px" height="" cellpadding="0" cellspacing="0" border="0">
								<tr valign="top">
									<td>
										<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
										<tr>
											<td> </td>
										</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table width="576px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
										<tr>
											<td width="150px" class="detail_column"><spring:message code='code.name.detailcode' /></td>
											<td class="detail_description">
												<form:input path="detailCode" maxlength="5" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.detailcodename' /></td>
											<td class="detail_description">
												<form:input path="detailCodeName" maxlength="200" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.ordernumber' /></td>
											<td class="detail_description">
												<form:input path="detailOrderNum" maxlength="2" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.detailinfo' /></td>
											<td class="detail_description">
												<form:input path="detailDetailInfo" maxlength="100" cssClass="detail_value_readonly"  cssStyle="width:360px" readonly="true" />
											</td>
										</tr>
										<tr>
											<td class="detail_column"><spring:message code='code.name.deleteyn' /></td>
											<td class="detail_description">
												<form:checkbox path="detailDeleteYn" value="check" />
											</td>
										</tr>
										</table>
									</td>
								</tr>
								<tr height="5px">
									<td/>
								</tr>
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td width="495px"> </td>
											<td width="42px"><img id="btnDetailNew" class="button" src="<c:url value='/images/button/btn_new.gif' />" /></td>
											<td width="39px"><img id="btnDetailSave" class="button" src="<c:url value='/images/button/btn_save.gif' />" /></td>
										</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
	<!-- 마스터코드 상세코드 좌우구분 끝 -->	
		</td>
		</tr>
		</table>
	</td>
</tr>
</table>
</form:form>
</body>
</html>
