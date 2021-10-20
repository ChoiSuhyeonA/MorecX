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
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery.jqplot.min.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript">
function init(){
	//document.getElementById("pagelist").value = 50;
	searchAccessList();
}

function searchAccessList(){
	$("#accessSearchVO").attr("target","iframeAccessList");
	$("#accessSearchVO").attr("action","<c:url value='/system/accessManageList.do'/>");
	$("#accessSearchVO").submit();
}

</script>
</head>
<body bgcolor="#FFFFFF" style="text-align: left" onload="init();">
<form:form  commandName="accessSearchVO" name="accessSearchVO" method="post">
<table align="left" width="1249px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
	<td>
		<table align="left" width="" height="730px" cellpadding="0" cellspacing="0" border="0" >
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_access.gif' />" />
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
						<table width="" height="480px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top" height="480px">
							<td width="14px"></td>
							<td>
								<table width="" height="" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
									<tr valign="top">
										<td style="padding-left: 14px;">
											<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
											<tr>
												<td>&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td style="padding-left: 14px;">
											<iframe id="iframeAccessList" name="iframeAccessList" frameborder="0" style="width: 1170px; height: 626px; border: none;" scrolling="auto"></iframe>
										</td>
									</tr>
									<tr height="5px">
										<td></td>
									</tr>
									<tr>
										<td style="padding-left: 14px;">
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
