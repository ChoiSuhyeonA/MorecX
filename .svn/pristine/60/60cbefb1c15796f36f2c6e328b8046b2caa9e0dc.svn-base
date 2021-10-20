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

//Session Check
checkSession("<c:out value="${sessionScope.user_id}"/>", "<spring:message code="message.logout_js" />", "<spring:message code="message.logout_js_retry" />");

$(document).ready(function(){
	<% /* 권한체크 */ %>
	if("${sessionScope.zirecx_id}" != "admin") {
		fn_check_private();
	}
	
	//searchList();
});

function searchList(){
	
	//validate 추가 
	
	
	$('div.div_groupDetail input[type=text]').attr("disabled", true);
	$('div.div_groupDetail input[type=text]').val("");
	$('div.div_groupDetail input[type=checkbox]').removeAttr("checked");
	
	$("input[name=nowpage]").val("1");
	$("input:hidden[name=pageIndex]").val("1");
	
	if($('#orderKey').val() == '') sortField('');
	
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	
	$("#groupSearchVO").attr("target","iframeGroupList");
	$("#groupSearchVO").attr("action","<c:url value='/system/groupManageList.do'/>");
	$("#groupSearchVO").submit();
}
function groupListExcelDownload(){
	$("#groupSearchVO").attr("action","<c:url value='/system/groupManageExcelList.do'/>");
	$("#groupSearchVO").submit();
}

<% /* 신규, 저장, 삭제 버튼 클릭 이벤트 */ %>
$(function() {
	$("#btn_new").bind("click", function(event) {
		$('div.div_groupDetail input[type=text]').val("");
		$('div.div_groupDetail input[type=checkbox]').removeAttr("checked");
		$('div.div_groupDetail input[type=text]').removeAttr("disabled");
		
		/* 선택한 사용자정보 초기화 */
		document.groupSearchVO.groupSeqUpperDT.value = "";
		document.groupSearchVO.groupSeqDT.value = "";
	});
	
	$("#btn_save").bind("click", function(event) {
		var strDeleteYn = "";
		if( document.getElementById("deleteYnDT").checked == true ) {
			strDeleteYn = "1";
		} else {
			strDeleteYn = "0";
		}
		
		var strListenSupported = "";
		if( document.getElementById("listenSupported").checked == true ) {
			strListenSupported = "1";
		} else {
			strListenSupported = "0";
		}
		
		var param = "groupSeqDT="+$("#groupSeqDT").val()
		  + "&groupSeqUpperDT="+$("#groupSeqUpperDT").val()
		  + "&groupNameUpperDT="+$("#groupNameUpperDT").val()
		  + "&groupNameDT="+$("#groupNameDT").val()
		  + "&deleteYnDT="+strDeleteYn
		  + "&licenseCnt="+$("#licenseCnt").val()
		  + "&listenSupported="+strListenSupported
		  + "&storagePeriod="+$("#storagePeriod").val()
		  + "&officeCode="+$("#officeCode").val()
		  + "&groupCode="+$("#groupCode").val()
		;
		  
		if(document.getElementById("groupSeqDT").value == "") {
			
			// 저장
			$.ajax({
				type: "POST",  
				url: "<c:url value='/system/groupManageInsert.do'/>",
				data: param,
				success: groupInsertCallBack,
				error: function(e){  
					alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
				}  
			});	
		} else {
			
			// 수정
			$.ajax({
				type: "POST",  
				url: "<c:url value='/system/groupManageUpdate.do'/>",
				data: param,
				success: groupUpdateCallBack,
				error: function(e){  
					alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
				}  
			});
		}
	});
});



function clickBtnNew() {
	document.getElementById("groupSeqDT").value = "";
	document.getElementById("groupSeqUpperDT").value = "";
	document.getElementById("groupNameUpperDT").value = "";
	document.getElementById("groupNameDT").value = "";
	document.getElementById("licenseCnt").value = "";
	document.getElementById("deleteYnDT").checked = false;
}

function groupInsertCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result != "0") {
		alert("<spring:message code='group.insertGroup.success' />");
		searchList();
	} else {
		alert("<spring:message code='group.insertGroup.failure' />");
	}
}
function groupUpdateCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS") {
		alert("<spring:message code='group.insertGroup.success' />");
		searchList();
	} else {
		alert("<spring:message code='group.insertGroup.failure' />");
	}
}

<% /* new 버튼 클릭 이벤트 */ %>
$(function() {
	$("#btn_new").bind("click", function(event) {
		$('div.div_groupDetail input[type=text]').val("");
		$("input[type=checkbox]").attr("checked", false);
	});
});


<% /* ORDER BY (SORT) */ %>
function sortField(field){
	if(field == ''){
		$("#orderType").val('ASC');
		$("#orderKey").val('groupnameupper');		
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

<% /* 페이징 */ %>
function page_first() {
	document.getElementById("nowpage").value = 1;
	iframeGroupList.fn_group_list_page();
}

function page_previous() {
	var pin = parseInt(document.getElementById("nowpage").value);
	if(1 < pin){
		document.getElementById("nowpage").value = pin - 1;
		iframeGroupList.fn_group_list_page();
	}else{
		
	}
}

function page_next() {
	var pin = parseInt(document.getElementById("nowpage").value);
	var max = parseInt(document.getElementById("maxPageCheck").value);
	if(pin < max){
		document.getElementById("nowpage").value = (pin + 1);
		iframeGroupList.fn_group_list_page();
	}else{
		
	}
}

function page_last() {
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	iframeGroupList.fn_group_list_page();
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//공통 부분 시작 (권한, 그룹 리스트 팝업, 사용자 리스트 팝업)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
					// 김해동 테스트 
					else if("${result.scope}" == "groupUp") {			// group
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
						$("#schUserId").val("${sessionScope.zirecx_id}");
						$("#schUserName").attr("readOnly", true);
						$("#schUserId").attr("readOnly", true);
						$("#schUserName").attr("class", "search_value_readonly");
						$("#schUserId").attr("class", "search_value_readonly");
					}
				}
			}
		</c:forEach>
	}
}

</script>
</head>

<body style="margin:0px" bgcolor="#FFFFFF">
<form:form  commandName="groupSearchVO" name="groupSearchVO" method="post">

<form:hidden path="pageIndex" />
<input type="hidden" id="orderKey" name="orderKey" value="groupnameupper" />
<input type="hidden" id="orderType" name="orderType" value="ASC" />
<input type="hidden" id="maxPageCheck" name="maxPageCheck" value=""/>
<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
<input type="hidden" id="groupTreeType" name = "groupTreeType" value="UpperDT" />
<input type="hidden" id="hidAccessPolicy" name = "hidAccessPolicy" value="" />

<!-- 권한 페이지 분류로 인해 값 추가  -->
<input type="hidden" id="pageType" value="system" />

<table align="left" width="1260px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
		<%@ include file="../common/popUpFunction.jsp" %>
	<td>
		<table align="left" width="1198px" height="730px" cellpadding="0" cellspacing="0" border="0" >
		
		<!-- 타이틀 시작 -->
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_center.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
		<!-- 타이틀 끝 -->
		
		<tr height="100%" valign="top">
			<td width="400px">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				
				<!-- 검색조건 시작 -->
				<tr>
					<td>
						<table width="400px" height="128px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top">
							<td>
								<table width="400px" height="100%" cellpadding="0" cellspacing="0" border="0" >
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
											<td align="right"><img id="btn_search" class="button" src="<c:url value='/images/button/btn_search.gif' />" onclick="javascript:searchList();" /></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr height="50px" valign="top">
									<td></td>
									<td>
										<table width="372px" height="50px" cellpadding="0" cellspacing="0" border="0" class="search_area">
										<tr height="17px">
											<td></td>
										</tr>
										<tr valign="top">
											<td>
												<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse">
														<tr>
															<td width="14px"></td>
															<td width="8px" ><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="58px" class="search_condition"><spring:message code='group.search.group' /></td>
															<td width="6px"></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="94px" ><form:input path="schGroupName" class="search_value" style="width:94px; " /></td>
															<td width="3px"></td>
															<td width="94px"><form:input path="schGroupId" class="search_value"  style="width:94px; " /></td>
															<td width="3px"></td>
															<td width="20px" align="center"><img id="btn_groupSearch" name="btn_groupSearch" align="absmiddle" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
															<td width="3px"></td>
															<td width="35px" ><img id="btn_groupTree" align="absmiddle" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
															<td width="14px"></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr height="17px">
													<td></td>
												</tr>
												</table>
											</td>
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
						<table width="400px" height="528px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top" height="528px">
							<td width="14px"></td>
							<td>
								<table width="" height="" cellpadding="0" cellspacing="0" border="0" >
									<tr valign="top">
										<td>
											<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
											<tr>
												<td>&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
							
											<!-- 리스트(iFrame) 시작 -->
												<iframe id="iframeGroupList" name="iframeGroupList" frameborder="0" style="width: 372px; height: 550px; border: none;" scrolling="auto"></iframe>
											<!-- 리스트(iFrame) 끝 -->
											
										</td>
									</tr>
									<tr height="5px">
										<td></td>
									</tr>
									
									<!-- 페이징 시작 -->
									<tr>
										<td>
											<table width="372px" height="29px" cellpadding="0" cellspacing="0" border="0" class="paging_table_box">
											<tr>
												<td width="15px"></td>
												<td width="10px" style="cursor: pointer;"><img id="btn_first" src="<c:url value='/images/button/btn_first.gif' />" onclick="page_first();" /></td>
												<td width="5px"></td>
												<td width="6px" style="cursor: pointer;"><img id="btn_previous" src="<c:url value='/images/button/btn_previous.gif' />" onclick="page_previous();"/></td>
												<td width="10px"></td>
												<td width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="40px">페이지</td>
												<td width="25px"><input id="nowpage" name="nowpage" class="detail_value_writable" style="width: 20px;height:13px; text-align: center;" type="text" value="<c:out value="${maxPage+1}"/>" onkeydown="javascript : if(event.keyCode == 13) iframeUserList.fn_user_list_page();"/></td>
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
												<td width="13px" style="cursor: pointer;"><img id="btn_refresh" src="<c:url value='/images/button/btn_refresh.gif' />" onclick="searchList();" /></td>
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
									<!-- 페이징 끝 -->
									
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
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			<td width="4px" height="100%" valign="top" >
				<table width="4px" height="770px" class="screen_bar">
					<tr>
					<td>
					</td>
					</tr>
				</table>
			</td>
			<td valign="top">
				<table width="" height="100%" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
				<tr height="20px">
					<td></td>
				</tr>
				<tr valign="top" height="600px">
					<td width="14px"></td>
					<td>
					
						<!-- 상세정보 시작 -->
						
						<!-- 상세정보 변경 값 -->
						<form:hidden path="groupSeqDT" />
						<form:hidden path="groupSeqUpperDT" />
						
						<div class="div_groupDetail">
						<table width="" height="" cellpadding="0" cellspacing="0" border="0" >
							<tr valign="top">
								<td>
									<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
									<tr>
										<td>&nbsp;</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="780px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
									<tr>
										<td width="116px" class="detail_column">센터추가(상위)</td>
										<td width="234px" class="detail_description">
											<table width="" height="" cellpadding="0" cellspacing="0" border="0">
												<td width="150px"><form:input path="groupNameUpperDT" class="detail_value_writable" style="width:150px" readonly="true" /></td>
												<td width="25px" align="center"><img id="btn_groupSearchDetail" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
												<td width="" ><img id="btn_groupTreeDetail" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
											</table>
										</td>
										<td width="116px" class="detail_column">센터명</td>
										<td width="234px" class="detail_description">
											<form:input path="groupNameDT" class="detail_value_writable" style="width:150px" />
										</td>
									</tr>
									<tr height="20px">
										<td width="116px" class="detail_column">회사코드</td>
										<td width="234px" class="detail_description">
											<form:input path="officeCode" class="detail_value_writable" style="width:150px" />
										</td>
										<td width="116px" class="detail_column">조직코드</td>
										<td width="234px" class="detail_description">
											<form:input path="groupCode" class="detail_value_writable" style="width:150px" />
										</td>
									</tr>
									<tr height="20px">
										<td width="116px" class="detail_column">앱청취여부</td>
										<td width="234px" class="detail_description">
											<input type="checkbox" id="listenSupported" name="listenSupported" />
										</td>
										<td width="116px" class="detail_column">앱녹취저장기간</td>
										<td width="234px" class="detail_description">
											<form:input path="storagePeriod" class="detail_value_writable" style="width:150px" />일
										</td>
									</tr>
									<tr height="20px">
										<td width="116px" class="detail_column">삭제여부</td>
										<td width="234px" class="detail_description">
											<input type="checkbox" id="deleteYnDT" name="deleteYnDT" />
										</td>
										<td width="116px" class="detail_column">라이선스 수량</td>
										<td width="234px" class="detail_description">
											<form:input path="licenseCnt" class="detail_value_writable" style="width:150px" />
										</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr height="5px">
								<td></td>
							</tr>
							<tr>
								<td>
									<table cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td width="708px">&nbsp;</td>
										<td><img id="btn_new" class="button" src="<c:url value='/images/button/btn_new.gif' />"  /></td>
										<td width="5px"></td>
										<td><img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />"  /></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
						</div>
						<!-- 상세정보 끝 -->
						
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
