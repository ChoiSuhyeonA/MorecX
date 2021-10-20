<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="overflow:hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">

var win = window.dialogArguments;

$(function() {
	$('#btnSubmit').bind({
		click : function() {
			if( $("#iframeGroupList").contents().find("#hidGroupId").val() == "" ) {
				alert("<spring:message code='message.groupToUser' />");
			} else {
				setParam();
				self.close();
			}
		}
	}),
	
	$('#btnCancel').bind({
		click : function() {
			self.close();
		}
	}),
	
	$('#btnSearch').bind({
		click : function() {
			searchGroupList();
		}
	}),
	
	$("input:text[name^=groupSearch]").keyup(function(event) {
		if (event.keyCode == 13){
			searchGroupList();
			
		}/*  else {
			if( this.name == "groupSearchName" ) {
				$("#groupSearchSeq").val("");
				
				$("#searchText").val( $("#groupSearchName").val() );
				$("#searchType").val( "groupName" );
			} else if( this.name == "groupSearchSeq" ) {
				$("#groupSearchName").val("");
				
				$("#searchText").val( $("#groupSearchSeq").val() );
				$("#searchType").val( "groupId" );
			}
		} */
	});
});

function init(){
	 if(!win.$("#groupPopSubCheck").val()){
		$("#groupSearchName").val( win.$("#schGroupName").val() );
		$("#groupSearchSeq").val(  win.$("#schGroupId").val() );
		$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
	}else{
		if(win.$("#groupPopSubCheck").val()=="group"){
			$("#groupSearchName").val( win.$("#schGroupName").val() );
			$("#groupSearchSeq").val(  win.$("#schGroupId").val() );
			$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
		}
	/* 	//추가
		else if(win.$("#groupPopSubCheck").val()=="groupUp"){
			$("#groupSearchName").val( win.$("#schGroupName").val() );
			$("#groupSearchSeq").val(  win.$("#schGroupId").val() );
			$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
		} */
		
		else if(win.$("#groupPopSubCheck").val()=="groupDetail"){
			$("#groupSearchName").val( win.$("#groupNameDetail").val() );
			$("#groupSearchSeq").val(  win.$("#groupIdDetail").val() );
			$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
		}
		else if(win.$("#groupPopSubCheck").val()=="groupUpperDT"){
			$("#groupSearchName").val( win.$("#groupNameUpperDT").val() );
			$("#groupSearchSeq").val(  win.$("#groupSeqUpperDT").val() );
			$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
		}
		else if(win.$("#groupPopSubCheck").val()=="groupBasic"){
			$("#groupSearchName").val( win.$("#groupName").val() );
			$("#groupSearchSeq").val(  win.$("#groupSeq").val() );
			$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
		}
	}
	
	
	// 테스트를 위한 임시
	//$("#hidAccessPolicy").val( "group" );
	
	/* if( $("#groupSearchName").val() != "" && $("#groupSearchSeq").val() == "" ) {
		$("#searchText").val( $("#groupSearchName").val() );
		$("#searchType").val( "groupName" );
		
		searchGroupList();
		
	} else if( $("#groupSearchName").val() == "" && $("#groupSearchSeq").val() != "" ) {
		$("#searchText").val( $("#groupSearchSeq").val() );
		$("#searchType").val( "groupId" );
		
		searchGroupList();
		
	} else {
		searchGroupList();
	} */
	
	
	searchGroupList();
}

function searchGroupList(){
	$("#cmnGroupSearchVO").attr("target","iframeGroupList");
	$("#cmnGroupSearchVO").attr("action","<c:url value='/common/selectGroupList.do'/>");
	$("#cmnGroupSearchVO").submit();
}

function setParam() {
	if(!win.$("#groupPopSubCheck").val()){
		GetDialogArguments().$("#schGroupName").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
		GetDialogArguments().$("#schGroupId").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
	}else{
		if(win.$("#groupPopSubCheck").val() == "group"){
			GetDialogArguments().$("#schGroupName").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
			GetDialogArguments().$("#schGroupId").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
		}
		/** 김해동 추가 */
		/* else if(win.$("#groupPopSubCheck").val()=="groupUp"){
			GetDialogArguments().$("#schGroupName").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
			GetDialogArguments().$("#schGroupId").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
		} */
		else if(win.$("#groupPopSubCheck").val()=="groupDetail"){
			GetDialogArguments().$("#groupNameDetail").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
			GetDialogArguments().$("#groupIdDetail").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
		}else if(win.$("#groupPopSubCheck").val()=="groupUpperDT"){
			GetDialogArguments().$("#groupNameUpperDT").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
			GetDialogArguments().$("#groupSeqUpperDT").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
			GetDialogArguments().$("#officeCode").val( $("#iframeGroupList").contents().find("#hidOfficeCode").val() );
			GetDialogArguments().$("#groupCode").val( $("#iframeGroupList").contents().find("#hidGroupCode").val() );
		}else if(win.$("#groupPopSubCheck").val()=="groupBasic"){
			GetDialogArguments().$("#groupName").val( $("#iframeGroupList").contents().find("#hidGroupName").val() );
			GetDialogArguments().$("#groupSeq").val( $("#iframeGroupList").contents().find("#hidGroupId").val() );
		}
	}
	
}

function GetDialogArguments() {
    var arguments;
 
    if (window.dialogArguments) { // For IE
        arguments = window.dialogArguments;
    }
    else { //For FF and Chrome
        arguments = window.opener;
    }
 
    return arguments;
}

</script>
</head>
<body onload="init();">
<form:form commandName="cmnGroupSearchVO" id="cmnGroupSearchVO" name="cmnGroupSearchVO" method="post">

<form:hidden path="auth" />
<!-- 조회 구분 -->
<form:hidden path="searchText" />
<form:hidden path="searchType" />

<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="" />
 
<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_group_pop.gif' />">
	<tr>
		<td width="15px">
		</td>
		<td width="320px">
			<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="88px"><td>&nbsp;</td></tr>
				<tr height="33px">
					<td>
						<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="5px"></td>
								<td width="127px">
									<form:input path="groupSearchName" cssStyle="width:127px; border:1px solid #C3C3C3; background-color:#FFFFFF" />
								</td>
								<td width="5px"></td>
								<td width="127px">
									<form:input path="groupSearchSeq" cssStyle="width:127px; border:1px solid #C3C3C3; background-color:#FFFFFF" />
								</td>
								<td width="5px"></td>
								<td width="20px">
									<img id="btnSearch" style="cursor: pointer;" src="<c:url value='/images/button/btn_simple_search.gif' />" />
								</td>
								<td width="">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="10px"><td></td></tr>
				<tr height="">
					<td width="320px">
						<iframe id="iframeGroupList" name="iframeGroupList" frameborder="0" style="width: 100%; height: 100%; border: none;" scrolling="yes"></iframe>
					</td>
				</tr>
				<tr height="10px"><td></td></tr>
				<tr height="24px">
					<td align="right">
						<img id="btnSubmit" style="cursor: pointer;" src="<c:url value='/images/button/btn_confirm.gif' />" />
						<img id="btnCancel" style="cursor: pointer;" src="<c:url value='/images/button/btn_close.gif' />" />
					</td>
				</tr>
				<tr height="16px"><td>&nbsp;</td></tr>
			</table>
		</td>
		<td width="15px">
		</td>
  	</tr>
</table>
</form:form>
</body>
</html>