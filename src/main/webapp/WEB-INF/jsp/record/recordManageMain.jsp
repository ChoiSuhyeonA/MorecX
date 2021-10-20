<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src = "<c:url value='/jquery/js/authority.js' />"></script>
<script type="text/javascript">

//Session Check
checkSession("<c:out value="${sessionScope.user_id}"/>", "<spring:message code="message.logout_js" />", "<spring:message code="message.logout_js_retry" />");

<% /* 굿콜지정권한 */ %>
function fn_check_goodcallauth() {
	var arrPrivTemp = "${strPrivName}".split("|");
	var arrPriv = new Array(arrPrivTemp.length);
	for(var i=0; i<arrPrivTemp.length; i++) {
		arrPriv[i] = new Array(7);
		arrPriv[i][0] = arrPrivTemp[i].split(",")[0];
		arrPriv[i][1] = arrPrivTemp[i].split(",")[1];
		arrPriv[i][2] = arrPrivTemp[i].split(",")[2];
		arrPriv[i][3] = arrPrivTemp[i].split(",")[3];
		arrPriv[i][4] = arrPrivTemp[i].split(",")[4];
		arrPriv[i][5] = arrPrivTemp[i].split(",")[5];
		arrPriv[i][6] = arrPrivTemp[i].split(",")[6];
	}
	
	for(var y=0; y<arrPrivTemp.length; y++) {
		<c:forEach var='result' items='${listPrivate}' varStatus='status'>
			if("${result.name}" == arrPriv[y][0]) {
				if(arrPriv[y][2] == "굿콜지정") {
					document.getElementById("strGoodCallPolicy").value = "${result.securitygroupId}";
				}
				
			}
		</c:forEach>
	}
}

<% /* 권한 (공통) */ %>
function fn_check_private() {
	var arrPrivTemp = "${strPrivName}".split("|");
	var arrPriv = new Array(arrPrivTemp.length);
	for(var i=0; i<arrPrivTemp.length; i++) {
		arrPriv[i] = new Array(7);
		arrPriv[i][0] = arrPrivTemp[i].split(",")[0];
		arrPriv[i][1] = arrPrivTemp[i].split(",")[1];
		arrPriv[i][2] = arrPrivTemp[i].split(",")[2];
		arrPriv[i][3] = arrPrivTemp[i].split(",")[3];
		arrPriv[i][4] = arrPrivTemp[i].split(",")[4];
		arrPriv[i][5] = arrPrivTemp[i].split(",")[5];
		arrPriv[i][6] = arrPrivTemp[i].split(",")[6];
	}
	
	for(var y=0; y<arrPrivTemp.length; y++) {
		<c:forEach var='result' items='${listPrivate}' varStatus='status'>
			if("${result.name}" == arrPriv[y][0]) {
				
				if(arrPriv[y][2] == "버튼") {
					if("${sessionScope.security_group_id}" == "${result.securitygroupId}") {
						$("#"+arrPriv[y][1]).show();
					} else {
						$("#"+arrPriv[y][1]).hide();
					}
				}
				
				if(arrPriv[y][2] == "그룹" || arrPriv[y][2] == "그룹트리") {
					if(arrPriv[y][2] == "그룹"){
						$("#hidAccessPolicy").val("${result.scope}");
					}
				
					if("${result.scope}" == "group") {			// group
						$("#btn_groupSearch").val("group");
					} else if("${result.scope}" == "all") {		// all
						$("#btn_groupSearch").val("all");
					} else {									// own
						$("#btn_groupSearch").val("own");
					
						if(arrPriv[y][2] == "그룹") {
							$("#schGroupName").val("${sessionScope.group_name}");
							$("#schGroupId").val("${sessionScope.group_id}");
							$("#schGroupName").attr("readOnly", true);
							$("#schGroupId").attr("readOnly", true);
							$("#schGroupName").attr("class", "search_value_readonly");
							$("#schGroupId").attr("class", "search_value_readonly");
						}
					}
				}
				
				if(arrPriv[y][2] == "사용자") {
					if("${result.scope}" == "group") {			// group
						$("#btn_userSearch").val("group");
					} else if("${result.scope}" == "all") {		// all
						$("#btn_userSearch").val("all");
					} else {									// own
						$("#btn_userSearch").val("own");
						
						$("#schUserName").val("${sessionScope.user_name}");
						$("#schUserZirecxId").val("${sessionScope.zirecx_id}");
						$("#schUserName").attr("readOnly", true);
						$("#schUserZirecxId").attr("readOnly", true);
						$("#schUserName").attr("class", "search_value_readonly");
						$("#schUserZirecxId").attr("class", "search_value_readonly");
					}
				}
				
				if(arrPriv[y][2] == "엑셀다운") {
					<% /* EXCEL(선택) 권한 */ %>
					privTopButton("<c:out value="${sessionScope.security_group_id}"/>", "${result.securitygroupId}", "btn_select_excel");
				}
					
				if(arrPriv[y][2] == "파일다운") {
					<% /* 녹취다운(선택) 권한 */ %>
					privTopButton("<c:out value="${sessionScope.security_group_id}"/>", "${result.securitygroupId}", "btn_select_file_dnload");
				}
			}
		</c:forEach>
	}
}

function init(){
	<% /* 권한체크 */ %>
	fn_check_goodcallauth();
	if("${sessionScope.zirecx_id}" != "admin") {
		fn_check_private();
	}
//	$("input:text[name=groupSeq]").val('<c:out value="${sessionScope.group_id}" />');
//	$("input:text[name=groupName]").val('<c:out value="${sessionScope.group_name}" />');
	document.getElementById("strStartDate").value = '<c:out value="${sessionScope.login_date}" />';
	document.getElementById("strEndDate").value = '<c:out value="${sessionScope.login_date}" />';
	document.getElementById("pagelist").value = 50;
	searchList();
}

$(function(){

	var clareCalendar = {
			monthNamesShort: ['<spring:message code='calendar.month.jan' />','<spring:message code='calendar.month.feb' />','<spring:message code='calendar.month.mar' />','<spring:message code='calendar.month.apr' />','<spring:message code='calendar.month.may' />','<spring:message code='calendar.month.jun' />','<spring:message code='calendar.month.jul' />','<spring:message code='calendar.month.aug' />','<spring:message code='calendar.month.sep' />','<spring:message code='calendar.month.oct' />','<spring:message code='calendar.month.nov' />','<spring:message code='calendar.month.dec' />'],
			dayNamesMin: ['<spring:message code='calendar.week.sun' />','<spring:message code='calendar.week.mon' />','<spring:message code='calendar.week.tue' />','<spring:message code='calendar.week.wed' />','<spring:message code='calendar.week.thu' />','<spring:message code='calendar.week.fri' />','<spring:message code='calendar.week.sat' />'],
			weekHeader: 'Wk',
			dateFormat: 'yy-mm-dd',
			autoSize: false,
			changeMonth: true,
			changeYear: true,
			showMonthAfterYear: true,
			showAnim: "slide", 
			buttonImageOnly: false
		};
		$("#strStartDate").datepicker(clareCalendar);
		$("#strEndDate").datepicker(clareCalendar);
		$("#ui-datepicker-div").hide();
});
function calendarPickerFrom(){
	$("#strStartDate").focus();
}
function calendarPickerTo(){
	$("#strEndDate").focus();
}

function searchList(){
	if ($("#schGroupName").val() != ""){
		if($("#schGroupId").val() == ""){
			alert("센터 선택이 제대로 되지 않았습니다.");
			return false;
		}
	}
	
	if ($("#schGroupId").val() != ""){
		if($("#schGroupName").val() == ""){
			alert("센터 선택이 제대로 되지 않았습니다.");
			return false;
		}
	}
	
	if ($("#schUserName").val() != ""){
		if($("#schUserZirecxId").val() == ""){
			alert("사용자 선택이 제대로 되지 않았습니다.");
			return false;
		}
	}
	
	if ($("#schUserZirecxId").val() != ""){
		if($("#schUserName").val() == ""){
			alert("사용자 선택이 제대로 되지 않았습니다.");
			return false;
		}
	}
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	document.getElementById("selectedRecId").value = "";
	$("input:text[name=nowpage]").val("1");
	$("input:hidden[name=pageIndex]").val("1");

	document.getElementById("orderField").value = "";
	document.getElementById("orderType").value = "";
	
	//새로고침을 위해 지난 검색정보 챙겨두기.
	document.getElementById("refgroupSeq").value = document.getElementById("schGroupId").value;
	document.getElementById("refuserId").value = document.getElementById("schUserZirecxId").value;
	document.getElementById("refsearchKeyword").value = document.getElementById("searchKeyword").value;
	document.getElementById("refstrStartDate").value = document.getElementById("strStartDate").value;
	document.getElementById("refstrEndDate").value = document.getElementById("strEndDate").value;
	
	document.getElementById("totalCount").value = 0;
	
	$("#recordSearchVO").attr("target","iframeRecordList");
	$("#recordSearchVO").attr("action","<c:url value='/record/recordManageList.do'/>");
	$("#recordSearchVO").submit();
}

<% /* 선택된 엑셀파일 다운로드 */ %>
function recordListCheckExcelDownload(){
	$("#recordSearchVO").attr("target","iframeDown");
	$("#recordSearchVO").attr("action","<c:url value='/record/recordManageCheckExcelList.do'/>");
	$("#recordSearchVO").submit();
}

<% /* 선택된 녹취파일 다운로드 */ %>
function recordListCheckFileDownload(){
	$("#recordSearchVO").attr("target","iframeDown");
	$("#recordSearchVO").attr("action","<c:url value='/record/fileDownload.do'/>");
	$("#recordSearchVO").submit();
}

function validation(startDate, endDate){
	if (startDate > endDate){
		alert("<spring:message code='linkCall.message.dateOrder' />");
		return false;
	}
	if (getDateInterval(startDate, endDate) < -30){
		alert("<spring:message code='linkCall.message.periodLimit' />" + "<spring:message code='linkCall.message.periodLimitPoint' />") ;
		return false;
	}
	return true;
}

<% /* 숫자만 입력 */ %>
function onlyNumberInput(){ 
 	var code = window.event.keyCode;
	if ((code > 34 && code < 41) || (code > 47 && code < 58) || (code > 95 && code < 106) || code == 8 || code == 9 || code == 13 || code == 46){ 
		window.event.returnValue = true; 
		return; 
	} 	
	window.event.returnValue = false; 
} 

<% /* 정렬 */ %>
function orderByField(field){
	top.mainFrame.iframeRecordList.orderByField(field);
}


function checkAll(){
	top.mainFrame.iframeRecordList.checkAll();
}

<% /* 페이지 바로가기 */ %>
function fn_record_list_pinpage(){
	var pin = document.getElementById("maxPage").innerHTML*1;
	if(pin<document.getElementById("nowpage").value){
		alert("페이지가 존재하지 않습니다.");
		return false;
	}
	if(document.getElementById("btn_search").disabled == true){
		return false;
	}
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	
	var pageNo = getOnlyNumber(document.getElementById("nowpage").value);
	if(pageNo == ""){
		document.getElementById("nowpage").value = "";
		alert("원하시는 페이지를 입력해주십시오.");
	}else if(pageNo == 0){
		document.getElementById("nowpage").value = "";
		alert("원하시는 페이지를 입력해주십시오.");
	}else{
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
		document.getElementById("btn_search").disabled = true;
		
		document.getElementById("pageIndex").value = pageNo;
		document.getElementById("nowpage").value = pageNo;
		
		historySave();
		
		$("#recordSearchVO").attr("target","iframeRecordList");
	   	$("#recordSearchVO").attr("action","<c:url value='/record/recordManageList.do'/>");
	   	$("#recordSearchVO").submit();
	}
}

<% /* 새로고침시에 사용할 이전 검색값 세팅  */ %>
function historySave(){
	document.getElementById("refgroupSeq").value = document.getElementById("schGroupId").value;
	document.getElementById("refuserId").value = document.getElementById("schUserZirecxId").value;
	document.getElementById("refsearchKeyword").value = document.getElementById("searchKeyword").value;
	document.getElementById("refstrStartDate").value = document.getElementById("strStartDate").value;
	document.getElementById("refstrEndDate").value = document.getElementById("strEndDate").value;
}

<% /* 새로고침 */ %>
function refreshList(){
	if(document.getElementById("btn_search").disabled == true){
		return false;
	}

	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	
	$("#recordSearchVO").attr("target","iframeRecordList");
   	$("#recordSearchVO").attr("action","<c:url value='/record/recordrefreshList.do'/>");
   	$("#recordSearchVO").submit();
}

<% /* 페이징 */ %>
function page_first() {
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	document.getElementById("nowpage").value = 1;
	fn_record_list_pinpage();
}

function page_previous() {
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	var pin = parseInt(document.getElementById("nowpage").value);
	if(1 < pin){
		document.getElementById("nowpage").value = pin - 1;
		fn_record_list_pinpage();
	}else{
		
	}
}

function page_next() {
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	var pin = parseInt(document.getElementById("nowpage").value);
	var max = parseInt(document.getElementById("maxPageCheck").value);
	if(pin < max){
		document.getElementById("nowpage").value = (pin + 1);
		fn_record_list_pinpage();
	}else{
		
	}
}

function page_last() {
	var datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	fn_record_list_pinpage();
}
</script>
<style type="text/css">
.ui-widget-header { border: 1px solid #aaaaaa; 
background: #5ebbd9 url(images/ui-bg_highlight-soft_75_5ebbd9_1x100.png) 
50% 50% repeat-x; color: #5ebbd9; font-weight: bold; }
</style>

</head>
<body style="margin:0px" bgcolor="#FFFFFF" onload="init();">
<form:form  commandName="recordSearchVO" id="recordSearchVO" name="recordSearchVO" method="post">
<table align="left" width="1249px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
		<%@ include file="../common/popUpFunction.jsp" %>
	<td>
		<table align="left" width="1198px" height="730px" cellpadding="0" cellspacing="0" border="0" >
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_listen.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr height="100%" valign="top">
			<td width="1198px">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td>
						<table width="1198px" height="156px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td>
								<form:hidden path="pageIndex" />
								<form:hidden path="userSeq" />
								<form:hidden path="auth" />
								<form:hidden path="orderField" />
								<form:hidden path="orderType" />
								<input type="hidden" id="selectedRecId" name="selectedRecId" value=""/>
								<input type="hidden" id="refgroupSeq" name="refgroupSeq" value=""/>
								<input type="hidden" id="refuserId" name="refuserId" value=""/>
								<input type="hidden" id="refsearchKeyword" name="refsearchKeyword" value=""/>
								<input type="hidden" id="refstrStartDate" name="refstrStartDate" value=""/>
								<input type="hidden" id="refstrEndDate" name="refstrEndDate" value=""/>
								
								<input type="hidden" id="refstrStartTime" name="refstrStartTime" value=""/>
								<input type="hidden" id="refstrEndTime" name="refstrEndTime" value=""/>
								<input type="hidden" id="refcallresult" name="refcallresult" value=""/>
								<input type="hidden" id="refcampaign" name="refcampaign" value=""/>
								
								<input type="hidden" id="maxPageCheck" name="maxPageCheck" value=""/>
								<input type="hidden" id="downloadcode" name="downloadcode" value="Z"/>
								<input type="hidden" id="strGoodCallPolicy" name="strGoodCallPolicy" value=""/>
								<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
								<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="all"/>
							</td>
						</tr>
						<tr valign="top">
							<td>
								<table width="1198px" height="100%" cellpadding="0" cellspacing="0" border="0">
								<tr valign="top" height="23px">
									<td width="14px"></td>
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
											<td align="right"><img id="btn_search" class="button" src="<c:url value='/images/button/btn_search.gif' />" onclick="javascript:searchList();"/></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr height="92px" valign="top">
									<td></td>
									<td>
										<table width="1170px" height="92px" cellpadding="0" cellspacing="0" border="0" class="search_area">
										<tr height="17px">
											<td colspan="3"></td>
										</tr>
										<tr valign="top">
											<td>
												<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="" height="" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="10px"></td>
															<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='record.search.calldate' /></td>
															<td width="6px"></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="75px" ><input type="text" id="strStartDate" name="strStartDate" class="search_value" style="width:70px; " readonly="readonly"/></td>
															<td width="3px"></td>
															<td width="14px" align="right"><img class="button" src="<c:url value='/images/icon/icon_calendar.gif' />" onclick="calendarPickerFrom();"/></td>
															<td width="20px" align="center"><img src="<c:url value='/images/icon/icon_period.gif' />" /></td>
															<td width="75px"><input type="text" id="strEndDate" name="strEndDate" class="search_value"  style="width:70px; " readonly="readonly"/></td>
															<td width="3px"></td>
															<td width="16px" align="center"><img class="button" src="<c:url value='/images/icon/icon_calendar.gif' />" onclick="calendarPickerTo();"/></td>
															
															<td width="60px"></td>
															<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='record.search.group' /></td>
															<td width="6px"></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="75px" ><input type="text" id="schGroupName" name="schGroupName" maxlength="12" class="search_value" style="width:70px; "/></td>
															<td width="3px"></td>
															<td width="75px"><input type="text" id="schGroupId" name="schGroupId" class="search_value" maxlength="5"  style="width:70px; " /></td>
															<td width="25px" align="center"><img id="btn_groupSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
															<td width="3px"></td>
															<td width="" ><img id="btn_groupTree" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
															
															<td width="107px"></td>
															<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='record.search.user' /></td>
															<td width="6px"></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="75px" ><input type="text" id="schUserName" name="schUserName" class="search_value" maxlength="10" style="width:70px; "/></td>
															<td width="3px"></td>
															<td width="75px"><input type="text" id="schUserZirecxId" name="schUserZirecxId" class="search_value" maxlength="10"  style="width:70px; " /></td>
															<td width="25px" align="center"><img id="btn_userSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />"/></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr height="14px">
													<td></td>
												</tr>
												<tr>
													<td>
														<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="10px"></td>
															<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='record.search.condition' /></td>
															<td width="6px"></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="100px" valign="middle">
																<form:select path="searchCondition" class="search_condition_select" cssStyle="width:100px;">
																	<form:option value="CUST_PHONE_NO"><spring:message code='record.option.custphone' /></form:option>
																</form:select>
															</td>
															<td width="3px"></td>
															<td width="98px"><form:input path="searchKeyword"  class="search_value" maxlength="14" cssStyle="width:98px;" onkeydown="onlyNumberInput();" /></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr height="17px">
													<td></td>
												</tr>
												</table>
											</td>
											<td></td>
											<td width="10px"></td>
										</tr>
										</table>
									</td>
									<td width="14px"></td>
								</tr>
								<tr valign="top" height="6px">
									<td></td>
									<td>
										<table width="100%" height="6px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_shadow.gif' />">
										<tr>
											<td></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
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
				<tr>
					<td>
						<table width="1198px" height="540px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td>&nbsp;</td>
						</tr>
						<tr valign="top" height="520px">
							<td width="14px"></td>
							<td>
								<table width="1170px" height="520px" cellpadding="0" cellspacing="0" border="0" >
									<tr valign="top" height="23px">
										<td>
											<table width="1170px" height="23px" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td>
													<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
													<tr height="23px">
														<td></td>
													</tr>
													</table>
												</td>
												<td align="right">
													<table width="134px" height="23px" cellpadding="0" cellspacing="0" border="0" align="right">
													<tr height="20px">
														<td width="64px" id="btn_select_file_dnload" class="button" style="background-image: url('<c:url value='/images/button/btn_select_file_dnload.gif' />'); background-repeat: no-repeat;" onclick="recordListCheckFileDownload();">
														</td>
														<td width="6px"></td>
														<td width="64px" id="btn_select_excel" class="button" style="background-image: url('<c:url value='/images/button/btn_select_excel.gif' />'); background-repeat: no-repeat;" onclick="recordListCheckExcelDownload();">
														</td>
													</tr>
													</table>
												</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table width="1170px" cellpadding="0" cellspacing="0" border="1" style="border-bottom: 0;" class="list_table_box">
											<tr height="27px">
												<td width="30px" align="center" class="list_header">
													<input type="checkbox" name="chkAll" id="chkAll" hidefocus="true" onclick="checkAll();"></input>
												</td>
												<td width="50px" align="center" class="list_header">
													<spring:message code='record.name.column.number' />
												</td>
												<td width="30px" align="center" class="list_header">
													<spring:message code='record.name.column.play' />
												</td>
												<td width="30px" align="center" class="list_header">
													<spring:message code='record.name.column.goodcall' />
												</td>
												<td align="center" class="list_header">
													<spring:message code='record.name.column.groupname' />
												</td>
												<td  width="100px" align="center" class="list_header">
													<spring:message code='record.name.column.username' />
												</td>
												<td width="100px" align="center" class="list_header">
													<spring:message code='record.name.column.userid' />
												</td>
												<td width="100px" align="center" class="list_header">
													<spring:message code='record.name.column.phonenumber' />
												</td>
												<td width="50px" align="center" class="list_header">
													<spring:message code='record.name.column.sendreceive' />
												</td>
												<td width="100px" align="center" class="list_header">
													<spring:message code='record.name.column.custphonenumber' />
												</td>
												<td width="80px" style="cursor: pointer;" align="center" class="list_header" onclick="orderByField('ordertime');">
													<u><spring:message code='record.name.column.calldate' /></u>
												</td>
												<td width="100px" style="cursor: pointer;" align="center" class="list_header" onclick="orderByField('ordertime');">
													<u><spring:message code='record.name.column.callstarttime' /></u>
												</td>
												<td width="70px" style="cursor: pointer;" align="center" class="list_header" onclick="orderByField('duration');">
													<u><spring:message code='record.name.column.callduration' /></u>
												</td>
												<td width="17px" class="list_header">
													
												</td>
											</tr>
											</table>
											<iframe id="iframeRecordList" name="iframeRecordList" frameborder="0" style="width: 1170px; height: 463px; border: none; overflow-y: scroll; "></iframe>
											<iframe id="iframeDown" name="iframeDown" frameborder="0" style="border: none; display: none;" scrolling="no"></iframe>
										</td>
									</tr>
									<tr height="5px">
										<td colspan="2"></td>
									</tr>
									<tr>
										<td>
											<table width="1170px" height="29px" cellpadding="0" cellspacing="0" border="0" class="paging_table_box">
											<tr>
												<td width="15px"></td>
												<td width="10px"><img id="btn_first" style="cursor: pointer;" src="<c:url value='/images/button/btn_first.gif' />" onclick="page_first();" /></td>
												<td width="5px"></td>
												<td width="6px"><img id="btn_previous" style="cursor: pointer;" src="<c:url value='/images/button/btn_previous.gif' />" onclick="page_previous();"/></td>
												<td width="10px"></td>
												<td width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="40px">페이지</td>
												<td width="25px"><input id="nowpage" name="nowpage" type="text" value="1" style="width:20px; height:13px" class="detail_value_writable" onkeyup="javascript : if(event.keyCode == 13) fn_record_list_pinpage();" onkeydown="onlyNumberInput();"></td>
												<td width="3px"></td>
												<td>/</td>
												<td width="20px"><span style="text-align: left;" id="maxPage">0</span></td>
												<td width="5px"></td>
												<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="6px"><img id="btn_next" style="cursor: pointer;" src="<c:url value='/images/button/btn_next.gif' />" onclick="page_next();"/></td>
												<td width="5px"></td>
												<td width="10px"><img id="btn_last" style="cursor: pointer;" src="<c:url value='/images/button/btn_last.gif' />" onclick="page_last();"/></td>
												<td width="10px"></td>
												<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="13px"><img id="btn_refresh" style="cursor: pointer;" src="<c:url value='/images/button/btn_refresh.gif' />" onclick="refreshList();"/></td>
												<td width="10px"></td>
												<td><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="30px">표시</td>
												<td>
													<select id="pagelist" name="pagelist" onchange="javascript:searchList();">
														<option value="10">10</option>
														<option value="50">50</option>
														<option value="100">100</option>
														<option value="200">200</option>
													</select>
												</td>
												<td align="right"><span id="totalCount" >0</span>건&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
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
							<td width="14px"></td>
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
</form:form>
</body>
</html>