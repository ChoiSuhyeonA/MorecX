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
<title>MorecX</title>
<script type="text/javascript">

var win = window.dialogArguments;

function init(){
	document.getElementById('serverUrl').value = win.strServerUrlParam;
	document.getElementById('filePath').value = win.strFilePathParam;
	
//	document.getElementById('filePath').value = document.getElementById('filePath').value.replace("테스트",encodeURIComponent("테스트"));
	
//	document.getElementById('filePath').value = document.getElementById('filePath').value.replace("테스트",encodeURIComponent("테스트"));
	
	playnow();
}

function playnow(){
	var playurl;
	
//	var pin = encodeURIComponent(document.getElementById('filePath').value);
	
//	playurl = document.getElementById('serverUrl').value + pin;
	//alert(document.getElementById('serverUrl').value);
	//alert(document.getElementById('filePath').value);
	playurl = document.getElementById('serverUrl').value + "recData/" + document.getElementById('filePath').value;
	playurl = playurl.replace(":80/", "/");
alert(playurl);
	
	document.getElementById('MediaPlayer').AutoStart = "1";
	document.getElementById('MediaPlayer').Filename = playurl;
}

</script>
</head>
<body style="width: 350px; height: 159px; margin: 0px;" onload="init();" class="popup_player">
<form:form commandName="recordSearchVO" name="playerPopForm" method="post">
<form:hidden path="serverUrl" />
<form:hidden path="filePath" />
	<table width="350px" height="159px" cellpadding="0" cellspacing="0" border="0">
		<tr height="70px">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td width="20px">&nbsp;</td>
			<td>
				<object id="MediaPlayer" width="310px" height="65px" classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701" standby="Loading Microsoft?Windows?Media Player components..." type="application/x-oleobject">
				 	<param name="Filename" value="">
					<param name="ShowStatusBar" value="1">
					<param name="AutoStart" value="1">
					<param name="ShowControls" value="1">
					<param name="AllowChangeDisplaySize" value="0">
					<param name="DisplaySize" value="0">
					<param name="DisplayMode" value="4">
					<param name="AllowScan" value="1">
					<param name="Volume" value="-750">
					<param name="EnableContextMenu" value="true">
					<param name="ShowDisplay" value="false">
				</object>
			</td>
			<td width="20px">&nbsp;</td>
		</tr>
		<tr height="24px">
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
</form:form>
</body>
</html>