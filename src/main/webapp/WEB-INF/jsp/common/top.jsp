<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>MorecX</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<style type="text/css">
	.greeting { font-family: "돋움";font-size: 12px; color: #0068a3; font-weight: bold; padding-top:15px;}
</style>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">
/* 로그아웃 function */
$(function() {
	$("img.button").click(function() {
		document.logoutForm.target = "_top";
		document.logoutForm.action = "<c:url value='/common/logoutProcess.do'/>";
	   	document.logoutForm.submit();
	});
});
</script>
</head>
<body>
<form:form commandName="loginVO" name="logoutForm" method="post">
</form:form>
	<table width="100%" height="78px" cellpadding="0" cellspacing="0" style="border-collapse:collapse;" border="0">
	<tr height="78px">
		<td width="1212px">
			<table width="1212px" height="78px" cellpadding="0" cellspacing="0" style="border-collapse:collapse;" background="<c:url value='/images/bg/bg_top.gif' />">
			<tr>
				<td align="right" class="greeting" width="1167px">
					<%=session.getAttribute("user_name")%>님 로그인 중
				</td>
				<td width="9px">
				</td>
				<td id="greeting_class" width="58px" valign="top" style="padding-top:34px">
					<img class="button" src="<c:url value='/images/button/btn_logout.gif' />">
				</td>
			</tr>
			</table>
		</td>
		<td width="">
			<table width="100%" height="78px" cellpadding="0" cellspacing="0" style="border-collapse:collapse;" background="<c:url value='/images/bg/bg_top_margin.gif' />">
			<tr>
				<td>&nbsp;</td>
			</tr>
			</table>
		</td>
	</tr>
	</table>
<!-- 	<object ID="ZiPhonePlayer"  WIDTH="0" HEIGHT="0"  CLASSID="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" 
codebase = "<c:url value='/cabfiles/ZiPhonePlayer.cab' />#version=2,0,1,34" ></OBJECT> -->
</body>
</html>