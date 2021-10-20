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
			if( $("#iframeUserList").contents().find("#hidUserId").val() == "" ) {
				alert("<spring:message code='message.userSelect' />");
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
			searchUserList();
		}
	}),
	
	$("input:text[name^=userSearch]").keyup(function(event) {
		if (event.keyCode == 13){
			searchUserList();
			
		}
	});
});

function init(){
	$("#userSearchName").val( win.$("#schUserName").val() );
	$("#userSearchSeq").val(  win.$("#schUserZirecxId").val() );
	$("#hidAccessPolicy").val( win.$("#hidAccessPolicy").val() );
	
	if("<c:out value="${sessionScope.zirecx_id}"/>" == "admin"){
		$("#groupId").val(win.$("#schGroupId").val());
	}
	searchUserList();
}

function searchUserList(){
	win.$("#selectedId").val("");

	$("#cmnUserSearchVO").attr("target","iframeUserList");
	$("#cmnUserSearchVO").attr("action","<c:url value='/smart/selectSmartPhoneUserList.do'/>");
	$("#cmnUserSearchVO").submit();
}

function setParam() {
	GetDialogArguments().$("#schUserName").val( $("#iframeUserList").contents().find("#hidUserName").val() );
	GetDialogArguments().$("#schUserZirecxId").val( $("#iframeUserList").contents().find("#hidUserId").val() );
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
<form:form commandName="cmnUserSearchVO" id="cmnUserSearchVO" name="cmnUserSearchVO" method="post">

<form:hidden path="auth" />
<!-- 조회 구분 -->
<form:hidden path="searchText" />
<form:hidden path="searchType" />
<input type="hidden" id="hidAccessPolicy" name="hidAccessPolicy" value="" />
<input type="hidden" id="groupId" name="groupId" value="" />
 
<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_user_pop.gif' />">
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
									<form:input path="userSearchName" cssStyle="width:127px; border:1px solid #C3C3C3; background-color:#FFFFFF" />
								</td>
								<td width="5px"></td>
								<td width="127px">
									<form:input path="userSearchSeq" cssStyle="width:127px; border:1px solid #C3C3C3; background-color:#FFFFFF" />
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
						<iframe id="iframeUserList" name="iframeUserList" frameborder="0" style="width: 100%; height: 100%; border: none;" scrolling="yes"></iframe>
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