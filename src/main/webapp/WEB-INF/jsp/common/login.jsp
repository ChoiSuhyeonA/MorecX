<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
function init(){
	var strUserID = getCookie("ZirecX_UserID");
	$("input:text[name=strZirecxId]").val(strUserID);
	
	if(strUserID == ""){
		$("#strZirecxId").focus();
	}else{
		$("#strPassword").focus();
	}
	
	if("FAIL" == "<c:out value="${loginSuccessYN}"/>"){
		alert("<spring:message code='login.fail.alert' />");
		$("#strPassword").focus();
	}
	
	if("FIRST" == "<c:out value="${loginSuccessYN}"/>"){
		alert("처음 로그인 하셨습니다.\r\n비밀번호를 변경 후 로그인을 진행하시기 바랍니다.");
		fn_changePassword();
	}
	
	if("RANDOMPASS" == "<c:out value="${loginSuccessYN}"/>") {
		alert("임시 비밀번호로 로그인 하실 수 없습니다.\r\n비밀번호를 변경 후 로그인을 진행하시기 바랍니다.");
		fn_changePassword();
	}
}

/* 로그인 function */
function fn_login() {
	if($("#strZirecxId").val() == ""){
		alert("<spring:message code='login.error.id' />");
		$("#strZirecxId").focus();
		return;
	}
	if($("#strPassword").val() == ""){
		alert("<spring:message code='login.error.password' />");
		$("#strPassword").focus();
		return;
	}
	
	rememberLoginInfo();
	
	$("#loginVO").attr("action","<c:url value='/common/loginProcess.do'/>");
	$("#loginVO").submit();

}


function fn_chg_img(pin) {
	if(pin == 1){
		document.getElementById("btn_login").src="<c:url value='/images/button/btn_login_over.gif' />";
	}else if(pin == 2){
		document.getElementById("chg_pw").src="<c:url value='/images/button/btn_change_password_over.gif' />";
	}else if(pin == 3){
		document.getElementById("btn_login").src="<c:url value='/images/button/btn_login.gif' />";
	}else if(pin == 4){
		document.getElementById("chg_pw").src="<c:url value='/images/button/btn_change_password.gif' />";
	}
}

function rememberLoginInfo(){
	if($("input:checkbox[id='checkIdSave']").is(":checked") == true){
	  	setCookie("ZirecX_UserID", $("#strZirecxId").val(), 7);
   }else{
  	    setCookie("ZirecX_UserID", $("#strZirecxId").val(), -1);
   }
}

function setCookie(cookieName, cookieValue, cookieExpiredays){
	var strExpireday = new Date();
	strExpireday.setDate( strExpireday.getDate() + cookieExpiredays );
	document.cookie = cookieName + "=" + escape( cookieValue ) + "; path=/; expires=" + strExpireday.toGMTString() + ";";
}

function getCookie(cookieName) {  //쿠키의 값을 가져오는 메소드.
	var Found = false;
	var start, end;
	var i = 0;

	while(i <= document.cookie.length) {
		start = i;
		end = start + cookieName.length;
	  
		if(document.cookie.substring(start, end) == cookieName) {
			Found = true;
			break;
		}
		i++;
	}

	if(Found == true) {
		start = end + 1;
		end = document.cookie.indexOf(";", start);
	  
		if(end < start)
			end = document.cookie.length;

		$("input:checkbox[id='checkIdSave']").attr("checked", true); 
		return document.cookie.substring(start, end);
	}
	return "";
}

function fn_changePassword(){
	var topPosition = window.screenTop + 100;
	var leftPosition = window.screenLeft + 100;
	var changePasswordPop="<c:url value='/common/changePasswordMain.do' />";
	var changePasswordPopParam = "?strUserIdParam="+document.getElementById('strZirecxId').value;
	
	var changePassword = window.open(changePasswordPop+changePasswordPopParam,'','top='+topPosition+', left='+leftPosition+', width=295px, height=240px, menubar=no, toolbar=no, location=no, status=no, scrollbars=no');
}

function downloadCodec(){
	location.href = "https://mobile.welcomefg.co.kr/download/K-Lite_Codec_Pack_995_Basic.zip";
	//this.focus.out();
}

</script>
<title>MorecX</title>
<link rel="shortcut icon" href="<c:url value='/images/icon/favicon.ico' />" />
</head>
<body onload="init();" style="margin:0px; padding:0px; width:100%; height:100%;">
<form:form commandName="loginVO" name="loginVO" method="post">
<div id="divLogin" align="center" style="position:absolute; margin:0px; padding:0px; width:100%; height: 100%;">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="background-image: url('<c:url value='/images/bg/bg_login.gif' />');">
<tr valign="middle">
	<td align="center">
	
		<table width="845px" height="858px" border="0" cellspacing="0" cellpadding="0" style="background-image: url('<c:url value='/images/bg/bg_login_box.gif' />');">
		<tr height="452px">
			<td colspan="5">&nbsp;</td>
		</tr>
		<tr height="30px">
			<td width="358px">&nbsp;</td>
			<td width="134px" style="background-image:url('<c:url value='/images/bg/bg_login_textbox.png' />'); background-repeat:no-repeat;'">
				<form:input path="strZirecxId" cssStyle="ime-mode:disabled;width:134px; height:20px; border:0; background:transparent; outline-style:none;" tabindex="11" />
			</td>
			<td width="13px">&nbsp;</td>
			<td rowspan="3"><img class="button" id="btn_login" src="<c:url value='/images/button/btn_login.png' />" width="68px" height="68px" tabindex="13" style="cursor: pointer;" onclick="javascript:fn_login();"></td>
			<td></td>
		</tr>
		<tr height="7px">
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr height="30px">
			<td width="358px">&nbsp;</td>
			<td width="134px" style="background-image:url('<c:url value='/images/bg/bg_login_textbox.png' />'); background-repeat:no-repeat;'">
				<form:password path="strPassword" cssStyle="ime-mode:disabled;width:134px; height:20px; border:0; background:transparent; outline-style:none;" tabindex="12" onkeydown="javascript : if(event.keyCode == 13) fn_login();" />																
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr height="4px">
			<td></td>
		</tr>
		<tr height="18px">
			<td colspan="5">
				<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" >
				<tr height="18px" valign="top">
					<td width="352px">&nbsp;</td>
					<td width="68px" >
						<input type="checkbox" name="checkIdSave" id="checkIdSave" tabindex="14" />
					</td>
					<td align="left" style="inline-height:15px;">
						&nbsp;<img class="button" id="btn_password" src="<c:url value='/images/button/btn_password.png' />" width="67px" height="18px" tabindex="13" style="cursor: hand;" onclick="javascript:fn_changePassword();">
					</td>
					<td></td>
				</tr>
				<tr height="4px">
					<td colspan="4"></td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="inline-height:15px;">
						&nbsp;<img class="button" id="btn_codec" src="<c:url value='/images/button/btn_codec.png' />" width="134px" height="23px" hidefocus="true" tabindex="15" style="cursor: hand;" onclick="downloadCodec();">
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
</div>
</form:form>
</body>
</html>