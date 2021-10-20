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
	parent.chngBtnSearch('end');	//조회중 버튼처리
	
	$('#nonScrollTitle u:first').click(function(){ 
		parent.sortField('c.campaign_name');
		parent.searchReportList();
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
		<td width="50px" rowspan="2" align="center" class="list_header_report">
			<div style='width:48px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
				No
			</div>
		</td>
		<td width="203px" rowspan="2" align="center" class="list_header_report">
			<div style='width:201px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
				<u style="cursor:hand"><spring:message code='message.camp_name' /></u>
			</div>
		</td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.sum' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.less1' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from1to5' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from5to10' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from10to20' /></td>
		<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.more20' /></td>
		<td class="list_header_report" rowspan="2" width="16px"></td>
	</tr>
	<tr>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.total' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.outbound' /></td>
		<td class="list_header_report" width="50px" align="center"><spring:message code='message.inbound' /></td>
	</tr>
</table>
<div id="scrollTable" style="width:1170px; height:439px; overflow-x:hidden;overflow-y:scroll; border:none;">
<c:if test="${fn:length(reportList) == 0}">
	<table width="1153px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
		<tr id=""><td align="center" class="list_value" style="border-left:0px;"><spring:message code='common.nodata.message' /></td></tr>
	</table>
</c:if>
<c:choose>
<c:when test="${fn:length(reportList) > 0}">
	<table width="1153px" border="0" cellspacing="0" cellpadding="0" class="list_table_box">
	<c:forEach var="result" items="${reportList}" varStatus="status">
		<tr id='tr_<c:out value="${status.count}" />' title='<c:out value="${result.campaignName}" />' >
			<td height="24px" width="50px" align="center" class="list_value">
				<div style='width:48px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${status.count}" />&nbsp;
				</div>
			</td>
			<td width="203px" align="center" class="list_value">
				<div style='width:201px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${result.campaignName}" />&nbsp;
				</div>
			</td>
			<td class="list_value" width="50px" align="right"><%/* 전체통화건수*/%><c:out value="${result.tO + result.tI}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신통화건수*/%><c:out value="${result.tO}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신통화건수*/%><c:out value="${result.tI}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 전체통화시간*/%><c:out value="${result.less1O + result.less1I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신통화시간*/%><c:out value="${result.less1O}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신통화시간*/%><c:out value="${result.less1I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 전체통화건수(연결)*/%><c:out value="${result.less2O + result.less2I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신통화건수(연결)*/%><c:out value="${result.less2O}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신통화건수(연결)*/%><c:out value="${result.less2I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 전체talk시간*/%><c:out value="${result.less3O + result.less3I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신talk시간*/%><c:out value="${result.less3O}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신talk시간*/%><c:out value="${result.less3I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 전체ring시간*/%><c:out value="${result.less4O + result.less4I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신ring시간*/%><c:out value="${result.less4O}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신ring시간*/%><c:out value="${result.less4I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 전체후처리시간*/%><c:out value="${result.less5O + result.less5I}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 발신후처리시간*/%><c:out value="${result.less5O}" />&nbsp;</td>
			<td class="list_value" width="50px" align="right"><%/* 수신후처리시간*/%><c:out value="${result.less5I}" />&nbsp;</td>
		</tr>
	</c:forEach>
		<tr id="" >
			<td colspan="2" class="list_value" align="center"><spring:message code='message.sum' /></td>
			<td class="list_value" align="right"><%/* 전체통화건수*/%><c:out value="${totCnt.i0 + totCnt.o0}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.o0}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.i0}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 전체통화시간*/%><c:out value="${totCnt.i1 + totCnt.o1}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신통화시간*/%><c:out value="${totCnt.o1}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신통화시간*/%><c:out value="${totCnt.i1}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 전체통화건수(연결)*/%><c:out value="${totCnt.i2 + totCnt.o2}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신통화건수(연결)*/%><c:out value="${totCnt.o2}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신통화건수(연결)*/%><c:out value="${totCnt.i2}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 전체talk시간*/%><c:out value="${totCnt.i3 + totCnt.o3}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신talk시간*/%><c:out value="${totCnt.o3}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신talk시간*/%><c:out value="${totCnt.i3}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 전체ring시간*/%><c:out value="${totCnt.i4 + totCnt.o4}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신ring시간*/%><c:out value="${totCnt.o4}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신ring시간*/%><c:out value="${totCnt.i4}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 전체후처리시간*/%><c:out value="${totCnt.i5 + result.o5}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 발신후처리시간*/%><c:out value="${totCnt.o5}" />&nbsp;</td>
			<td class="list_value" align="right"><%/* 수신후처리시간*/%><c:out value="${totCnt.i5}" />&nbsp;</td>
		</tr>
	</table>
</c:when>
</c:choose>
</div>
</form:form>
</body>
</html>
