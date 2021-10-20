<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//공통 부분 시작 (권한, 그룹 리스트 팝업, 사용자 리스트 팝업)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 /* 그룹 리스트 팝업 */ 
//그룹 검색 이벤트(Enter)
$(function() {
	$("input:text[name^=schGroup]").keyup(function(event) {
		if (event.keyCode == 13){
			/** 숫자 정규식 추가 */
			var numRegExr = /^[0-9]+$/;
			if($("#schGroupName").val() == "" && $("#schGroupId").val() != "" &&!numRegExr.test($("#schGroupId").val())) {
				return;
			}
			
			if ($("#schGroupName").val() != "" && $("#schGroupId").val() != "" ){
				searchList();	
			} else {
				searchGroup(this.name, 'schGroupName', 'schGroupId', 'btn_groupSearch', "<c:url value='/common/selectGroupCheck.do'/>", "<spring:message code='group.insertGroup.failure' />");
			} 
		} else {
			if( this.name == "schGroupName" ) {
				$("#schGroupId").val("");
			} else if( this.name == "schGroupId" ) {
				$("#schGroupName").val("");
			}
			return;
		}
	}),

	/* $("input:text[name^=group]").keyup(function(event) {
		if (event.keyCode == 13){
			if ($("#groupName").val() != "" && $("#groupSeq").val() != "" ){
				alert(1);
				searchList();
			} else {
				alert(2);
				searchGroup(this.name, 'groupName', 'groupSeq', 'btn_groupSearch_monitor', "<c:url value='/common/selectGroupCheck.do'/>", "<spring:message code='group.insertGroup.failure' />");
			}
		} else {
			if( this.name == "groupName" ) {
				$("#groupSeq").val("");
			} else if( this.name == "groupSeq" ) {
				$("#groupName").val("");
			}
			return;
		}
	}), */
	
	/*
	김해동 수정... 
	$("input:text[name$=Detail]").keyup(function(event) {
		if (event.keyCode == 13){
			if ($("#groupNameDetail").val() != "" && $("#groupIdDetail").val() != "" ){
				searchList();
			} else {
				searchGroup(this.name, 'groupNameDetail', 'groupIdDetail', 'btn_groupSearch', "<c:url value='/common/selectGroupCheck.do'/>", "<spring:message code='group.insertGroup.failure' />");
			}
		} else {
			if( this.name == "groupNameDetail" ) {
				$("#groupIdDetail").val("");
			} else if( this.name == "groupIdDetail" ) {
				$("#groupNameDetail").val("");
			}
			return;
		}
	}), */
	
	$('#btn_userSearch').bind({
		click : function() {
			openCommonPopup("user", $("#schUserName").val(), $("#schUserZirecxId").val());
		}
	}),
	
	$('#btn_smartPhoneUserSearch').bind({
		click : function() {
			openCommonPopup("smartPhoneUser", $("#schUserName").val(), $("#schUserZirecxId").val());
		}
	}),
	
	$('#btn_groupSearch').bind({
		click : function() {
			
			//수정수정..
			//var btnGroupSearch = $("#btn_groupSearch").val() === "groupUp" ? "groupUp" : "group";
			//$("#groupPopSubCheck").val(btnGroupSearch);
			
			openCommonPopup("group", $("#schGroupName").val(), $("#schGroupId").val());
		}
	}),
	
	$("#btn_groupTree").bind("click", function(event) {
		groupTree('schGroupName', 'schGroupId', '', '<c:url value='/common/' />',$("#pageType").val());
	}),
	
/* 	$('#btn_groupSearchDetail').bind({
		click : function() {
			$("#groupPopSubCheck").val("group"+$("#groupTreeType").val());
			openCommonPopup("group", $("#groupNameDetail").val(), $("#groupIdDetail").val());
		}
	}), */
	
	$("#btn_groupTreeDetail").bind("click", function(event) {
		if($("#groupTreeType").val() == "Detail"){
			groupTree('groupNameDetail', 'groupIdDetail', '', '<c:url value='/common/' />', $("#pageType").val());
			
		}else if($("#groupTreeType").val() == "UpperDT"){
			groupTree('groupNameUpperDT', 'groupSeqUpperDT', '', '<c:url value='/common/' />', $("#pageType").val());
		}
		
	}),
	/** 김해동 테스트 .. 
	$('#btn_groupSearch_user').bind({
		click : function() {
			
			$("#groupPopSubCheck").val("groupUp");
			openCommonPopup("groupUp", $("#schGroupName").val(), $("#schGroupId").val());
			
			
			alert("popupFunction test ");
		}
	}),
	*/
	/** 김해동 테스트 미사용 예정;; 
	$("#btn_groupTree_user").bind("click", function(event) {
		groupUserTree('schGroupName', 'schGroupId', '', '<c:url value='/common/' />');
	}),
	*/
	
	/**************** 테스트 !! 공통화 로 ***/ 
	/* $('#btn_groupSearchDetail_user').bind({
		click : function() {
			// 김해동 테스트 
			$("#groupPopSubCheck").val("group"+$("#groupTreeType").val());
			
			alert($("#groupPopSubCheck").val());
			openCommonPopup("group", $("#groupNameDetail").val(), $("#groupIdDetail").val());
		}
	}), */
	
	$('#btn_groupSearchDetail').bind({
		click : function() {
			// 김해동 테스트 
			$("#groupPopSubCheck").val("group"+$("#groupTreeType").val());
			openCommonPopup("group", $("#groupNameDetail").val(), $("#groupIdDetail").val());
		}
	}),
	 //$("#btn_groupTreeDetail").bind("click", function(event) {
	/* if($("#groupTreeType").val() == "Detail"){
		groupUserTree('groupNameDetail', 'groupIdDetail', '', '<c:url value='/common/' />');
	}else if($("#groupTreeType").val() == "UpperDT"){
		groupUserTree('groupNameUpperDT', 'groupSeqUpperDT', '', '<c:url value='/common/' />');
	} */
	
	//groupTree('schGroupName', 'schGroupId', '', '<c:url value='/common/' />');
		//groupTree('groupNameDetail', 'groupIdDetail', '', '<c:url value='/common/' />',$("#pageType").val());
	
	//}), 
	
	
	//김해동 테스트 사용자관리 .. 
	/* $("#btn_groupTreeDetail_user").bind("click", function(event) {
		/* if($("#groupTreeType").val() == "Detail"){
			groupUserTree('groupNameDetail', 'groupIdDetail', '', '<c:url value='/common/' />');
		}else if($("#groupTreeType").val() == "UpperDT"){
			groupUserTree('groupNameUpperDT', 'groupSeqUpperDT', '', '<c:url value='/common/' />');
		} */
		
		//groupTree('schGroupName', 'schGroupId', '', '<c:url value='/common/' />');
	/* 	groupTree('groupNameDetail', 'groupIdDetail', '', '<c:url value='/common/' />',$("#pageType").val());
		
	}),  */
	
	$('#btn_groupSearch_monitor').bind({
		click : function() {
			openCommonPopup("group", $("#groupName").val(), $("#groupSeq").val());
		}
	}),
	
	$("#btn_groupTree_monitor").bind("click", function(event) {
		groupTree('groupName', 'groupSeq', '', '<c:url value='/common/' />');
	});	
});

//그룹 검색 공통 모듈
function searchGroup(searchObj, tgtGroupNameObj, tgtGroupIdObj, idName, callUrl, failMessage){
	if (searchObj == tgtGroupNameObj){
		searchText = $("#" + tgtGroupNameObj).val();
		searchType = "groupName";
	} else if (searchObj == tgtGroupIdObj){
		searchText = $("#" + tgtGroupIdObj).val();
		searchType = "groupId";
	}
	var param = "searchText=" + searchText
	+ "&searchType=" + searchType
	+ "&hidAccessPolicy=" + document.getElementById("hidAccessPolicy").value ;
	
	$.ajax({
		type: "POST",  
		url: callUrl,
		data: param,
		success: groupCheckCallBack,
		error: function(e){  
			alert(failMessage + e.responseText);
		}  
	});	
}

//그룹 검색 CallBack
function groupCheckCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var returnData = $.parseJSON(jsonObj);
	
	if( returnData.count == 1){
		if($("#groupPopSubCheck").val()=="groupBasic"){
			$("#groupName").val(returnData.groupName);
			$("#groupSeq").val(returnData.groupId);
		}else{
			$("#schGroupName").val(returnData.groupName);
			$("#schGroupId").val(returnData.groupId);
		}
	} else if (returnData.count == 2){
		// 그룹 검색 값이 하나 이상일 경우 리스트 팝업
		if($("#groupPopSubCheck").val()=="groupBasic"){
			openCommonPopup("group", $("#groupName").val(), $("#groupSeq").val());
		}
		/* else if($("#groupPopSubCheck").val() === "groupDetail"){
			openCommonPopup("group", $("#groupNameDetail").val(), $("#groupIdDetail").val());
		} */
		else{
			openCommonPopup("group", $("#schGroupName").val(), $("#schGroupId").val());
		}
	} else {
		// 그룹 검색 값이 하나도 없을 경우
		return;
	}
}

 /* 사용자(ZirecX ID) 리스트 팝업 */ 
//사용자(ZirecX ID) 검색 이벤트(Enter)
$(function() {
	$("input:text[name^=schUser]").keyup(function(event) {

		if (event.keyCode == 13){
			if ($("#schUserName").val() != "" && $("#schUserZirecxId").val() != "" ){
				searchList();
			} else {
				if($("#pageType").val() === "smartPhone") {
					searchSmartPhoneUser(this.name, 'schUserName', 'schUserZirecxId', 'btn_smartPhoneUserSearch', "<c:url value='/common/selectUserCheck.do'/>", "<spring:message code='group.insertGroup.failure' />");
				} 
				else {
					searchUser(this.name, 'schUserName', 'schUserZirecxId', 'btn_userSearch', "<c:url value='/common/selectUserCheck.do'/>", "<spring:message code='group.insertGroup.failure' />");
				}
			} 
		} else {
			if( this.name == "schUserName" ) {
				$("#schUserZirecxId").val("");
			} else if( this.name == "schUserZirecxId" ) {
				$("#schUserName").val("");
			}
			return;
		}
	})
});

//사용자 검색 공통 모듈
function searchUser(searchObj, tgtUserNameObj, tgtUserIdObj, idName, callUrl, failMessage){
	if (searchObj == tgtUserNameObj){
		searchText = $("#" + tgtUserNameObj).val();
		searchType = "firstname";
	} else if (searchObj == tgtUserIdObj){
		searchText = $("#" + tgtUserIdObj).val();
		searchType = "zirecxId";
	}

	var param = "searchText=" + searchText
	+ "&searchType=" + searchType
	//김해동 추가
	+ "&strAccessPolicy=" + document.getElementById(idName).value
	+ "&pageType=" + document.getElementById("pageType").value
	+ "&searchGroupName=" + document.getElementById("schGroupName").value
	+ "&searchGroupSeq=" + document.getElementById("schGroupId").value;
	

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

//사용자 검색 CallBack
function userCheckCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var returnData = $.parseJSON(jsonObj);
	
	if( returnData.count == 1){
		$("#schUserName").val(returnData.userName);
		$("#schUserZirecxId").val(returnData.zirecxId);
	} else if (returnData.count == 2){
		// 그룹 검색 값이 하나 이상일 경우 리스트 팝업
		openCommonPopup("user", $("#schUserName").val(), $("#schUserZirecxId").val());
	} else {
		// 그룹 검색 값이 하나도 없을 경우
		return;
	}
}

//총무권한 사용자 검색 공통 모듈
function searchSmartPhoneUser(searchObj, tgtUserNameObj, tgtUserIdObj, idName, callUrl, failMessage){
	if (searchObj == tgtUserNameObj){
		searchText = $("#" + tgtUserNameObj).val();
		searchType = "firstname";
	} else if (searchObj == tgtUserIdObj){
		searchText = $("#" + tgtUserIdObj).val();
		searchType = "zirecxId";
	}
	
	var param = "searchText=" + searchText
	+ "&searchType=" + searchType
	+ "&strAccessPolicy=" + document.getElementById(idName).value
	+ "&pageType=" + document.getElementById("pageType").value
	+ "&searchGroupName=" + document.getElementById("schGroupName").value
	+ "&searchGroupSeq=" + document.getElementById("schGroupId").value;
	
	$.ajax({
		type: "POST",  
		url: callUrl,
		data: param,
		success: smartPhoneUserCheckCallBack,
		error: function(e){  
			alert(failMessage + e.responseText);
		}  
	});
}

//총무권한 사용자 검색 CallBack
function smartPhoneUserCheckCallBack(result) {
	var jsonObj = decodeURIComponent(result);
	var returnData = $.parseJSON(jsonObj);
	
	if( returnData.count == 1){
		$("#schUserName").val(returnData.userName);
		$("#schUserZirecxId").val(returnData.zirecxId);
	} else if (returnData.count == 2){
		// 그룹 검색 값이 하나 이상일 경우 리스트 팝업
		openCommonPopup("smartPhoneUser", $("#schUserName").val(), $("#schUserZirecxId").val());
	} else {
		// 그룹 검색 값이 하나도 없을 경우
		return;
	}
}

//공통 팝업 이벤트
function openCommonPopup(strFlag, strName, strId) {
	
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strNameParam = strName;
	objParam.strIdParam = strId;
	

	var aName = "";
	if(strFlag == "group") {
		aName = "<c:url value='/common/groupCommonPopMain.do' />";
	} else if(strFlag == "user") {
		//objParam.searchGroupName = document.getElementById("schGroupName").value;
		//objParam.searchGroupSeq = document.getElementById("schGroupId").value;
		aName = "<c:url value='/common/userCommonPopMain.do' />";	
	}
	else if(strFlag == "smartPhoneUser") {
		aName = "<c:url value='/smart/smartPhoneUserPopMain.do' />";
	}
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);  

	if(br_info_num >= 8  || br_info_num == '7.'){			
		var arrValue = centerPop("350", "350");
		var winSearchBranch = window.showModalDialog(aName, window,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("350", "350");
		var winSearchBranch = window.showModalDialog(aName, window,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//공통 부분 끝
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
</script>

</head>
</html>