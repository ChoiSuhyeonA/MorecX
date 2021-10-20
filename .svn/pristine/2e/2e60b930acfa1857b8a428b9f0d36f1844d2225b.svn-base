<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript">

function showDetail(trId, code, name){
	changeLine(name, trId);
	top.document.getElementById("strCampName").value = name;
}

function selectCampaign(name)
{
	eval("top.win.OPENER.document.getElementById('" + top.win.strCampNameParam +"')").value = name;
	
	self.close();
}
</script>
</head>
<body>
<form:form commandName="campaignPopSearchVO" id="campaignPopListForm" name="campaignPopListForm" method="post">
<input type="hidden" name="hidListCount" id="hidListCount" value="0" />
<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;" bordercolor="#c6e3ed">
	<tr height="20px">
		<td width="13%" align="center" style="font-family: 돋움;font-size: 11px; color: #737373;" background="<c:url value='/images/bg/bg_table_header.gif' />">No</td>
		<td width="87%" align="center" style="width:font-family: 돋움;font-size: 11px; color: #737373;" background="<c:url value='/images/bg/bg_table_header.gif' />">캠페인명</td>
	</tr>
	<span>
	<c:forEach var="result" items="${campaignPopList}" varStatus="status">
		<tr height="20px" id="tr_<c:out value="${status.count}"/>" onclick="showDetail('<c:out value="${status.count}"/>','<c:out value="${result.code}"/>','<c:out value="${result.name}"/>');" ondblclick="selectCampaign('<c:out value="${result.name}"/>')" style="cursor:hand" >
			<td id="no" width="20px" style="font-family: 돋움;font-size: 11px; color: #737373;" align="right">
				<c:out value="${status.count}"/>&nbsp;
			</td>
			<td width="" align="center" title="<c:out value='${result.name}'/>" style="font-family: 돋움;font-size: 11px; color: #737373;">
				&nbsp;<c:out value="${result.name}"/>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${fn:length(campaignPopList) == 0}">
	<tr height="">
		<td colspan="2" align="center" style="font-family: 돋움;font-size: 11px; color: #737373;"><spring:message code='common.nodata.message' /></td>
	</tr>
	</c:if>
	</span>
</table>
</form:form>
</body>
</html>
