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
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/authority.js' />"></script>
<script type="text/javascript">

var win = window.dialogArguments;

function init(){
}

function fn_convert(){
	var srcFile = document.all.srcFile.value;
	var destFile = srcFile.split(".")[0] + ".wav";
	document.all.ZiPhonePlayer.FileCvtWave(document.all.srcFile.value, destFile);
}

</script>
</head>
<body style="width: 350px; height: 159px; margin: 0px;" onload="init();" class="popup_cvtFile">
<form:form commandName="recordSearchVO" name="playerPopForm" method="post">
<form:hidden path="serverUrl" />
<form:hidden path="filePath" />
	<table width="350px" height="159px" cellpadding="0" cellspacing="0" border="0">
		<tr height="150px">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td width="40px">
			<!-- <OBJECT ID="ZiPhonePlayer" WIDTH="0" HEIGHT="0" CLASSID="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" 
				codebase = "../cabfiles/ZiPhonePlayer.cab#version=2,1,2,26">
			  </Object> -->
			  <!-- 2020.11.06 version up -->
			  <OBJECT ID="ZiPhonePlayer" WIDTH="0" HEIGHT="0" CLASSID="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" 
				codebase = "../cabfiles/ZiPhonePlayer.cab#version=2,1,2,42">
			  </Object>
			  
			</td>
			<td width="200px">
				<input type="text" name="srcFileTxt" id="srcFileTxt" style="width:200px; height:30px; color:#c5c8cd; padding-top:3px">
			</td>
			<td width="5px"></td>
			<td style="padding-top:3px">
				<input type="file" name="srcFile" style="display:none" onchange="document.getElementById('srcFileTxt').value=this.value">
				<img id="btn_srchFile"  class="button" style="cursor: pointer;" src="<c:url value='/images/button/bt_find_exfile.gif' />"  onclick="document.getElementById('srcFile').click();"/>
			</td>
			<td width="20px">&nbsp;</td>
		</tr>
		<tr height="30px">
			<td></td>
		</tr>
		<tr height="24px">
			<td colspan="5" align="center">
			<img id="btn_cvt"  class="button" style="cursor: pointer;" src="<c:url value='/images/button/bt_exfile.gif' />"  onclick="fn_convert();"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>