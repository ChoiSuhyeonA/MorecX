<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/popup.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript">

var win = window.dialogArguments;

function init(){
	document.getElementById('userId').value = win.strUserIdParam;
}

function updatePassword(){
	if($("#userId").val() == ""){
		alert("<spring:message code='login.error.id' />");
		$("#userId").focus();
		return;
	}
	if($("#userCurrentPassword").val() == ""){
		alert("<spring:message code='login.changePassword.error.userCurrentPassword' />");
		$("#userCurrentPassword").focus();
		return;
	}
	if($("#userNewPassword").val() == ""){
		alert("<spring:message code='login.changePassword.error.userNewPassword' />");
		$("#userNewPassword").focus();
		return;
	}
	if($("#userNewPassword").val() == "welcome"){
		alert("비밀번호를 'welcome'으로 설정 하실 수 없습니다.");
		$("#userNewPassword").focus();
		return;
	}
	if($("#userNewPassword").val() != $("#userConfirmPassword").val()){
		alert("<spring:message code='login.changePassword.error.userConfirmPassword' />");
		$("#userNewPassword").val("");
		$("#userConfirmPassword").val("");
		$("#userNewPassword").focus();
		return;
	}
	if($("#userCurrentPassword").val() == $("#userNewPassword").val()){
		alert("<spring:message code='login.changePassword.error.userEqualPassword' />");
		$("#userNewPassword").val("");
		$("#userConfirmPassword").val("");
		$("#userNewPassword").focus();
		return;
	}
	var param = "userId="+$("#userId").val()
    		  + "&userCurrentPassword="+$("#userCurrentPassword").val()
    		  + "&userNewPassword="+$("#userNewPassword").val()
    		  + "&userConfirmPassword="+$("#userConfirmPassword").val();
     

	$.ajax({
	    type: "POST",  
	    url: "<c:url value='/common/updatePassword.do'/>",
	    data: param,
	    success: updatePasswordCallBack,
	    error: function(e){  
	      alert('<spring:message code='login.changePassword.failure' /> : ' + e.responseText);  
	    }  
	  }); 	
}

function updatePasswordCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);
	
	if(searchData.result == "SUCCESS"){
		alert("패스워드가 변경되었습니다.");
		window.close();
	}else if(searchData.result == "NOTEXIST"){
		alert("아이디가 존재하지 않습니다.");
		$("#userCurrentPassword").val("");
		$("#userNewPassword").val("");
		$("#userConfirmPassword").val("");
		$("#userId").val("");
		$("#userId").focus();
	}else if(searchData.result == "NOTPASS"){
		alert("비밀번호가 일치하지 않습니다.");
		$("#userCurrentPassword").val("");
		$("#userNewPassword").val("");
		$("#userConfirmPassword").val("");
		$("#userCurrentPassword").focus();
	}else{
		alert("패스워드  변경에 실패하였습니다.");
	}
}

function popClose(){
	self.close();
}
</script>
</head>
<body onload="init();">
<form:form commandName="changePasswordVO" name="changePasswordVO" method="post">
<table width="295px" height="240px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_change_password.gif' />" style="background-repeat: no-repeat;">
	<tr>
		<td width="15px"></td>
		<td align="center">
      		<table width="265px" height="240px" cellpadding="0" cellspacing="0" border="0">
      			<tr height="88px"><td></td></tr>
        		<tr height="101px">
          			<td valign="top">
          				<table width="100%" cellpadding="0" cellspacing="0" border="1" class="list_table_box">
          					<tr height="24px">
          						<td width="100px" align="center" class="password_header">
          							<spring:message code='changePassword.column.userId' />
          						</td>
          						<td class="password_value">
									&nbsp;<form:input path="userId" cssStyle="ime-mode:disabled;width:165px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
								</td>
							</tr>
							<tr height="24px">
								<td width="100px" align="center" class="password_header">
          							<spring:message code='changePassword.column.userCurrentPassword' />
          						</td>
								<td align="left" class="password_value">
									&nbsp;<form:password path="userCurrentPassword" cssStyle="ime-mode:disabled;width:165px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
								</td>
							</tr>
							<tr height="24px">
								<td width="100px" align="center" class="password_header">
          							<spring:message code='changePassword.column.userNewPassword' />
          						</td>
								<td align="left" class="password_value">
									&nbsp;<form:password path="userNewPassword" cssStyle="ime-mode:disabled;width:165px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
								</td>
							</tr>
							<tr height="24px">
								<td width="100px" align="center" class="password_header">
          							<spring:message code='changePassword.column.userConfirmPassword' />
          						</td>
								<td align="left" class="password_value">
									&nbsp;<form:password path="userConfirmPassword" onkeydown="javascript : if(event.keyCode == 13) updatePassword();" cssStyle="ime-mode:disabled;width:165px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
								</td>
							</tr>
						</table>
          			</td>
        		</tr>
        		<tr height="51px">
        			<td>
						<table align="right" cellpadding="0" cellspacing="0" border="0">
							<tr height="10px"><td colspan="3"></td></tr>
							<tr height="24px">
								<td width="48px">
									<img class="button" src="<c:url value='/images/button/btn_change_password_change.gif' />" style="cursor: hand" onclick="javascript:updatePassword();"/>
								</td>
								<td width="5px">
									&nbsp;
								</td>
								<td width="48px">
									<img class="button" src="<c:url value='/images/button/btn_change_password_cancle.gif' />" style="cursor: hand" onclick="javascript:popClose();"/>
								</td>
							</tr>
							<tr height="17px"><td colspan="3"></td></tr>
						</table>
        			</td>
        		</tr>
      		</table>
    	</td>
    	<td width="15px"></td>
	</tr>
</table>

</form:form>
</body>
</html>