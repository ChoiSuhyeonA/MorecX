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

function init(){
	<% /* 권한체크 */ %>
	fn_check_goodcallauth();
	if("${sessionScope.zirecx_id}" != "admin") {
		fn_check_private();
	} else {
		$("#btn_userSearch").val("all");
	}
//	$("input:text[name=groupSeq]").val('<c:out value="${sessionScope.group_id}" />');
//	$("input:text[name=groupName]").val('<c:out value="${sessionScope.group_name}" />');
	document.getElementById("strStartDate").value = '<c:out value="${sessionScope.login_date}" />';
	document.getElementById("strEndDate").value = '<c:out value="${sessionScope.login_date}" />';
	document.getElementById("pagelist").value = 50;
	//searchList();
	explorerVer();
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
	// admin 이나 manager 권한이 아닐 경우에는 센터가 필수 입력값
	/* if("<c:out value="${sessionScope.user_id}"/>" != "1" && "<c:out value="${sessionScope.security_group_id}"/>" != "14") {
		if($("#schGroupName").val() == "" || $("#schGroupId").val() == "") {
			alert("센터를 선택해 주세요.");
			return false;
		}
	} */
	
	// admin 이나 manager 권한이 아닐 경우에는 센터가 필수 입력값 
	if("<c:out value="${sessionScope.user_id}"/>" != "1" && "<c:out value="${sessionScope.security_group_id}"/>" != "14") {

		if(($("#schGroupName").val() == "" || $("#schGroupId").val() == "")) {
			//groupUp 권한이 아니며  schGroupName 이 공백일 경우 
			if($("#btn_groupSearch").val() != "groupUp" && $("#btn_groupTree").val() != "groupUp") {
				alert("센터를 선택해 주세요.");
				return false;	
			} 
		}
	}
	
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
	var timepin, datepin;
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
	document.getElementById("refstrStartDate").value = document.getElementById("strStartDate").value;
	document.getElementById("refstrEndDate").value = document.getElementById("strEndDate").value;
	
	document.getElementById("totalCount").value = 0;
	
	$("#recordPenVO").attr("target","iframeLinkCallList");
	$("#recordPenVO").attr("action","<c:url value='/record/linkPenCallManageList.do'/>");
	$("#recordPenVO").submit();
}

<% /* 선택된 엑셀파일 다운로드 */ %>
function linkCallListCheckExcelDownload(){
	$("#recordPenVO").attr("target","iframeDown");
	$("#recordPenVO").attr("action","<c:url value='/record/linkPenCallManageCheckExcelList.do'/>");
	$("#recordPenVO").submit();
}

<% /* 선택된 녹취파일 다운로드 */ %>
function recordListCheckFileDownload(){
	$("#recordPenVO").attr("target","iframeDown");
	$("#recordPenVO").attr("action","<c:url value='/record/fileDownloadPen.do'/>");
	$("#recordPenVO").submit();
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

function onlyNumberInput(){ 
 	var code = window.event.keyCode;
	if ((code > 34 && code < 41) || (code > 47 && code < 58) || (code > 95 && code < 106) || code == 8 || code == 9 || code == 13 || code == 46){ 
		window.event.returnValue = true; 
		return; 
	} 	
	window.event.returnValue = false; 
} 

<% /* 검색조건 항목에 따른 value 제한 - 현재 검색조건의 항목 확인 및 value 초기화  */ %>
function selectNumChk(obj){ 
 	document.getElementById("selectNumCheck").value = obj.value;
 	document.getElementById("searchKeyword").value = "";
} 

function selectVisitType(obj) {
	if(obj.value == ""){
		//document.getElementById("visitPlace").setAttribute("disabled","disabled");
		$("#visitPlace").prop("readonly", true);
		document.getElementById("visitPlace").value = "전체";
		return;
	} else if(obj.value == "실거주지" || obj.value == "등복" || obj.value == "직장") {
		//document.getElementById("visitPlace").setAttribute("disabled","disabled");
		$("#visitPlace").prop("readonly", true);
		document.getElementById("visitPlace").value = obj.value;
	} else {
		document.getElementById("visitPlace").value = "";
		//document.getElementById("visitPlace").removeAttribute("disabled");
		$("#visitPlace").prop("readonly", false);
	} 
}

<% /* 검색조건 항목에 따른 value 제한 - 고객명이 아닐경우 숫자만 허용 */ %>
function numOrWordChk(){ 
 	if(document.getElementById("selectNumCheck").value != "CUSTOMER_NAME"){
 		onlyNumberInput();
 	}
} 

<% /* 정렬*/ %>
function orderByField(field){
	iframeLinkCallList.orderByField(field);
}


function checkAll(){
	iframeLinkCallList.checkAll();
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
	var timepin, datepin;
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
		
		$("#recordPenVO").attr("target","iframeLinkCallList");
	   	$("#recordPenVO").attr("action","<c:url value='/record/linkPenCallManageList.do'/>");
	   	$("#recordPenVO").submit();
	}
}

<% /* 새로고침시에 사용할 이전 검색값 세팅  */ %>
function historySave(){
	document.getElementById("refgroupSeq").value = document.getElementById("schGroupId").value;
	document.getElementById("refuserId").value = document.getElementById("schUserZirecxId").value;
	//document.getElementById("refsearchKeyword").value = document.getElementById("searchKeyword").value;
	document.getElementById("refstrStartDate").value = document.getElementById("strStartDate").value;
	document.getElementById("refstrEndDate").value = document.getElementById("strEndDate").value;
}

<% /* 새로고침 */ %>
function refreshList(){
	if(document.getElementById("btn_search").disabled == true){
		return false;
	}

	var timepin, datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;

	datepin = validation(strStartDate, strEndDate);

	if(datepin == false){
		return false;
	}
	
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	
	$("#recordPenVO").attr("target","iframeLinkCallList");
   	$("#recordPenVO").attr("action","<c:url value='/record/linkPenCallRefreshList.do'/>");
   	$("#recordPenVO").submit();
}

<% /* 페이징 */ %>
function page_first() {
	var timepin, datepin;
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
	var timepin, datepin;
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
	var timepin, datepin;
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
	var timepin, datepin;
	var strStartDate = document.getElementById("strStartDate").value;
	var strEndDate = document.getElementById("strEndDate").value;
	datepin = validation(strStartDate, strEndDate);
	
	if(datepin == false){
		return false;
	}
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	fn_record_list_pinpage();
}

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
		arrPriv[i] = new Array(3);
		arrPriv[i][0] = arrPrivTemp[i].split(",")[0];
		arrPriv[i][1] = arrPrivTemp[i].split(",")[1];
		arrPriv[i][2] = arrPrivTemp[i].split(",")[2];
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
					
						if(arrPriv[y][2] == "그룹") {
							$("#schGroupName").val("${sessionScope.group_name}");
							$("#schGroupId").val("${sessionScope.group_id}");
						}
					} 

					else if("${result.scope}" == "groupUp") {			
						$("#btn_groupSearch").val("groupUp");	
					 	//추가
					 	$("#btn_groupTree").val("groupUp");
						if(arrPriv[y][2] == "그룹") {
							$("#schGroupName").val("${sessionScope.group_name}");
							$("#schGroupId").val("${sessionScope.group_id}");
						}
					} 
					
					else if("${result.scope}" == "all") {		// all
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
					} 
					/** 김해동 테스트 */
					else if("${result.scope}" == "groupUp") {			// group
						$("#btn_userSearch").val("groupUp");
					}
					else if("${result.scope}" == "all") {		// all
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


function fn_convert(){
	var logoutPop="../common/fileCvtPop.do";
	//var popLogout = window.open(logoutPop,'','top=40%, left=40%, width=300px, height=150px, menubar=no, toolbar=no, location=no, status=yes, scrollbars=no');
	var arrValue = centerPop("350", document.getElementById('explorerVer').value);
	
	var winSearchBranch = window.showModalDialog(logoutPop, "", 'dialogWidth:350px; dialogHeight:'+document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
	

}

function fn_upload(){
	var logoutPop="../common/uploadPenRec.do";
	var popLogout = window.open(logoutPop,'','top=40%, left=40%, width=550px, height=550px, menubar=no, toolbar=no, location=no, status=yes, scrollbars=no');
	//var arrValue = centerPop("350", document.getElementById('explorerVer').value);

	//var winSearchBranch = window.showModalDialog(logoutPop, "", 'dialogWidth:350px; dialogHeight:'+document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
}


//브라우져의 버젼을 알아내어 팝업의 크기를 결정함.
function explorerVer(){
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	 var br_index = br_version.indexOf('MSIE');
	 //MSIE 포함한 브라우저 버전명
	 var br_info = br_version.substr(br_index,8);
	 //브라우저버전
	 var br_info_num = br_info.substr(5,2);
  
	if(br_info_num >= 8){
		document.getElementById("explorerVer").value = "350";
	}else if(br_info_num <= 7){
		document.getElementById("explorerVer").value = "397";	
	}
}
</script>
<style type="text/css">
.ui-widget-header { border: 1px solid #aaaaaa; 
background: #5ebbd9 url(images/ui-bg_highlight-soft_75_5ebbd9_1x100.png) 
50% 50% repeat-x; color: #5ebbd9; font-weight: bold; }
</style>
</head>
<body style="margin:0px" bgcolor="#FFFFFF" onload="init();">

<%-- <object ID="ZiPhonePlayer" CLASSID="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" 
codebase="<c:url value='/cabfiles/ZiPhonePlayer.cab' />#version=2,1,2,26" 
style="opacity:1;background-color:#000000;width:0px;height:0px; position: absolute; font-size:0px; top:-50px; border:none;">
</object> --%>
<!-- version up 2020.11.06 -->
<object ID="ZiPhonePlayer" CLASSID="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" 
codebase="<c:url value='/cabfiles/ZiPhonePlayer.cab' />#version=2,1,2,42" 
style="opacity:1;background-color:#000000;width:0px;height:0px; position: absolute; font-size:0px; top:-50px; border:none;">
</object>

<form:form  commandName="recordPenVO" id="recordPenVO" name="recordPenVO" method="post">
<input type="hidden" name="explorerVer" id="explorerVer" >
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
						<img height="33px" border="0px" src="<c:url value='/images/title/title_pen.gif' />" />
					</td>
					<td>
						<table style="display: none;" width="0px">
						<tr>
						<td width="0px">
							<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701" standby="Loading Microsoft?Windows?Media Player components..." type="application/x-oleobject">
							</object>
							</td>
						</tr>
						</table>
					</td>
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
								<input type="hidden" id="downloadcode" name="downloadcode" value="M"/>
								<input type="hidden" id="strGoodCallPolicy" name="strGoodCallPolicy" value=""/>
								<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
								<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="all"/>
								<input type="hidden" id="selectNumCheck" name="selectNumCheck" value=""/>
								
								<!-- 권한 페이지 분류로 인해 값 추가  -->
								<input type="hidden" id="pageType" value="record"/>
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
								<tr height="130px" valign="top">
									<td></td>
									<td>
										<table width="1170px" height="130px" cellpadding="0" cellspacing="0" border="0" class="search_area">
										<tr height="17px">
											<td colspan="3"></td>
										</tr>
										<tr valign="top">
											<td>
												<table width="" height="80px" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="" height="" cellpadding="0" cellspacing="0" border="0">
															<tr>
																<td width="10px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="60px" class="search_condition"><spring:message code='penrec.search.date' /></td>
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
	
																<td width="39px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="50px" class="search_condition"><spring:message code='penrec.search.place' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="75px" ><input type="text" id="schGroupName" name="schGroupName" class="search_value" maxlength="12" style="width:70px; "/></td>
																<td width="3px"></td>
																<td width="75px"><input type="text" id="schGroupId" name="schGroupId" class="search_value" maxlength="5" style="width:70px; " /></td>
																<td width="25px" align="center"><img id="btn_groupSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
																<td width="3px"></td>
																<td width="" ><img id="btn_groupTree" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
	                              								<td width="3px"></td>
																
																<td width="39px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="50px" class="search_condition"><spring:message code='penrec.search.counselor' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="75px" ><input type="text" id="schUserName" name="schUserName" class="search_value" maxlength="10" style="width:70px; "/></td>
																<td width="3px"></td>
																<td width="75px"><input type="text" id="schUserZirecxId" name="schUserZirecxId" class="search_value" maxlength="10" style="width:70px; " /></td>
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
																<td width="60px" class="search_condition"><spring:message code='penrec.search.customernumber' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="206px" align="left"><input type="text" id="phoneNumber" name="phoneNumber" class="search_value" maxlength="11" style="width:200px; " value="" /></td>
																
																<td width="39px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="50px" class="search_condition"><spring:message code='penrec.search.customername' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="219px"><input type="text" id="customerName" name="customerName" class="search_value" maxlength="11" style="width:214px; " value="" /></td>
																
																<td width="39px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="50px" class="search_condition"><spring:message code='penrec.search.facetoface' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="" valign="middle">
																	<form:select path="faceToFace" class="search_condition_select" cssStyle="width:176px;"> <%-- onchange="selectNumChk(this)" > --%>
																		<form:option value="전체"></form:option>
																		<form:option value="본인"><spring:message code='penrec.option.myself' /></form:option>
																		<form:option value="부재"><spring:message code='penrec.option.absence' /></form:option>
																		<form:option value="가족"><spring:message code='penrec.option.family' /></form:option>
																		<form:option value="지인"><spring:message code='penrec.option.acquaintance' /></form:option>
																		<form:option value="기타"><spring:message code='penrec.option.guitar' /></form:option>
																	</form:select>
																</td>
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
																<td width="60px" class="search_condition"><spring:message code='penrec.search.visitingplace' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="104px" valign="middle">
																	<form:select path="visitType" class="search_condition_select" cssStyle="width:104px;" onchange="selectVisitType(this)" >
																		<form:option value=""><spring:message code='penrec.option.all' /></form:option>
																		<form:option value="실거주지"><spring:message code='penrec.option.live' /></form:option>
																		<form:option value="등본"><spring:message code='penrec.option.uniform' /></form:option>
																		<form:option value="직장"><spring:message code='penrec.option.job' /></form:option>
																		<form:option value="DIRECTINPUT"><spring:message code='penrec.option.directinput' /></form:option>
																	</form:select>
																</td>
																<td width="6px"></td>
																<td width="96px"><form:input path="visitPlace" readonly="true" class="search_value" maxlength="14" cssStyle="width:90px;" value="전체" /></td>

																<td width="39px"></td>
																<td width="5px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																<td width="5px"></td>
																<td width="50px" class="search_condition"><spring:message code='penrec.search.playlength' /></td>
																<td width="6px"></td>
																<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
																<td width="14px"></td>
																<td width="89px" align="center" style="font-size: 12px;"><input type="text" id="startPlayTime" name="startPlayTime" class="search_value" maxlength="8" style="width:89px;" value="0" /><spring:message code='penrec.search.second' /></td>
																<td width="20px" align="center"><img src="<c:url value='/images/icon/icon_period.gif' />" /></td>
																<td width="89px" style="font-size: 12px;"><input type="text" id="endPlayTime" name="endPlayTime" class="search_value" maxlength="8" style="width:89px;" value="0"/><spring:message code='penrec.search.second' /></td>
																<td colspan="16"></td>
															</tr>
														</table>
													</td>
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
							<td></td>
						</tr>
						<tr valign="top" height="520px">
							<td width="14px"></td>
							<td>
								<table width="1170px" height="520px" cellpadding="0" cellspacing="0" border="0" >
									<tr valign="top" height="23px">
										<td align="right">
											<table width="1170px" height="23px" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td  width="122px">
													<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
													<tr valign="top" height="23px">
														<td>&nbsp;</td>
													</tr>
													</table>
												</td>
												<td align="right" width="1508px">
													<table width="" height="23px" cellpadding="0" cellspacing="0" border="0" align="right">
													<tr height="20px">
							                            <td width="86px" id="btn_uploadRec" class="button" style="background-image: url('<c:url value='/images/button/rec_upload.gif' />'); background-repeat: no-repeat;" onclick="fn_upload();">
							                            </td>
                            							<%-- <td width="6px"></td>
														<td width="64px" id="btn_cvt" class="button" style="background-image: url('<c:url value='/images/button/btn_select_file_change.gif' />'); background-repeat: no-repeat;" onclick="fn_convert();">
														</td> --%>
														<td width="6px"></td>
														<td width="64px" id="btn_select_file_dnload" class="button" style="background-image: url('<c:url value='/images/button/btn_select_file_dnload.gif' />'); background-repeat: no-repeat;" onclick="recordListCheckFileDownload();">
														</td>
														<td width="6px"></td>
														<td width="64px" id="btn_select_excel" class="button" style="background-image: url('<c:url value='/images/button/btn_select_excel.gif' />'); background-repeat: no-repeat;" onclick="linkCallListCheckExcelDownload();">
														</td>
													</tr>
													</table>
												</td>
												<td></td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table width="1170px" cellpadding="0" cellspacing="0" border="0" style="border-bottom: 0px;">
												<tr height="27px">
													<td width="1153px">
														<div id="topTable" style="width:1153px; height:27px; overflow-x: hidden; ">
														<table width="1153px" cellpadding="0" cellspacing="0" border="1" style="border-bottom: 0;" class="list_table_box">
															<tr height="27px">
																<td width="30px" align="center" class="list_header">
																	<input type="checkbox" name="chkAll" id="chkAll" hidefocus="true" onclick="checkAll();"></input>
																</td>
																<td width="50px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.number' />
																</td>
																<td width="30px" align="center" class="list_header">
																	<spring:message code='linkCall.name.column.play' />
																</td>
																<td width="50px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.gubun' />
																</td>
																<td width="60px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.counselor' />
																</td>
																<td width="80px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.customernumber' />
																</td>
																<td width="80px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.customername' />
																</td>
																<td width="45px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.facetoface' />
																</td>
																<td width="100px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.visitingplace' />
																</td>
																<td width="120px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.date' />
																</td>
																<td width="80px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.visitdateclass' />
																</td>
																<td width="80px" align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.playlength'/>
																</td>
																<td align="center" class="list_header">
																	<spring:message code='linkpenrec.name.column.uploaddate'/>
																</td>
															</tr>
															</table>
															</div>
														</td>
														<td width="17px">
														<div style="width:17px; height:27px; overflow-x: hidden; ">
															<table width="17px" cellpadding="0" cellspacing="0" border="0" class="list_table_box">
																<tr>
																	<td width="17px" align="center" class="list_header">
																	</td>
																</tr>
															</table>
														</div>
														</td>
													</tr>
												</table>
											<iframe id="iframeLinkCallList" name="iframeLinkCallList" frameborder="0" style="width: 1170px; height: 463px; border: none; overflow: hidden;"></iframe>
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