<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5" />
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>" />
<title>MorecX</title>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src="<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src="<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript" src="<c:url value='/jquery/js/authority.js' />"></script>
<script type="text/javascript">

//Session Check
checkSession("<c:out value="${sessionScope.user_id}"/>", "<spring:message code="message.logout_js" />", "<spring:message code="message.logout_js_retry" />");

$(document).ready(function(){
	
	//권한설정 추가 
	if("${sessionScope.zirecx_id}" != "admin") {
		fn_check_private();
	}
	
	$('div.div_smartPhoneDetail input[type=text]').attr("disabled", true);
	
	$('#btn_search').click(function(){ 
		searchList(); }
	);
	$('#btn_select_excel').click( searchSmartPhoneListExcel );
	
	fnc_init();
});

<% /* 초기 화면 */ %>
function fnc_init(){
	document.getElementById("pagelist").value = 50;
	
	$("#smartPhoneSearchVO").attr("target","iframeSmartPhonetList");
	$("#smartPhoneSearchVO").attr("action","<c:url value='/smart/smartPhoneManageInitList.do'/>");
	$("#smartPhoneSearchVO").submit();
} 

<% /* 생성 / 삭제  */ %>
$(function() {
	$("#btn_new").bind("click", function(event) {
		$('div.div_smartPhoneDetail input[type=text]').val("");
		$('div.div_smartPhoneDetail input[type=text]').removeAttr("disabled");
		$('div.div_smartPhoneDetail select').val("Y");
		$("input:hidden[id=jobType]").val("insert");
	});

	$("#btn_save").bind("click", function(event) {
		if($.trim($("#groupIdDetail").val()) == "") {
			alert("센터를 선택해 주세요.");
			return;
		}
		if($.trim($("#detail_phoneNumber").val()) == "") {
			alert("전화번호를 입력해 주세요.");
			return;
		}
		
		if(smartPhoneSearchVO.jobType.value != ""){
			$.ajax({  
			    type: "POST",  
			    url: "<c:url value='/smart/smartPhoneInfoManage.do'/>",
			    data:"id="+smartPhoneSearchVO.detail_id.value
			    	+"&groupIdDetail="+smartPhoneSearchVO.groupIdDetail.value
			    	+"&detail_phoneNumber="+smartPhoneSearchVO.detail_phoneNumber.value
			    	+"&detail_imei="+smartPhoneSearchVO.detail_imei.value
			    	+"&detail_useStatusFlag="+smartPhoneSearchVO.detail_useStatusFlag.value
			    	+"&detail_memo="+smartPhoneSearchVO.detail_memo.value
			    	+"&jobType="+smartPhoneSearchVO.jobType.value
			    ,
			     
			    success: updateSmartPhoneListCallBack,
			    error: function(e){  
			        alert('Error: ' + e.responseText);  
			    }  
            }); 	 
		}
	});
});

//조회중 버튼처리
function changBtnSearch(bValue){
	if(bValue == 'start'){
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
		document.getElementById("btn_search").disabled = true;
	}else{
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
		document.getElementById("btn_search").disabled = false;
	}
}

<% /* 조회 리스트 */ %>
function searchList(){
	$('div.div_smartPhoneDetail input[type=text]').attr("disabled", true);
	$('div.div_smartPhoneDetail input[type=text]').val("");
	$('div.div_smartPhoneDetail select').val("Y");

	$("input[name=nowpage]").val("1");
	$("input:hidden[name=pageIndex]").val("1");
	$("input:hidden[id=jobType]").val("");
	changBtnSearch('start');
	
	if($('#orderKey').val() == '')
		sortField('');
	$("#smartPhoneSearchVO").attr("target","iframeSmartPhonetList");
	$("#smartPhoneSearchVO").attr("action","<c:url value='/smart/smartPhoneManageList.do'/>");
	$("#smartPhoneSearchVO").submit();
}

<% /* 조회 리스트 엑셀 */ %>
function searchSmartPhoneListExcel(){
	if($('#orderKey').val() == '')
		sortField('');
	$("#smartPhoneSearchVO").attr("target","iframeDown");
	$("#smartPhoneSearchVO").attr("action","<c:url value='/smart/smartPhoneManageListExcel.do'/>");
	$("#smartPhoneSearchVO").submit();
}

<% /* 고객 수정 콜백 */ %>
function updateSmartPhoneListCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);

	if (searchData.result == "1") {
		alert('생성하였습니다.');
		searchList();
	} else if (searchData.result == "2") {
		alert('수정하였습니다.');
		searchList();
	} else {
		alert('본인이 등록한 번호만 수정이 가능합니다.');
	}
}

<% /* 페이징 */ %>
function page_first() {
	document.getElementById("nowpage").value = 1;
	iframeSmartPhonetList.fn_smartPhone_list_page();
	
	//선택값 초기화 
	$("#selectedId").val("");
}

<% /* 현재 페이지 */ %>
function page_previous() {
	var pin = parseInt(document.getElementById("nowpage").value);
	if(1 < pin){
		document.getElementById("nowpage").value = pin - 1;
		iframeSmartPhonetList.fn_smartPhone_list_page();
		//선택값 초기화 
		$("#selectedId").val("");
	}else{
	}
}

<% /* 다음 페이지 */ %>
function page_next() {
	var pin = parseInt(document.getElementById("nowpage").value);
	var max = parseInt(document.getElementById("maxPageCheck").value);
	if(pin < max){
		document.getElementById("nowpage").value = (pin + 1);
		iframeSmartPhonetList.fn_smartPhone_list_page();
		//선택값 초기화 
		$("#selectedId").val("");
	}else{
		
	}
}

<% /* 마지막 페이지 */ %>
function page_last() {
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	iframeSmartPhonetList.fn_smartPhone_list_page();
	//선택값 초기화 
	$("#selectedId").val("");
}

<% /* 새로고침 */ %>
function refreshList(){
	searchList();
}

<% /* input text를  number만  */ %>
function onlyNumberInput(){ 
 	var code = window.event.keyCode;
	if ((code > 34 && code < 41) || (code > 47 && code < 58) || (code > 95 && code < 106) || code == 8 || code == 9 || code == 13 || code == 46){ 
		window.event.returnValue = true; 
		return; 
	} 	
	window.event.returnValue = false; 
}

<% /* 센터 정렬 */ %>
function sortField(field){
	if(field == ''){
		$("#orderKey").val("groupid");
		$("#orderType").val('ASC');
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

<% /* 변경일 정렬 */ %>
/* function sortFieldDate(field){
	if(field == ''){
		$("#orderTypeDate").val('DESC');
	}else{
		if($("#orderKeyDate").val() == field){
			if($("#orderTypeDate").val() == "ASC"){
				$("#orderTypeDate").val('DESC');
			}else{
				$("#orderTypeDate").val('ASC');
			}
		}else{
			$("#orderKeyDate").val(field);
			$("#orderTypeDate").val('DESC');
		}
	}
} */

function sortFieldDate(field){
	if(field == ''){
		$("#orderKey").val("dateUpdated")
		$("#orderType").val('DESC');
	}else{
		if($("#orderKey").val() == field){
			if($("#orderType").val() == "ASC"){
				$("#orderType").val('DESC');
			}else{
				$("#orderType").val('ASC');
			}
		}else{
			$("#orderKey").val(field);
			$("#orderType").val('DESC');
		}
	}
}


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
						$("#btn_smartPhoneUserSearch").val("group");
					} 
					/** 김해동 테스트 */
					else if("${result.scope}" == "groupUp") {			// group
						$("#btn_smartPhoneUserSearch").val("groupUp");
					}
					else if("${result.scope}" == "all") {		// all
						$("#btn_smartPhoneUserSearch").val("all");
					} else {									// own
						$("#btn_smartPhoneUserSearch").val("own");
						
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
			}
		</c:forEach>
	}
}

</script>
<style type="text/css">
.ui-widget-header {
	border: 1px solid #aaaaaa;
	background: #5ebbd9 url(images/ui-bg_highlight-soft_75_5ebbd9_1x100.png)
		50% 50% repeat-x;
	color: #5ebbd9;
	font-weight: bold;
}
</style>
</head>
<body style="margin: 0px" bgcolor="#FFFFFF">
	<form:form commandName="smartPhoneSearchVO" id="smartPhoneSearchVO" name="smartPhoneSearchVO" method="post">
	<form:hidden path="pageIndex" />
	<input type="hidden" id="jobType">
	<input type="hidden" id="groupTreeType" name = "groupTreeType" value="Detail" />
	<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
	<input type="hidden" id="maxPageCheck" name="maxPageCheck" value=""/>
	<input type="hidden" id="orderKey" name="orderKey" value="groupId" />
	<input type="hidden" id="orderType" name="orderType" value="ASC" />
<!-- 	<input type="hidden" id="orderKeyDate" name="orderKeyDate" value="dateUpdated" />
	<input type="hidden" id="orderTypeDate" name="orderTypeDate" value="DESC" /> -->
	<input type="hidden" id="detail_id" name="detail_id" value="" />
	<input type="hidden" id="selectedId" name="selectedId" value=""/>
	<!-- 권한 페이지 분류로 인해 값 추가  -->
	<input type="hidden" id="pageType" value="smartPhone"/>
	<!-- 권한 추가  -->
	<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="all"/>
								
		<table align="left" width="1260px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse: collapse;">
			<tr valign="top">
				<%@ include file="../common/popUpFunction.jsp"%>
				<td>
					<table align="left" width="1198px" height="650px" cellpadding="0" cellspacing="0" border="0">
						<!-- 네비게이션 시작 -->
						<tr height="36px" valign="top">
							<td colspan="3">
								<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
									<tr>
										<td width="14px"></td>
										<td style="padding-top: 1px;"><img height="33px" border="0px" src="<c:url value='/images/title/title_smp_g.gif' />" /></td>
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
						<!-- 네비게이션 끝 -->
						<tr valign="top">
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
														<table width="1198px" cellpadding="0" cellspacing="0" border="0">
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
																				<table cellpadding="0" cellspacing="0" border="0" style="border-collapse: collapse">
																					<tr>
																						<td width="14px"></td>
																						<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																						<td width="5px"></td>
																						<td width="40px" class="search_condition"><spring:message code='record.search.group' /></td>
																						<td width="6px"></td>
																						<td width="2px" style="border-right: 1px solid #d0e3e3;">&nbsp;</td>
																						<td width="14px"></td>
																						<td width="70px"><form:input type="text" path="schGroupName" class="search_value" style="width: 70px;" /></td>
																						<td width="70px" style="padding-left: 3px;"><form:input type="text" path="schGroupId" class="search_value" onkeydown="onlyNumberInput();" style="width: 70px;" /></td>
																						<td width="20px" style="padding-left: 3px;"><img class="button" id="btn_groupSearch" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
																						<td width="45px" style="padding-left: 3px;"><img class="button" id="btn_groupTree" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
																						<td width="39px"></td>
																						<td width="5px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																						<td width="5px"></td>
																						<td width="70px" class="search_condition">전화번호</td>
																						<td width="6x"></td>
																						<td width="2px" style="border-right: 1px solid #d0e3e3;">&nbsp;</td>
																						<td width="14px"></td>
																						<td width="206px"><input type="text" id="phoneNumber" name="phoneNumber" class="search_value" onkeydown="onlyNumberInput();" maxlength="11" style="width: 206px;" /></td>
																					</tr>
																				</table>
																			</td>
																		</tr>
																		<tr height="8px">
																			<td></td>
																		</tr>
																		<tr>
																			<td>
																				<table cellpadding="0" cellspacing="0" border="0" style="border-collapse: collapse">
																					<tr>
																						<td width="14px"></td>
																						<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																						<td width="5px"></td>
																						<td width="40px" class="search_condition">IMEI</td>
																						<td width="6px"></td>
																						<td width="2px" style="border-right: 1px solid #d0e3e3;">&nbsp;</td>
																						<td width="14px"></td>
																						<td width="205px"><input type="text" id="imei" name="imei" class="search_value" maxlength="15" onkeydown="onlyNumberInput();" style="width: 205px;" /></td>
																						<td width="48px"></td>
																						<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																						<td width="5px"></td>
																						<td width="70px" class="search_condition">작업자</td>
																						<td width="6px"></td>
																						<td width="2px" style="border-right: 1px solid #d0e3e3;">&nbsp;</td>
																						<td width="14px"></td>
																						<td width="90px" ><input type="text" id="schUserName" name="schUserName" class="search_value" maxlength="10" style="width:90px; "/></td>
																						<td width="3px"></td>
																						<td width="90px"><input type="text" id="schUserZirecxId" name="schUserZirecxId" class="search_value" maxlength="10"  style="width:90px; " /></td>
																						<td width="25px" align="center"><img id="btn_smartPhoneUserSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />"/></td>
																						<!-- <input type="text" id="updateUserId" name="updateUserId" class="search_value" maxlength="15" style="width: 205px;" /></td> -->
																						<td width="60px"></td>
																						<td width="8px"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
																						<td width="5px"></td>
																						<td width="40px" class="search_condition">상태</td>
																						<td width="6px"></td>
																						<td width="2px" style="border-right: 1px solid #d0e3e3;">&nbsp;</td>
																						<td width="14px"></td>
																						<td width="150px"><select id="useStatusFlag" name="useStatusFlag" class="search_condition_select" style="width: 150px; height: 18px;">
																							<option value="A">전체</option>
																							<option value="Y">사용</option>
																							<option value="N">미사용</option>
																						</select></td>
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
																<td height="14px;" colspan="3"></td>
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
													<td></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table width="100%" height="300px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
												<tr height="10px">
													<td colspan="2"></td>
												</tr>
												<tr valign="top" height="300px">
													<td width="14px"></td>
													<td>
														<table width="" height="" cellpadding="0" cellspacing="0" border="0">
															<tr valign="top">
																<td>
																	<table width="1170px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
																		<tr>
																			<td align="right"><img id="btn_select_excel" class="button" src="<c:url value='/images/button/btn_excel.gif' />" /></td>
																		</tr>
																	</table>
																</td>
															</tr>
															<tr>
																<td>
																	<!-- 리스트 iframe 들어가는 곳  --> 
																	<iframe id="iframeSmartPhonetList" name="iframeSmartPhonetList" frameborder="" style="width: 1170px; height: 300px; border: none;" scrolling="no"></iframe>
																	<iframe id="iframeDown" name="iframeDown" frameborder="0" style="border: none; display: none;" scrolling="no"></iframe>
																</td>
															</tr>
															<tr>
																<td height="2px"></td>
															</tr>
															<tr>
															<td>
																<table width="1170px" height="29px" cellpadding="0" cellspacing="0" border="0" class="paging_table_box">
																<tr>
																	<td width="15px"></td>
																	<td width="10px" style="cursor: pointer;"><img id="btn_first" src="<c:url value='/images/button/btn_first.gif' />" onclick="page_first();" /></td>
																	<td width="5px"></td>
																	<td width="6px" style="cursor: pointer;"><img id="btn_previous" src="<c:url value='/images/button/btn_previous.gif' />" onclick="page_previous();"/></td>
																	<td width="10px"></td>
																	<td width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
																	<td width="10px"></td>
																	<td width="40px">페이지</td>
																	<td width="25px"><input id="nowpage" name="nowpage" class="detail_value_writable" style="width: 20px;height:13px; text-align: center;" type="text" onkeydown="onlyNumberInput();" value="<c:out value="${maxPage+1}"/>" onkeydown="javascript : if(event.keyCode == 13) iframeSmartPhonetList.fn_smartPhone_list_page();"/></td>
																	<td width="3px"></td>
																	<td>/</td>
																	<td width="20px" id="pageCnt">0 </td>
																	<td width="5px"></td>
																	<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
																	<td width="10px"></td>
																	<td width="6px" style="cursor: pointer;"><img id="btn_next" src="<c:url value='/images/button/btn_next.gif' />" onclick="page_next();" /></td>
																	<td width="5px"></td>
																	<td width="10px" style="cursor: pointer;"><img id="btn_last" src="<c:url value='/images/button/btn_last.gif' />" onclick="page_last();" /></td>
																	<td width="10px"></td>
																	<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
																	<td width="10px"></td>
																	<td width="13px" style="cursor: pointer;"><img id="btn_refresh" src="<c:url value='/images/button/btn_refresh.gif' />" onclick="refreshList();" /></td>
																	<td width="10px"></td>
																	<td><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
																	<td width="10px"></td>
																	<td width="30px">표시</td>
																	<td>
																		<select id="pagelist" name="pagelist">
																			<option value="10" >10</option>
																			<option value="50" selected="selected">50</option>
																			<option value="100">100</option>
																			<option value="200">200</option>
																		</select> 
																	</td>
																	<td align="right" id="totalCnt">0건&nbsp;</td>
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

									<!-- 등록 / 수정 -->
									<tr valign="top">
										<td width="100%">
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="1198px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
															<tr height="20px">
																<td></td>
															</tr>
															<tr valign="top">
																<td>
																	<table width="1198px" cellpadding="0" cellspacing="0" border="0">
																		<tr valign="top">
																			<table width="" height="100%" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
																				<tr valign="top" height="50px">
																					<td width="14px"></td>
																					<td>
																						<div class="div_smartPhoneDetail">
																							<table width="" height="" cellpadding="0" cellspacing="0" border="0">
																								<tr valign="top">
																									<td>
																										<table width="1170px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
																											<tr>
																												<td width="1100px">&nbsp;</td>
																												<td align="right"><img id="btn_new" class="button" src="<c:url value='/images/button/btn_new.gif' />" /></td>
																												<td width="5px"></td>
																												<td align="right"><img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />" /></td>
																											</tr>
																										</table>
																									</td>
																								</tr>
																								<tr>
																									<td>
																										<table width="1170px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
																											<tr>
																												<td width="185px" class="detail_column">센터 <font color="red">*</font>
																												</td>
																												<td width="400px" class="detail_description">
																													<table cellpadding="0" cellspacing="0">
																														<tr>
																															<td width="100px"><input type="text" id="groupNameDetail" name="groupNameDetail" class="detail_value_writable" style="width: 100px" maxlength="255" /></td>
																															<td width="3px"></td>
																															<td width="100px"><input type="text" id="groupIdDetail" name="groupIdDetail" class="detail_value_writable" style="width: 100px" maxlength="11" onkeydown="onlyNumberInput();" /></td>
																															<td width="3px"></td>
																															<td width="25px" align="left"><img id="btn_groupSearchDetail" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
																															<td width="" align="left"><img id="btn_groupTreeDetail" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
																														</tr>
																													</table>
																												</td>
																												<td width="185px" class="detail_column">전화번호<font color="red">*</font></td>
																												<td width="400px" class="detail_description">
																													<input type="text" id="detail_phoneNumber" name="detail_phoneNumber" class="detail_value_writable" style="width: 200px" maxlength="11" onkeydown="onlyNumberInput();" />
																												</td>
																											</tr>
																											<tr>
																												<td width="185px" class="detail_column">IMEI</td>
																												<td width="400px" class="detail_description">
																													<input type="text" id="detail_imei" name="detail_imei" class="detail_value_writable" style="width: 266px" maxlength="15" onkeydown="onlyNumberInput();" />
																												</td>
																												<td width="185px" class="detail_column">상태 <font color="red">*</font>
																												</td>
																												<td width="400px" class="detail_description">
																													<select id="detail_useStatusFlag" name="detail_useStatusFlag"  class="detail_value_writable" style="width: 200px; height: 20px">
																														<option value="Y">사용</option>
																														<option value="N">미사용</option>
																													</select>
																												</td>
																											</tr>
																											<tr>
																												<td width="185px" class="detail_column">특이사항</td>
																												<td width="400px" class="detail_description" colspan="3"><input type="text" id="detail_memo" name="detail_memo" class="detail_value_writable" style="width: 266px" maxlength="255" /></td>
																											</tr>
																										</table>
																									</td>
																								</tr>
																								<tr height="3px">
																									<td></td>
																								</tr>
																							</table>
																						</div>
																					</td>
																				</tr>
																				<tr>
																					<td></td>
																				</tr>
																			</table>
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
	</form:form>
</body>
</html>
