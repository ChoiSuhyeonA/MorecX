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
		parent.sortField('usr.firstname');
		parent.searchList();
	});
	$('div[id$=crollTable] tr').click(function(){ 
		if(this.id != '')
			changeLine2('true', this.id.substring(3)); 
	});
	$('div[id$=crollTable] tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length-1);
			overColor(vId + 'L');
			overColor(vId + 'R');
		}
	});
	$('div[id$=crollTable] tr').mouseout(function(){ 
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length-1);
			outColor(vId + 'L');
			outColor(vId + 'R');
		}
	});
});

</script>
</head>
<body>
<form:form method="post">
<%/*전체를 감싸는 테이블 */ %>
<table width="1170px" cellpadding="0" cellspacing="0" border="0" style="overflow:hidden;" >
	<tr>
		<td style="vertical-align:top" width="300px">
			<%/*왼쪽 전체를 감싸는 테이블 (스크롤 자리 만들기) */ %>
			<table border="0" cellspacing="0" cellpadding="0" >
				<tr>
					<td>
					<%/*왼쪽 타이틀 고정 테이블*/ %>
						<table id="nonScrollTitle" width="300px" class="list_table_box" border="0" cellspacing="0" cellpadding="0" >
							<tr>
								<td width="50px" align="center" class="list_header_report" style="height:52px;">
									No
								</td>
								<td width="180px" align="center" class="list_header_report">
									<spring:message code='message.group' />
								</td>
								<td width="70px" align="center" class="list_header_report">
									<u style="cursor:hand"><spring:message code='message.user' /></u>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="300px" height="422px">
					<%/*왼쪽 고정 테이블 */ %>
					<c:if test="${fn:length(reportList) == 0}">
					<div style="width:300px; height:422px; overflow:hidden; border:none;">
						<table width="300px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
							<tr><td class="list_value">&nbsp;</td></tr>
						</table>
					</div>
					</c:if>
					<c:choose>
					<c:when test="${fn:length(reportList) > 0}">
					<div id="nonScrollTable" style="width:300px; height:422px; overflow:hidden; border:none;">
						<table width="300px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
						<c:forEach var="result" items="${reportList}" varStatus="status">
							<tr id="tr_<c:out value="${status.count}"/>L" >
								<td width="50px" align="center" class="list_value">
									<div style='width:48px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
										<c:out value="${status.count}" />&nbsp;
									</div>
								</td>
								<td width="180px" align="center" class="list_value">
									<div style='width:178px;overflow:hidden;text-align:left;text-overflow:ellipsis;white-space:nowrap;' title="<c:out value='${result.groupPath}'/>">
										&nbsp;<c:out value="${result.groupPath}" />
									</div>
								</td>
								<td width="70px" align="center" class="list_value">
									<div style='width:68px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
										<c:out value="${result.firstName}" />&nbsp;
									</div>
								</td>
							</tr>
						</c:forEach>
							<tr id="">
								<td colspan="3" align="center" class="list_value"><spring:message code='message.sum' />
								</td>
							</tr>
						</table>
					</div>
					</c:when>
					</c:choose>
					</td>
				</tr>
			</table>
		</td>
		<td><!-- 오른쪽 테이블 -->
			<table border="0px" style="width:100%;" cellspacing="0" cellpadding="0" >
				<tr>
				 	<td>
			 		<%/* 오른쪽 타이틀테이블 */ %>
			 		<div id="topTable" style="width:853px; overflow:hidden;">
						<table width="1150px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" style="border-left:0xp;">
						<tr>
							<td class="list_header_report" width="70px" align="center" rowspan="2" style="border-left:0px;"><spring:message code='message.user_id' /></td>
							<td class="list_header_report" width="80px" align="center" rowspan="2"><spring:message code='message.local_party' /></td>
							<td class="list_header_report" width="80px" align="center" rowspan="2"><spring:message code='message.camp_name' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.sum' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.less1' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from1to5' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from5to10' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.from10to20' /></td>
							<td class="list_header_report" colspan="3" width="" align="center"><spring:message code='message.more20' /></td>
							
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
					</div>
					</td>
					<td>
						<table border="0" cellspacing="0" cellpadding="0" class="list_table_box">
							<tr><td class="list_header_report" width="17px" style="height:52px"></td></tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<%/* 오른쪽 내용 테이블 */ %>
						<c:if test="${fn:length(reportList) == 0}">
						<div style="width:870px; height:439px; overflow:hidden; border:none;">
							<table width="1150px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
								<tr><td align="center" class="list_value" style="border-left:0px;"><spring:message code='common.nodata.message' /></td></tr>
							</table>
						</div>
						</c:if>
						<c:choose>
						<c:when test="${fn:length(reportList) > 0}">
						<div id="scrollTable" style="overflow:scroll; height:439px; width:870px;" onscroll="javascript:tableScrolling()" >
						<table width="1150px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" style="border-left:0xp;">
						<c:forEach var="result" items="${reportList}" varStatus="status">
							<tr id='tr_<c:out value="${status.count}" />R' title='<c:out value="${result.firstName}" />' >
								<td class="list_value" width="70px" align="center" style="border-left:0px;">
									<div style='width:68px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
										<c:out value="${result.userId}" />
									</div>
								</td>
								<td class="list_value" width="80px" align="center" >
									<div style='width:78px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
										<c:out value="${result.phoneno}" />
									</div>
								</td>
								<td class="list_value" width="80px" align="center" >
									<div style='width:78px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
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
							<tr>
								<td colspan="3" class="list_value" style="border-left:0px;"></td>
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
						</div>
						</c:when>
						</c:choose>
					</td>
				</tr>
			</table>
		</td><!-- 오른쪽 전체테이블 끝 -->
	</tr>
</table>
</form:form>
</body>
</html>
