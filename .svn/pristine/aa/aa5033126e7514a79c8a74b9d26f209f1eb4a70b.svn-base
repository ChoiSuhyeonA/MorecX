<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title></title>
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/common.js'/>"></script>
<script type="text/javascript">

$(document).ready(function(){
	parent.chngBtnSearch('end');
	
	$('#nonScrollTitle u:first').click(function(){ 
		parent.sortField('firstname');
		parent.searchList();
	});
	$('div[id$=crollTable] tr').click(function(){
		if(this.id != '')
			changeLine('true', this.id.substring(3)); 
	});
	$('div[id$=crollTable] tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3);
			overColor(vId);
		}
	});
	$('div[id$=crollTable] tr').mouseout(function(){ 
		if(this.id != ''){
			var vId = this.id.substring(3);
			outColor(vId);
		}
	});
});

</script>
</head>
<body>
<form:form method="post">
<table id="nonScrollTitle" width="1170px" class="list_table_box" border="0" cellspacing="0" cellpadding="0" >
	<tr>
		<td width="50px" rowspan="3" align="center" class="list_header_report">
			No
		</td>
		<td width="" rowspan="3" align="center" class="list_header_report">
			<spring:message code='message.group' />
		</td>
		<td width="80px" rowspan="3" align="center" class="list_header_report">
			<u style="cursor:hand"><spring:message code='message.user' /></u>
		</td>
		<td width="80px" rowspan="3" align="center" class="list_header_report">
			<spring:message code='message.user_id' />
		</td>
		<td width="90px" rowspan="3" align="center" class="list_header_report">
			<spring:message code='message.local_party' />
		</td>
		<td class="list_header_report" colspan="6" width="" align="center"><spring:message code='message.sum' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.average' /></td>
		<td class="list_header_report" rowspan="3" width="16px"></td>
	</tr>
	<tr>
		<td class="list_header_report" colspan="3" align="center"><spring:message code='message.call_count' />(total)</td>
		<td class="list_header_report" colspan="3" align="center"><spring:message code='message.call_time_report' />(total)</td>
		<td class="list_header_report" colspan="3" align="center"><spring:message code='message.call_time_report' />(total)</td>
	</tr>
	<tr>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="60px" align="center"><spring:message code='message.inbound' /></td>
	</tr>
</table>
<div id="scrollTable" style="width:1170px; height:413px; overflow-x:hidden;overflow-y:scroll; border:none;">
<c:if test="${fn:length(reportList) == 0}">
	<table width="1153px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
		<tr id=""><td align="center" class="list_value" style="border-left:0px; height:78px;"><spring:message code='common.nodata.message' /></td></tr>
	</table>
</c:if>
<c:choose>
<c:when test="${fn:length(reportList) > 0}">
	<table width="1153px" border="0" cellspacing="0" cellpadding="0" class="list_table_box">
	<c:forEach var="result" items="${reportList}" varStatus="status">
		<tr id='tr_<c:out value="${status.count}" />' title='<c:out value="${result.campaignName}" />' >
			<td width="50px" align="center" class="list_value">
				<div style='width:48px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${status.count}" />&nbsp;
				</div>
			</td>
			<td width="" align="center" class="list_value">
				<div style='width:100%;overflow:hidden;text-align:left;text-overflow:ellipsis;white-space:nowrap;'>
					&nbsp;<c:out value="${result.groupId}" />
				</div>
			</td>
			<td width="80px" align="center" class="list_value">
				<div style='width:80px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${result.firstName}" />&nbsp;
				</div>
			</td>
			<td width="80px" align="center" class="list_value">
				<c:out value="${result.zirecxId}" />&nbsp;
			</td>
			<td width="90px" align="center" class="list_value">
				<c:out value="${result.phonenumber}" />&nbsp;
			</td>
			<td class="list_value" width="60px" align="right"><%/* 전체통화건수*/%><c:out value="${result.totCountCall}" />&nbsp;</td>
			<td class="list_value" width="60px" align="right"><%/* 발신통화건수*/%><c:out value="${result.outCountCall}" />&nbsp;</td>
			<td class="list_value" width="60px" align="right"><%/* 수신통화건수*/%><c:out value="${result.inCountCall}" />&nbsp;</td>
			<td class="list_value" width="60px" align="center"><%/* 전체통화시간*/%><c:out value="${result.totDurationCall}" /></td>
			<td class="list_value" width="60px" align="center"><%/* 발신통화시간*/%><c:out value="${result.outDurationCall}" /></td>
			<td class="list_value" width="60px" align="center"><%/* 수신통화시간*/%><c:out value="${result.inDurationCall}" /></td>
			<td class="list_value" width="60px" align="center"><%/* 전체통화평균시간*/%><c:out value="${result.totDurationAverage}" /></td>
			<td class="list_value" width="60px" align="center"><%/* 발신통화평균시간*/%><c:out value="${result.outDurationAverage}" /></td>
			<td class="list_value" width="60px" align="center"><%/* 수신통화평균시간*/%><c:out value="${result.inDurationAverage}" /></td>
		</tr>
	</c:forEach>
		<tr id="" >
			<td colspan="5" class="list_value" align="center"><spring:message code='message.sum' /></td>
			<td class="list_value" align="right"><%/* 전체통화건수*/%><c:out value="${totCnt.totCountCall}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.outCountCall}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.inCountCall}" />&nbsp;</td>
			<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDurationCall}" /></td>
			<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.outDurationCall}" /></td>
			<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.inDurationCall}" /></td>
			<td class="list_value" align="center"><%/* 전체통화평균시간*/%><c:out value="${totCnt.totDurationAverage}" /></td>
			<td class="list_value" align="center"><%/* 발신통화평균시간*/%><c:out value="${totCnt.outDurationAverage}" /></td>
			<td class="list_value" align="center"><%/* 수신통화평균시간*/%><c:out value="${totCnt.inDurationAverage}" /></td>
		</tr>
	</table>
</c:when>
</c:choose>
</div>
</form:form>
</body>
</html>
