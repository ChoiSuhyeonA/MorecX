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

$(document).ready(function(){
	if("${sessionScope.zirecx_id}" != "admin") {
		fn_check_private();
	}
	
	document.getElementById("strStartDate").value = '<c:out value="${sessionScope.login_date}" />';
	
	$('#btn_search').click(function(){ 
		$('#orderKey').val(''); 
		searchList(); 
	});
	$('#btn_excel').click( searchReportListExcel );
	
	$('#imgCalendarStart').click(function(){ calendarPickerFrom(); });
	
	$("#onlyRealUser").prop('checked', true);
	fnc_init();
});

function fnc_init(){
	$("#reportSearchDurationVO").attr("target","iframeReportList");
	$("#reportSearchDurationVO").attr("action","<c:url value='/report/linkageReportDurationManageInitList.do'/>");
	$("#reportSearchDurationVO").submit();
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
		$("#ui-datepicker-div").hide();
});
function calendarPickerFrom(){
	$("#strStartDate").focus();
}

//조회중 버튼처리
function chngBtnSearch(bValue){
	if(bValue == 'start'){
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
		document.getElementById("btn_search").disabled = true;
	}else{
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
		document.getElementById("btn_search").disabled = false;
	}
}

function searchList(){
	// admin 이나 manager 권한이 아닐 경우에는 센터가 필수 입력값
	if("<c:out value="${sessionScope.user_id}"/>" != "1" && "<c:out value="${sessionScope.security_group_id}"/>" != "14") {
		if($("#schGroupName").val() == "" || $("#schGroupId").val() == "") {
			alert("센터를 선택해 주세요.");
			return false;
		}
	}
	
	chngBtnSearch('start');
	
	if($('#orderKey').val() == '')
		sortField('');
	$("#reportSearchDurationVO").attr("target","iframeReportList");
	$("#reportSearchDurationVO").attr("action","<c:url value='/report/linkageReportDurationManageList.do'/>");
	$("#reportSearchDurationVO").submit();
}

function searchReportListExcel(){
	// admin 이나 manager 권한이 아닐 경우에는 센터가 필수 입력값
	if("<c:out value="${sessionScope.user_id}"/>" != "1" && "<c:out value="${sessionScope.security_group_id}"/>" != "14") {
		if($("#schGroupName").val() == "" || $("#schGroupId").val() == "") {
			alert("센터를 선택해 주세요.");
			return false;
		}
	}
	
	if($('#orderKey').val() == '')
		sortField('');
	$("#reportSearchDurationVO").attr("target","iframeReportList");
	$("#reportSearchDurationVO").attr("action","<c:url value='/report/linkageReportDurationManageListExcel.do'/>");
	$("#reportSearchDurationVO").submit();
}

function sortField(field){
	
	if(field == ''){
		$("#orderType").val('ASC');
		var selSearchType = $('#selSearchType').val();
		
		if(selSearchType == 'user')
			$("#orderKey").val('usr.firstname');
		else if(selSearchType == 'group')
			$("#orderKey").val('dbo.usp_get_group_path(gtu.groupId)');
		else if(selSearchType == 'campaign')
			$("#orderKey").val('c.campaign_name');
		
	}else{
		if($("#orderKey").val() == field){
			if($("#orderType").val() == "DESC"){
				$("#orderType").val('ASC');
			}else{
				$("#orderType").val('DESC');
			}
		}else{
			$("#orderKey").val(field);
			$("#orderType").val('ASC');
		}
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
					privTopButton("<c:out value="${sessionScope.security_group_id}"/>", "${result.securitygroupId}", "btn_excel");
				}
			}
		</c:forEach>
	}
}
</script>
<style type="text/css">
.ui-widget-header { border: 1px solid #aaaaaa; 
background: #5ebbd9 url(images/ui-bg_highlight-soft_75_5ebbd9_1x100.png) 
50% 50% repeat-x; color: #5ebbd9; font-weight: bold; }
</style>
</head>
<body style="margin:0px" bgcolor="#FFFFFF" >
<form:form  commandName="reportSearchDurationVO" id="reportSearchDurationVO" name="reportSearchDurationVO" method="post">
<input type="hidden" id="orderKey" name="orderKey" value="" />
<input type="hidden" id="orderType" name="orderType" value="ASC" />
<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="all"/>
<table align="left" width="1260px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
	<%@ include file="../common/popUpFunction.jsp" %>
	<td>
		<table align="left" width="1198px" height="730px" cellpadding="0" cellspacing="0" border="0" >
<!-- 네비게이션 시작 -->
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_report_duration.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
<!-- 네비게이션 끝 -->
		<tr height="100%" valign="top">
			<td width="100%">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<!-- 검색조건 시작 -->
				<tr>
					<td>
						<table width="1198px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top">
							<td>
								<table width="1198px" cellpadding="0" cellspacing="0" border="0" >
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
											<td align="right"><img id="btn_search" class="button" src="<c:url value='/images/button/btn_search.gif' />" /></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr valign="top">
									<td></td>
									<td>
										<table width="1170px" cellpadding="0" cellspacing="0" border="0" class="search_area">
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
													<td width="55px" class="search_condition"><spring:message code='record.search.calldate' /></td>
													<td width="6px"></td>
													<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
													<td width="14px"></td>
													<td width="70px"><input type="text" id="strStartDate" name="strStartDate" class="search_value" style="width:70px; " readonly="readonly"/></td>
													<td width="15px" style="padding-left:3px;"><img id="imgCalendarStart" src="<c:url value='/images/icon/icon_calendar.gif' />" style="cursor: pointer;" /></td>
													<td width="142px">&nbsp;</td>
													<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
													<td width="5px"></td>
													<td width="75px" class="search_condition"><spring:message code='record.search.group' /></td>
													<td width="6px"></td>
													<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
													<td width="14px"></td>
													<td width="70px"><input type="text" id="schGroupName" name="schGroupName" class="search_value" style="width:70px;" /></td>
													<td width="70px" style="padding-left:3px;"><input type="text" id="schGroupId" name="schGroupId" class="search_value"  style="width:70px;" /></td>
													<td width="20px" style="padding-left:3px;"><img class="button" id="btn_groupSearch" style="cursor: pointer;" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
													<td width="45px" style="padding-left:3px;"><img class="button" id="btn_groupTree" style="cursor: pointer;" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
												</tr>
												</table>
											</td>
										</tr>
										<tr height="8px">
											<td>
											</td>
										</tr>
										<tr>
											<td>
												<table cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse">
												<tr>
													<td width="14px"></td>
													<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
													<td width="5px"></td>
													<td width="55px" class="search_condition"><spring:message code='message.regulation' /></td>
													<td width="6px"></td>
													<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
													<td width="14px"></td>
													<td width="75px">
														<select id="selSearchType" name="selSearchType" class="search_value" style="width:70px; height:18px;" >
							                				<option value="user"><spring:message code='report.search.type.user' /></option>
							                				<option value="group"><spring:message code='report.search.type.group' /></option>
							                				<option value="campaign"><spring:message code='report.search.type.campaign' /></option>
							                			</select>
													</td>
													<td width="155px">&nbsp;</td>
													<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
													<td width="5px"></td>
													<td width="75px" class="search_condition"><spring:message code='report.search.includeretired' /></td>
													<td width="6px"></td>
													<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
													<td width="14px"></td>
													<td width="25px" align="left"><form:checkbox path="includeRetired" value="check" /></td>
													<td width="210px"></td>
													<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
													<td width="5px"></td>
													<td width="95px" class="search_condition"><spring:message code='report.search.onlyrealuser' /></td>
													<td width="6px"></td>
													<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
													<td width="14px"></td>
													<td width="25px" align="left"><form:checkbox path="onlyRealUser" id="onlyRealUser" value="check" /></td>
												</tr>
												</table>
											</td>
										</tr>
										<tr height="15px">
											<td></td>
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
								<tr height="14px">
									<td colspan="3"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
	<!-- 검색조건 끝 -->
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
						<table width="100%" height="500px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td colspan="2"></td>
						</tr>
						<tr valign="top" height="500px">
							<td width="14px"></td>
							<td>
								<table width="" height="" cellpadding="0" cellspacing="0" border="0" >
								<tr valign="top">
									<td>
										<table width="1170px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
										<tr>
											<td align="right"><img id="btn_excel" class="button" src="<c:url value='/images/button/btn_excel.gif' />" /></td>
										</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
<!-- 리스트 iframe 들어가는 곳  -->			<iframe id="iframeReportList" name="iframeReportList" frameborder="0" style="width:1170px; height:500px; border:none;" scrolling="no"></iframe>
									</td>
								</tr>
								</table>
							</td>
						</tr>
						<tr height="5px">
							<td colspan="2"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		</table>
	</td>
</tr>
</table>
</form:form>
</body>
</html>
