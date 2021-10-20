<%-- 
- 페이지 제목 : 사용자관리 메인
- 페이지 ID : userManageMain.jsp
- 저작권 : ㈜ 아이알링크
- 작성자 : 풍기정
- 작성일자 : 2013-08-28
- 설명 : 사용자의 정보를 조회 등록 수정 삭제 한다.
- 연관 method : /system/userManageList.do
- 변경내역 : 
- 
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<%

String user_id=(String)session.getAttribute("user_id"); 
String login_string=(String)session.getAttribute("login_string"); 
String user_name=(String)session.getAttribute("user_name"); 
String login_date=(String)session.getAttribute("login_date"); 
String login_time=(String)session.getAttribute("login_time"); 
String security_group_id=(String)session.getAttribute("security_group_id"); 
String group_id=(String)session.getAttribute("group_id"); 
String group_name=(String)session.getAttribute("group_name"); 
String zirecx_id=(String)session.getAttribute("zirecx_id"); 

%>

<!DOCTYPE html PUBLIC "Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery.jqplot.min.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery.jqplot.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/excanvas.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.pointLabels.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.barRenderer.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.categoryAxisRenderer.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.pieRenderer.min.js' />"></script>
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
	
	$('div.div_userDetail input[type=text]').attr("disabled", true);

	// 권한콤보
	<c:forEach var="result" items="${authList}" varStatus="status">
		new_option = new Option('<c:out value="${result.groupName}"/>','<c:out value="${result.groupId}"/>');
		userSearchVO.cmbAuthSearch.options.add(new_option, userSearchVO.cmbAuthSearch.options.length);
	</c:forEach>	
	//searchList();
	

	
	
});

<% /* 그래프 그리기 */%>
function graphDraw(){
	$("#userSearchVO").attr("target","iframeUserGraph");
	$("#userSearchVO").attr("action","<c:url value='/system/userManageGraph.do'/>");
	$("#userSearchVO").submit();
}



<% /* 고객검색 */ %>
function searchList(){
	$('div.div_userDetail input[type=text]').attr("disabled", true);
	$('div.div_userDetail input[type=text]').val("");
	$('div.div_userDetail input[type=checkbox]').removeAttr("checked");
	$("input[name=nowpage]").val("1");
	$("input:hidden[name=pageIndex]").val("1");
	$("input:hidden[name=userId]").val("");
	$("input:hidden[name=detailZirecxId]").val("");
	//$("input:hidden[name=detailLoginstring]").val("");
	$("input:hidden[id=jobType]").val("");
	
	if($('#orderKey').val() == '') sortField('');
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	
	$("#userSearchVO").attr("target","iframeUserList");
	$("#userSearchVO").attr("action","<c:url value='/system/userManageList.do'/>");
	$("#userSearchVO").submit();
}

<% /* 검색버튼 클릭시 이벤트 */ %>
$(function() {
	$("#btn_search").bind("click", function(event) {		
		searchList();
	});
});

<% /* 신규, 저장, 삭제 버튼 클릭 이벤트 */ %>
$(function() {
	$("#btn_new").bind("click", function(event) {
		$('div.div_userDetail input[type=text]').val("");
		$('div.div_userDetail input[type=checkbox]').removeAttr("checked");
		$('div.div_userDetail input[type=text]').removeAttr("disabled");
		
		$('input[id=logoutSupported]').attr("checked", "checked");
		$('input[id=recordable]').attr("checked", "checked");
		$('input[id=autoUploadSupported]').attr("checked", "checked");
		
		/* 선택한 사용자정보 초기화 */
		$("input:hidden[name=userId]").val("");
		$("input:hidden[name=detailZirecxId]").val("");
		//$("input:hidden[name=detailLoginstring]").val("");
		$("input:hidden[id=jobType]").val("insert");
		
		/*
		userSearchVO.recordable.checked = true;
		userSearchVO.autoUploadSupported.checked = true;
		*/
	});

	$("#btn_save").bind("click", function(event) {
		if($.trim($("#groupIdDetail").val()) == "") {
			alert("센터를 선택해 주세요.");
			return;
		}
		if($.trim($("#zirecxId").val()) == "") {
			alert("사번을 입력해 주세요.");
			return;
		}
		if($.trim($("#firstname").val()) == "") {
			alert("이름을 입력해 주세요.");
			return;
		}
		if($.trim($("#phonenumber").val()) == "") {
			alert("사용자 개인 전화번호를 입력해 주세요.");
			return;
		}
		
		if(userSearchVO.jobType.value != ""  && userCheck()){
			$.ajax({  
			    type: "POST",  
			    url: "<c:url value='/system/userInfoManage.do'/>",
			    data:"groupIdDetail="+userSearchVO.groupIdDetail.value
			    	+"&securityGroupId="+userSearchVO.cmbAuthSearch.value
			    	+"&userId="+userSearchVO.userId.value
			    	+"&firstname="+$.trim(encodeURIComponent(userSearchVO.firstname.value))
			    	+"&zirecxId="+$.trim(userSearchVO.zirecxId.value)
			    	+"&phonenumber="+userSearchVO.phonenumber.value.replaceAll("-","")
			    	//+"&loginstring="+$.trim(userSearchVO.loginstring.value)
			    	+"&loginstring="+$.trim(userSearchVO.zirecxId.value)
			    	+"&recordable="+userSearchVO.recordable.checked
			    	+"&deleted="+userSearchVO.deleted.checked
			    	//+"&useMonitoring="+userSearchVO.useMonitoring.checked
			    	+"&jobType="+userSearchVO.jobType.value
			    	+"&detailZirecxId="+$.trim(userSearchVO.detailZirecxId.value)
			    	//+"&detailLoginstring="+$.trim(userSearchVO.detailLoginstring.value)
			    	+"&logoutSupported="+userSearchVO.logoutSupported.checked
			    	+"&autoUploadSupported="+userSearchVO.autoUploadSupported.checked
			    	+"&phonenumberOffice1="+userSearchVO.phonenumberOffice1.value
			    	+"&phonenumberOffice2="+userSearchVO.phonenumberOffice2.value
			    ,
			     
			    success: updateUserListCallBack,
			    error: function(e){  
			        alert('Error: ' + e.responseText);  
			    }  
            }); 	 
		}
	});
	
	<% /* 삭제 체크박스 클릭 이벤트 */ %>
	$("#deleted").bind("click", function(event) {
		if($('input[id="deleted"]').is(":checked")){
			//$("#loginstring").val("D"); 
			//$("#loginstring").attr("disabled", true);
		}
		//else $("#loginstring").removeAttr("disabled");
	});
	
	<% /* 삭제 체크박스 클릭 이벤트 */ %>
	$("#deleted").bind("click", function(event) {
		if($('input[id="deleted"]').is(":checked")){
			//$("#loginstring").val("D"); 
			//$("#loginstring").attr("disabled", true);
			$('input[id=recordable]').removeAttr("checked");
			//$('input[id=useMonitoring]').removeAttr("checked");
		}
		//else $("#loginstring").removeAttr("disabled");
		
	});
	
	<% /* 녹취여부 체크박스 클릭 이벤트 */ %>
	$("#recordable").bind("click", function(event) {
		if($('input[id="recordable"]').is(":checked")){
			//$("#loginstring").removeAttr("disabled");
			$('input[id=deleted]').removeAttr("checked");
		}
	});
	
	<% /* 모니터링 표시여부 체크박스 클릭 이벤트 */ %>
	/* 
	$("#useMonitoring").bind("click", function(event) {
		if($('input[id="useMonitoring"]').is(":checked")){
			//$("#loginstring").removeAttr("disabled");
			$('input[id=deleted]').removeAttr("checked");
		}
	});
	 */
	
	<% /* 그래프 표시 형태 바꿨을 때 */ %>
	$("#searchType").bind("change", function(event) {
		if($('input:hidden[name=detailZirecxId]').val() != ""){
			graphDraw();
		}
	});
});

<% /* 고객 수정 콜백 */ %>
function updateUserListCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);

	if(searchData.result == "1"){
		alert('<spring:message code='userManagerMain.alert.createSuccess' />');
		searchList();
	}else if(searchData.result == "2"){
		alert('<spring:message code='userManagerMain.alert.updateSuccess' />');
		searchList();
	}else if(searchData.result == "-1"){
		alert('<spring:message code='userManagerMain.alert.duplicateUserId' />');
		userSearchVO.zirecxId.focus();
	//}else if(searchData.result == "-2"){
		//alert('<spring:message code='userManagerMain.alert.duplicateEndPointId' />');
		//userSearchVO.loginstring.focus();
		//buttonConditionChange("enabled", "this", "update", "<c:url value='/images/'/>");
	}else{
		alert('<spring:message code='userManagerMain.alert.fail' />');
		//buttonConditionChange("enabled", "this", "update", "<c:url value='/images/'/>");
	}	
}

//로그인체크
function userCheck(){	
	if($.trim(userSearchVO.groupIdDetail.value) == ""){
		alert('<spring:message code="message.groupToUser"/>');
		return;
	}
	if(userSearchVO.cmbAuthSearch.value == "00"){
		alert('<spring:message code="message.selectPolicyName"/>');
		return;
	}
	if($.trim(userSearchVO.zirecxId.value) == ""){
		alert('<spring:message code="message.inputId"/>');
		userSearchVO.zirecxId.focus();
		return;
	}
	if($.trim(userSearchVO.zirecxId.value).length < 3){
		alert('<spring:message code="message.inputIdLength"/>');
		userSearchVO.zirecxId.focus();
		return;
	}
	if($.trim(userSearchVO.firstname.value) == ""){
		alert('<spring:message code="message.inputName"/>');
		userSearchVO.firstname.focus();
		return;
	}
	
	return true;
}

function sortField(field){
	if(field == ''){
		$("#orderType").val('ASC');
		$("#orderKey").val('firstname');		
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
	iframeUserList.fn_user_list_page();
}

function page_previous() {
	var pin = parseInt(document.getElementById("nowpage").value);
	if(1 < pin){
		document.getElementById("nowpage").value = pin - 1;
		iframeUserList.fn_user_list_page();
	}else{
		
	}
}

function page_next() {
	var pin = parseInt(document.getElementById("nowpage").value);
	var max = parseInt(document.getElementById("maxPageCheck").value);
	if(pin < max){
		document.getElementById("nowpage").value = (pin + 1);
		iframeUserList.fn_user_list_page();
	}else{
		
	}
}

function page_last() {
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	iframeUserList.fn_user_list_page();
}

/* 사용자 검색 공통모듈 
 * code : 키이벤트에 받은 코드
 * type :
 * userName : 사용자명 객체 명
 * userId : 사용자 아이디 객체 명
 * */ 
//function searchUser(code, type, strUserName, strUserId, idName){
function searchUser(searchObj, tgtUserNameObj, tgtUserIdObj, idName, callUrl, failMessage){
	
	if (searchObj == tgtUserNameObj){
		searchText = $("#" + tgtUserNameObj).val();
		searchType = "firstname";
	} else if (searchObj == tgtUserIdObj){
		searchText = $("#" + tgtUserIdObj).val();
		searchType = "zirecxId";
	}
	
	var param = "searchText=" + searchText
	+ "&searchType=" + searchType ;
//	+ "&strAccessPolicy=" + document.getElementById(idName).value; 
	
	$.ajax({
		type: "POST",  
		url: callUrl,
		data: param,
		success: userCheckCallBack,
		error: function(e){  
			alert(failMessage + e.responseText);
		}  
	});		
}

<% // 사용자 검색 call back function %>
function userCheckCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var returnData = $.parseJSON(jsonObj);
	if( returnData.count == 1){
		alert(returnData.userId);
		$("#schUserName").val(returnData.userName);
		$("#schUserZirecxId").val(returnData.zirecxId);
	} else if (returnData.count == 2){
		
	} else {
		return;
	}
}

<% /* 새로고침 */ %>
function refreshList(){
	searchList();
}

function fn_resetPassword() {
	if(userSearchVO.userId.value == "") {
		alert("패스워드를 초기화 할 사용자를 선택해 주세요.");
	} else {
		var msg = "사용자 '" + $.trim(userSearchVO.firstname.value) + "'의 패스워드를 초기화 하시겠습니까?\r\n(초기화 패스워드 : welcome)";
		if(confirm(msg)) {
			$.ajax({  
			    type: "POST",  
			    url: "<c:url value='/system/userPasswordInit.do'/>",
			    data:"userId="+userSearchVO.userId.value,
			     
			    success: function(result){
			    	var jsonObj = decodeURIComponent(result);
			    	var searchData = $.parseJSON(jsonObj);

			    	if(searchData.result > 0){
			    		alert("패스워드 초기화가 완료 되었습니다.");
			    		return;
			    	}else {
			    		alert("패스워드 초기화를 실패 하였습니다.");
			    		return;
			    	}
			    },
			    error: function(e){  
			        alert('Error: ' + e.responseText);  
			    }  
            });
		}
	}
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
					else if("${result.scope}" == "groupUp") {			// groupUp
						$("#btn_groupSearch").val("groupUp"); 
						$("#btn_groupTree").val("groupUp");
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
					
					else if("${result.scope}" == "groupUp") {			// groupUp
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
				if(arrPriv[y][2] == "check") {
					if("${sessionScope.security_group_id}" == "${result.securitygroupId}") {
						$("#"+arrPriv[y][1]).attr("disabled", false);
					} else {
						$("#"+arrPriv[y][1]).attr("disabled", true);
					}
				}
			}
		</c:forEach>
	}
}

</script>
</head>
<body bgcolor="#FFFFFF" style="text-align: left">
<form:form  commandName="userSearchVO" name="userSearchVO" method="post">
<form:hidden path="pageIndex" />
<form:hidden path="userId" />
<form:hidden path="detailZirecxId" />
<%-- <form:hidden path="detailLoginstring" /> --%>
<input type="hidden" id="btn_userSearch" name="btn_userSearch">
<input type="hidden" id="jobType">
<input type="hidden" id="orderKey" name="orderKey" value="firstName" />
<input type="hidden" id="orderType" name="orderType" value="ASC" />
<input type="hidden" id="maxPageCheck" name="maxPageCheck" value=""/>
<input type="hidden" id="hidAccessPolicy" name = "hidAccessPolicy" value="all" />
<input type="hidden" id="groupPopSubCheck" name = "groupPopSubCheck" value="" />
<input type="hidden" id="groupTreeType" name = "groupTreeType" value="Detail" />

<!-- 권한 페이지 분류로 인해 값 추가  -->
<input type="hidden" id="pageType" value="system" />

<table align="left" width="1249px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
		<%@ include file="../common/popUpFunction.jsp" %>
	<td>
		<table align="left" width="" height="730px" cellpadding="0" cellspacing="0" border="0" >
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_user.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr height="100%" valign="top">
			<td width="400px">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td>
						<table width="400px" height="169px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top">
							<td>
								<table width="400px" height="100%" cellpadding="0" cellspacing="0" border="0" >
								<tr valign="top" height="23px">
									<td width="14px"></td>
									<td>
										<table width="100%" height="23px" cellpadding="0" cellspacing="0" border="0" class="search_title">
										<tr>
											<td width="">&nbsp;</td>
											<td width="50px" align="right"><img id="btn_search" class="button" src="<c:url value='/images/button/btn_search.gif' />" /></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr height="106px" valign="top">
									<td></td>
									<td>
										<table width="372px" height="106px" cellpadding="0" cellspacing="0" border="0" class="search_area">
										<tr height="15px">
											<td colspan="2"></td>
										</tr>
										<tr valign="top">
											<td>
												<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="" height="" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="14px"></td>
															<td width="5px" style="padding-bottom: 4px;"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='user.search.group' /></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="93px" style="padding-bottom: 2px;"><form:input type="text" path="schGroupName" class="search_value" style="width:93px;" maxlength="255"/></td>
															<td width="3px"></td>
															<td width="93px" style="padding-bottom: 2px;"><form:input type="text" path="schGroupId"  class="search_value"  style="width:93px;" maxlength="11"/></td>
															<td width="3px"></td>
	 														<td width="20px" style="padding-top: 4px;"><img id="btn_groupSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
															
															<td width="3px"></td>
															<td width="" style="padding-top: 4px;"><img id="btn_groupTree" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr height="8px">
													<td></td>
												</tr>
												<tr>
													<td>
														<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="14px"></td>
															<td width="5px" style="padding-bottom: 4px;"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition"><spring:message code='user.search.user' /></td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="93px" style="padding-bottom: 2px;"><form:input type="text" path="schUserName" class="search_value" style="width:93px; " maxlength="20"/></td>
															<td width="3px"></td>
															<td width="93px" style="padding-bottom: 2px;"><form:input type="text" path="schUserZirecxId"  class="search_value"  style="width:93px; " maxlength="20" /></td>
															<td width="3px"></td>
															<td width=""></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr height="8px">
													<td></td>
												</tr>
												<tr>
													<td>
														<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="14px"></td>
															<td width="5px" style="padding-bottom: 4px;"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="5px"></td>
															<td width="50px" class="search_condition">사번</td>
															<td width="2px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="14px"></td>
															<td width="192px" style="padding-bottom: 2px;"><form:input type="text" path="schEndPointId" class="search_value" style="width:192px; " maxlength="20"/></td>
															<td width="" align="center"></td>
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
								<tr height="20px">
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
						<table width="400px" height="480px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top" height="480px">
							<td width="14px"></td>
							<td>
								<table width="" height="" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
									<tr valign="top">
										<td>
											<table width="372px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
											<tr>
												<td>&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<iframe id="iframeUserList" name="iframeUserList" frameborder="0" style="width: 372px; height: 445px; border: 1px solid #cbe0dd;"  scrolling="yes"></iframe>
										</td>
									</tr>
									<tr height="5px">
										<td></td>
									</tr>
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
				<table width="4px" height="730px" class="screen_bar">
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
						<div class="div_userDetail">
						<table width="" height="" cellpadding="0" cellspacing="0" border="0" >
							<tr valign="top">
								<td>
									<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
									<tr>
										<td align="right">&nbsp;</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="810px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
									<tr>
										<td width="130px" class="detail_column">센터 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<table cellpadding="0" cellspacing="0">
												<tr>
													<td width="75px"><input type="text" id="groupNameDetail" name="groupNameDetail" class="detail_value_writable" style="width:73px" maxlength="255"/></td>
													<td width="3px"></td>
													<td width="75px"><input type="text" id="groupIdDetail" name="groupIdDetail" class="detail_value_writable" style="width:73px" maxlength="11"/></td>
													<td width="3px"></td>
													<td width="25px" align="left"><img id="btn_groupSearchDetail" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td>
													<td width="" align="left"><img id="btn_groupTreeDetail" class="button" src="<c:url value='/images/button/btn_center_search.gif' />" /></td>
												</tr>
											</table>
											
										</td>
										<td width="130px" class="detail_column">권한 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<select name="cmbAuthSearch" class="detail_value_writable" style="width:158px;;height : 20px">
											</select>
										</td>
									</tr>
									<tr>
										<td width="130px" class="detail_column">사번 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<input type="text" id="zirecxId" class="detail_value_writable" style="width:153px" maxlength="6"/>
										</td>
										<td width="130px" class="detail_column">이름 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<input type="text" id="firstname" class="detail_value_writable" style="width:153px" maxlength="20"/>
										</td>
									</tr>
									<tr>
										<td width="130px" class="detail_column">패스워드 초기화</td>
										<td width="220px" class="detail_description">
											<c:if test="${sessionScope.security_group_id == '14' || sessionScope.security_group_id == '2'}">
												<img class="button" src="<c:url value='/images/button/btn_reset_pw.gif' />" style="cursor: hand;" onclick="javascript:fn_resetPassword();" />
											</c:if>
											<c:if test="${sessionScope.security_group_id != '14' && sessionScope.security_group_id != '2'}">
												<%-- <img class="button" src="<c:url value='/images/button/btn_reset_pw_inactive.gif' />" style="cursor: arrow;" /> --%>
											</c:if>
										</td>
										<td width="130px" class="detail_column">사용자 개인 전화번호 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<input type="text" id="phonenumber" class="detail_value_writable" style="width:153px" maxlength="20"/>
										</td>
									</tr>
									<tr style="display:none;">
										<td width="130px" class="detail_column">법인폰 전화번호 1 <font color="red">*</font></td>
										<td width="220px" class="detail_description">
											<input type="text" id="phonenumberOffice1" class="detail_value_writable" style="width:153px" maxlength="20"/>
										</td>
										<td width="130px" class="detail_column">법인폰 전화번호 2</td>
										<td width="220px" class="detail_description">
											<input type="text" id="phonenumberOffice2" class="detail_value_writable" style="width:153px" maxlength="20"/>
										</td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td width="130px" class="detail_column">로그아웃 지원여부</td>
										<td width="220px" class="detail_description">
											<input type="checkbox" id="logoutSupported" onfocus="this.blur();" align="left" />
										</td>
										<td width="130px" class="detail_column">녹취여부</td>
										<td width="220px" class="detail_description">
											<input type="checkbox" id="recordable" onfocus="this.blur();" align="left" />
										</td>
									</tr>
									<tr>
										<td width="130px" class="detail_column">삭제여부</td>
										<td width="220px" class="detail_description">
											<input type="checkbox" id="deleted" onfocus="this.blur();" align="left" />
										</td>
										<td width="130px" class="detail_column">자동업로드 지원여부</td>
										<td width="220px" class="detail_description">
											<input type="checkbox" id="autoUploadSupported" onfocus="this.blur();" align="left" />
										</td>
									</tr>
								</table>
									
								</td>
							</tr>
							<tr height="3px">
								<td></td>
							</tr>
							<tr>
								<td>
									<table cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td width="726px">&nbsp;</td>
										<td><img id="btn_new" class="button" src="<c:url value='/images/button/btn_new.gif' />" /></td>
										<td width="5px"></td>
										<td><img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />" /></td>
									</tr>
									</table>
								</td>
							</tr>
							<!-- 그래프 부분
							<tr>
								<td>
									<table cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td align="right" style="font-family: 돋움; color: #737373; font-size: 12px"> 그래프 표시 기준 : 
											<form:select path="searchType" class="detail_value_writable">
												<form:option value="day" >일</form:option>
												<form:option value="week">주</form:option>
												<form:option value="month">월</form:option>
											</form:select> 
										</td>
										<td width="585px">&nbsp;</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<iframe id="iframeUserGraph" name="iframeUserGraph" frameborder="0" style="width: 808px; height: 480px; border: 1px solid #cbe0dd;"  scrolling="no"></iframe>
								</td>
							</tr> -->
						</table>
					</div>
					</td>
				</tr>
				<tr>
					<td></td>
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
